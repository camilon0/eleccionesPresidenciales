/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Usuario
 */
public class ClsMensaje {
    
    public final String OK = "OK";
    public final String ERROR = "ERROR";
    public final String ADVERTENCIA = "ADVERTENCIA";
        
    private boolean respuesta;
    private String tipo;
    private String descripcion;

    public ClsMensaje(){
            
    }   
    
    
    public void CambiarMensaje (String tipo, boolean respuesta, String descripcion) {
       this.respuesta = respuesta;
        this.tipo = tipo;
        this.descripcion = descripcion;
}
    
}