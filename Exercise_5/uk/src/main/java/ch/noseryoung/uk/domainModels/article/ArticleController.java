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

    // Injecting the dependency via constructor
    @Autowired
    public ArticleController(ArticleService articleService, ArticleMapper articleMapper)
    {
        this.articleService = articleService;
        this.articleMapper=articleMapper;
    }


    @PostMapping({"/", ""})
    public ResponseEntity<ArticleDTO> create(@RequestBody ArticleDTO articleDTO) {
        // In this line we now convert the DTO to an business object first to create it via the service, and then back into a DTO to send it back as a response
        return new ResponseEntity<>(articleMapper.toDTO(articleService.create(articleMapper.fromDTO(articleDTO))), HttpStatus.CREATED);
    }

    // This endpoint retrieves all users as a list
    @GetMapping({"/", ""})
    public ResponseEntity<List<ArticleDTO>> getAll() {
        // In this line we now convert the list of business objects into a list of DTOs
        return new ResponseEntity<>(articleMapper.toDTOs(articleService.findAll()), HttpStatus.OK);
    }

    // This endpoint retrieves a single user by it's id
    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getById(@PathVariable int id) {
        // In this line we now convert the business object into a DTO
        return new ResponseEntity<>(articleMapper.toDTO(articleService.findById(id)), HttpStatus.OK);
    }

    // This endpoint updates an existing user with the id and data given
    @PutMapping("/{id}")
    public ResponseEntity<ArticleDTO> updateById(@PathVariable int id, @RequestBody ArticleDTO articleDTO) {
        // In this line we now convert the DTO to an business object first to create it via the service, and then back into a DTO to send it back as a response
        return new ResponseEntity<>(articleMapper.toDTO(articleService.updateById(id, articleMapper.fromDTO(articleDTO))), HttpStatus.OK);
    }

    // This endpoint deletes an existing user with the id given
    // Nothing was changed in this end point
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        articleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
