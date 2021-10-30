/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto_3_ciclo_3.Reto_3_ciclo_3.interfas;

import Reto_3_ciclo_3.Reto_3_ciclo_3.modelo.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface interfaceReservation extends CrudRepository<Reservation, Integer>{
       
       public List<Reservation> findAllByStatus(String status);

       public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

       // select clientId, count(*) as "total" from reservacion group by cliendId order by total desc;
       @Query ("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client)DESC")
       public List<Object[]> countTotalReservationsByClient();
    
}
