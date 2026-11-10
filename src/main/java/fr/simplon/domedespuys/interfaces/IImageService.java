package fr.simplon.domedespuys.interfaces;

import fr.simplon.domedespuys.entity.Image;

public interface IImageService extends
        IDelete,
        ICreate<Image, ImageDTO>
{
}
