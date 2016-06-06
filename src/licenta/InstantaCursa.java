/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package licenta;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author aslif
 */
public class InstantaCursa {
    public Integer ID_CURSA;
    public InstantaNava NAVA;
    public Date INCEPUT;
    public Date SFARSIT;
    public Integer PORT_START;
    public Integer PORT_DEST;
    public static Map<InstantaPersoana,String> ECHIPAJ;
    
    InstantaCursa(Integer ID_CURSA,InstantaNava NAVA,Date INCEPUT,Date SFARSIT,Integer PORT_START,Integer PORT_DEST){
        this.ID_CURSA= ID_CURSA;
        this.NAVA=NAVA;
        this.INCEPUT=INCEPUT;
        this.SFARSIT=SFARSIT;
        this.PORT_START=PORT_START;
        this.PORT_DEST=PORT_DEST;
        this.ECHIPAJ = new HashMap<>();
    }
    
    public static void adaugaPersoanaEchipaj( InstantaPersoana persoana, String grad){
        ECHIPAJ.put(persoana,grad);
    }
    
    
    public String toSting(){
        return ID_CURSA+" "+NAVA.ID_NAVA+" "+INCEPUT+" "+SFARSIT+" "+PORT_START+" "+PORT_DEST;
    }
}
