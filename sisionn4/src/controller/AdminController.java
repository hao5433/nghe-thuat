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

@WebServlet("/admin/")
public class AdminController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		PrintWriter printWriter = resp.getWriter();

		HttpSession httpSession = req.getSession();

		Object obj = httpSession.getAttribute("loginUser");

		if (!(obj != null && ((User) obj).getRole().equals("admin")))
			resp.sendRedirect("/sisionn4/signin");

		printWriter.println("<h1>Welcome admin</h1>");

		printWriter.println("<form action='/sisionn4/create' method='post'>");
		printWriter.println("Username: <input type='text' name='username' required>");
		printWriter.println("Password: <input type='password' name='password' required>");
		printWriter.println("<button type='submit' value='submit'>Add user</button>");
		printWriter.println("</form>");
		printWriter.println("<br><a href='/sisionn4/signout'>Sign out</a>");
		printWriter.close();

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
