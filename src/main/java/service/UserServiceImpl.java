package service;

import Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private List<User> users = new ArrayList<>();

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public boolean saveUser(User u) {

        if (users.add(u)){
            return true;
        }
        return false;
    }
}
