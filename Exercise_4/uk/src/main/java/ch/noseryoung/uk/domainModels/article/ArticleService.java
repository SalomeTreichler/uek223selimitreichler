package ch.noseryoung.uk.domainModels.article;

import java.util.List;

public interface ArticleService {
    Article create(Article article);

    List<Article> findAll();

    Article findById(int id);

    Article updateById(int id, Article article);

    void deleteById(int id);
}
