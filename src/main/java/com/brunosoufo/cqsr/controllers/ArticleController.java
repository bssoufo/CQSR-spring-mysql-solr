package com.brunosoufo.cqsr.controllers;

import java.util.List;

import javax.validation.Valid;

import com.brunosoufo.cqsr.dtos.ArticleReadDto;
import com.brunosoufo.cqsr.dtos.ArticleWriteDto;
import com.brunosoufo.cqsr.services.IArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ArticleController
 */
@RestController
public class ArticleController {

    @Autowired
    IArticleService articleService;

    @GetMapping("/articles")
   ResponseEntity<List<ArticleReadDto>> getAllArticles(){

    return new ResponseEntity<>(
        articleService.getAllArticles(),
        HttpStatus.ACCEPTED);

    }

    @PostMapping("/article")
    ResponseEntity <Long>  saveArticle(@RequestBody @Valid ArticleWriteDto articleWriteDto){
    Long articleId = articleService.createArticle(articleWriteDto);
        return new ResponseEntity<>(
            articleId,
            HttpStatus.ACCEPTED);
      
    }

    @GetMapping("/article/{id}")
    ResponseEntity<ArticleReadDto> getArticle(@PathVariable Long id){
        return new ResponseEntity<>(
            articleService.geArticleReadDto(id).get(),
            HttpStatus.ACCEPTED);
    }

    @GetMapping("/articles/search")
    ResponseEntity<List<ArticleReadDto>> searchArticleByTitleOrBody( @RequestParam String term){
        return new ResponseEntity<>(
            articleService.findOnTitleOrBody(term),
            HttpStatus.ACCEPTED);
    }
    
}