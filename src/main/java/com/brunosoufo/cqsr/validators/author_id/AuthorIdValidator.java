package com.brunosoufo.cqsr.validators.author_id;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.brunosoufo.cqsr.entities.Author;
import com.brunosoufo.cqsr.repositories.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * CategoryIdValidator
 */

public class AuthorIdValidator implements ConstraintValidator<IsValidAuthorId, Long> {
    @Autowired
    AuthorRepository authorRepository;


    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        if (value == null) {
            return false;
        }
        Optional<Author>  authorOptional= authorRepository.findById(value);

        if (!authorOptional.isPresent()) {
            return false;
        }
        return true;
    }

}