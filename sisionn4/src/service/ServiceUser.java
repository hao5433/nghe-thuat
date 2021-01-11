package service;

import model.User;

public interface ServiceUser {
	void imput(User user);

	void info(User user);

	void createUser(User user) throws Exception;

	User findUser(String username);

}
