package com.parlour.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parlour.product.entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
