/**
 * StudentDAO class that encapsulates code to store and retrieve the Survey data into/from 
 * a database. It provides two methods: one to save the Student Survey Form data 
 * to a database table and another to retrieve the survey information from the database
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;


import managedBean.studentBean;

/**
 * 
 * @author rutujajadhav
 * StudentDao
 * It encapsulates code to store and retrieve the Survey data into/from a database. 
 * It provides two methods:one to save the Student Survey Form data to a database table
 *  and another to retrieve the survey information from the database
 *
 */
@WebServlet(name="StudentDao" ,urlPatterns = {"/StudentDao"})
public class StudentDao {
	public void saveForm(HttpServletRequest req) {
		String studID = req.getParameter("StudentID");
		String fullname = req.getParameter("FullName");
		String email = req.getParameter("e");
		String phone = req.getParameter("p");
		String url = req.getParameter("u");
		String address = req.getParameter("a");
		String zipCode = req.getParameter("z");
		String city = req.getParameter("City");
		String state = req.getParameter("State");
		String comments = req.getParameter("c");

		studentBean studentBean = new studentBean();

		studentBean.setStudID(studID);
		studentBean.setFullname(fullname);
		studentBean.setEmail(email);
		studentBean.setPhone(phone);
		studentBean.setUrl(url);
		studentBean.setAddress(address);
		studentBean.setZipCode(zipCode);
		studentBean.setCity(city);
		studentBean.setState(state);
		studentBean.setComments(comments);


		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch(ClassNotFoundException e) {
			Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, "Driver class not found", e);
		}

		try {
			Connection con;
			con = DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu", "rjadhav2", "oxufetso");
			String insertSql = "INSERT INTO STUDENT" + "(STUDID, FULLNAME, EMAIL, PHONE, URL, ADDRESS, ZIPCODE, CITY, STATE, COMMENTS) VALUES" + "(?,?,?,?,?,?,?,?,?,?)";
			//jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu
			try (PreparedStatement preparedStmt = con.prepareStatement(insertSql)) {
				preparedStmt.setString(1, studentBean.getStudID());
				preparedStmt.setString(2, studentBean.getFullname());
				preparedStmt.setString(3, studentBean.getEmail());
				preparedStmt.setString(4, studentBean.getPhone());
				preparedStmt.setString(5, studentBean.getUrl());
				preparedStmt.setString(6, studentBean.getAddress());
				preparedStmt.setString(7, studentBean.getZipCode());
				preparedStmt.setString(8, studentBean.getCity());
				preparedStmt.setString(9, studentBean.getState());
				preparedStmt.setString(10, studentBean.getComments());
				preparedStmt.executeUpdate();
			}


			con.close();   

		} catch(SQLException sqlEx){
			Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, "sqlException during insert", sqlEx);
		}
	}
public studentBean retrieveForm(String id){
        
        Statement statement = null;
        studentBean stBean = new studentBean();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
        } catch(ClassNotFoundException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, "OracleDriver Class not Found", ex);
        }
        
        try {
            Connection con;
            con = DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu", "rjadhav2", "oxufetso");
            id = "'"+id+"'";
            String selectSql = "SELECT * from STUDENT where STUDID = " +id;  
            statement = con.createStatement();
            
            
            ResultSet rs = statement.executeQuery(selectSql);
            
            while(rs.next()) {
                stBean.setStudID(rs.getString("STUDID"));
                stBean.setFullname(rs.getString("FULLNAME"));
                stBean.setEmail(rs.getString("EMAIL"));
                stBean.setPhone(rs.getString("PHONE"));
                stBean.setUrl(rs.getString("URL"));
                stBean.setAddress(rs.getString("ADDRESS"));
                stBean.setZipCode(rs.getString("ZIPCODE"));
                stBean.setCity(rs.getString("CITY"));
                stBean.setState(rs.getString("STATE"));
                stBean.setComments(rs.getString("COMMENTS"));
            }
            
            statement.close();
            con.close();
                 
        
    }catch(SQLException e){
        Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, "sqlException during retrieve", e);
        
    }
    return stBean;
    }
}
