package fr.simplon.domedespuys.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.entity.Product;
import fr.simplon.domedespuys.interfaces.IProductService;
import fr.simplon.domedespuys.repository.ProductRepository;
import fr.simplon.domedespuys.view.ProductView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{id}")
    @JsonView(ProductView.ProductDetailView.class)
    private Product getProductById(@PathVariable String id){
        return productService.getById(id);
    }
}
