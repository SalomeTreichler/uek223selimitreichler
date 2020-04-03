package ch.noseryoung.uk.domainModels.article;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
@Service
public class ArticleServiceImp implements ArticleService{
    private ArticleRepository articlerepository;

    @Autowired
    public ArticleServiceImp(ArticleRepository articleRepository) {
        this.articlerepository = articleRepository;
    }


    // The logic for creating a new authority
    @Override
    public Article create(Article article) {
        return articlerepository.save(article);
    }

    // The logic for retrieving all authorities
    @Override
    public List<Article> findAll() {
        return articlerepository.findAll();
    }

    // The logic for retrieving a single authority with a given id
    @Override
    public Article findById(int id) {
        return articlerepository.findById(id).get();
    }

    // The logic for updating an existing authority with a given id and data
    @Override
    public Article updateById(int id, Article article) {
        if(articlerepository.existsById(id)) {
            article.setId(id);
            articlerepository.save(article);

            return article;
        } else {
            throw new NoSuchElementException("No value present");
        }
    }

    // The logic for deleting an authority with a given id
    @Override
    public void deleteById(int id) {
        articlerepository.deleteById(id);
    }
}
