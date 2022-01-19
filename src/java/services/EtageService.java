/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;
import connexion.Connexion;
import entities.Etage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author houssamelg
 */
public class EtageService {

    public boolean create(Etage o) {
        try {
            String req = "insert into etage values (null, ?, ?)";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setInt(1, o.getRank());
            pr.setString(2, o.getNameParking());
            if (pr.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("create : Error");

        }

        return false;
    }

    public boolean delete(Etage o) {
        try {
            String req = "delete from section where id_etage = ?";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setInt(1, o.getId());
            pr.executeUpdate();
        } catch (SQLException e) {
            System.err.println(" delete : Error");
        }
        try {
            String req = "delete from etage where id = ?";
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

    public Etage findById(int id) {
        try {
            String req = "select * from etage where id = ?";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                return new Etage(rs.getInt("id"), rs.getInt("rank"), rs.getString("name_parking"));
            }
        } catch (SQLException e) {
            System.err.println("find by id : Error");
        }

        return null;
    }

    public ArrayList<Etage> findAll() {
        ArrayList<Etage> etages = new ArrayList<Etage>();
        try {
            String req = "select * from etage";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                etages.add(new Etage(rs.getInt("id"), rs.getInt("rank"), rs.getString("name_parking")));
            }
        } catch (SQLException e) {
            System.err.println("find all : Error");

        }
        return etages;
    }

    public int getCount() {
        try {
            String req = "select count(*) as cnt from etage ";
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

    /*public boolean isEmpty(String parkingName, int etageRank, String sectionRef ){
     try{
     String req = "select ref from secion where id_etage = ?";
     PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
     pr.setInt(1, id);
     ResultSet rs = pr.executeQuery();
     }catch(Exception e){
            
     }
     return false;
     }*/
    public ArrayList<String> AvailableSection(int id) {
        ArrayList<String> trueList = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F"));
        try {
            ArrayList<String> secList = new ArrayList<String>();
            String req = "select ref from section where id_etage = ?";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                secList.add(rs.getString("ref"));
            }
            for (String c : secList) {
                trueList.remove(c);
            }
            

        } catch (Exception e) {

        }
        return trueList;
    }

    public String nextSection(int id) {
        try {
            ArrayList<String> secList = new ArrayList<String>();
            String req = "select ref from section where id_etage = ?";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                return rs.getString("ref");
            }

        } catch (Exception e) {

        }
        return null;
    }

    public int getIdEtageByName(String nameParking, int rank) {
        try {
            String req = "select id from etage where rank = ? and name_parking = ?";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setInt(1, rank);
            pr.setString(2, nameParking);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (Exception e) {

        }
        return -1;
    }

    // for Statiscics
    public int getCounter(int id){
        SectionService ss = new SectionService();
        int counter = 0;
        try{
            String req = "select id from section where id_etage = ?";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                int _id = rs.getInt("id") ;
                counter += ss.getCounter(_id);
            }
            
        }catch(Exception e){
            System.err.println("get counter etage : "+e.toString());
        }
        return counter;
    }
    
    // for user to show 
    public boolean isEmpty(int idEtage){
        SectionService ss = new SectionService();
        int counter = 0;
        try{
            String req = "select id from section where id_etage = ?";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setInt(1, idEtage);
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                int _id = rs.getInt("id") ;
                if (ss.isEmpty(_id)) {
                    return true;
                }
            }
            
        }catch(Exception e){
            System.err.println("isEmpty etage : "+e.toString());
        }
        return false;
    }
    
    // for user to show 
    public ArrayList<Integer> emptySections(int idEtage) {
        EtageService es = new EtageService();
        SectionService ss = new SectionService();
        ArrayList<Integer> sections = new ArrayList<Integer>();
        if (es.isEmpty(idEtage)) {
        try{
            String req = "select id from section where id_etage = ?";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setInt(1, idEtage);
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                int _id = rs.getInt("id") ;
                if (ss.emptyPlaces(_id) != null) {
                    System.err.println("id is: "+_id);
                    sections.add(_id);
                }
            }
            
        }catch(Exception e){
            System.err.println("isEmpty etage : "+e.toString());
        }
        return sections;
        }
        return null;
        
    }
    
    
}
