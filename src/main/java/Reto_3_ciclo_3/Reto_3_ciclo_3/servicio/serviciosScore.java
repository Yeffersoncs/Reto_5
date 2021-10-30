/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto_3_ciclo_3.Reto_3_ciclo_3.servicio;

import Reto_3_ciclo_3.Reto_3_ciclo_3.modelo.Score;
import Reto_3_ciclo_3.Reto_3_ciclo_3.repositorio.RepositorioScore;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviciosScore {
    
    @Autowired
    private RepositorioScore metodosCrud;
    public List<Score> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Score> getScore(int idScore){
        return metodosCrud.getScores(idScore);
    }
    public Score save(Score score){
        if(score.getScore()==null){
            return metodosCrud.save(score);
        }else{
            Optional<Score> paux=metodosCrud.getScores(score.getScore());
            if(paux.isEmpty()){
            return metodosCrud.save(score);
            }else{
                return score;
            }
        }
    }
    
}
