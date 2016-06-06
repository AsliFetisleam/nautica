/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package licenta;

/**
 *
 * @author aslif
 */
public class InstantaNava {
    public Integer ID_NAVA;
    public Integer TONAJ;
    public Integer REZERVOR;
    public Integer CONSUM;    
    public Integer VITEZA_MAX;
    public float LUNGIME;
    public float LATIME;
    public float INALTIME;
    public String NUME;
    
    InstantaNava( Integer ID_NAVA,Integer TONAJ,Integer REZERVOR,Integer CONSUM,Integer VITEZA_MAX,float LUNGIME,float LATIME,float INALTIME,String NUME){
        this.ID_NAVA=ID_NAVA;
        this.TONAJ=TONAJ;
        this.REZERVOR=REZERVOR;
        this.CONSUM=CONSUM;    
        this.VITEZA_MAX=VITEZA_MAX;
        this.LUNGIME=LUNGIME;
        this.LATIME=LATIME;
        this.INALTIME=INALTIME;
        this.NUME=NUME;
    }
    
    @Override
    public String toString(){
        return ID_NAVA+" "+TONAJ+ " "+REZERVOR+" "+CONSUM+" "+VITEZA_MAX+" "+LUNGIME+" "+ LATIME+" "+INALTIME+" "+NUME;
    }
}
