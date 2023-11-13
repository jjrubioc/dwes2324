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
                    showForm(response);
                    break;
                case "delete":
                    if (deporte.isBlank()) {
                        // do nothing
                    } else {
                        db.deleteSport(deporte);
                    }
                    showForm(response);
                    break;
                case "list":
                    ArrayList listSports = null;
                    listSports = db.listSports();
                    listSportsAndShowForm(listSports, response);
                    break;
                default:
                    break;
            }
        } else if (run.equalsIgnoreCase("start")) { // first run from this client
            this.db = new DBConnection();
            showForm(response);
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

    private void showForm(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloWorld de las once</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"helloworld\">\n"
                    + "            Deporte:<input type=\"text\" name=\"deporte\"><!-- comment -->\n"
                    + "            <input type=\"hidden\" name=\"task\" value=\"insert\" \">\n"
                    + "            <input type=\"submit\" value=\"Insert\">\n"
                    + "        </form>");
            out.println("<form action=\"helloworld\">\n"
                    + "            Deporte:<input type=\"text\" name=\"deporte\"><!-- comment -->\n"
                    + "            <input type=\"hidden\" name=\"task\" value=\"delete\" \">\n"
                    + "            <input type=\"submit\" value=\"Delete\">\n"
                    + "        </form>");
            out.println("<form action=\"helloworld\">\n"
                    + "            <input type=\"hidden\" name=\"task\" value=\"list\" \">\n"
                    + "            <input type=\"submit\" value=\"List sports\">\n"
                    + "        </form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void listSportsAndShowForm(ArrayList listSports, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloWorld de las once</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table>");
            for (Object sp : listSports) {
                out.println("<tr>");
                Deporte s = (Deporte) sp;
                out.println("<td>Sport:</td><td> " + s.getName() + "</td></tr>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<form action=\"helloworld\">\n"
                    + "            Deporte:<input type=\"text\" name=\"deporte\"><!-- comment -->\n"
                    + "            <input type=\"hidden\" name=\"task\" value=\"insert\" \">\n"
                    + "            <input type=\"submit\" value=\"Insert\">\n"
                    + "        </form>");
            out.println("<form action=\"helloworld\">\n"
                    + "            Deporte:<input type=\"text\" name=\"deporte\"><!-- comment -->\n"
                    + "            <input type=\"hidden\" name=\"task\" value=\"delete\" \">\n"
                    + "            <input type=\"submit\" value=\"Delete\">\n"
                    + "        </form>");
            out.println("<form action=\"helloworld\">\n"
                    + "            <input type=\"hidden\" name=\"task\" value=\"list\" \">\n"
                    + "            <input type=\"submit\" value=\"List sports\">\n"
                    + "        </form>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
