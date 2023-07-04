package com.webforum.forum.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("post")
@Data
@NoArgsConstructor
public class Post {
    @Id
    private Long id;
    private String content;
    private Long threadId;
}
