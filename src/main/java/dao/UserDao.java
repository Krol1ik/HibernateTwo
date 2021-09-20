package dao;

import models.Users;

import java.util.List;

public interface UserDao {

    Users findId(int id);
    void save (Users users);
    void update (Users users);
    void delete (Users users);
    List<Users> findAllUsers ();
}
