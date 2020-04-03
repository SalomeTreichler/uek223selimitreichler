package ch.noseryoung.uk.domainModels.article;

import ch.noseryoung.uk.domainModels.user.User;

import java.util.List;

public interface ArticleService {
    Article create(Article article);

    List<Article> findAll();

    Article findById(int id);

    Article updateById(int id, Article user);

    void deleteById(int id);
}
