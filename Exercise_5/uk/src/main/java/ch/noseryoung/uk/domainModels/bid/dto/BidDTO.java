package ch.noseryoung.uk.domainModels.bid.dto;

public class BidDTO {
    private int id;
    private int amount;
    private int userId;

    public BidDTO(){};

    public int getId() {
        return id;
    }

    public BidDTO setId(int id) {
        this.id = id;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public BidDTO setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public BidDTO setUserId(int userId) {
        this.userId = userId;
        return this;
    }
}
