package Reto_3_ciclo_3.Reto_3_ciclo_3.web;

import Reto_3_ciclo_3.Reto_3_ciclo_3.modelo.Machine;
import Reto_3_ciclo_3.Reto_3_ciclo_3.servicio.serviciosMachine;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Machine")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MachineWeb {
    
    @Autowired
    private serviciosMachine servicios;
    @GetMapping("/all")
    public List<Machine>getMachine(){
        return servicios.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Machine>getMachine(@PathVariable("id")int id){
        return servicios.getMachine(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine save(@RequestBody Machine machine){
        return servicios.save(machine);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine update(@RequestBody Machine machine) {
        return servicios.update(machine);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int machineId) {
        return servicios.deleteMachine(machineId);
    } 
    
}
