package Dao;

import model.User;
public interface UserDao {
	void create(User user) throws Exception;
    User find(String username);
}
