package ch.noseryoung.uk.domainModels.user;

import java.util.List;
import ch.noseryoung.uk.domainModels.auction.Auction;
import org.springframework.security.core.userdetails.UserDetailsService;

// This is an example service with method signatures for CRUD logic
public interface UserService extends UserDetailsService {

    User create(User user);

    List<User> findAll();

    User findById(String id);

    User updateById(String id, User user);

    void deleteById(String id);

    List<User> getUsersBySalary(double minSalary, double maxSalary);

    /*List<Auction> getAuctionsByUserId(int id);*/
}
