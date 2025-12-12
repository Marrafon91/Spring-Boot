package io.github.marrfon91.login_acesso.services;

import io.github.marrfon91.login_acesso.dto.ProductDTO;
import io.github.marrfon91.login_acesso.entities.Product;
import io.github.marrfon91.login_acesso.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Product entity = productRepository.findById(id).get();
        return new ProductDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();
        entity.setName(dto.name());
        entity = productRepository.save(entity);
        return new ProductDTO(entity);
    }
}
