package be.syntra.auction.services;

import be.syntra.auction.domain.User;

import java.util.List;

public interface UserService {

    User findById(Long id);
    void registerUser(User user);
    void updateUser(Long id, User user);
    void deleteUser(Long id);

    void login(User user);
    User findByUsername(String username);
    List<User> findAllUsers();


}
