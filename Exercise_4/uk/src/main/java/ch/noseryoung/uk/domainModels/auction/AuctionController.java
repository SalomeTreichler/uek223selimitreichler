package ch.noseryoung.uk.domainModels.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionService auctionService;

    @Autowired
    public AuctionController(AuctionService auctionService){
        this.auctionService = auctionService;
    }

    @PostMapping({"/", ""})
    public ResponseEntity<Auction> create(@RequestBody Auction auction){
        return new ResponseEntity<>(auctionService.create(auction), HttpStatus.OK);
    }

    @GetMapping({"/", ""})
    public ResponseEntity<List<Auction>> getAll() {
        return new ResponseEntity<>(auctionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auction> getById(@PathVariable int id) {
        return new ResponseEntity<>(auctionService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Auction> updateById(@PathVariable int id, @RequestBody Auction auction) {
        return new ResponseEntity<>(auctionService.updateById(id, auction), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        auctionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
