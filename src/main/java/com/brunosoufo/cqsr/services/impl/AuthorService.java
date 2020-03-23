package com.brunosoufo.cqsr.services.impl;

import java.util.List;

import com.brunosoufo.cqsr.entities.Author;
import com.brunosoufo.cqsr.repositories.AuthorRepository;
import com.brunosoufo.cqsr.services.IAuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * AuthorService
 */
@Service("authorService")
@Validated
public class AuthorService implements IAuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    
}