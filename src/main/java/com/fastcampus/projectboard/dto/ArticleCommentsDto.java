package com.fastcampus.projectboard.dto;

import java.time.LocalDateTime;

public record ArticleCommentsDto(
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy,
        String content
) {
    public static ArticleCommentsDto of(LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy, String content) {
        return new ArticleCommentsDto(createdAt, createdBy, modifiedAt, modifiedBy, content);
    }
}
