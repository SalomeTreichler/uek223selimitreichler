package ch.noseryoung.uk.domainModels.article;

import ch.noseryoung.uk.domainModels.user.User;

import javax.persistence.*;

@Entity
// This annotation defines this entity as it's own table with it's given name
// We can also not define it's name, but then it'd take the name of the class itself and that wouldn't be best practice
// This naming pattern is an exception and not best practice, as the term user is reserved we went with the plural
@Table(name = "article")
public class Article {
    // Regular attributes
    // The primary key, this annotation defines that this is a primary key:
    @Id
    // This annotation makes sure that our id gets auto-incremented
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // This annotation simply defines that this attribute has it's own column and how that column is called
    @Column(name = "id")
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int value;

    public Article() {}

    // Getters and setters
    public int getId() {
        return id;
    }

    public Article setId(int id) {
        this.id = id;
        return this;
    }
    public String getName() {
        return name;
    }

    public Article setName(String name) {
        this.name = name;
        return this;
    }
    public String getDescription() {
        return description;
    }

    public Article setDescription(String description) {
        this.description = description;
        return this;
    }
    public int getValue() {
        return value;
    }

    public Article setValue(int value) {
        this.value = value;
        return this;
    }



}
