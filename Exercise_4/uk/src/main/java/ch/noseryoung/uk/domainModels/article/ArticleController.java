package ch.noseryoung.uk.domainModels.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService){
        this.articleService = articleService;
    }

    @PostMapping({"/", ""})
    public ResponseEntity<Article> create(@RequestBody Article article){
        return new ResponseEntity<>(articleService.create(article), HttpStatus.OK);
    }

    @GetMapping({"/", ""})
    public ResponseEntity<List<Article>> getAll() {
        return new ResponseEntity<>(articleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getById(@PathVariable int id) {
        return new ResponseEntity<>(articleService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateById(@PathVariable int id, @RequestBody Article article) {
        return new ResponseEntity<>(articleService.updateById(id, article), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        articleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
