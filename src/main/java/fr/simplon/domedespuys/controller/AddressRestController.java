package fr.simplon.domedespuys.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.dto.AddressDTO;
import fr.simplon.domedespuys.entity.Address;
import fr.simplon.domedespuys.interfaces.IAddressService;
import fr.simplon.domedespuys.view.AddressView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/address")
public class AddressRestController {
    private final IAddressService addressService;

    @GetMapping("/{id}")
    @JsonView(AddressView.AddressDetailView.class)
    public Address getAddressById(@PathVariable String id){
        return addressService.getById(id);
    }

    @PostMapping
    @JsonView(AddressView.AddressDetailView.class)
    public Address createAddress(@RequestBody AddressDTO dto) {
        return addressService.create(dto);
    }

    @PutMapping("/{id}")
    @JsonView(AddressView.AddressDetailView.class)
    public Address updateAddress(@PathVariable String id, @RequestBody AddressDTO dto) {
        return addressService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @JsonView(AddressView.AddressDetailView.class)
    public boolean delete(@PathVariable String id) {
        return addressService.delete(id);
    }
    
}
