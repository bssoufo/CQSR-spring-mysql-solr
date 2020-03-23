package com.brunosoufo.cqsr.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * Article
 */
@Table(name = "article")
@Data
@Entity
public class Article {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String title;
    private String body;
    private String status;
    @ManyToOne
    @JoinColumn(name ="author_id" )
    private Author author;
    @OneToMany
    @ManyToOne
    @JoinColumn(name ="category_id" )
    private Category category;
    private Date createdAt;
    private Date updatedAt;
    
}