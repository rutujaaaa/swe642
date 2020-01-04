SWE 642: Assignment 3
Servlet, JSPs, MVC & Database I/O
 /
 *
 * @author rutujajadhav
 *
 */
 This assignment focuses on server side processing of the Student Survey Form data via
MVC implementation using a RequestDispatcher object. The implementation required to
implement one Servlet that acts as a front controller that receives all client requests, saves the
form data to a database table, performs business logic(s) via business delegate classes, stores
JavaBean objects into a session or request object, and then forwards the request to appropriate
JSP to present the data to the user. The assignment required all business logic code into separate
Java class(es) which could be called from within the servlet to perform specific tasks. All
presentation logic is moved to JSP pages.

 Software and jar files Required:

1) Eclipse IDE for Java EE Developers 
2) Apache Tomcat 9 
3) Cisco AnyConnect VPN 
4) ojdbc14.jar 
 
 1Extract Eclipse and start 
2) Extract Apache Tomcat and configure with eclipse
3) Install Cisco AnyConnect VPN and use this "vpn.gmu.edu" VPN id
4) Create a table (STUDENT). This can be done in the following way:
 a) Use this link "https://apollo.vse.gmu.edu:4443/isqlplus/" 
5) Unzip the file: it contains
 - ReadMe file
 - 'war' file(created using Export) 
 - 'zip' file 
6)  Import the 'war' file to eclipse
 -> file -> import -> filter with 'war' and click next
 -> browse for this 'war' file -> click finish
7) Run this project
 -> Right click on this project -> 'Run as' -> select 'Run on server'
 
 Oracle Table Creation:
 // for sqlDeveloper
 
 use
 -rjadhav2
 -oxufetso
 
 use the below queries
 
create table STUDENT(STUDID VARCHAR(20) NOT NULL PRIMARY KEY,

FULLNAME VARCHAR2(20), EMAIL VARCHAR(20), PHONE VARCHAR2(10), URL VARCHAR2(40), ADDRESS VARCHAR2(40), ZIPCODE VARCHAR(20), 

CITY VARCHAR2(20), STATE VARCHAR2(20), COMMENTS VARCHAR(20));

SELECT * FROM STUDENT;

