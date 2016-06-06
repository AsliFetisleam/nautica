/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package licenta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author aslif
 */
public class ControllerDatabase {
    
    private static Connection conn;
    
    ControllerDatabase(){
        try {
           conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "C##ASLI", "1q2w3e$R");
           if (conn != null) {

           }
       } catch (SQLException ex) {
           System.out.println("An error occurred. Maybe user/password is invalid");
       } finally {
           if (conn != null) {
               try {
                   conn.close();
               } catch (SQLException ex) {
               }
           }
       }
    }
    
    public static void adaugaPersoana(Integer cnp ,String nume ,String prenume,String data,String tara,String oras,String nr ){
        Statement stmt = null;
        String query = "insert into persoane(cnp,nume,prenume,data_nastere,tara,oras,strada,nr) values (" +
                    cnp + "," + nume.toUpperCase() + "," + prenume.toUpperCase() + "," + 
                    "to_date('" + data + "','dd/mm/yyyy')" + "," +
                    tara.toUpperCase() + "," + oras.toUpperCase() + "," + nr.toUpperCase() + ")";
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e ) {
             e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void adaugaNava(Integer tonaj ,Integer rezervor ,Integer consum,Integer viteza_max,Integer lungime,Integer latime,Integer inaltime ){
        Statement stmt = null;
        String query = "insert into nave(tonaj,rezervor,consum,viteza_max,lungime,latime,inaltime) values (" +
                    tonaj + "," + rezervor + "," + consum + "," +  viteza_max + "," +
                    lungime + "," +latime + "," + inaltime + ")";
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e ) {
             e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
        
    public static void adaugaCursa(Integer id_nava ,String inceput ,String sfarsit,Integer port_start,Integer port_dest){
        Statement stmt = null;
        String query = "insert into curse(id_nava,inceput,sfarsit,port_start,port_dest) values (" +
                    id_nava + "," + "to_date('" + inceput + "','dd/mm/yyyy')" + "," +
                    "to_date('" + sfarsit + "','dd/mm/yyyy')" + "," + port_start + "," +  port_dest + ")";
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e ) {
             e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void adaugaProdus(String nume ,String furnizor,String descriere){
        Statement stmt = null;
        String query = "insert into produse(nume,furnizor,descriere) values (" +
                    nume + "," + furnizor + "," +  descriere + ")";
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e ) {
             e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }      
    
    public static void adaugaIncarcatura(Integer id_cursa , Integer furnizor, Integer cantitate){
        Statement stmt = null;
        String query = "insert into incarcatura(id_cursa,id_prod,cantitate) values (" +
                    id_cursa + "," + furnizor + "," +cantitate + ")" ;
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e ) {
             e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public static void adaugaEchipaj(Integer id_pers, Integer id_cursa, Integer grad,Integer id_pers_ct, String locatie_doc ){
        Statement stmt = null;
        String query = "insert into echipaj(id_pers,id_cursa,grad, id_pers_ct,locatie _doc) values (" +
                    id_pers + "," +id_cursa + "," + grad + "," + id_pers_ct+ "," + locatie_doc + ")";
        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e ) {
             e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            }catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
        
    public static ObservableList<InstantaPersoana> getPersoane() {
        
        ObservableList<InstantaPersoana> persoane = FXCollections.observableArrayList();
        Statement stmt = null;
        String query = "select * from Persoane";
        InstantaPersoana persoana;
            
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                    persoana = new InstantaPersoana(
                            rs.getInt("ID_PERS"),rs.getLong("CNP"),rs.getString("NUME"),rs.getString("PRENUME"),
                            rs.getTimestamp("DATA_NASTERE"),rs.getString("TARA"), rs.getString("ORAS"),
                            rs.getString("STRADA"),rs.getInt("NR"), rs.getInt("MOBIL"),rs.getInt("FIX"),
                            rs.getString("EMAIL"),rs.getString("LOCATIE_DOC"));
                    persoane.add(persoana);
                }
        } catch (SQLException e ) {
        } finally {
            //if (stmt != null) { stmt.close(); }
        }    

        return persoane;
    }
    
      /* public static ObservableList<InstantaCursa> getCurse() {
        
        ObservableList<InstantaPersoana> persoane = FXCollections.observableArrayList();
        Statement stmt = null;
        String query = "select * from Persoane";
        InstantaPersoana persoana;
            
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                    persoana = new InstantaPersoana(
                            rs.getInt("ID_PERS"),rs.getLong("CNP"),rs.getString("NUME"),rs.getString("PRENUME"),
                            rs.getTimestamp("DATA_NASTERE"),rs.getString("TARA"), rs.getString("ORAS"),
                            rs.getString("STRADA"),rs.getInt("NR"), rs.getInt("MOBIL"),rs.getInt("FIX"),
                            rs.getString("EMAIL"),rs.getString("LOCATIE_DOC"));
                    persoane.add(persoana);
                }
        } catch (SQLException e ) {
        } finally {
            //if (stmt != null) { stmt.close(); }
        }    

        return persoane;
    }
     */
    
    
   /* 
    public static void main(String[] args) {
        
    }
  */  
    
}
