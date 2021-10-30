package Reto_3_ciclo_3.Reto_3_ciclo_3.repositorio;

import Reportes.ContadorClientes;
import Reto_3_ciclo_3.Reto_3_ciclo_3.interfas.interfaceReservation;
import Reto_3_ciclo_3.Reto_3_ciclo_3.modelo.Client;
import Reto_3_ciclo_3.Reto_3_ciclo_3.modelo.Reservation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservation {
    
    @Autowired
    private interfaceReservation crud;
    
     public List<Reservation> getAll(){
        return (List<Reservation>)crud.findAll();
    }
    public Optional<Reservation> getReservation (int id){
       return crud.findById(id);
    }
    public Reservation save(Reservation reservation){
        return crud.save(reservation);
    }
    public void delete(Reservation reservation){
	        crud.delete(reservation);
	    }
    
    public List<Reservation> ReservacionStatus (String status){
         return crud.findAllByStatus(status);
     }
     
     public List<Reservation> ReservacionTiempo (Date a, Date b){
         return crud.findAllByStartDateAfterAndStartDateBefore(a, b);
     }
   
     public List<ContadorClientes> getTopClientes(){
         List<ContadorClientes> res=new ArrayList<>();
         List<Object[]>report = crud.countTotalReservationsByClient();
         for(int i=0; i<report.size();i++){
             res.add(new ContadorClientes((Long)report.get(i)[1],(Client) report.get(i)[0]));
         
         }
         return res;
     }
}
