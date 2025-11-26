package io.github.marrafon91.salvarParaMuitos.services;

import io.github.marrafon91.salvarParaMuitos.dto.ProductDTO;
import io.github.marrafon91.salvarParaMuitos.entities.Category;
import io.github.marrafon91.salvarParaMuitos.entities.Product;
import io.github.marrafon91.salvarParaMuitos.repositories.CategoryRepository;
import io.github.marrafon91.salvarParaMuitos.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    @Autowired
    CategoryRepository categoryRepository;

    public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();

        entity.setName(dto.name());
        entity.setPrice(dto.price());

        dto.categories().forEach(catDTO -> {
            Category cat = categoryRepository.getReferenceById(catDTO.id());
            entity.getCategories().add(cat);
        });

        Product saved = repository.save(entity);
        return new ProductDTO(saved);
    }
}
