package ch.noseryoung.uk.domainModels.user;

import ch.noseryoung.uk.domainModels.auction.Auction;
import ch.noseryoung.uk.domainModels.user.dto.UserDTO;
import ch.noseryoung.uk.domainModels.user.dto.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// This is an example controller with CRUD logic
@RestController
@RequestMapping("/users")
public class UserController {

    // The newly created service to be injected
    private UserService userService;
    private UserMapper userMapper;

    // Injecting the dependency via constructor
    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    // This endpoint creates a new user with the data given
    @PostMapping({"/", ""})
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userMapper.toDTO(userService.create(userMapper.fromDTO(userDTO))), HttpStatus.CREATED);
    }

   /* @GetMapping("/auctions/{id}")
    public ResponseEntity<List<Auction>> getAuctionsByUserId(@PathVariable int id){
        return new ResponseEntity<>(userService.getAuctionsByUserId(id), HttpStatus.OK);
    }*/

    // This endpoint retrieves all users as a list
    @GetMapping({"/", ""})
    public ResponseEntity<List<UserDTO>> getAll() {
        // In this line we now convert the list of business objects into a list of DTOs
        return new ResponseEntity<>(userMapper.toDTOs(userService.findAll()), HttpStatus.OK);
    }

    // This endpoint retrieves a single user by it's id
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable int id) {
        // In this line we now convert the business object into a DTO
        return new ResponseEntity<>(userMapper.toDTO(userService.findById(id)), HttpStatus.OK);
    }

    // This endpoint updates an existing user with the id and data given
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateById(@PathVariable int id, @RequestBody UserDTO userDTO) {
        // In this line we now convert the DTO to an business object first to create it via the service, and then back into a DTO to send it back as a response
        return new ResponseEntity<>(userMapper.toDTO(userService.updateById(id, userMapper.fromDTO(userDTO))), HttpStatus.OK);
    }

    // This endpoint deletes an existing user with the id given
    // Nothing was changed in this end point
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/sal/{min}/{max}")
    public ResponseEntity<List<UserDTO>> getUserBySalary(@PathVariable double min, @PathVariable double max){
        return new ResponseEntity<>(userMapper.toDTOs(userService.getUsersBySalary(min, max)), HttpStatus.OK);
    }

}
