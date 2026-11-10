package fr.simplon.domedespuys.services;

import fr.simplon.domedespuys.dto.ImageDTO;
import fr.simplon.domedespuys.entity.Image;
import fr.simplon.domedespuys.interfaces.IImageService;

public class ImageServiceImpl implements IImageService {
    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Image create(ImageDTO dto) {
        return null;
    }
}
