package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.ServiceUser;
import service.ServiceUserImpl;

@WebServlet("/signin")
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<form action='/sisionn4/signin' method='post'>");
		printWriter.println("username: <input type='text' name='username'>");
		printWriter.println("password: <input type='password' name='password'>");
		printWriter.println("<button type='submit' name='submit'>Sign in</button>");
		printWriter.println("</form");
		printWriter.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		ServiceUser serviceUser = new ServiceUserImpl();

		User user = serviceUser.findUser(username);
		
		if (user != null && user.getPassword().equals(password)) {
			HttpSession httpSession = req.getSession();
			
			httpSession.setAttribute("loginUser", user);
			if (user.getRole().equals("admin")) {
				resp.sendRedirect("/sisionn4/admin/");
			} else {
				resp.sendRedirect("/sisionn4/welcome/");
			}
		} else {
			resp.sendRedirect("/sisionn4/signin");
		}
	}
}
