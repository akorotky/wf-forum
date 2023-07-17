package com.webforum.forum.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Data
public abstract class AuditMetadata {
    @CreatedDate
    private Instant createdDate;
    @CreatedBy
    private Long createdByUserId;
    @LastModifiedDate
    private Instant updatedDate;
    @LastModifiedBy
    private Long updatedByUserId;
}
