package com.webforum.forum.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("thread_tag")
@Data
@NoArgsConstructor
public class ThreadTag {
    @Id
    private Long id;
    private Long threadId;
    private Long tagId;
}
