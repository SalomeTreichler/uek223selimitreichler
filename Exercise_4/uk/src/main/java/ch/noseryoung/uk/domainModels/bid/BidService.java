package ch.noseryoung.uk.domainModels.bid;

import java.util.List;

public interface BidService {
    Bid create(Bid bid);

    List<Bid> findAll();

    Bid findById(int id);

    Bid updateById(int id, Bid bid);

    void deleteById(int id);
}
