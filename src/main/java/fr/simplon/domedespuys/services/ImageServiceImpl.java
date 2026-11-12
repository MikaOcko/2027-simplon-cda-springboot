package fr.simplon.domedespuys.services;

import fr.simplon.domedespuys.dto.ImageDTO;
import fr.simplon.domedespuys.entity.Image;
import fr.simplon.domedespuys.entity.Product;
import fr.simplon.domedespuys.interfaces.IImageService;
import fr.simplon.domedespuys.repository.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements IImageService {
    private ImageRepository imageRepository;

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Image create(ImageDTO dto, Product product) {
        Image image = new Image();
        image.setProduct(product);
        image.setIsDefault(dto.isDefault);
        image.setPath(dto.path);
        image.setExtension("png");
        imageRepository.save(image);
        return image;
    }

    @Override
    public void flush(){
        imageRepository.flush();
    }

}
