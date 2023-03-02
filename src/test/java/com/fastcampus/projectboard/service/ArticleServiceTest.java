package com.fastcampus.projectboard.service;

import com.fastcampus.projectboard.domain.Article;
import com.fastcampus.projectboard.domain.type.SearchType;
import com.fastcampus.projectboard.dto.ArticleDto;
import com.fastcampus.projectboard.dto.ArticleUpdateDto;
import com.fastcampus.projectboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

@DisplayName("비즈니스 로직 - 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks
    private ArticleService articleService;
    @Mock
    private ArticleRepository articleRepository;

    @DisplayName("게시글을 검색하면, 게시글을 반환한다.")
    @Test
    void givenSearchParameters_whenSearchingArticle_thenReturnArticleList() {
        // given
        // when
        Page<ArticleDto> articles = articleService.searchArticles(SearchType.TITLE, "search keyword");

        // then
        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글을 조회하면, 게시글을 반환한다.")
    @Test
    void givenArticleId_whenSearchingArticle_thenReturnArticleList() {
        // given

        // when
        ArticleDto article = articleService.searchArticle(1L);

        // then
        assertThat(article).isNotNull();
    }

    @DisplayName("게시글 정보를 입력하면, 게시글을 생성한다.")
    @Test
    void givenArticleInfo_whenSavingArticle_thenSaveArticle() {
        // given
        given(articleRepository.save(any(Article.class))).willReturn(null);

        // when
        articleService.saveArticle(ArticleDto.of("title", "chorlock", "hashtag", LocalDateTime.now(), "chorlock"));

        // then
        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글의 ID와 수정 정보를 입력하면, 게시글을 수정한다..")
    @Test
    void givenArticleIdAndModifiedInfo_whenUpdatingArticle_thenUpdateArticle() {
        // given
        given(articleRepository.save(any(Article.class))).willReturn(null);

        // when
        articleService.updateArticle(1L, ArticleUpdateDto.of("title", "chorlock", "hashtag"));

        // then
        then(articleRepository).should().save(any(Article.class));
    }

    @DisplayName("게시글의 ID 를 입력하면, 게시글을 삭제한다.")
    @Test
    void givenArticleId_whenDeletingArticle_thenDeleteArticle() {
        // given
        willDoNothing().given(articleRepository).delete(any(Article.class));

        // when
        articleService.deleteArticle(1L);

        // then
        then(articleRepository).should().delete(any(Article.class));
    }
}