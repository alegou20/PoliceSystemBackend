package controller;

import domain.Vehicle;
import service.VehicleService;
import javax.ejb.EJB;
import javax.ws.rs.*;

@Path("vehicle")
public class VehicleController {

    @EJB
    VehicleService vehicleService;

    @GET
    @Path("/{id}")
    @Consumes("application/json")
    public Vehicle getVehicleByCarTrackerId(@PathParam("id") Long id){
        return vehicleService.getVehicleByCarTrackerId(id);
    }

    @PUT
    @Consumes("application/json")
    public void getVehicleByCarTrackerId(String licensplate, boolean isStolen){
        vehicleService.markAsStolen(licensplate, isStolen);
    }
}

