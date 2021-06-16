package testpack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import DB.connection.connection;
import java.sql.Date;


public class testtab1 {

public static void main(String[] args) {
	//String query ="INSERT INTO `testtab1`(`id`, `nai`, `name`) VALUES (?,?,?)";
	String query = "SELECT `id`, `nai`, `name` FROM `testtab1`";
	
	Connection c = connection.getConnection();
	try {
		PreparedStatement ps = c.prepareStatement(query);
		/*SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = new java.util.Date();
		
		ps.setObject(1, 1);
		ps.setObject(2, new Date(date.getTime()));
		ps.setObject(3, "fatima");
		*/
		
		ResultSet rs = ps.executeQuery();
		Object o = null;
		Object i= null;
		Object d = null;
		Object n = null;
		while(rs.next()) {
			i = rs.getObject(1);
			d = rs.getObject(2);
			n = rs.getObject(3);
		}
		System.out.println(i+" "+d+" "+n);
		ps.execute();
		ps.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
