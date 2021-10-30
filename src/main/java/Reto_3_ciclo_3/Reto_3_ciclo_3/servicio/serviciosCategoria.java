package Reto_3_ciclo_3.Reto_3_ciclo_3.servicio;

import Reto_3_ciclo_3.Reto_3_ciclo_3.modelo.Category;
import Reto_3_ciclo_3.Reto_3_ciclo_3.repositorio.RepositorioCategoria;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviciosCategoria {
    
    @Autowired
    private RepositorioCategoria metodosCrud;
    
    public List<Category> getAll(){
         return metodosCrud.getAll();
    }
    
    public Optional<Category> getCategoria(int idCategory){
        return metodosCrud.getCategoria(idCategory);
    }
    
    
    public Category save(Category category){
        if(category.getId()==null){
            return metodosCrud.save(category);
        }else{
            Optional<Category> evt=metodosCrud.getCategoria(category.getId());
            if(evt.isEmpty()){
            return metodosCrud.save(category);
            }else{
                return category;
            }
        
        
        }
    
    }
    
     public Category update(Category category){
	        if(category.getId()!=null){
	            Optional<Category> e= metodosCrud.getCategoria(category.getId());
	            if(!e.isEmpty()){
	                if(category.getName()!=null){
	                    e.get().setName(category.getName());
	                }
                        if(category.getDescription()!=null){
	                    e.get().setDescription(category.getDescription());
	                } return metodosCrud.save(e.get());
            }
        }
        return category;
    }
     
     public boolean deleteCategory(int categoryId){
        
         Boolean aBoolean = getCategoria(categoryId).map(category-> { 
             metodosCrud.delete(category);
             return (true);
                 }).orElse(false);
            return aBoolean;
         
        }  
}
