/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mutantapirestdna;

import com.mycompany.mutantapirestdna.service.DnaFacadeREST;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import com.google.gson.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * REST Web Service
 *
 * @author JuanJose
 */
@Path("mutant")
public class MutantResource {

    @Context
    private UriInfo context;
    private EntityManager em;
    /**
     * Creates a new instance of MutantResource
     */
    public MutantResource() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.mutantapirestdna.MutantResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        return "<dna>info dna</dna>";
    }

    /**
     * PUT method for updating or creating an instance of MutantResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
        
    }
      /**
     * POST method for updating or creating an instance of MutantResource
     * @param content representation for the resource
     */
    @POST
    @Path("mutant")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postJson(String content) {
        
        DnaFacadeREST dnafac=new DnaFacadeREST();
         boolean isMutant;
       
        Gson gson = new Gson();
        Dna Dnagson = gson.fromJson(content, Dna.class);
        System.out.println(Dnagson.getDna());
        //System.out.println();
           //Dna vdna= new Dna(Dnagson.getDnastrings());
         isMutant=Dnagson.valIsMutant(Dnagson.getDna());
         try { 
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_MutantApiRestDNA_war_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
       Query q = em.createNativeQuery("CREATE TABLE dna ( dnastrings CHAR(17) NOT NULL, ismutant CHAR(1) NOT NULL,);");     
                
        } catch (PersistenceException e) {
            // Check if the exception is DatabaseException and ConstraintViolation
            // Update instead or skip it
            return "{\n"
                    + "    \"name\": \"NOK\",\n"
                    + "    \"message\": \"404 OK es un Mutante.\",\n" + e.getMessage()
                    + "    \"code\": 0,\n"
                    + "    \"status\": 404\n"
                    + "}";
        }
        
        
         if (isMutant==true){

            return "{\n"
                    + "    \"name\": \"OK\",\n"
                    + "    \"message\": \"200 OK es un Mutante.\",\n"
                    + "    \"code\": 0,\n"
                    + "    \"status\": 200\n"
                    + "}";
            //return "<dna>Es mutantico</dna>";
        }
         else if (isMutant==false){
             return "{\n"
                     + "    \"name\": \"403 Forbidden\",\n"
                     + "    \"message\": \"403 Forbidden - Humano Normal.\",\n"
                     + "    \"code\": 0,\n"
                     + "    \"status\": 403\n"
                     + "}";
         }
        return null;
         
    }
        
  
    
        /**
     * Retrieves representation of an instance of com.mycompany.mutantapirestdna.MutantResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("getHtml")
    @Produces("text/html")
    public String getHtml() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        return "<h1>prueba Html para mutantes X</h1>";
    }
    
        /**
     * Retrieves representation of an instance of com.mycompany.mutantapirestdna.MutantResource
     * @return an instance of java.lang.String
     */
    @POST
    @Path("stats")
    @Produces(MediaType.APPLICATION_JSON)
    public String stats() {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        System.out.println(context);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_MutantApiRestDNA_war_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
       Query q = em.createNativeQuery("SELECT a.dnastrings, a.ismutant FROM dna a ;");
//        String url = "jdbc:postgresql://localhost:5432/postgres";
//        Properties props = new Properties();
//        props.setProperty("user","postgres");
//        props.setProperty("password","admin");
        //props.setProperty("ssl","true");
//        try {
//            try {
//                //DriverManager.registerDriver(n);
//                Class.forName("org.postgresql.Driver");
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(MutantResource.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            Connection conn = DriverManager.getConnection(url, props);
//        url = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=admin";
//        conn = DriverManager.getConnection(url);
//
//        PreparedStatement stmt = conn.prepareStatement("SELECT a.dnastrings, a.ismutant FROM dna a ;");
//        stmt.execute();
//        
//        ResultSet rsregistros=stmt.getResultSet();
//        //rsregistros.
//        stmt.close();
//        conn.close(); }
//        catch (SQLException e) {
//                                     return "{\n" +
//"    \"name\": \"NOK\",\n" + 
//"    \"message\": \"404 NOK en stats.\",\n" + e.getMessage() +
//"    \"code\": 0,\n" +
//"    \"status\": 404\n" +
//"}";
            
//        }
        List<Object[]> registros = q.getResultList();
        int contMutantes=0;
        int contHumanos=1;
        double ratio=0.0;
       for (Object[] a : registros) {
            System.out.println("dnas "
                    + a[0]
                    + " "
                    + a[1]);
            if (a[1]=="M") contMutantes++;
            if (a[1]=="N") contHumanos++;
        }
       
       ratio=(contMutantes/contHumanos);
      
        return "{\n"
                    + "    ADN: {\n"
                    + "    \"count_mutant_dna\":"+contMutantes+",\n"
                    + "    \"count_human_dna\": "+contHumanos+",\n"
                    + "    \"ration\": "+ratio+"}\n"
                    + "}";
   
    }
}
