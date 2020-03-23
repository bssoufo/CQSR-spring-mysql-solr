package com.brunosoufo.cqsr.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.brunosoufo.cqsr.dtos.ArticleReadDto;
import com.brunosoufo.cqsr.dtos.ArticleWriteDto;

/**
 * IArticleService
 */
public interface IArticleService {

    List<ArticleReadDto> getAllArticles();

    Long  createArticle(@Valid ArticleWriteDto articleWriteDto);

    Optional<ArticleReadDto> geArticleReadDto(Long id);

    List<ArticleReadDto> findOnTitleOrBody(String searchTerm);
    
}