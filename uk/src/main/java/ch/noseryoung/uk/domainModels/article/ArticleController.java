package ch.noseryoung.uk.domainModels.article;

import ch.noseryoung.uk.domainModels.article.dto.ArticleDTO;
import ch.noseryoung.uk.domainModels.article.dto.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private ArticleService articleService;
    private ArticleMapper articleMapper;

    @Autowired
    public ArticleController(ArticleService articleService, ArticleMapper articleMapper){
        this.articleMapper = articleMapper;
        this.articleService = articleService;
    }

    @PostMapping({"/", ""})
    public ResponseEntity<ArticleDTO> create(@RequestBody ArticleDTO articleDTO){
        return new ResponseEntity<>(articleMapper.toDTO(articleService.create(articleMapper.fromDTO(articleDTO))), HttpStatus.CREATED);
    }

    @GetMapping({"/", ""})
    public ResponseEntity<List<ArticleDTO>> getAll() {
        return new ResponseEntity<>(articleMapper.toDTOs(articleService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getById(@PathVariable int id) {
        return new ResponseEntity<>(articleMapper.toDTO(articleService.findById(id)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArticleDTO> updateById(@PathVariable int id, @RequestBody ArticleDTO articleDTO) {
        return new ResponseEntity<>(articleMapper.toDTO(articleService.updateById(id, articleMapper.fromDTO(articleDTO))), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        articleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
