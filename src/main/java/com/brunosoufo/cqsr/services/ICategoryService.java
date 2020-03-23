package com.brunosoufo.cqsr.services;

import java.util.List;

import com.brunosoufo.cqsr.entities.Category;

/**
 * CategoryService
 */
public interface ICategoryService {

    List<Category> getAllCategories();
    
}