package com.parlour.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parlour.product.entity.Product;
import com.parlour.product.service.ProductService;

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
	
	
	
	
}
