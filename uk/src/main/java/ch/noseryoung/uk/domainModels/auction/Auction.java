package ch.noseryoung.uk.domainModels.auction;

import ch.noseryoung.uk.domainModels.article.Article;
import ch.noseryoung.uk.domainModels.bid.Bid;
import ch.noseryoung.uk.domainModels.user.User;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
// This annotation defines this entity as it's own table with it's given name
// We can also not define it's name, but then it'd take the name of the class itself and that wouldn't be best practice
// This naming pattern is an exception and not best practice, as the term user is reserved we went with the plural
@Table(name = "auction")
public class Auction {
    @Id
    // This annotation makes sure that our id gets auto-incremented
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // This annotation simply defines that this attribute has it's own column and how that column is called
    @Column(name = "id")
    private int id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int fixed_price;

    @Column(nullable = false)
    private int starting_price;

    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean is_public;

    // Standard empty constructor
    public Auction() {}

    // Getters and setters
    public int getId() {
        return id;
    }

    public Auction setId(int id) {
        this.id = id;
        return this;
    }
    public String getDescription() {
        return description;
    }

    public Auction setDescription(String description) {
        this.description = description;
        return this;
    }
    public int getFixed_priced() {
        return fixed_price;
    }

    public Auction setFixedPrice(int fixed_price) {
        this.fixed_price =fixed_price;
        return this;
    }
    public int getStarting_price() {
        return starting_price;
    }

    public Auction setStartingPrice(int starting_price) {
        this.starting_price = starting_price;
        return this;
    }
    public boolean getIs_Public() {
        return is_public;
    }

    public Auction setIs_Public(boolean is_public) {
        this.is_public = is_public;
        return this;
    }
    

    //@OneToOne(fetch = FetchType.EAGER)
    //@JoinColumn(
    //        name = "article_id"
    //)
    //List<Article> articles;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "article_id", referencedColumnName = "id")
    private Article article;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User User;
}
