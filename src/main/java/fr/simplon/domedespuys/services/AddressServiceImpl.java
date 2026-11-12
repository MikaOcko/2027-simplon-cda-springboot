package fr.simplon.domedespuys.services;

import fr.simplon.domedespuys.dto.AddressDTO;
import fr.simplon.domedespuys.entity.Address;
import fr.simplon.domedespuys.interfaces.IAddressService;
import fr.simplon.domedespuys.repository.AddressRepository;
import fr.simplon.domedespuys.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements IAddressService {

    private AddressRepository addressRepository;

    @Override
    public Address create(AddressDTO dto) {
        Address address = new Address();

            address.setLine(dto.line);
            address.setExtraLine(dto.extraLine);
            address.setCity(dto.city);
            address.setZipCode(dto.zipCode);
            address.setCountry(dto.country);
            address.setPhone(dto.phone);
            address.setFirstname(dto.firstname);
            address.setLastname(dto.lastname);

            addressRepository.saveAndFlush(address);

        return address;

    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Address update(String id, AddressDTO dto) {
        return null;
    }
}
