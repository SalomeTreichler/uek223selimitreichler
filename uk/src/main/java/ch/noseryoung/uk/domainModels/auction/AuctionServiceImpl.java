package ch.noseryoung.uk.domainModels.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuctionServiceImpl implements AuctionService{
    private AuctionRepository auctionRepository;

    @Autowired
    public AuctionServiceImpl(AuctionRepository auctionRepository){
        this.auctionRepository = auctionRepository;
    }

    @Override
    public Auction create(Auction auction) {
        return auctionRepository.save(auction);
    }

    @Override
    public List<Auction> findAll() {
        return auctionRepository.findAll();
    }

    @Override
    public Auction findById(int id) {
        return auctionRepository.findById(id).get();
    }

    @Override
    public Auction updateById(int id, Auction auction) {
        if(auctionRepository.existsById(id)){
            auction.setId(id);
            auctionRepository.save(auction);

            return auction;
        } else {
            throw new NoSuchElementException("No value present");
        }
    }

    @Override
    public void deleteById(int id) {
        auctionRepository.deleteById(id);
    }

   /* @Override
    public List<Auction> findAllByUserId(int id) {
        List<Auction> auctions = auctionRepository.findAll();
        List<Auction> auctionsByUserId = null;
        for(Auction auction : auctions){
            if(auction.getUser().getId() == id && auction.getBids() != null){
                auctionsByUserId.add(auction);
            }
        }
        return auctionsByUserId;
    }*/
}
