package com.nimap.demo.serviceImple;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nimap.demo.Exception.ProductNotFoundException;
import com.nimap.demo.Repository.ProductRepository;
import com.nimap.demo.Service.CategoryService;
import com.nimap.demo.Service.ProductService;
import com.nimap.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public List<Product> getAllProducts(int page) {
        int pageSize = 10; // Set the desired page size
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        return productRepository.findAll(pageRequest).getContent();
    }

    @Override
    public Product getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));
        product.setCategory(categoryService.getCategoryById(product.getCategory().getId()));
        return product;
    }

    @Override
    public Product createProduct(Product product) {
        com.nimap.demo.model.Category category = categoryService.getCategoryById(product.getCategory().getId());
        product.setCategory(category);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = getProductById(id);
        existingProduct.setName(product.getName());
        existingProduct.setCategory(categoryService.getCategoryById(product.getCategory().getId()));
        return productRepository.save(existingProduct);
    }
    @Override
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}
