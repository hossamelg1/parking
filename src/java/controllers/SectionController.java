/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import entities.Etage;
import entities.Section;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.EtageService;
import services.ParkingService;
import services.PlaceService;
import services.SectionService;

/**
 *
 * @author houssamelg
 */
@WebServlet(name = "SectionController", urlPatterns = {"/SectionController"})
public class SectionController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EtageService es = new EtageService();
        ParkingService ps = new ParkingService();
        SectionService ss = new SectionService();
        PlaceService placeS = new PlaceService();
        if (request.getParameter("op") != null) {
            if (request.getParameter("op").equals("load")) {
                response.setContentType("application/json");
                List<Section> sections = ss.findAll();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(sections));  
            } else if (request.getParameter("op").equals("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                ss.delete(id);
                response.setContentType("application/json");
                List<Section> sections = ss.findAll();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(sections));
            } else if (request.getParameter("op").equals("nextetage")) {
                String name = request.getParameter("name");
                response.setContentType("application/json");
                int next = ps.nextEtage(name);
                Gson json = new Gson();
                response.getWriter().write(json.toJson(next));
            } else if (request.getParameter("op").equals("getOptions")) {
                String name = request.getParameter("name");
                ArrayList<Integer> etages;
                etages = ps.getEtages(name);
                response.setContentType("application/json");
                int next = ps.nextEtage(name);
                Gson json = new Gson();
                response.getWriter().write(json.toJson(etages));
            } else if (request.getParameter("op").equals("getNextSec")) {
                String name = request.getParameter("name");
                int rank = Integer.parseInt(request.getParameter("etage"));
                int id_etage = es.getIdEtageByName(name, rank);
                ArrayList<String> refs = es.AvailableSection(id_etage);
                response.setContentType("application/json");
                Gson json = new Gson();
                response.getWriter().write(json.toJson(refs));
            } else if (request.getParameter("op").equals("generate")) {
                int id = Integer.parseInt(request.getParameter("id"));
                if (!ss.isGenerated(id)) {
                    placeS.create(id);
                    response.setContentType("application/json");
                    Gson json = new Gson();
                    response.getWriter().write(json.toJson("les places ont été créés avec succès"));
                }else{
                    Gson json = new Gson();
                    response.getWriter().write(json.toJson("Cette Section a deja 4 places"));
                }
            }

        } else {
            String name = request.getParameter("name");
            String ref = request.getParameter("ref");
            int rank = Integer.parseInt(request.getParameter("etage"));
            int id_etage = es.getIdEtageByName(name, rank);
            ss.create(id_etage, ref);
            response.setContentType("application/json");
            List<Section> sections = ss.findAll();
            Gson json = new Gson();
            response.getWriter().write(json.toJson(sections));
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
