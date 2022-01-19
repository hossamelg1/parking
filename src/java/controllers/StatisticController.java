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
import java.util.ArrayList;
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
@WebServlet(name = "StatisticController", urlPatterns = {"/StatisticController"})
public class StatisticController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        EtageService es = new EtageService();
        ParkingService ps = new ParkingService();
        SectionService ss = new SectionService();
        PlaceService placeS = new PlaceService();
        if (request.getParameter("chart").equals("parkingName")) {
            ArrayList<String> parkings = new ArrayList<String>();
            for (Parking p : ps.findAll()) {
                parkings.add(p.getName());
            }
            response.setContentType("application/json");
            Gson json = new Gson();
            String str = "works";
            response.getWriter().write(json.toJson(parkings));
        }
        if (request.getParameter("chart").equals("parkingCount")) {
            ArrayList<Integer> parkings = new ArrayList<Integer>();
            for (Parking p : ps.findAll()) {
                parkings.add(ps.getCounter(p.getName()));
            }
            response.setContentType("application/json");
            Gson json = new Gson();
            response.getWriter().write(json.toJson(parkings));
        }
        if (request.getParameter("chart").equals("etageRank")) {
            String name = request.getParameter("name");
            ArrayList<Integer> etages = new ArrayList<Integer>();
            ArrayList<String> ranks = new ArrayList<String>();
            for (int rank : ps.getEtages(name)) {
                etages.add(rank);
            }
            for (int rank : etages) {
                switch (rank) {
                    case 0:
                        ranks.add("Rez de chaussée");
                        break;
                    case 1:
                        ranks.add("Premier Etage");
                        break;
                    case 2:
                        ranks.add("Deuxiéme Etage");
                        break;
                    case 3:
                        ranks.add("troisiéme Etage");
                        break;
                }
            }
            response.setContentType("application/json");
            Gson json = new Gson();
            response.getWriter().write(json.toJson(ranks));
        }
        if (request.getParameter("chart").equals("etageCount")) {
            String name = request.getParameter("name");
            ArrayList<Integer> etages = new ArrayList<Integer>();
            for (int rank : ps.getIdEtages(name)) {
                etages.add(es.getCounter(rank));
            }
            response.setContentType("application/json");
            Gson json = new Gson();
            response.getWriter().write(json.toJson(etages));
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
