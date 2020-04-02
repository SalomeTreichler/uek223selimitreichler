package ch.noseryoung.uk.domainModels.bid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
@Service
public class BidServiceImpl implements BidService {

    private BidRepository bidRepository;
    @Autowired
    public BidServiceImpl(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    // The logic for creating a new user
    @Override
    public Bid create(Bid bid) {
        return bidRepository.save(bid);
    }

    // The logic for retrieving all users
    @Override
    public List<Bid> findAll() {
        return bidRepository.findAll();
    }

    // The logic for retrieving a single user with a given id
    @Override
    public Bid findById(int id) {
        return bidRepository.findById(id).get();
    }

    // The logic for updating an existing user with a given id and data
    @Override
    public Bid updateById(int id, Bid bid) {
        if(bidRepository.existsById(id)) {
            bid.setId(id);
            bidRepository.save(bid);

            return bid;
        } else {
            throw new NoSuchElementException("No value present");
        }
    }

    // The logic for deleting a user with a given id
    @Override
    public void deleteById(int id) {
        bidRepository.deleteById(id);
    }



}
