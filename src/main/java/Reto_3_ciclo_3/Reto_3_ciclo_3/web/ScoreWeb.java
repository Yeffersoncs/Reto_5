package Reto_3_ciclo_3.Reto_3_ciclo_3.web;

import Reto_3_ciclo_3.Reto_3_ciclo_3.modelo.Score;
import Reto_3_ciclo_3.Reto_3_ciclo_3.servicio.serviciosScore;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ScoreWeb {
    
    @Autowired
    private serviciosScore servicios;
    @GetMapping("/all")
    public List<Score>getScores(){
        return servicios.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Score>getScores(@PathVariable("id")int id){
        return servicios.getScore(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score score){
        return servicios.save(score);
    }
    
}
