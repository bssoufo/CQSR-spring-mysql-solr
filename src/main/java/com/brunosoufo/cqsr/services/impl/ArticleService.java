package com.brunosoufo.cqsr.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import com.brunosoufo.cqsr.dtos.ArticleReadDto;
import com.brunosoufo.cqsr.dtos.ArticleWriteDto;
import com.brunosoufo.cqsr.entities.Article;
import com.brunosoufo.cqsr.repositories.ArticleRepository;
import com.brunosoufo.cqsr.repositories.AuthorRepository;
import com.brunosoufo.cqsr.repositories.CategoryRepository;
import com.brunosoufo.cqsr.repositories.solr.ArticleSolrRepository;
import com.brunosoufo.cqsr.services.IArticleService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

/**
 * CategoryService
 */
@Service
@Validated
public class ArticleService implements IArticleService {

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ArticleSolrRepository articleReadpository;

    @Override
    public List<ArticleReadDto> getAllArticles() {
        Iterable<ArticleReadDto> aIterable = articleReadpository.findAll();

        List<ArticleReadDto> articleReadDtos = StreamSupport.stream(aIterable.spliterator(), false)
                .collect(Collectors.toList());

        return articleReadDtos;
    }

    @Override
    @Transactional
    public Long createArticle(@Valid ArticleWriteDto articleWriteDto) {
        ModelMapper modelMapper = new ModelMapper();
        Article article = modelMapper.map(articleWriteDto, Article.class);
        article.setAuthor(authorRepository.findById(articleWriteDto.getAuthorId()).get());
        article.setCategory(categoryRepository.findById(articleWriteDto.getCategoryId()).get());
        article.setCreatedAt(new Date());
        article.setUpdatedAt(new Date());
        article.setStatus("NEW");
        article = articleRepository.save(article);
        ArticleReadDto articleReadDto = modelMapper.map(article, ArticleReadDto.class);
        articleReadpository.save(articleReadDto);
        return article.getId();
    }

    @Override
    public Optional<ArticleReadDto> geArticleReadDto(Long id) {
        return articleReadpository.findById(id);
    }

    @Override
    public List<ArticleReadDto> findOnTitleOrBody(String searchTerm) {
        return articleReadpository.findOnTitleOrBody(searchTerm);
    }

    
    
}