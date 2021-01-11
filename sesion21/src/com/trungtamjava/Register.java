package com.trungtamjava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class Register  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter=resp.getWriter();
		printWriter.print("	<form action=\"#\" method=\"post\">\r\n" + 
				"		<div>\r\n" + 
				"			<label>Username :</label> <input type=\"text\" name=\"name\"\r\n" + 
				"				maxlength=\"20\" required placeholder=\"xin moi nhap\" />\r\n" + 
				"		</div>\r\n" + 
				"		<div>\r\n" + 
				"			<label>Password:</label> <input type=\"password\" name=\"password\"\r\n" + 
				"				required placeholder=\"xin moi nhap\" />\r\n" + 
				"		</div>\r\n" + 
				"		<div>\r\n" + 
				"			<label>Avatar:</label> <input type=\"file\" name=\"file\" required\r\n" + 
				"				/>\r\n" + 
				"		</div>\r\n" + 
				"		<div>\r\n" + 
				"			<label>City:</label> <select name=\"town\" size=\"3\">\r\n" + 
				"				<option values=\"hn\">ha noi</option>\r\n" + 
				"				<option values=\"hcm\">ho chi minh</option>\r\n" + 
				"				<option values=\"dn\">da nang</option>\r\n" + 
				"			</select>\r\n" + 
				"		</div>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"		<button type=\"button\">login</button>\r\n" + 
				"	</form>");
		
		printWriter.close();
	}

}
