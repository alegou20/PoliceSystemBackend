package service;

import domain.Cartracker;
import repository.CartrackerRepo;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
@Stateless
public class CartrackerService {

    @EJB
    CartrackerRepo cartrackerRepo;

    //End-point
    public Cartracker getCartrackerById(Long id){

        return cartrackerRepo.getCartrackerById( id );
    }

    //End-Point
    public void markAsStolen(Cartracker cartracker){

        cartrackerRepo.markAsStolen( cartracker );

    }

    //JMS - real time
    public Cartracker getStolen(){
    return cartrackerRepo.getStolen(  );
    }
}
