package br.com.t2_fat.techstore.services;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.t2_fat.techstore.domain.Product;
import br.com.t2_fat.techstore.repository.ProductRepository;

@Service

public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Product save(Product p) {
    return repo.save(p);
}


}