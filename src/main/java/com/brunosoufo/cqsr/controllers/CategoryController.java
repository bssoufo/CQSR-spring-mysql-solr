package com.brunosoufo.cqsr.controllers;

import java.util.List;

import com.brunosoufo.cqsr.entities.Category;
import com.brunosoufo.cqsr.services.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CategoryController
 */
@RestController
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

@GetMapping("/categories")
   ResponseEntity<List<Category>> getAllCategory(){

    return new ResponseEntity<>(
        categoryService.getAllCategories(),
        HttpStatus.ACCEPTED);

    }
    
}