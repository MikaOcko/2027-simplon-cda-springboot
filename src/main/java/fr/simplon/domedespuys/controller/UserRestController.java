package fr.simplon.domedespuys.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.dto.BrandDTO;
import fr.simplon.domedespuys.dto.User.UserPostDTO;
import fr.simplon.domedespuys.dto.User.UserPutDTO;
import fr.simplon.domedespuys.entity.Brand;
import fr.simplon.domedespuys.entity.User;
import fr.simplon.domedespuys.interfaces.IUserService;
import fr.simplon.domedespuys.repository.UserRepository;
import fr.simplon.domedespuys.view.BrandView;
import fr.simplon.domedespuys.view.UserView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserRestController {
    private final IUserService userService;

    /*
    @GetMapping
    @JsonView(UserView.UserListView.class)
    private List<User> getUsers(){
        return userRepository.findAll();
        return userService.getCollection();
    }
    */

    @PostMapping
    @JsonView(UserView.UserDetailView.class)
    public User createUser(@RequestBody UserPostDTO dto) {
        return userService.create(dto);
    }

    @GetMapping("/{id}")
    @JsonView(UserView.UserDetailView.class)
    private User getUserById(@PathVariable String id){
        return userService.getById(id);
    }

    @PutMapping("/{id}")
    private User updateUser(@PathVariable String id, @RequestBody UserPutDTO dto){
        return userService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @JsonView(UserView.UserDetailView.class)
    private boolean deleteUser(@PathVariable String id){
        return userService.delete(id);
    }
}

