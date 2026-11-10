package fr.simplon.domedespuys.services;

import fr.simplon.domedespuys.dto.User.UserPostDTO;
import fr.simplon.domedespuys.dto.User.UserPutDTO;
import fr.simplon.domedespuys.entity.User;
import fr.simplon.domedespuys.interfaces.IUserService;
import fr.simplon.domedespuys.repository.UserRepository;

public class UserServiceImpl implements IUserService {
    private UserRepository userRepository;

    @Override
    public User create(UserPostDTO dto) {
        User user = new User();
        
        user.setEmail(dto.email);
        user.setPassword(dto.password);
        user.setFirstname(dto.firstname);
        user.setLastname(dto.lastname);
        userRepository.saveAndFlush(user);

        return user;
    }

    @Override
    public User getById(String id) {
        return null;
    }

    @Override
    public User update(String id, UserPutDTO dto) {
        return null;
    }
}
