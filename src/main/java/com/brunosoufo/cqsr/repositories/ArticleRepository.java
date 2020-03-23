package com.brunosoufo.cqsr.repositories;

import com.brunosoufo.cqsr.entities.Article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ArticleRepository
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    
}