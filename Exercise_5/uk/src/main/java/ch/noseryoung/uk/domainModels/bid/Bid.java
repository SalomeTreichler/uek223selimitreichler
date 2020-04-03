package ch.noseryoung.uk.domainModels.bid;


import ch.noseryoung.uk.domainModels.user.User;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
// This annotation defines this entity as it's own table with it's given name
// We can also not define it's name, but then it'd take the name of the class itself and that wouldn't be best practice
// This naming pattern is an exception and not best practice, as the term user is reserved we went with the plural
@Table(name = "bid")
public class Bid {
    @Id
    // This annotation makes sure that our id gets auto-incremented
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // This annotation simply defines that this attribute has it's own column and how that column is called
    @Column(name = "id")
    private int id;

    // In this example the name has not been defined, if you do this hibernate will plainly use the name of the variable itself
    // The nullable parameter defines if this attribute can be null in the database
    @Column(nullable = true)
    private int amount;



    public Bid() {}

    // Getters and setters
    public int getId() {
        return id;
    }

    public Bid setId(int id) {
        this.id = id;
        return this;
    }

    public int getAmount(){return amount;}

    public Bid setAmount(int id){
        this.id = id;
        return this;
    }
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "bid_id", nullable = false
    )
    private Bid bids;





}
