/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import connexion.Connexion;
import entities.Place;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author houssamelg
 */
public class PlaceService {

    public boolean create(int idSection) {
        boolean created = false;
        try {
            for (int i = 1; i < 5; i++) {
                String req = "insert into place values (null, ?, ?, false, 0)";
                PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
                pr.setInt(1, i);
                pr.setInt(2, idSection);
                if (pr.executeUpdate() != 0) {
                    created = true;
                } else {
                    created = false;
                }
            }
        } catch (SQLException e) {
            System.err.println("create : Error");

        }

        return created;
    }

    public boolean delete(int idSection) {
        try {
            String req = "delete from place where id_section = ?";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setInt(1, idSection);
            pr.executeUpdate();
        } catch (SQLException e) {
            System.err.println(" delete : Error");
        }
        try {
            String req = "delete from place where id_section = ?";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setInt(1, idSection);
            if (pr.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println(" delete : Error");

        }

        return false;
    }

    public boolean garer(int idSection, int idPlace) {

        try {
            String req = "update place set filled = true, filled_cnt = filled_cnt+1 where id = ? and id_section = ? ";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setInt(1, idPlace);
            pr.setInt(2, idSection);
            if (pr.executeUpdate() != 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }

        return false;
    }

    public boolean deparquer(int idSection, int idPlace) {
       try {
            String req = "update place set filled = false where id = ? and id_section = ? ";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setInt(1, idPlace);
            pr.setInt(2, idSection);
            if (pr.executeUpdate() != 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }

        return false;
    }
    public ArrayList<Place> findAll() {
        ArrayList<Place> places = new ArrayList<Place>();
        try {
            String req = "select * from place";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            while(rs.next()) {
                boolean myBool =(boolean) rs.getObject("filled"); 
                places.add(new Place(rs.getInt("id"), rs.getInt("ref"), myBool, rs.getInt("id_section")));
            }
        } catch (Exception e) {

        }
        return places;
    }

    // for statistics
    public int getCounter(int idSection, int idPlace) {

        try {
            String req = "select filled_cnt as count from place where id = ? and id_section = ?";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setInt(1, idPlace);
            pr.setInt(2, idSection);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                return rs.getInt("count");
            }
        } catch (Exception e) {
            System.out.println("get counter error: " + e.toString());
        }
        return 0;
    }
    
    
}
