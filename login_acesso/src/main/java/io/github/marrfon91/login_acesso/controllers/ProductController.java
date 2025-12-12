package io.github.marrfon91.login_acesso.controllers;

import io.github.marrfon91.login_acesso.dto.ProductDTO;
import io.github.marrfon91.login_acesso.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController implements GenericController {

    @Autowired
    private ProductService productService;

    @GetMapping("{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        ProductDTO dto = productService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        List<ProductDTO> list = productService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO dto) {
        dto = productService.insert(dto);
        URI location = headerLocation(dto.id());
        return ResponseEntity.created(location).body(dto);
    }
}
