package be.syntra.auction.services;

import be.syntra.auction.domain.Category;
import be.syntra.auction.domain.Item;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    Category findById(Long itemId);
    List<Category> findAll();
    Set<Item> findItems(Long id);
}
