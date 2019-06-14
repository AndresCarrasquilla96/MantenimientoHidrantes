/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Hidrante;
import models.dao.HidranteDao;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet
@MultipartConfig
public class Hidrantes extends HttpServlet {

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

            HidranteDao hidraDao = new HidranteDao();
            JSONArray hidrantes = new JSONArray();
            List<Hidrante> hidra = hidraDao.obtenerHidrantes();
            hidra.forEach(h -> {
                JSONObject jobj = new JSONObject();
                
                jobj.put("id_hidrante", h.getId_hidrante());
                jobj.put("latitud", h.getUbicacion().getX());
                jobj.put("longitud", h.getUbicacion().getY());
                jobj.put("caudal_esperado", h.getCaudal_esperado());
                jobj.put("tamanio_salidas", h.getTamanio_salidas());
                jobj.put("estado", h.getBuen_estado());
                
                System.out.println(jobj);
                
                hidrantes.put(jobj);
            });

            out.println(hidrantes);
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

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HidranteDao hidraDao = new HidranteDao();
            JSONObject jobj = new JSONObject();
            Integer id_hidrante = Integer.parseInt(request.getParameter("id_hidrante"));
            jobj.put("status", hidraDao.actualizarEstado(id_hidrante) ? "200" : "500");

            out.println(jobj);
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