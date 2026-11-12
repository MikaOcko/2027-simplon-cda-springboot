package fr.simplon.domedespuys.interfaces;

import fr.simplon.domedespuys.dto.ImageDTO;
import fr.simplon.domedespuys.entity.Image;
import fr.simplon.domedespuys.entity.Product;

public interface IImageService extends IDelete {

    Image create(ImageDTO dto, Product product);

}
