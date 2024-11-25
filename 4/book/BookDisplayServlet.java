package com.example.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class BookDisplayServlet extends HttpServlet {
    private Connection connection;

    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryManagement", "yourUsername", "yourPassword");
        } catch (Exception e) {
            throw new ServletException("DB Connection Error", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String query = "SELECT * FROM BOOK";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            request.setAttribute("bookList", rs);
            RequestDispatcher dispatcher = request.getRequestDispatcher("viewBooks.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
        }
    }

    public void destroy() {
        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
