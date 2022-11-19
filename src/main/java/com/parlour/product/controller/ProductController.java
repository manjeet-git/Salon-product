package com.parlour.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parlour.product.entity.Product;
import com.parlour.product.exception.ProductNotFoundException;
import com.parlour.product.exception.ProductTypeNotFoundException;
import com.parlour.product.exception.RareCombinationException;
import com.parlour.product.service.ProductService;
import com.parlour.product.utility.UtilityData;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	//Insertion of products 
	@PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> storeProduct(@RequestBody Product product){
		Product resProduct=productService.persistProduct(product);
		if(resProduct!=null) {
			return new ResponseEntity<Product>(resProduct, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	@GetMapping(path="/find-by-id/{prodId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductById(@PathVariable Integer prodId){
		try {
		    Product product=productService.findProductById(prodId);
		    if(product.getProductId()==prodId)
			return new ResponseEntity<Product>(product,HttpStatus.OK);
		    throw new ProductNotFoundException("Product havind id : "+prodId+" is not found");
		}catch (Exception e) {
			throw new ProductNotFoundException("Product havind id : "+prodId+" is not found");
		}	 	
	}
	
	
	@GetMapping(path="/find-all-product",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products=productService.showAllProduct();
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@GetMapping(path="/find-by-product-type/{producttype}")
	public ResponseEntity<List<Product>> getProductsByProductType(@PathVariable String producttype){
		if(!UtilityData.productTypes.contains(producttype))
			throw new ProductTypeNotFoundException("Product having type : "+producttype+" is not availabe. Please enter right product type");
		  List<Product> products=productService.showProductByProductType(producttype);
		  return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	
	@GetMapping(path="/find-by-productType-and-mfgCountry/{productType}/{mfgCountry}")
	public ResponseEntity<List<Product>> getProductsByProductTypeAndMfgCountry(@PathVariable(name = "productType") String pType, @PathVariable(name="mfgCountry") String mfgCountry){
		List<Product> products=productService.showProductByProductTypeAndMfgCountry(pType, mfgCountry);
		if(!(products.size()>0))
			throw new RareCombinationException("Product having product-type : "+pType+" and manufactured Country : "+mfgCountry+" is not available");
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@PutMapping(path="/update-product/{productType}/{productId}")
	public ResponseEntity<String> updateProductInfo(@PathVariable String  productType, @PathVariable int productId){
		int recordCount= productService.updateProductById(productType, productId);
		if(recordCount>0)
			return new ResponseEntity<String>("Successfully record updated",HttpStatus.OK);
		    return new ResponseEntity<String>("Record not updated ",HttpStatus.BAD_REQUEST);
	}
	
}
