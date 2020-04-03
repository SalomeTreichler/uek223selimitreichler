package ch.noseryoung.uk.domainModels.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ArticleServiceImpl implements ArticleService{

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    @Override
    public Article create(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article findById(int id) {
        return articleRepository.findById(id).get();
    }

    @Override
    public Article updateById(int id, Article article) {
        if(articleRepository.existsById(id)){
            article.setId(id);
            articleRepository.save(article);

            return article;
        } else {
            throw new NoSuchElementException("No value present");
        }
    }

    @Override
    public void deleteById(int id) {
        articleRepository.deleteById(id);
    }
}
