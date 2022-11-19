package com.parlour.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parlour.product.entity.Product;
import com.parlour.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;
	
	public Product persistProduct(Product product) {
		return repository.save(product);
		
	}
	
	public Product findProductById(Integer id) {
		 Optional<Product> product=repository.findById(id);
		 if(product.isPresent()) {
			 return product.get();
		 }else {
			 return null;
		 }
	}
	
	public List<Product> showAllProduct(){
		return repository.findAll();
	}
	
	public List<Product> showProductByProductType(String type){
		return repository.findAllByProductType(type);
	}
	
	public List<Product> showProductByProductTypeAndMfgCountry(String productType, String mfgCountry){
		return repository.findAllByProductTypeAndMfgCountry(productType, mfgCountry);
	}
	
	public Integer updateProductById(String productType, Integer productId) {
		return repository.updateProduct(productType, productId);
	}
	
}
