package be.syntra.auction.controllers;

import be.syntra.auction.domain.Category;
import be.syntra.auction.domain.Item;
import be.syntra.auction.services.CategoryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;


@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryServiceImpl categoryService;

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getCategories() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}/items")
    public ResponseEntity<Set<Item>> getItemsFromCategory(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.findItems(id), HttpStatus.OK);
    }
}
