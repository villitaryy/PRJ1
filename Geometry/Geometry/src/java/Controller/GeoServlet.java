/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

/**
 *
 * @author ACER
 */
@WebServlet(name = "GeoServlet", urlPatterns = {"/GeoServlet"})
public class GeoServlet extends HttpServlet {

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
            out.println("<title>Servlet GeoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GeoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String hinh = request.getParameter("hinh");
        String img = "";
        String base64img ="";
        switch (hinh) {
            case "Circle" -> {
                img = getServletContext().getRealPath("/img/tron.png");
            }
            case "Square" -> {
                img = getServletContext().getRealPath("/img/vuong.png");
            }
            case "Triangular" -> {
                img = getServletContext().getRealPath("/img/tamgiac.png");
            }
            case "Rectangle" -> {
                img = getServletContext().getRealPath("/img/chunhat.png");
            }
        }
        try {
            base64img = encodeImageToBase64(img);
        } catch (Exception e) {
            e.printStackTrace();
            base64img = "Error encoding image.";
        }
        request.setAttribute("base64img", base64img);
        request.setAttribute("hinh", hinh);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    private String encodeImageToBase64(String imagePath) throws IOException {
        File file = new File(imagePath);
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] imageBytes = new byte[(int) file.length()];
            fis.read(imageBytes);
            return Base64.getEncoder().encodeToString(imageBytes);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
