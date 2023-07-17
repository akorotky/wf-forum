package com.webforum.forum.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("category_relation")
@Data
@NoArgsConstructor
public class CategoryRelation {
    @Id
    private Long id;
    private Long parentCategoryId;
    private Long childCategoryId;
}
