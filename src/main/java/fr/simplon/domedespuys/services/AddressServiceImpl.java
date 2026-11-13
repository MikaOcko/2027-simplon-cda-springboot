package fr.simplon.domedespuys.services;

import fr.simplon.domedespuys.dto.AddressDTO;
import fr.simplon.domedespuys.entity.Address;
import fr.simplon.domedespuys.entity.User;
import fr.simplon.domedespuys.interfaces.IAddressService;
import fr.simplon.domedespuys.interfaces.IUserService;
import fr.simplon.domedespuys.repository.AddressRepository;
import fr.simplon.domedespuys.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements IAddressService {

    private AddressRepository addressRepository;
    private IUserService userService;

    @Override
    public Address getById(String id) {
        return addressRepository
                .findById(Long.parseLong(id))
                .orElse(null);
    }

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
        address.setCreatedAt(LocalDateTime.now());
        address.setUser(userService.getById("10"));
        //address.setUser(new User());

        addressRepository.saveAndFlush(address);

        return address;
    }


    @Override
    public boolean delete(String id) {
        try {
            addressRepository.deleteById(Long.parseLong(id));
            return true;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Address update(String id, AddressDTO dto) {
        Address address = getById(id);

        if (address != null){
            address.setLine(dto.line);
            address.setExtraLine(dto.extraLine);
            address.setCity(dto.city);
            address.setZipCode(dto.zipCode);
            address.setCountry(dto.country);
            address.setPhone(dto.phone);
            address.setFirstname(dto.firstname);
            address.setLastname(dto.lastname);

            addressRepository.saveAndFlush(address);
        }

        return address;
    }

}
