package ch.noseryoung.uk.domainModels.article.dto;


public class ArticleDTO {
    private int id;
    private int value;
    private String name;
    private String description;

    public ArticleDTO(){}

    public int getId() {
        return id;
    }

    public ArticleDTO setId(int id) {
        this.id = id;
        return this;
    }

    public int getValue() {
        return value;
    }

    public ArticleDTO setValue(int value) {
        this.value = value;
        return this;
    }

    public String getName() {
        return name;
    }

    public ArticleDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ArticleDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
