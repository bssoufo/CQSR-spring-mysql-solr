package com.brunosoufo.cqsr.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.brunosoufo.cqsr.validators.author_id.IsValidAuthorId;
import com.brunosoufo.cqsr.validators.category_id.IsValidCategoryId;

import lombok.Data;

/**
 * ArticleSaveDto
 */
@Data
public class ArticleWriteDto {

    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String body;
    private String status;
    @NotNull
    @IsValidAuthorId
    private Long authorId;
    @NotNull
    @IsValidCategoryId
    private Long categoryId;
    
}