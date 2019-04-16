package controller;

import domain.Cartracker;
import gateway.CartrackerAppGateway;
import service.CartrackerService;
import javax.ejb.EJB;
import javax.ws.rs.*;
import java.util.List;

@Path("cartracker")
public class CartrackerController {

    @EJB
    CartrackerService cartrackerService;

    @GET
    @Path("/{id}")
    @Consumes("application/json")
    public Cartracker getById(@PathParam("id") Long id){
        return cartrackerService.getCartrackerById(id);
    }

    @GET
    @Consumes("application/json")
    public Cartracker getStolenById(){
        CartrackerAppGateway gateway = new CartrackerAppGateway();
        return cartrackerService.getStolen();
    }

    @PUT
    @Consumes("application/json")
    public void markAsStolen(Cartracker cartracker){
        cartrackerService.markAsStolen(cartracker);
    }
}

