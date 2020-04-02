package ch.noseryoung.uk.domainModels.article;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/articles")
public class ArticleController {
    private ArticleService articleServiceService;

    // Injecting the dependency via constructor
    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleServiceService = articleService;
    }

    // This endpoint creates a new user with the data given
    @PostMapping({"/", ""})
    public ResponseEntity<Article> create(@RequestBody Article article) {
        return new ResponseEntity<>(articleServiceService.create(article), HttpStatus.CREATED);
    }

    // This endpoint retrieves all users as a list
    @GetMapping({"/", ""})
    public ResponseEntity<List<Article>> getAll() {
        return new ResponseEntity<>(articleServiceService.findAll(), HttpStatus.OK);
    }

    // This endpoint retrieves a single user by it's id
    @GetMapping("/{id}")
    public ResponseEntity<Article> getById(@PathVariable int id) {
        return new ResponseEntity<>(articleServiceService.findById(id), HttpStatus.OK);
    }

    // This endpoint updates an existing user with the id and data given
    @PutMapping("/{id}")
    public ResponseEntity<Article> updateById(@PathVariable int id, @RequestBody Article article) {
        return new ResponseEntity<>(articleServiceService.updateById(id, article), HttpStatus.OK);
    }

    // This endpoint deletes an existing user with the id given
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        articleServiceService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
