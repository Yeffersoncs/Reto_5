/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto_3_ciclo_3.Reto_3_ciclo_3.servicio;

import Reto_3_ciclo_3.Reto_3_ciclo_3.modelo.Message;
import Reto_3_ciclo_3.Reto_3_ciclo_3.repositorio.RepositorioMessage;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviciosMessages {
    
    @Autowired
    private RepositorioMessage metodosCrud;
    public List<Message> getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Message> getMessage(int idMessage){
        return metodosCrud.getMessage(idMessage);
    }
    public Message save(Message messages){
        if(messages.getIdMessage()==null){
            return metodosCrud.save(messages);
        }else{
            Optional<Message> paux=metodosCrud.getMessage(messages.getIdMessage());
            if(paux.isEmpty()){
            return metodosCrud.save(messages);
            }else{
                return messages;
            }
        }
    }
    
     public Message update(Message message){
	        if(message.getIdMessage()!=null){
	            Optional<Message> e= metodosCrud.getMessage(message.getIdMessage());
	            if(!e.isEmpty()){
	                if(message.getMessageText()!=null){
	                    e.get().setMessageText(message.getMessageText());
	                }
	                metodosCrud.save(e.get());
                        return e.get();
                    }else{
                    return message;
                    }
                }else{
                    return message;
                }
    }
     
     public boolean deleteMessage(int messageId){
        
         Boolean aBoolean = getMessage(messageId).map(message-> { 
             metodosCrud.delete(message);
             return (true);
                 }).orElse(false);
            return aBoolean;
         
        }  
    
    
}
