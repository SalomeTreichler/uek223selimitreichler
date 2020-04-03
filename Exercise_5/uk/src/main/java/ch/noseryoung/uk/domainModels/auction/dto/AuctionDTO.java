package ch.noseryoung.uk.domainModels.auction.dto;

import ch.noseryoung.uk.domainModels.auction.Auction;
import org.hibernate.annotations.Type;

import javax.persistence.Column;

public class AuctionDTO {

    private int id;


    private String description;


    private int fixed_price;


    private int starting_price;


    private boolean is_public;

    // Standard empty constructor
    public AuctionDTO() {}

    // Getters and setters
    public int getId() {
        return id;
    }

    public AuctionDTO setId(int id) {
        this.id = id;
        return this;
    }
    public String getDescription() {
        return description;
    }

    public AuctionDTO setDescription(String description) {
        this.description = description;
        return this;
    }
    public int getFixed_priced() {
        return fixed_price;
    }

    public AuctionDTO setFixedPrice(int fixed_price) {
        this.fixed_price =fixed_price;
        return this;
    }
    public int getStarting_price() {
        return starting_price;
    }

    public AuctionDTO setStartingPrice(int starting_price) {
        this.starting_price = starting_price;
        return this;
    }
    public boolean getIs_Public() {
        return is_public;
    }

    public AuctionDTO setIs_Public(boolean is_public) {
        this.is_public = is_public;
        return this;
    }
}
