/*
 * Servlet class.
 * The servlet stores this bean to the session object and forwards request to a
 *  StudentJSP using RequestDispatcher object to display the student data to the user. 
 */
package TestServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Statement;
import javax.servlet.http.HttpSession;
import managedBean.*;
import dao.*;
import java.util.ArrayList;
/**
 * 
 * @author rutujajadhav
 *
 */
@WebServlet(name = "TestServelet", urlPatterns = {"/TestServelet"})

public class TestServelet extends HttpServlet {
    
    public TestServelet(){
        super();
        System.out.println("Entered Servlet");
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServelet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestServelet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String[] clickedID = request.getParameterValues("param1");
        StudentDao stDao = new StudentDao();
        studentBean stBean = stDao.retrieveForm(clickedID[0]);
        HttpSession session = request.getSession();
        session.setAttribute("studentdetails", stBean);
        request.setAttribute("std", stBean);
        String address1;
        if (stBean != null) { //If details found
                address1 = "student.jsp";
        } else {
                address1 = "NoSuchStudent.jsp";
        }

        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher(address1);
        dispatcher.forward(request, response);
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        StudentDao stDAO = new StudentDao();
        stDAO.saveForm(request);
        float mean;
        double stdDev;
        String dataValues = request.getParameter("Data");
        DataProcessor dataProc = new DataProcessor();
        mean = dataProc.calcMean(dataValues);
        stdDev = dataProc.calStdDev(dataValues, mean);
        dataBean dtBean = new dataBean();
        dtBean.setMean(mean);
        dtBean.setSdtdev(stdDev);
        String id_list= "";
        Statement statement = null;
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
        } catch(ClassNotFoundException ex) {
            Logger.getLogger(TestServelet.class.getName()).log(Level.SEVERE, "OracleDriver Class not Found", ex);
        }
        
        try {
            Connection con;
            con = DriverManager.getConnection("jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu", "rjadhav2", "oxufetso");
            String selectSql = "SELECT STUDID from STUDENT";  
            statement = con.createStatement();
            
            // execute select SQL stetement
            ResultSet rs = statement.executeQuery(selectSql);
            while (rs.next()) {
		id_list = id_list + rs.getString(1) + ",";
            }
            
            con.close();
			
        

        
        }catch(SQLException sqlEx){
           Logger.getLogger(TestServelet.class.getName()).log(Level.SEVERE, "sqlEx during select", sqlEx); 
        } 
        
        String[] ids_list = id_list.split(",");
        ArrayList<String> std = new ArrayList<String>();
        for(String id:ids_list){
            std.add(id);
        }
        request.setAttribute("id_jsp", std);
        HttpSession session = request.getSession();
        session.setAttribute("data_bean1", dtBean);
        RequestDispatcher dispatcher;
        String address;
        if (dtBean.getMean() >= 90) { //if mean is greater than 90
            request.setAttribute("mean", dtBean.getMean());
            request.setAttribute("stdDev", dtBean.getSdtdev());
            address = "WinnerAck.jsp";
        } else {
            request.setAttribute("mean", dtBean.getMean());
            request.setAttribute("stdDev", dtBean.getSdtdev());
            address = "SimpleAck.jsp";
        }

        dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
