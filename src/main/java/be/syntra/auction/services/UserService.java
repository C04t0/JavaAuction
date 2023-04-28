package be.syntra.auction.services;

import be.syntra.auction.domain.User;

public interface UserService {

    User findById(Long id);
    void registerUser(User user);
    void updateUser(Long id, User user);
    void deleteUser(Long id);
    User findByUsername(String username);

}
