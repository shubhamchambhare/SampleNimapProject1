package com.nimap.demo.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nimap.demo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}