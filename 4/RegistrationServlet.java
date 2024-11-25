import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    @Override
    public String toString() {
        return "RegistrationServlet []";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Extracting form data
        String name = request.getParameter("name");
        String rollNo = request.getParameter("rollno");
        String gender = request.getParameter("gender");
        String year = request.getParameter("year");
        String department = request.getParameter("department");
        String section = request.getParameter("section");
        String mobileNo = request.getParameter("mobile_no");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String pincode = request.getParameter("pincode");

        // Set response content type
        response.setContentType("text/html");

        // Generate response HTML
        response.getWriter().println("<h2>Registration Details</h2>");
        response.getWriter().println("<p><strong>Student Name:</strong> " + name + "</p>");
        response.getWriter().println("<p><strong>Roll No:</strong> " + rollNo + "</p>");
        response.getWriter().println("<p><strong>Gender:</strong> " + gender + "</p>");
        response.getWriter().println("<p><strong>Year:</strong> " + year + "</p>");
        response.getWriter().println("<p><strong>Department:</strong> " + department + "</p>");
        response.getWriter().println("<p><strong>Section:</strong> " + section + "</p>");
        response.getWriter().println("<p><strong>Mobile No:</strong> " + mobileNo + "</p>");
        response.getWriter().println("<p><strong>E-Mail ID:</strong> " + email + "</p>");
        response.getWriter
