package be.syntra.auction.services;

import be.syntra.auction.domain.Category;
import be.syntra.auction.domain.Item;
import be.syntra.auction.exceptions.EntityNotFoundException;
import be.syntra.auction.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;


    @Override
    public Category findById(Long id) {
        Optional<Category> entity = categoryRepository.findById(id);
        return unwrapCategory(entity, id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Set<Item> findItems(Long id) {
        Optional<Category> entity = categoryRepository.findById(id);
        Category category = unwrapCategory(entity, id);
        return category.getItems();
    }

    public static Category unwrapCategory(Optional<Category> entity, Long id) {
        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new EntityNotFoundException(id, Category.class);
        }
    }

}
