/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;
import connexion.Connexion;
import entities.Parking;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author houssamelg
 */
public class ParkingService {

    public boolean create(Parking o) {
        try {
            String req = "insert into parking values (null, ?, ?)";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setString(1, o.getName());
            pr.setString(2, o.getQuartier());
            if (pr.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("create : Error");

        }

        return false;
    }

    public boolean delete(Parking o) {
        try {
            String req = "delete from parking where id = ?";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setInt(1, o.getId());
            if (pr.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println(" delete : Error");

        }

        return false;
    }

    public boolean update(Parking o, int id) {
        try {
            String req = "update parking set quartier = ? where id = ?";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setString(1, o.getQuartier());
            pr.setInt(2, id);
            if (pr.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("update : Error");

        }

        return false;
    }

    public Parking findById(int id) {
        try {
            String req = "select * from parking where id = ?";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                return new Parking(rs.getInt("id"), rs.getString("name"), rs.getString("quartier"));
            }
        } catch (SQLException e) {
            System.err.println("find by id : Error");
        }

        return null;
    }

    public ArrayList<Parking> findAll() {
        ArrayList<Parking> parkings = new ArrayList<Parking>();
        try {
            String req = "select * from parking";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                parkings.add(new Parking(rs.getInt("id"), rs.getString("name"), rs.getString("quartier")));
            }
        } catch (SQLException e) {
            System.err.println("find all : Error");

        }
        return parkings;
    }

    public int getCount() {
        try {
            String req = "select count(*) as cnt from parking ";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                int count = rs.getInt("cnt");
                return count;
            }

        } catch (Exception e) {

        }
        return 0;
    }

    public boolean nameIsExist(String name) {
        try {
            String req = "select * from parking where name = ?";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setString(1, name);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.err.println("find by name error!");
        }

        return false;
    }

    public Parking findByName(String name) {
        try {
            String req = "select * from parking where name = ?";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);

            pr.setString(1, name);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                return new Parking(rs.getInt("id"), rs.getString("name"), rs.getString("quartier"));
            }
        } catch (Exception e) {
            System.err.println("find by name error!");
        }

        return null;
    }

    // get all floors in a parking for section management 
    public ArrayList<Integer> allEtages(String name) {
        ArrayList<Integer> etages = new ArrayList<>();
        etages.add(0);
        etages.add(1);
        etages.add(2);
        etages.add(3);
        try {
            String req = "select rank from etage where name_parking = ?";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setString(1, name);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                for (int i : etages) {
                    if (i == rs.getInt("rank")) {
                        etages.remove(i);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("available etage error!");
        }
        return etages;
    }

    // get the next floor to add 
    public int nextEtage(String name) {
        try {
            String req = "select count(*) as cnt from etage where name_parking = ?";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setString(1, name);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                return rs.getInt("cnt");
            }
        } catch (Exception e) {
            System.err.println("next Etage error!");
        }
        return 0;
    }

    public ArrayList<Integer> getEtages(String name) {
        ArrayList<Integer> etages = new ArrayList<Integer>();
        try {
            String req = "select rank from etage where name_parking = ?";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setString(1, name);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                etages.add(rs.getInt("rank"));
            }
        } catch (Exception e) {

        }
        return etages;
    }
    public ArrayList<Integer> getIdEtages(String name) {
        ArrayList<Integer> etages = new ArrayList<Integer>();
        try {
            String req = "select id from etage where name_parking = ?";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setString(1, name);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                etages.add(rs.getInt("id"));
            }
        } catch (Exception e) {

        }
        return etages;
    }
    //for statistics
    public int getCounter(String parkingName){
        ParkingService ps = new ParkingService();
        EtageService es = new EtageService();
        int counter = 0;
        for(int num : ps.getIdEtages(parkingName) ){
            System.out.println("etage: "+es.getCounter(num));
            counter  += es.getCounter(num);
        }
        return counter;
    }
    // for user to show 
    public boolean isEmpty(String parkingName){
        ParkingService ps = new ParkingService();
        EtageService es = new EtageService();
        for(int num : ps.getIdEtages(parkingName) ){
            if (es.isEmpty(num)) {
                return true;
            }
        }
        
        return false;
    }
    
    // for user to show
    public ArrayList<Integer> emptyEtages(String parkignName){
        ParkingService ps = new ParkingService();
        EtageService es = new EtageService();
        ArrayList<Integer> etages = new ArrayList<Integer>();
        
        for(int etage : ps.getIdEtages(parkignName)){
            if (es.emptySections(etage) != null) {
                etages.add(etage);
            }
        }
        return etages ;
    }
}
