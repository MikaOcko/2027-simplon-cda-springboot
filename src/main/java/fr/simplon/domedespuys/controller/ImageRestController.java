package fr.simplon.domedespuys.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.dto.ImageDTO;
import fr.simplon.domedespuys.entity.Image;
import fr.simplon.domedespuys.entity.Product;
import fr.simplon.domedespuys.interfaces.IImageService;
import fr.simplon.domedespuys.view.ExceptionView;
import fr.simplon.domedespuys.view.ImageView;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/image")
public class ImageRestController {
    private final IImageService imageService;

    @PostMapping
    @JsonView(ImageView.ImageListView.class)
    public Image createImage(@Valid  @RequestBody ImageDTO dto, Product product) {
        return imageService.create(dto, product);
    }

    @DeleteMapping("/{id}")
    @JsonView({ImageView.ImageListView.class, ExceptionView.ExceptionViewFull.class})
    public boolean delete(@PathVariable String id) {
        return imageService.delete(id);
    }
}
