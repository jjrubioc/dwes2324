/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.sportthingsmanagement;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author Juanjo
 */
@WebServlet(name = "HelloWorld", urlPatterns = {"/helloworld"})
public class HelloWorld extends HttpServlet {

    DBConnection db = null;

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
        String run = request.getParameter("run");
        String deporte = request.getParameter("deporte");
        String task = request.getParameter("task");

        if (run == null) {  // not first run

            switch (task) {
                case "insert":
                    if (deporte.isBlank()) {
                        // do nothing
                    } else {
                        db.insertSport(deporte);
                    }
                    response.sendRedirect("form.jsp");

                    break;
                case "delete":
                    if (deporte.isBlank()) {
                        // do nothing
                    } else {
                        db.deleteSport(deporte);
                    }
//                    showForm(response);
                    response.sendRedirect("form.jsp");
                    break;
                case "list":
                    ArrayList<Deporte> listSports = null;
                    //obtenemos de la base de datos la lista de deportes:
                    listSports = db.listSports();
                    //para poder escribir en HTML la lista hay que hacerla
                    //llegar a la página JSP.
                    //Para ello, hay que guardarla en el objeto Session
                    //y recuperarla de este objeto en la página JSP:
                    HttpSession s = request.getSession();
                    s.setAttribute("listSports", listSports);
                    response.sendRedirect("listAndForm.jsp");
//                    listSportsAndShowForm(listSports, response);
                    break;
                default:
                    break;
            }
        } else if (run.equalsIgnoreCase("start")) { // first run from this client
            this.db = new DBConnection();
            response.sendRedirect("form.jsp");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
