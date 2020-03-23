package com.brunosoufo.cqsr.repositories;

import com.brunosoufo.cqsr.entities.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * AuthorRepository
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    
}