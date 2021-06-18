/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mutantapirestdna;

import java.io.Serializable;
import java.text.Normalizer;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JuanJose
 */
@Entity
@Table(name = "dna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dna.findAll", query = "SELECT d FROM Dna d"),
    @NamedQuery(name = "Dna.findByDnastrings", query = "SELECT d FROM Dna d WHERE d.dnastrings = :dnastrings")})
public class Dna implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "dnastrings")
    private String dnastrings;
    @Column(name = "isMutant")
    private String ismutant;
    private String []dna;
    private char [][] dnachr;

    public String[] getDna() {
        return dna;
    }

    public String getIsmutant() {
        return ismutant;
    }

    public void setIsmutant(String ismutant) {
        this.ismutant = ismutant;
    }

    public char[][] getDnachr() {
        return dnachr;
    }

    public void setDnachr(char[][] dnachr) {
        this.dnachr = dnachr;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    public Dna() {
    }

    public Dna(String dnastrings) {
        if (isDNAValid(dnastrings)==true) { 
            this.dnastrings = dnastrings;
            //String strMain = "Alfa, Beta, Delta, Gamma, Sigma";   
        this.dna = dnastrings.split(",");   
        for (int i = 0; i<=dnastrings.length(); i++)    {     
            System.out.println(this.dna[i]);   
        }  
        //this.isMutant(dna);
        } 
    }

    public String getDnastrings() {
        return dnastrings;
    }

    public void setDnastrings(String dnastrings) {
        this.dnastrings = dnastrings;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dnastrings != null ? dnastrings.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dna)) {
            return false;
        }
        Dna other = (Dna) object;
        if ((this.dnastrings == null && other.dnastrings != null) || (this.dnastrings != null && !this.dnastrings.equals(other.dnastrings))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mutantapirestdna.Dna[ dnastrings=" + dnastrings + " ]";
    }
    
    
    public boolean valIsMutant(String[] dnaToVal) {
        
        String cadConcatADN="";
        for (int i=0; i<dnaToVal.length;i++){
            String s=dnaToVal[i];
            cadConcatADN = cadConcatADN+dnaToVal[i]+",";
        }
        this.dnastrings=cadConcatADN;
        if (horizontalValidation(dnaToVal)==false && verticalValidation(dnaToVal)==false && diagonalValidation(dnaToVal)==false)  
        {
            this.setDna(dnaToVal);
            this.setIsmutant("N");
            this.setDnastrings(this.getDnastrings());
            return false;
        }  
        else {
            this.setDna(dnaToVal);
            this.setIsmutant("M");
            this.setDnastrings(this.getDnastrings());
            return true;
        }
        
    }
    
    private boolean isDNAValid(String dna) {
     
          
           if (dna.matches("[ATCG,]")==false) {
                System.out.println("valor de dna para validacion FALSE--* "+dna);
               return false;
           }
           else {
                System.out.println("valor de dna para validacion TRUE--* "+dna);
               return true;
           } 
    }
    public boolean horizontalValidation(String[] pdna){
        String A="AAAA";
        String T="TTTT";
        String C="CCCC";
        String G="GGGG";
       
        for (int i=0; i<pdna.length;i++){
            String s=pdna[i];
            
            System.out.println("String a validar Horizontal "+ i +  " "+s);
            
            if (s.regionMatches(0, A, 0, 4)||s.regionMatches(0, T, 0, 4)||s.regionMatches(0, C, 0, 4)||s.regionMatches(0, G, 0, 4)) return true;
            
        }
        
        return false;
    }
    public boolean verticalValidation(String[] pdna){
        
        String [] sT=this.convertHorizontal(pdna);              
        return horizontalValidation(sT);
    }
    
    public boolean diagonalValidation(String[] pdna){
         
        
        char [][] matriz=convertirArrayStringInMatrizChar (pdna);
        Integer alt = matriz.length, anch = matriz[0].length;
        String ns ="";
        String A="AAAA";
        String T="TTTT";
        String C="CCCC";
        String G="GGGG";
        for (
            
            Integer diag = 1 - anch; 
            diag <= alt - 1; 
            diag += 1 
        ) {
            
            char[]  c=new char[alt];
            for (
                
                Integer vert = Math.max(0, diag), horiz = -Math.min(0, diag);
                vert < alt && horiz < anch; 
                vert += 1, horiz += 1 
            ) {
                
                System.out.println(matriz[vert][horiz]);
                c[vert]=matriz[vert][horiz];
                
            }
            
            ns = String.valueOf(c);
            System.out.println("la cadena diagonal es -->"+ns);
            if (ns.regionMatches(0, A, 0, 4)||ns.regionMatches(0, T, 0, 4)||ns.regionMatches(0, C, 0, 4)||ns.regionMatches(0, G, 0, 4)) return true;
        
        }
    
               
        return false;
    }
    public String [] convertHorizontal (String[] pdna){
     char dnachr [][] =null;
        int i=0;
        System.out.println("Convertir a Horizontal -> "+pdna);
        for (i=0; i<pdna.length;i++){
            String s=pdna[i];
            System.out.println("Recorriendo para dimensionar "+ i +  " "+s);
            //char[]  c=s.toCharArray();
               
        }
        dnachr = new char [pdna.length][i];   
        String s=null;
        char[]  c=null;
        for (i=0; i<pdna.length;i++){
            s=pdna[i];
            
            System.out.println("String "+ i +  " "+s);
            c=s.toCharArray();
            //dnachr = new char [c.length][pdna.length];
            for (int j=0; j<c.length;j++){
       
              dnachr[j][i]= c[j];
              System.out.println("Valor dnachr["+j+"]["+i+"]"+dnachr[j][i]);
              System.out.println("------fin for interno"+j);
        }
        System.out.println("------fin for externo"+i);
        }
        
       String [] ns =new String[dnachr.length];
        
       for (i=0; i<dnachr.length;i++){
          ns[i]= String.valueOf(dnachr[i]);
          System.out.println("la cadena ns"+i+" "+ns[i]);
       }
       return ns;
    }
    
    public char [][] convertirArrayStringInMatrizChar (String[] pdna){
        
        System.out.println("Cadena Original a convertir en matriz "+pdna.toString());
        
        char dnachr [][] =null;
        //char dnachr [][] = new char [][];
        //System.out.println("Inicializando Nula a dnachr "+dnachr);
        for (int i=0; i<pdna.length;i++){
            String s=pdna[i];
            System.out.println("Recorriendo para dimensionar "+ i +  " "+s);
            char[]  c=s.toCharArray();
            dnachr = new char [c.length][pdna.length];
        
        }
         String s=null;
         char[]  c=null;
        for (int i=0; i<pdna.length;i++){
            s=pdna[i];
            
            System.out.println("String "+ i +  " "+s);
            s=s.trim();
            s=s.replaceAll("\\\\W+","");
            s=s.replaceAll("\\s","");
            s=s.replaceAll("^\\s*","");
            s=s.replaceAll("\\s*$","");
            s=s.replaceAll("\\P{Print}", "");
            Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
            c=s.toCharArray();
            //dnachr = new char [c.length][pdna.length];
            for (int j=0; j<c.length;j++){
       
              dnachr[i][j]= c[j];
              System.out.println("Valor dnachr["+i+"]["+j+"]"+dnachr[i][j]);
              System.out.println("------fin for interno"+j);
        }
        System.out.println("------fin for externo"+i);
        }
        return dnachr;
    }
}
