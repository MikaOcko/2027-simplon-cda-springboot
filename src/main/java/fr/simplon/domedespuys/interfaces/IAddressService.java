package fr.simplon.domedespuys.interfaces;


import fr.simplon.domedespuys.dto.AddressDTO;
import fr.simplon.domedespuys.entity.Address;

public interface IAddressService extends
        IGetItem<Address>,
        ICreate<Address, AddressDTO>,
        IUpdate<Address, AddressDTO>,
        IDelete
{
}
