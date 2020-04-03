package ch.noseryoung.uk.domainModels.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

// This is an example service implementation with coded out CRUD logic
// Note that the @Service annotation belongs on here as the effective logic is found here
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // The logic for creating a new user
    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    // The logic for retrieving all user
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // The logic for retrieving a single user with a given id
    @Override
    public User findById(String id) {
        return userRepository.findById(id).get();
    }

    // The logic for updating an existing user with a given id and data
    @Override
    public User updateById(String id, User user) {
        if(userRepository.existsById(id)) {
            user.setId(id);
            userRepository.save(user);

            return user;
        } else {
            throw new NoSuchElementException("No value present");
        }
    }

    // The logic for deleting an authority with a given id
    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    // This method is needed for login purposes
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return new UserDetailsImpl(findByUsername(username));
        } catch (NoSuchElementException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }

    // This method finds a user by it's username, it's private as it's never needed outside this class
    private User findByUsername(String username) {
        return userRepository.findByUsernameAndLockedFalse(username);
    }

}
