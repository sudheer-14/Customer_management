package com.customer.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.dao.UserDao;
import com.customer.model.Customer;
import com.customer.model.User;


@WebServlet("/")
public class Myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Myservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		switch(path)
		{
		case "/validate":validateuser(request,response);
						break;
		case "/user":userlist(request,response);
						break;
		case "/userform":userform(request,response);
						break;
		case "/insert":insertcustomer(request,response);
						break;
		case "/delete":deleterUserbyId(request,response);
						break;
		case"/edit":selectuserbyId(request,response);
						break;
		case"/update":updatecustomer(request,response);
						break;
		default:Loginpage(request,response);
		
		}
	}

	
	private void updatecustomer(HttpServletRequest request, HttpServletResponse response) {

		String firstname=request.getParameter("firstname");
		String lastname =request.getParameter("lastname");
		String street = request.getParameter("street");
		String address =request.getParameter("address");
		String city =request.getParameter("city");
		String state = request.getParameter("state");
		String email = request.getParameter("email");
		long phone = Long.parseLong(request.getParameter("phone"));
		Customer c = new Customer( firstname, lastname, street, address, city, state, email, phone);
		UserDao.updatecustomer(c);
		try {
			response.sendRedirect("user");
  			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void selectuserbyId(HttpServletRequest request, HttpServletResponse response) {
		
		int id =Integer.parseInt(request.getParameter("id"));
		Customer c = UserDao.selectcustomer(id);
		request.setAttribute("list", c);
		RequestDispatcher rd = request.getRequestDispatcher("userform.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private void deleterUserbyId(HttpServletRequest request, HttpServletResponse response) {
	
		int id = Integer.parseInt(request.getParameter("id"));
		UserDao.deleteuser(id);
		try {
			response.sendRedirect("user");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void insertcustomer(HttpServletRequest request, HttpServletResponse response) {
		
		String firstname=request.getParameter("firstname");
		String lastname =request.getParameter("lastname");
		String street = request.getParameter("street");
		String address =request.getParameter("address");
		String city =request.getParameter("city");
		String state = request.getParameter("state");
		String email = request.getParameter("email");
		long phone = Long.parseLong(request.getParameter("phone"));
		
		Customer c = new Customer(firstname, lastname, street, address, city, state, email, phone);
		UserDao.insertcust(c);
		try {
			response.sendRedirect("user");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void userform(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd = request.getRequestDispatcher("userform.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void userlist(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<Customer> cs = UserDao.displaycust();
		request.setAttribute("display", cs);
		
	  RequestDispatcher rd = request.getRequestDispatcher("userlist.jsp");
	  try {
		rd.forward(request, response);
	} catch (ServletException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}


	private void validateuser(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User u = new User(username, password);
		String status = UserDao.validateuser(u);
		if(status.equals("success")) {
			RequestDispatcher rd = request.getRequestDispatcher("user");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	private void Loginpage(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
