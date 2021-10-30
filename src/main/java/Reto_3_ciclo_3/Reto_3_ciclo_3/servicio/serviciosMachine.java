package Reto_3_ciclo_3.Reto_3_ciclo_3.servicio;

import Reto_3_ciclo_3.Reto_3_ciclo_3.modelo.Machine;
import Reto_3_ciclo_3.Reto_3_ciclo_3.repositorio.RepositorioMachine;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviciosMachine {
    
    @Autowired
    private RepositorioMachine metodosCrud;
    public List<Machine> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Machine> getMachine(int idMachine){
        return metodosCrud.getMachine(idMachine);
    }
    public Machine save(Machine machine){
        if(machine.getId()==null){
            return metodosCrud.save(machine);
        }else{
            Optional<Machine> paux=metodosCrud.getMachine(machine.getId());
            if(paux.isEmpty()){
            return metodosCrud.save(machine);
            }else{
                return machine;
            }
        }
    }
    
    public Machine update(Machine machine){
	        if(machine.getId()!=null){
	            Optional<Machine> e= metodosCrud.getMachine(machine.getId());
	            if(!e.isEmpty()){
	                if(machine.getName()!=null){
	                    e.get().setName(machine.getName());
	                }
                        if(machine.getBrand()!=null){
	                    e.get().setBrand(machine.getBrand());
	                }
                        if(machine.getYear()!=null){
	                    e.get().setYear(machine.getYear());
	                }
                        if(machine.getDescription()!=null){
	                    e.get().setDescription(machine.getDescription());
	                }
                        if(machine.getCategory()!=null){
	                    e.get().setCategory(machine.getCategory());
	                }
                        
	                metodosCrud.save(e.get());
                        return e.get();
                    }else{
                    return machine;
                    }
                }else{
                    return machine;
                }
    }
                        
                        
     public boolean deleteMachine(int machineId){
        
         Boolean aBoolean = getMachine(machineId).map(machine-> { 
             metodosCrud.delete(machine);
             return (true);
                 }).orElse(false);
            return aBoolean;
         
        }         
    
}
