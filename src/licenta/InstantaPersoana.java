/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package licenta;

import java.util.Date;

/**
 *
 * @author aslif
 */
public class InstantaPersoana {
    //Attribute  
    public Integer ID_PERS ;   
    public long CNP;
    public String NUME;
    public String PRENUME;
    public Date DATA_NASTERE;      
    public String TARA; 
    public String ORAS; 
    public String STRADA;
    public Integer NR;
    public Integer MOBIL;    
    public Integer FIX;  
    public String EMAIL ; 
    public String LOCATIE_DOC;
 
    public InstantaPersoana(Integer ID_PERS,long CNP,String NUME,String PRENUME,
            Date DATA_NASTERE, String TARA, String ORAS,String STRADA,Integer NR,
            Integer MOBIL,Integer FIX,String EMAIL,String LOCATIE_DOC) {
        
        this.ID_PERS = ID_PERS ;   
        this.CNP = CNP;
        this.NUME = NUME;
        this.PRENUME = PRENUME;
        this.DATA_NASTERE = DATA_NASTERE;      
        this.TARA=TARA; 
        this.ORAS =ORAS; 
        this.STRADA= STRADA;
        this.NR= NR;
        this.MOBIL=MOBIL;    
        this.FIX= FIX;  
        this.EMAIL= EMAIL ; 
        this.LOCATIE_DOC =LOCATIE_DOC;
    }

   /* public Integer getId() {
        return id;
    }
    public String getNume() {
        return nume;
    }
    
    public String getDateGenerale() {
        return date_generale;
    }

    public String getInceput() {
        return data_inceput;
    }
    
    public String getSfarsit() {
        return data_sfarsit;
    }
    
    public void setId(String album) {
        this.album = album;
    }

   public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    */
    
    @Override
    public String toString(){

        return ID_PERS +" "+CNP+" "+NUME+" "+PRENUME+" "+" "+TARA+" "+ORAS+" "+STRADA+" "+NR+" "+MOBIL+" "+FIX+" "+EMAIL +" "+LOCATIE_DOC;
    }
    
}
