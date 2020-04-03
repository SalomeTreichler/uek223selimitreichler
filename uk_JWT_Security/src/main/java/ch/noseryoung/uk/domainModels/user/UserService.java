package ch.noseryoung.uk.domainModels.user;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

// This is an example service with method signatures for CRUD logic
// We now have to extend this service with the interface UserDetailsService for implementing the necessary
// security feature Spring Boot offers
public interface UserService extends UserDetailsService {

    User create(User user);

    List<User> findAll();

    User findById(String id);

    User updateById(String id, User user);

    void deleteById(String id);

}
