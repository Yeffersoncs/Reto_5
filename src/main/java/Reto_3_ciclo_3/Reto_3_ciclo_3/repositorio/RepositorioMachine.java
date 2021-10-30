package Reto_3_ciclo_3.Reto_3_ciclo_3.repositorio;

import Reto_3_ciclo_3.Reto_3_ciclo_3.interfas.interfaceMachine;
import Reto_3_ciclo_3.Reto_3_ciclo_3.modelo.Machine;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioMachine {
    
     @Autowired
    private interfaceMachine crud;
    
    public List<Machine> getAll(){
        return (List<Machine>)crud.findAll();
    }
    public Optional<Machine> getMachine (int id){
       return crud.findById(id);
    }
    public Machine save(Machine machine){
        return crud.save(machine);
    }
    
    public void delete(Machine machine){
	        crud.delete(machine);
	    }
    
}
