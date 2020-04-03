package ch.noseryoung.uk.domainModels.bid;
import java.util.List;

public interface BidService {
    Bid create(Bid user);

    List<Bid> findAll();

    Bid findById(int id);

    Bid updateById(int id, Bid user);

    void deleteById(int id);
}
