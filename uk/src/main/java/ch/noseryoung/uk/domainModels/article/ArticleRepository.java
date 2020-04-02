package ch.noseryoung.uk.domainModels.article;

import ch.noseryoung.uk.domainModels.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
