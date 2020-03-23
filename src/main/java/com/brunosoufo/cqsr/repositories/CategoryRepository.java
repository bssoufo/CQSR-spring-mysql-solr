package com.brunosoufo.cqsr.repositories;

import com.brunosoufo.cqsr.entities.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CategoryRepository
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    
}