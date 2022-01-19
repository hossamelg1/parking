package test;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import connexion.Connexion;
import entities.Place;
import java.sql.ResultSet;
import java.util.ArrayList;
import services.EtageService;
import services.ParkingService;
import services.PlaceService;
import services.SectionService;

public class Test {

    public static void main(String[] args) {
        PlaceService ps = new PlaceService();
        ParkingService pps = new ParkingService();
        SectionService ss = new SectionService();
        EtageService es = new EtageService();
        //ps.garer(68, 111);
        ps.deparquer(68, 111);
        //System.err.println("place service: "+ps.getCounter(53, 72));
        //System.err.println("section servcei: "+ss.getPlaces(39));
        //System.err.println(es.getCounter(21));
        //System.err.println("nombre des fois est: "+pps.getCounter("hossam"));
        //ss.emptyPlaces(26);
        //System.err.println(es.isEmpty(1));
        //es.emptySections(1);
        
       // System.out.println(pps.getCounter("myParking"));
        
        
        
        
    }
}
