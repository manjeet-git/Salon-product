package com.parlour.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.parlour.product.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	public List<Product> findAllByProductType(String productType);
	
	public List<Product> findAllByProductTypeAndMfgCountry(String productType, String mfgCountry);
	
	@Modifying
	@Transactional
	@Query("update Product set productType=:productType where productId=:productId")
	public Integer updateProduct(@Param("productType") String prodType, @Param("productId") Integer prodId);
}
