package ch.noseryoung.uk.domainModels.auction;


import ch.noseryoung.uk.domainModels.user.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuctionServiceImp implements AuctionService {


    private AuctionRepository auctionRepository;

    @Autowired
    public AuctionServiceImp(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }


    // The logic for creating a new authority
    @Override
    public Auction create(Auction auction) {
        return auctionRepository.save(auction);
    }

    // The logic for retrieving all authorities
    @Override
    public List<Auction> findAll() {
        return auctionRepository.findAll();
    }

    public List<Auction> findAllbyUser(int userid){
       var auctions =  auctionRepository.findAll();
       List<Auction> auctionList = new ArrayList<Auction>();
        for (var auction:auctions) {
            if (auction.getId()==userid){
                auctionList.add(auction);
            }
        }
        return auctionList;
    }
    /*public List<Auction> findAllbyUser(List<Auction> auctionList){
        for (var auction:auctionList) {
           // if (auction)
        }
    }*/

    // The logic for retrieving a single authority with a given id
    @Override
    public Auction findById(int id) {
        return auctionRepository.findById(id).get();
    }

    // The logic for updating an existing authority with a given id and data
    @Override
    public Auction updateById(int id, Auction auction) {
        if(auctionRepository.existsById(id)) {
            auction.setId(id);
            auctionRepository.save(auction);

            return auction;
        } else {
            throw new NoSuchElementException("No value present");
        }
    }

    // The logic for deleting an authority with a given id
    @Override
    public void deleteById(int id) {
        auctionRepository.deleteById(id);
    }
}
