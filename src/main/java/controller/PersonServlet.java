package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import DAO.ConnectionProperty;
import DAO.PersonDbDAO;
import DAO.RoleDbDAO;
import domain.Person;
import domain.Role;
/**
* Servlet implementation class PersonServlet
*/
@WebServlet("/person")
public class PersonServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
ConnectionProperty prop;
public PersonServlet() throws FileNotFoundException, IOException {
super();
prop = new ConnectionProperty();
}
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");
String userPath;
List<Person> persons;
List<Role> roles;
RoleDbDAO daoRole = new RoleDbDAO();
PersonDbDAO dao = new PersonDbDAO();
try {
persons = dao.findAll();
roles = daoRole.findAll();
for (Person person: persons) {
person.setRole(daoRole.FindById(person.getIdRole(), roles));
}
request.setAttribute("persons", persons);
} catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
userPath = request.getServletPath();
if("/person".equals(userPath)){
request.getRequestDispatcher("/views/person.jsp").forward(request, response);
}
}
/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
doGet(request, response);
}
}