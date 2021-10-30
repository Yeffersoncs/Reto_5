/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto_3_ciclo_3.Reto_3_ciclo_3.servicio;

import Reto_3_ciclo_3.Reto_3_ciclo_3.modelo.Client;
import Reto_3_ciclo_3.Reto_3_ciclo_3.repositorio.RepositorioClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviciosClient {
    
    @Autowired
    private RepositorioClient metodosCrud;
    public List<Client> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Client> getCliente(int idCliente){
        return metodosCrud.getCliente(idCliente);
    }
    public Client save(Client cliente){
        if(cliente.getIdClient()==null){
            return metodosCrud.save(cliente);
        }else{
            Optional<Client> paux=metodosCrud.getCliente(cliente.getIdClient());
            if(paux.isEmpty()){
            return metodosCrud.save(cliente);
            }else{
                return cliente;
            }
        }
    }
    
    public Client update(Client client){
	        if(client.getIdClient()!=null){
	            Optional<Client> e= metodosCrud.getCliente(client.getIdClient());
	            if(!e.isEmpty()){
                        if(client.getPassword()!=null){
	                    e.get().setPassword(client.getPassword());
	                }
                        if(client.getName()!=null){
	                    e.get().setName(client.getName());
	                }
                        if(client.getAge()!=null){
	                    e.get().setAge(client.getAge());
	                }
                        
	                metodosCrud.save(e.get());
                        return e.get();
                    }else{
                    return client;
                    }
                }else{
                    return client;
                }
    }
                    
                
    public boolean deleteClient(int clientId){
        
         Boolean aBoolean = getCliente(clientId).map(client-> { 
             metodosCrud.delete(client);
             return (true);
                 }).orElse(false);
            return aBoolean;
         
        }  
    
    
}
