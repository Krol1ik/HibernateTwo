package serviceUser;

import dao.UserDao;
import dao.UserDaoImpl;
import models.Users;

import java.util.List;

public class ServiceUser {
    private UserDao userDao = new UserDaoImpl();

    public void saveUser(Users users) {
        userDao.save(users);
    }

    public void updateUser(Users users){
        userDao.update(users);
    }

    public void deleteUser (Users users){
        userDao.delete(users);
    }

    public Users findByUser (int id){
        return userDao.findId(id);
    }

    public List<Users> findAllUsers (){
        return userDao.findAllUsers();
    }
}
