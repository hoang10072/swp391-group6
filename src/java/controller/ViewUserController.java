/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Customer;
import dao.CustomerDAO;

/**
 *
 * @author troqu
 */
@WebServlet(name = "ViewUserController", urlPatterns = {"/user"})
public class ViewUserController extends HttpServlet {

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
            out.println("<title>Servlet ViewUserController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewUserController at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<Customer> customers = CustomerDAO.getCustomers();
        
        printUsers(request, response, customers);

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
//        processRequest(request, response);
//        response.setContentType("text/html;charset=UTF-8");
//        ArrayList<Customer> customers = CustomerDAO.getCustomers();
//        
//        
//        printUsers(request, response, customers);
//        try (PrintWriter out = response.getWriter()) {
//            out.print(customers.size());
//        }
    }

    protected void printUsers(HttpServletRequest request, HttpServletResponse response, ArrayList<Customer> users)
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            if (!users.isEmpty()) {
                out.println("<h3>List of Users:</h3>");
                out.println("<table border='1'>");
                out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Phone</th><th>Address</th></tr>");

                for (Customer user : users) {
                    out.println("<tr>");
                    out.println("<td>" + user.getCustomerID() + "</td>");
                    out.println("<td>" + user.getCustomerName() + "</td>");
                    out.println("<td>" + user.getEmail() + "</td>");
                    out.println("<td>" + user.getPhone() + "</td>");
                    out.println("<td>" + user.getAddress() + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
            } else {
                out.println("<h3>No users found</h3>");
            }
        }
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
