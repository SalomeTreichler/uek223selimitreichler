package ch.noseryoung.uk.domainModels.bid;


import ch.noseryoung.uk.domainModels.bid.dto.BidDTO;
import ch.noseryoung.uk.domainModels.bid.dto.BidMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// This is an example controller with CRUD logic
@RestController
@RequestMapping("/bids")
public class BidController {

    private BidService bidService;
    private BidMapper bidMapper;

    @Autowired
    public BidController(BidService bidService, BidMapper bidMapper)
    {
        this.bidService = bidService;
        this.bidMapper=bidMapper;
    }

    // This endpoint creates a new user with the data given
    @PostMapping({"/", ""})
    public ResponseEntity<BidDTO> create(@RequestBody BidDTO bidDTO) {
        return new ResponseEntity<>(bidMapper.toDTO(bidService.create(bidMapper.fromDTO((bidDTO)))), HttpStatus.CREATED);
    }

    // This endpoint retrieves all users as a list
    @GetMapping({"/", ""})
    public ResponseEntity<List<BidDTO>> getAll() {

        return new ResponseEntity<>(bidMapper.toDTOs(bidService.findAll()), HttpStatus.OK);
    }

    // This endpoint retrieves a single user by it's id
    @GetMapping("/{id}")
    public ResponseEntity<BidDTO> getById(@PathVariable int id) {
        return new ResponseEntity<>(bidMapper.toDTO(bidService.findById(id)), HttpStatus.OK);
    }

    // This endpoint updates an existing user with the id and data given
    @PutMapping("/{id}")
    public ResponseEntity<BidDTO> updateById(@PathVariable int id, @RequestBody BidDTO bidDto) {
        return new ResponseEntity<>(bidMapper.toDTO(bidService.updateById(id, bidMapper.fromDTO(bidDto))), HttpStatus.OK);
    }

    // This endpoint deletes an existing user with the id given
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        bidService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
