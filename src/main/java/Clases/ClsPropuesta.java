
package Clases;

/**
 *
 * @author Usuario
 */
public class ClsPropuesta {
    
    
    private String idCandidato;
    private String idPropuesta;
    private String sector;
    private String descripcion;
    private String fecha;

    public ClsPropuesta(String idCandidato, String sector, String descripcion) {
        this.idCandidato = idCandidato;
        this.sector = sector;
        this.descripcion = descripcion;
    }

    public ClsPropuesta(String idCandidato, String idPropuesta, String sector, String descripcion, String fecha) {
        this.idCandidato = idCandidato;
        this.idPropuesta = idPropuesta;
        this.sector = sector;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }
    
    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(String idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getIdPropuesta() {
        return idPropuesta;
    }

    public void setIdPropuesta(String idPropuesta) {
        this.idPropuesta = idPropuesta;
    }
    
}
