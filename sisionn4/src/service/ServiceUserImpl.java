package service;

import java.util.Scanner;

import Dao.UserDao;
import Dao.UserDaoImpl;
import model.User;

public class ServiceUserImpl implements ServiceUser {

	@Override
	public void createUser(User user) throws Exception {
		UserDao userDao = new UserDaoImpl();
		userDao.create(user);

	}

	@Override
	public User findUser(String username) {
		UserDao userDao = new UserDaoImpl();
		return userDao.find(username);
	}

	@Override
	public void imput(User user) {
		System.out.println("nhap username");
		Scanner sc = new Scanner(System.in);
		user.setUsername(sc.nextLine());
		System.out.println("nhap password");
		user.setPassword(sc.nextLine());
		System.out.println("nhap role");
		user.setRole(sc.nextLine());
	}

	@Override
	public void info(User user) {
		System.out.println("username" + user.getUsername());
		System.out.println("password" + user.getPassword());
		System.out.println("role" + user.getRole());
	}

}
