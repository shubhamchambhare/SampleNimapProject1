package com.nimap.demo.Service;

import java.util.List;

import com.nimap.demo.model.Category;


public interface CategoryService {
    List<Category> getAllCategories(int page);
    Category getCategoryById(Long id);
    Category createCategory(Category category);
    Category updateCategory(Long id, Category category);
    void deleteCategory(Long id);
}
