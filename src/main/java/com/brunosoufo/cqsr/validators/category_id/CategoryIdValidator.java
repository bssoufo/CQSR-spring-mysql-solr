package com.brunosoufo.cqsr.validators.category_id;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.brunosoufo.cqsr.entities.Category;
import com.brunosoufo.cqsr.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * CategoryIdValidator
 */

public class CategoryIdValidator implements ConstraintValidator<IsValidCategoryId, Long> {
    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        if (value == null) {
            return false;
        }
        Optional<Category> category = categoryRepository.findById(value);

        if (!category.isPresent()) {
            return false;
        }
        return true;
    }

}