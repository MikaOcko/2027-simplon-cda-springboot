package fr.simplon.domedespuys.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.entity.User;
import fr.simplon.domedespuys.interfaces.IUserService;
import fr.simplon.domedespuys.repository.UserRepository;
import fr.simplon.domedespuys.view.UserView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/{id}")
    @JsonView(UserView.UserDetailView.class)
    private User getUserById(@PathVariable String id){
        return userService.getById(id);
    }
}
