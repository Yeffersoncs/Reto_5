/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto_3_ciclo_3.Reto_3_ciclo_3.repositorio;

import Reto_3_ciclo_3.Reto_3_ciclo_3.interfas.interfaceClient;
import Reto_3_ciclo_3.Reto_3_ciclo_3.modelo.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioClient {
    
    @Autowired
    private interfaceClient crud;
    
    public List<Client> getAll(){
        return (List<Client>)crud.findAll();
    }
    public Optional<Client> getCliente (int id){
       return crud.findById(id);
    }
    public Client save(Client cliente){
        return crud.save(cliente);
    }
    
    public void delete(Client client){
	crud.delete(client);
    }
    
}
