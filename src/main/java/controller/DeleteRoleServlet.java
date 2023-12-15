package controller;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import DAO.ConnectionProperty;
import DAO.RoleDbDAO;

@WebServlet( "/deleterole")
public class DeleteRoleServlet extends HttpServlet {

private static final long serialVersionUID = 1L;
ConnectionProperty prop;

public DeleteRoleServlet() throws FileNotFoundException,
IOException {
 super();
 prop = new ConnectionProperty();
 }
protected void doGet(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {
RoleDbDAO dao = new RoleDbDAO();
String strId = request.getParameter("id");
Long deleteid = null;
if(strId != null) {
deleteid = Long.parseLong(strId);
}
try {
dao.delete(deleteid);
} catch (Exception e) {
e.printStackTrace();
}
response.sendRedirect("/person1/role");
}
}