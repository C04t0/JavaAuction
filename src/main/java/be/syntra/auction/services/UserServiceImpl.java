package be.syntra.auction.services;

import be.syntra.auction.domain.Item;
import be.syntra.auction.domain.User;
import be.syntra.auction.exceptions.EntityNotFoundException;
import be.syntra.auction.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        Optional<User> entity = userRepository.findById(id);
        return unwrapUser(entity, id);
    }

    @Override
    public void login(User user) {

    }
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void registerUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        User target = findById(id);
        target.setBillingAddress(user.getBillingAddress());
        target.setUsername(user.getUsername());
        target.setFirstName(user.getFirstName());
        target.setLastName(user.getLastName());
        userRepository.save(target);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        Optional<User> entity = userRepository.findByUsername(username);
        User user = unwrapUser(entity, entity.get().getId());
        return user;
    }

    public static User unwrapUser(Optional<User> entity, Long id) {
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new EntityNotFoundException(id, User.class);
        }
    }

}
