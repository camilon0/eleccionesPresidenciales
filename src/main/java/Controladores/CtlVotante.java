
package Controladores;

import Clases.ClsMensaje;
import Clases.ClsVotante;
import Modelos.MdlVotante;
import java.util.LinkedList;


public class CtlVotante {
    
    MdlVotante modelo;
    
    public CtlVotante(){
        this.modelo = new MdlVotante();
    }
    
    public ClsMensaje AgregarVotante(ClsVotante votante){
       
        ClsMensaje respuesta = this.modelo.agregarVotante(votante);
        
        return respuesta;
     
    }
    public ClsMensaje ActualizarVotante(ClsVotante votante){
       
        ClsMensaje respuesta = this.modelo.ActualizarVotante(votante);
        
        return respuesta;
    }   
    public ClsMensaje EliminarVotante(String candidato){
       
        ClsMensaje respuesta = this.modelo.EliminarVotante(candidato);
        
        return respuesta;
     
    }
    public LinkedList<ClsVotante> ObtenerVotante(){
        
        return this.modelo.ObtenerVotante();
        
    }
    public boolean ObtenerCedulaVotante(String cedula){
       
        boolean respuesta = this.modelo.ObtenerCedulaVotante(cedula);
        
        return respuesta;
    }
    
    public boolean ComprobarVotante(String idVotante){
       
        boolean respuesta = this.modelo.ComprobarVotante(idVotante);
        
        return respuesta;
    }
    
    public LinkedList<String> ObtenerAnios(){
       
        LinkedList<String> respuesta = this.modelo.ObtenerAnios();
        
        return respuesta;
    }
}