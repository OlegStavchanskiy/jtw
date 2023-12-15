package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import domain.Role;

import DAO.RoleDbDAO;
import DAO.ConnectionProperty;
/**

* Servlet implementation class RoleServlet
*/
@WebServlet("/role")
public class RoleServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
ConnectionProperty prop;
/**
* @throws IOException
* @throws FileNotFoundException
* @see HttpServlet#HttpServlet()
*/
public RoleServlet() throws FileNotFoundException, IOException {
super();
// TODO Auto-generated constructor stub
prop = new ConnectionProperty();
}
/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
* response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");
String userPath;
List<Role> roles;
RoleDbDAO dao = new RoleDbDAO();
try {
roles = dao.findAll();
request.setAttribute("roles", roles);
} catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
userPath = request.getServletPath();
if ("/role".equals(userPath)) {
request.getRequestDispatcher("/views/role.jsp").forward(request, response);
}
}
/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse

* response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
// TODO Auto-generated method stub
doGet(request, response);
}
}
