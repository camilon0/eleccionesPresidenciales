package Clases;

import java.util.LinkedList;

public class ClsCandidato extends ClsPersona {
	
	private String partidoPolitico;
	private String ciudadOrigen;
	private String descripcion;
	private String mensajeCamapania;
	private LinkedList<String> propuestas;

    public ClsCandidato(String partidoPolitico, String descripcion, String numeroDocumento, String nombre, String telefono, String correo) {
        super(numeroDocumento, nombre, telefono, correo);
        this.partidoPolitico = partidoPolitico;
        this.descripcion = descripcion;
        this.propuestas = new LinkedList<>();
    }

    public String getPartidoPolitico() {
        return partidoPolitico;
    }

    public void setPartidoPolitico(String partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
	
        
        
}	