package com.fastcampus.projectboard.service;

import com.fastcampus.projectboard.dto.ArticleCommentsDto;
import com.fastcampus.projectboard.repository.ArticleCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class ArticleCommentService {

    private final ArticleCommentService articleCommentService;

    private final ArticleCommentRepository articleCommentRepository;

    @Transactional(readOnly = true)
    public List<ArticleCommentsDto> searchArticleComments(long articleId) {
        return List.of();
    }

    public void saveArticleComment(ArticleCommentsDto dto) {

    }
}
