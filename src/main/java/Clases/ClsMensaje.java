package Clases;

/**
 *
 * @author Usuario
 */
public class ClsMensaje {
    
    public static final String OK = "OK";
    public static final String ERROR = "ERROR";
    public static final String ADVERTENCIA = "ADVERTENCIA";
        
    private String tipo;
    private String descripcion;
    private String data;
    
    public ClsMensaje(){
            
    }   
    
    public void CambiarMensaje (String tipo, String descripcion) {       
        this.tipo = tipo;
        this.descripcion = descripcion;
        
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
}