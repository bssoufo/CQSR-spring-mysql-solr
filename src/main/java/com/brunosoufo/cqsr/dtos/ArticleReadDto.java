package com.brunosoufo.cqsr.dtos;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import lombok.Data;

/**
 * ArticleReadDto
 */
@Data
@SolrDocument(solrCoreName = "article")
public class ArticleReadDto {

    @Id
    @Indexed(name ="id")
    private Long id;

    @Indexed(name ="title", type = "string")
    private String title;

    @Indexed(name ="body", type = "string")
    private String body;

   @Indexed(name ="status", type = "string")
    private String status;

    @Indexed(name ="author_firstname", type = "string")
    private String authorFirstName;

    @Indexed(name ="author_lastname", type = "string")
    private String authorLastName;

    @Indexed(name ="category_name", type = "string")
    private String categoryName;

    @Indexed(name ="created_at", type = "pdate")
    private Date createdAt;

    @Indexed(name ="updated_at", type = "pdate")
    private Date updatedAt;

}