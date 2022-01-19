/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;
import connexion.Connexion;
import entities.Etage;
import entities.Place;
import entities.Section;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author houssamelg
 */
public class SectionService {

    public boolean create(int id, String ref) {
        try {
            EtageService es = new EtageService();
            String req = "insert into section values(null, ?, ?)";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setString(1, ref);
            pr.setInt(2, id);
            if (pr.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Section create : Error");

        }

        return false;
    }

    public boolean delete(int idSection) {
        try {
            PlaceService ps = new PlaceService();
            ps.delete(idSection);
            String req = "delete from section where id = ?";
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

    public boolean update(Section o, int id) {
        try {
            String req = "update section set ref = ? where id = ?";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setString(1, o.getRef());
            pr.setInt(2, id);
            if (pr.executeUpdate() != 0) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("update : Error");

        }

        return false;
    }

    public Section findById(int id) {
        try {
            String req = "select * from section whereb id = ?";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                return new Section(rs.getInt("id"), rs.getString("ref"), rs.getInt("id_etage"));
            }
        } catch (SQLException e) {
            System.err.println("find by id : Error");
        }

        return null;
    }

    public ArrayList<Section> findAll() {
        ArrayList<Section> sections = new ArrayList<Section>();
        try {
            String req = "select * from section";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                sections.add(new Section(rs.getInt("id"), rs.getString("ref"), rs.getInt("id_etage")));
            }
        } catch (SQLException e) {
            System.err.println("find all : Error");

        }
        return sections;
    }

    public ArrayList<Place> EmptyPlaces() {
        ArrayList<Place> places = new ArrayList<Place>();
        try {
            String req = "select rank from place where is_empty like 1";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                int placeRank = rs.getInt("rank");
            }
        } catch (Exception e) {

        }
        return places;
    }

    public boolean isEmpty(int idSection) {
        try {
            String req = "select count(*) as cnt from place where id_section = ? and filled = false ";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setInt(1, idSection);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                if (rs.getInt("cnt") > 0) {
                    return true;
                }
            }
        } catch (Exception e) {

        }
        return false;
    }

    public ArrayList<Integer> emptyPlaces(int idSection) {
        ArrayList<Integer> places = new ArrayList<Integer>();
        SectionService ss = new SectionService();
        if (ss.isEmpty(idSection)) {
            try {
                String req = "select ref from place where id_section = ? and filled = false ";
                PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
                pr.setInt(1, idSection);
                ResultSet rs = pr.executeQuery();
                while (rs.next()) {
                    System.err.println("ref: " + rs.getInt("ref"));
                    places.add(rs.getInt("ref"));
                }
            } catch (Exception e) {
                System.err.println("emptyPlaces error" + e.toString());
            }
            return places;
        }

        return null;
    }

    public int getCount() {
        try {
            String req = "select count(*) as cnt from section ";
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

    public boolean isGenerated(int idSection) {
        try {
            String req = "select COUNT(*) as cnt from place where id_section = ? ";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setInt(1, idSection);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {

                if (rs.getInt("cnt") > 0) {
                    return true;
                }
            }
        } catch (Exception e) {

        }
        return false;
    }

    public ArrayList<Place> getPlaces(int idSection) {
        ArrayList<Place> places = new ArrayList<Place>();
        try {
            String req = "select * from place where id_section = ? ";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setInt(1, idSection);
            ResultSet rs = pr.executeQuery();
            while(rs.next()) {
                boolean myBool =(boolean) rs.getObject("filled"); 
                places.add(new Place(rs.getInt("ref"), myBool));
            }
        } catch (Exception e) {

        }
        return places;
    }

    public int getCounter(int id) {
        int counter = 0;
        try {
            String req = "select filled_cnt as count from place where id_section = ? ";
            PreparedStatement pr = Connexion.getInstane().getConnection().prepareStatement(req);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                counter += rs.getInt("count");
            }
        } catch (Exception e) {
            System.out.println("get counter error: " + e.toString());
        }
        return counter;
    }

}
