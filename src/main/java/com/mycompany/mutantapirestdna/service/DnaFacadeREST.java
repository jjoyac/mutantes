/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mutantapirestdna.service;

import com.mycompany.mutantapirestdna.Dna;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author JuanJose
 */
@Stateless
@Path("com.mycompany.mutantapirestdna.dna")
public class DnaFacadeREST extends AbstractFacade<Dna> {

    @PersistenceContext(unitName = "com.mycompany_MutantApiRestDNA_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    public DnaFacadeREST() {
        super(Dna.class);
        //em.persist(em);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Dna entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Dna entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Dna find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Dna> findAll() {
        return super.findAll();
        
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Dna> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        
        return em;
    }
//    public EntityManager getEntityManager2() {
//        
//        return em;
//    }
//    @POST
//    @Path("stats")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String stats() {
//        //TODO return proper representation object
//        //throw new UnsupportedOperationException();
//        return "{\n"
//                    + "    ADN: {\n"
//                    + "    \"count_mutant_dna\":40,\n"
//                    + "    \"count_human_dna\": 100,\n"
//                    + "    \"ration\": 0,4}\n"
//                    + "}";
//    }
}
