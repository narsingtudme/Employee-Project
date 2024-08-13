package comm.qsp.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import comm.qsp.model.Employee;

public class EmployeeController {
	static Connection con;
	static String url = "jdbc:postgresql://localhost:5432/qsp";
	static String pass = "root";
	static String user = "postgres";

	static {
		try {
			Class.forName("org.postgresql.Driver");
			// 2nd step
			con = DriverManager.getConnection(url, user, pass);
			System.out.println(con);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public static void insert(Employee e) {
		// 3rd step
		try {
			PreparedStatement ps = con.prepareStatement("insert into Employee values(?,?,?)");
			// printing the value to delimeter
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setDouble(3, e.getSal());
			// 4th step
			ps.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public static boolean updateNameById(int id, String name) {
		// 3rd step
		Employee emp=fetchById(id);
		if(emp.getName()!=null) {
			try {
				PreparedStatement ps=con.prepareStatement("update employee set name=? where id=?");
				ps.setString(1, name);
				ps.setInt(2, id);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
			
		}
		else {
			return false;
		}
	}
	public static boolean deleteById(int id) {
		Employee e=fetchById(id);
		if(e.getName()!=null) {
			try {
				PreparedStatement ps=con.prepareStatement("delete from employee where id=?");
				ps.setInt(1, id);
				ps.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return true;
		}
		else {
			return false;
		}
		
	}

	public static Employee fetchById(int id) {
		Employee e = new Employee();
		try {
			PreparedStatement ps = con.prepareStatement("select * from employee where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				e.setId(rs.getInt("id"));
				e.setName(rs.getString("name"));
				e.setSal(rs.getDouble("sal"));

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}
	public static List<Employee> fetchAll(){
		List<Employee> li=new ArrayList<Employee>();
		try {
			PreparedStatement ps=con.prepareStatement("select * from employee");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Employee emp=new Employee();
				emp.setId(rs.getInt("Id"));
				emp.setName(rs.getString("name"));
				emp.setSal(rs.getDouble("Sal"));
				li.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return li;
		
	}

}
