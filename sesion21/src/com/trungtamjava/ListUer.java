package com.trungtamjava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/listuser")
public class ListUer  extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter =resp.getWriter();
		printWriter.print("<table class=\"table table-bordered\">\r\n" + 
				"		<!-- dong thi the tr -->\r\n" + 
				"		<thead>\r\n" + 
				"			<tr>\r\n" + 
				"				<th>ID</th>\r\n" + 
				"				<th>email</th>\r\n" + 
				"				<th>name</th>\r\n" + 
				"				<th>actioan</th>\r\n" + 
				"			</tr>\r\n" + 
				"		</thead>\r\n" + 
				"		<tbody>\r\n" + 
				"			<tr>\r\n" + 
				"				<td>1</td>\r\n" + 
				"				<td>vanhao5433@gmail.com</td>\r\n" + 
				"				<td>van hao</td>\r\n" + 
				"				<td><a href=\"#\"> edit</a> <a href=\"#\"> delete</a></td>\r\n" + 
				"			</tr>\r\n" + 
				"			<tr>\r\n" + 
				"				<td>2</td>\r\n" + 
				"				<td>vanhao5433@gmail.com</td>\r\n" + 
				"				<td>van hao</td>\r\n" + 
				"				<td><a href=\"#\"> edit</a> <a href=\"#\"> delete</a></td>\r\n" + 
				"			</tr>\r\n" + 
				"			<tr>\r\n" + 
				"				<td>3</td>\r\n" + 
				"				<td colspan=\"2\" rowspan=\"2\">vanhao5433@gmail.com</td>\r\n" + 
				"			\r\n" + 
				"				<td><a href=\"#\"> edit</a> <a href=\"#\"> delete</a></td>\r\n" + 
				"			</tr>\r\n" + 
				"				<tr>\r\n" + 
				"				<td>4</td>\r\n" + 
				"	\r\n" + 
				"			\r\n" + 
				"				<td><a href=\"#\"> edit</a> <a href=\"#\"> delete</a></td>\r\n" + 
				"			</tr>\r\n" + 
				"		</tbody>\r\n" + 
				"\r\n" + 
				"		<tfoot>\r\n" + 
				"			<tr>\r\n" + 
				"				<th>ID</th>\r\n" + 
				"				<th>email</th>\r\n" + 
				"				<th>name</th>\r\n" + 
				"				<th>actioan</th>\r\n" + 
				"			</tr>\r\n" + 
				"		</tfoot>\r\n" + 
				"		\r\n" + 
				"\r\n" + 
				"	</table>");
		printWriter.close();

	}}
