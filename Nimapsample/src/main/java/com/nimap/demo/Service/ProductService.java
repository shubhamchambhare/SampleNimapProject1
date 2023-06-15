package com.nimap.demo.Service;

import java.util.List;

import com.nimap.demo.model.Product;

public interface ProductService {
    List<Product> getAllProducts(int page);
    Product getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);

		
	}
