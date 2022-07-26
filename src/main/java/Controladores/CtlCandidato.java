package Controladores;

import Clases.ClsCandidato;
import Clases.ClsMensaje;
import Clases.ClsPropuesta;
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
    
    public ClsMensaje AgregarCandidato(ClsCandidato candidato){
       
        ClsMensaje respuesta = this.modelo.agregarCandidato(candidato);
        
        return respuesta;
     
    }
    public ClsMensaje ActualizarCandidato(ClsCandidato candidato){
       
        ClsMensaje respuesta = this.modelo.ActualizarCandidato(candidato);
        
        return respuesta;
    }       
            
    
    public ClsMensaje EliminarCandidato(String candidato){
       
        ClsMensaje respuesta = this.modelo.EliminarCandidato(candidato);
        
        return respuesta;
     
    }
    
    public LinkedList<ClsCandidato> ObtenerCandidatos(){
        
        return this.modelo.ObtenerCandidatos();
        
    }
 public LinkedList<ClsPropuesta> ObtenerPropuestas(String idCandidato) {

        return this.modelo.ObtenerPropuestas(idCandidato);

    }
    
    
    
    
     public ClsMensaje AgregarPropuesta(ClsPropuesta propuesta) {

        ClsMensaje respuesta = this.modelo.AgregarPropuesta(propuesta);
        return respuesta;
    }


}