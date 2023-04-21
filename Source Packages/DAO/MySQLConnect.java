/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class MySQLConnect {
    public static Connection getConnection() {
		Connection c=null;
		try {
			//đăng kí driver bằng drivermanager
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			//các thông số của cơ sở dữ liệu
			String url="jdbc:mySQL://localhost:3306/qlst_mn";
			String user="root";
			String password="";
			
			//tạo kết nối
			c=DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return c;
	}
	public static void closeConnection(Connection c) {
		try {
			if(c!=null) {
				c.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void printInfo(Connection c) {
		try {
			if(c!=null) {
				System.out.println(c.getMetaData().toString());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
