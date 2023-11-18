package com.customer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.customer.model.Customer;
import com.customer.model.User;

public class UserDao {
	 public static String url="jdbc:mysql://localhost:3306/customer";
	 public static String user="root";
	 public static String password="bobby";
	 public static Connection con=null;
	 public static Statement st=null;
	 public static PreparedStatement ps =null;
	 public static ResultSet rs = null;
	 public static String insert ="insert into cust_list (firstname,lastname,street,address,city,state,email,phone) values(?,?,?,"
	 		+ "?,?,?,?,?)";
	 public static String select= "select * from cust_list";
	 public static String delete ="delete from cust_list where id=?";
	 public static String selectid ="select * from cust_list where id=?";
	 public static String updatecustomer="update cust_list set firstname=?,lastname=?,street=?,address=?,city=?,state=?,email=?,"
	 		+ "phone=? where id=?)";
	 public static String validateuser(User u) {
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			st=con.createStatement();
			rs =st.executeQuery("select * from user");
			while(rs.next()) {
				String dusername=rs.getString("username");
				String dpass = rs.getString("password");
				
				if(dusername.equals(u.getUsername()) && dpass.equals(u.getPassword()) ) {
					
					return "success";
			}
		  }
		 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
			 
			 try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
	 
	 return "failure";
 }
	 public static void insertcust(Customer c) {
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(insert);
			ps.setString(1, c.getFirstname());
			ps.setString(2, c.getLastname());
			ps.setString(3, c.getStreet());
			ps.setString(4, c.getAddress());
			ps.setString(5, c.getCity());
			ps.setString(6, c.getState());
			ps.setString(7, c.getEmail());
			ps.setLong(8,c.getPhone());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
			 try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 
	 }
	 public static ArrayList<Customer> displaycust() {
			ArrayList<Customer> cs = new ArrayList<Customer>();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				ps = con.prepareStatement(select);
				rs = ps.executeQuery();
				while(rs.next())
				{	
					int id =rs.getInt("id");
					String firstname=rs.getString("firstname");
					String lastname= rs.getString("lastname");
					String street = rs.getString("street");
					String address = rs.getString("address");
					String city = rs.getString("city");
					String state = rs.getString("state");
					String email = rs.getString("email");
					long phone = rs.getLong("phone");
					Customer c = new Customer(id,firstname, lastname, street, address, city, state, email, phone);
					cs.add(c);
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					rs.close();
					ps.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			return cs;
}
	 public static void deleteuser(int id) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				ps = con.prepareStatement(delete);
				ps.setInt(1, id);
				ps.executeUpdate();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	 public static Customer selectcustomer(int id1) {
		 Customer c = null;
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				ps = con.prepareStatement(selectid);
				ps.setInt(1, id1);
				rs= ps.executeQuery();
				rs.next();
				int id = rs.getInt("id");
				String firstname=rs.getString("firstname");
				String lastname= rs.getString("lastname");
				String street = rs.getString("street");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String state = rs.getString("state");
				String email = rs.getString("email");
				long phone = rs.getLong("phone");
				
				c = new Customer(id, firstname, lastname, street, address, city, state, email, phone);
		 } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return c;
			
			
		}
	public static void updatecustomer(Customer c) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			ps =con.prepareStatement(updatecustomer);
			ps.setString(1, c.getFirstname());
			ps.setString(2, c.getLastname());
			ps.setString(3, c.getStreet());
			ps.setString(4, c.getAddress());
			ps.setString(5, c.getCity());
			ps.setString(6, c.getState());
			ps.setString(7, c.getEmail());
			ps.setLong(8, c.getPhone());
			ps.setInt(9,c.getId());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	 
	 }
