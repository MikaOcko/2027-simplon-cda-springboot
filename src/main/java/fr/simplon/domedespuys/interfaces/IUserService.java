package fr.simplon.domedespuys.interfaces;


import fr.simplon.domedespuys.dto.User.UserPostDTO;
import fr.simplon.domedespuys.dto.User.UserPutDTO;

import fr.simplon.domedespuys.entity.User;

public interface IUserService extends
        ICreate<User, UserPostDTO>,
        IUpdate<User, UserPutDTO>,
        IGetItem<User>
        //IDelete
{
}
