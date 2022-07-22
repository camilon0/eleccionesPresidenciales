package Controladores;

import Clases.ClsCandidato;
import Modelos.MdlCandidato;
import java.util.LinkedList;

/**
 *
 * @author Usuario
 */
public class CtlCandidato {
    
    MdlCandidato modelo;

    public CtlCandidato() {
        
        this.modelo = new MdlCandidato();
        
    }
    
    public boolean agregarCandidato(ClsCandidato candidato){
       
        boolean respuesta = this.modelo.agregarCandidato(candidato);
        return respuesta;
     
    }
    
    public LinkedList<ClsCandidato> ObtenerCandidatos(){
        
        return this.modelo.ObtenerCandidatos();
        
    }
    
}
