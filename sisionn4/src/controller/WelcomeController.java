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

@WebServlet(urlPatterns = "/welcome")
public class WelcomeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");

		PrintWriter printWriter = resp.getWriter();

		String username = "";

		HttpSession httpSession = req.getSession();

		Object obj = httpSession.getAttribute("loginUser");

		if (obj != null && ((User) obj).getRole().equals("user"))
			username = ((User) obj).getUsername();
		else
			resp.sendRedirect("/sisionn4/signin");

		printWriter.println("<h1>Welcome " + username + "</h1>");

		printWriter.println("<a href='/sisionn4/signout'>Sign out</a>");
		printWriter.close();

	}
	
}
