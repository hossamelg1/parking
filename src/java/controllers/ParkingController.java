/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import entities.Parking;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.ParkingService;

/**
 *
 * @author houssamelg
 */
@WebServlet(name = "ParkingController", urlPatterns = {"/ParkingController"})
public class ParkingController extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ParkingService ps = new ParkingService();
        if (request.getParameter("op") != null) {
            if (request.getParameter("op").equals("load")) {
                response.setContentType("application/json");
                List<Parking> parkings = ps.findAll();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(parkings));
            }else if (request.getParameter("op").equals("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                ps.delete(ps.findById(id));
                response.setContentType("application/json");
                List<Parking> parkings = ps.findAll();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(parkings));
            }else if(request.getParameter("op").equals("checkname")){
                String name = request.getParameter("name");
                response.setContentType("application/json");
                boolean exist = ps.nameIsExist(name);
                Gson json = new Gson();
                response.getWriter().write(json.toJson(exist));
            }else if(request.getParameter("op").equals("update")){
                String name = request.getParameter("name");
                String quartier = request.getParameter("quartier");
                int id = Integer.parseInt(request.getParameter("id"));
                ps.update(new Parking(name, quartier), id);
                List<Parking> parkings = ps.findAll();
                response.setContentType("application/json");
                Gson json = new Gson();
                response.getWriter().write(json.toJson(parkings));
            }
    }else {
            String quartier = request.getParameter("quartier");
            String name = request.getParameter("name");
            ps.create(new Parking(name, quartier));
            response.setContentType("application/json");
            List<Parking> parkings = ps.findAll();
            Gson json = new Gson();
            response.getWriter().write(json.toJson(parkings));
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
