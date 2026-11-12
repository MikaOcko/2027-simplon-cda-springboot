package fr.simplon.domedespuys.services;

import fr.simplon.domedespuys.dto.BrandDTO;
import fr.simplon.domedespuys.dto.ImageDTO;
import fr.simplon.domedespuys.dto.ProductDTO;
import fr.simplon.domedespuys.entity.Brand;
import fr.simplon.domedespuys.entity.Product;
import fr.simplon.domedespuys.interfaces.IBrandService;
import fr.simplon.domedespuys.interfaces.IImageService;
import fr.simplon.domedespuys.interfaces.IProductService;
import fr.simplon.domedespuys.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private ProductRepository productRepository;
    private IBrandService brandService;
    private IImageService imageService;

    @Override
    public List<Product> getCollection() {
        return productRepository.findAll();
    }

    @Override
    public Product create(ProductDTO dto) {
        Product product = new Product();

        product.setLabel(dto.label);
        product.setDescription(dto.description);
        product.setPrice(dto.price);
        product.setSlug(dto.label.trim().toLowerCase());
        product.setCreatedAt(LocalDateTime.now());
        product.setBrand(brandService.getById(dto.brandId));

        productRepository.saveAndFlush(product);

        for (ImageDTO imageDTO : dto.images){
            imageService.create(imageDTO, product);
        }

        imageService.flush();

        return product;
    }

    @Override
    public Product getById(String id) {
        return productRepository
                .findById(Long.parseLong(id))
                .orElse(null);
    }

    @Override
    public Product update(String id, ProductDTO dto) {
        Product product = getById(id);
        
        if (product != null) {
            product.setLabel(dto.label);
            product.setDescription(dto.description);
            product.setPrice(dto.price);
            product.setSlug(dto.label.trim().toLowerCase());
            product.setBrand(brandService.getById(dto.brandId));

            productRepository.saveAndFlush(product);
        }

        return product;
    }
}
