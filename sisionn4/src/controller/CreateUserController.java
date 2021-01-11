package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.ServiceUser;
import service.ServiceUserImpl;

@WebServlet("/create")
public class CreateUserController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);

		ServiceUser serviceUser = new ServiceUserImpl();
		try {
			serviceUser.createUser(user);
			printWriter.println("<h3>Create Successfully!</h3>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			printWriter.println("<h3>" + e.getMessage() + "</h3>");

			RequestDispatcher dispatcher = req.getRequestDispatcher("/admin");

			dispatcher.include(req, resp);
			e.printStackTrace();
		}
	}
}
