package ch.noseryoung.uk.domainModels.bid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bids")
public class BidController {

    private BidService bidService;

    @Autowired
    public BidController(BidService bidService){
        this.bidService = bidService;
    }

    @PostMapping({"/", ""})
    public ResponseEntity<Bid> create(@RequestBody Bid bid){
        return new ResponseEntity<>(bidService.create(bid), HttpStatus.OK);
    }

    @GetMapping({"/", ""})
    public ResponseEntity<List<Bid>> getAll() {
        return new ResponseEntity<>(bidService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bid> getById(@PathVariable int id) {
        return new ResponseEntity<>(bidService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bid> updateById(@PathVariable int id, @RequestBody Bid bid) {
        return new ResponseEntity<>(bidService.updateById(id, bid), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        bidService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
