package com.trungtamjava;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/request")
public class ResquestServletDome  extends HttpServlet{
	  @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 System.out.println(req.getMethod());
		 req.getContentType();
		 req.getContextPath();
		 System.out.println(req.getServerName());
		 System.out.println(req.getServletPath());
   }  
}