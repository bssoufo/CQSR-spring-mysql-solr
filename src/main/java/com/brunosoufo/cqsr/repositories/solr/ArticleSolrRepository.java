package com.brunosoufo.cqsr.repositories.solr;

import java.util.List;

import com.brunosoufo.cqsr.dtos.ArticleReadDto;

import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * ArticleReadRepository
 */
@Repository
public interface ArticleSolrRepository extends SolrCrudRepository<ArticleReadDto, Long> {

    @Query("title:*?0* OR body:*?0*")
    public List<ArticleReadDto> findOnTitleOrBody(String searchTerm);
    
}