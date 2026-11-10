package fr.simplon.domedespuys.interfaces;

import fr.simplon.domedespuys.dto.BrandDTO;
import fr.simplon.domedespuys.entity.Brand;

public interface IBrandService extends
        ICreate<Brand, BrandDTO>,
        ICollection
{
}
