package fr.simplon.domedespuys.services;

import fr.simplon.domedespuys.dto.User.UserPostDTO;
import fr.simplon.domedespuys.dto.User.UserPutDTO;
import fr.simplon.domedespuys.entity.Brand;
import fr.simplon.domedespuys.entity.User;
import fr.simplon.domedespuys.interfaces.IUserService;
import fr.simplon.domedespuys.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    private UserRepository userRepository;

    @Override
    public User create(UserPostDTO dto) {
        User user = new User();

        user.setEmail(dto.email);
        user.setPassword(dto.password);
        user.setFirstname(dto.firstname);
        user.setLastname(dto.lastname);
        user.setCreatedAt(LocalDateTime.now());
        
        userRepository.saveAndFlush(user);

        return user;
    }

    @Override
    public User getById(String id) {
        return userRepository
                .findById(Long.parseLong(id))
                .orElse(null);
    }

    @Override
    public User update(String id, UserPutDTO dto) {
        User user = getById(id);
        if (user != null) {

            user.setFirstname(dto.firstname);
            user.setLastname(dto.lastname);
            user.setPhone(dto.phone);

            userRepository.saveAndFlush(user);
        }
        return user;
    }

    @Override
    public boolean delete(String id) {
        try {
            userRepository.deleteById(Long.parseLong(id));
            return true;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
