package fr.simplon.domedespuys.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.dto.BrandDTO;
import fr.simplon.domedespuys.dto.ProductDTO;
import fr.simplon.domedespuys.entity.Brand;
import fr.simplon.domedespuys.entity.Product;
import fr.simplon.domedespuys.interfaces.IProductService;
import fr.simplon.domedespuys.repository.ProductRepository;
import fr.simplon.domedespuys.view.BrandView;
import fr.simplon.domedespuys.view.ProductView;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/product")
public class ProductRestController {
    private final IProductService productService;

    @GetMapping
    @JsonView(ProductView.ProductListView.class)
    private List<Product> getProducts(){
        return productService.getCollection();
    }

    @PostMapping
    @JsonView(ProductView.ProductDetailView.class)
    public Product createProduct(@Valid @RequestBody ProductDTO dto) {
        return productService.create(dto);
    }

    @GetMapping("/{id}")
    @JsonView(ProductView.ProductDetailView.class)
    private Product getProductById(@PathVariable String id){
        return productService.getById(id);
    }

    @PutMapping("/{id}")
    @JsonView(ProductView.ProductDetailView.class)
    private Product updateProduct(@Valid @PathVariable String id, @RequestBody ProductDTO dto){
        return productService.update(id, dto);
    }


}
