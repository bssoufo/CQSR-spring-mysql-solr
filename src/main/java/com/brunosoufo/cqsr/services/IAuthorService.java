package com.brunosoufo.cqsr.services;

import java.util.List;

import com.brunosoufo.cqsr.entities.Author;

/**
 * IAuthorService
 */
public interface IAuthorService {

    List<Author> getAllAuthors();
    
}