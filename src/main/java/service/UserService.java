package service;

import Model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    boolean saveUser(User u);

}
