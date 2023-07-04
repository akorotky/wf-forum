package com.webforum.forum.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("thread")
@Data
@NoArgsConstructor
public class Thread {
    @Id
    private Long id;
    private String title;
}
