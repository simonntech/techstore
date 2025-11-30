package br.com.t2_fat.techstore.api;
import br.com.t2_fat.techstore.domain.Category;
import br.com.t2_fat.techstore.repository.CategoryRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/categories")
public class CategoryRestController {
    private final CategoryRepository repo;
    public CategoryRestController(CategoryRepository repo) {
        this.repo = repo;
    }
     
    @GetMapping
    public List<Category> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable Long id) {
        return repo.findById(id).map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category c) {
        Category saved = repo.save(c);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
