package com.brunosoufo.cqsr.services.impl;

import java.util.List;

import com.brunosoufo.cqsr.entities.Category;
import com.brunosoufo.cqsr.repositories.CategoryRepository;
import com.brunosoufo.cqsr.services.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CategoryService
 */
@Service
public class CategoryService implements ICategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    
}