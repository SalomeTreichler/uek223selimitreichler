package ch.noseryoung.uk.domainModels.auction;

import ch.noseryoung.uk.domainModels.article.Article;
import ch.noseryoung.uk.domainModels.bid.Bid;
import ch.noseryoung.uk.domainModels.user.User;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "auction")
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "fixed_price")
    private double fixedPrice;

    @Column(name = "starting_price")
    private double startingPrice;

    /*@OneToMany(mappedBy = "auction")
    private List<Bid> bids;*/

    @Column(name = "is_public")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean isPublic;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="article_id", referencedColumnName = "id")
    private Article article;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getFixedPrice() {
        return fixedPrice;
    }

    public void setFixedPrice(double fixedPrice) {
        this.fixedPrice = fixedPrice;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

/*    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }*/
}
