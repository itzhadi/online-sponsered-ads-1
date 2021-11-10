package com.online.ads.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.ads.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
