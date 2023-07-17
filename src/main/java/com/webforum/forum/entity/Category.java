package com.webforum.forum.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("category")
@Data
@NoArgsConstructor
public class Category {
    @Id
    private Long id;
    private String name;
}
