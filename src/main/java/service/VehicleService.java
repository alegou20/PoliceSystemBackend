package service;

import domain.Vehicle;
import repository.VehicleRepo;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class VehicleService {

    @EJB
    VehicleRepo vehicleRepo;

    public Vehicle getVehicleByCarTrackerId(Long cartrackerId){
        return vehicleRepo.getVehicleByCartrackerId(cartrackerId);
    }

    //End-Point PUT billadministration
    public void markAsStolen(String licensplate, boolean isStolen){

        vehicleRepo.markAsStolen( licensplate, isStolen );
    }
}
