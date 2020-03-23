package com.brunosoufo.cqsr.controllers;

import java.util.List;

import com.brunosoufo.cqsr.entities.Author;
import com.brunosoufo.cqsr.services.IAuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AuthorController
 */
@RestController
public class AuthorController {

    @Autowired
    IAuthorService authorService;

@GetMapping("/authors")
   ResponseEntity<List<Author>> getAllAuthors(){

    return new ResponseEntity<>(
        authorService.getAllAuthors(),
        HttpStatus.ACCEPTED);

    }
    
}