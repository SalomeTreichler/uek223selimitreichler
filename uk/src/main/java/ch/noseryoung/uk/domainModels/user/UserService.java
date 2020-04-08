package ch.noseryoung.uk.domainModels.user;

import java.util.List;
import ch.noseryoung.uk.domainModels.auction.Auction;

// This is an example service with method signatures for CRUD logic
public interface UserService {

    User create(User user);

    List<User> findAll();

    User findById(int id);

    User updateById(int id, User user);

    void deleteById(int id);

    List<User> getUsersBySalary(double minSalary, double maxSalary);

    /*List<Auction> getAuctionsByUserId(int id);*/
}
