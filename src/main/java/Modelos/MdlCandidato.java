package Modelos;

import Clases.ClsCandidato;
import Clases.ClsJdbc;
import Clases.ClsMensaje;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class MdlCandidato {

    ClsJdbc jdbc;

    public MdlCandidato() {
        this.jdbc = new ClsJdbc();
        this.jdbc.CrearConexion();
    }

    public ClsMensaje agregarCandidato(ClsCandidato candidato) {

        ClsMensaje mensaje = new ClsMensaje();

        try {

            String sql = "INSERT INTO tbl_candidatos VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, candidato.getNumeroDocumento());
            sentencia.setString(2, candidato.getNombre());
            sentencia.setString(3, candidato.getTelefono());
            sentencia.setString(4, candidato.getCorreo());
            sentencia.setString(5, candidato.getPartidoPolitico());
            sentencia.setString(6, candidato.getCiudadOrigen());
            sentencia.setString(7, candidato.getDescripcion());
            sentencia.setString(8, candidato.getMensajeCampania());
            sentencia.setString(9, candidato.getPropuestas());

            int resultado = sentencia.executeUpdate();

            if (resultado == 1) {

                mensaje.CambiarMensaje(mensaje.OK, "Has creado un nuevo candidato");

            } else {

                mensaje.CambiarMensaje(mensaje.ERROR, "Error no encontrado");

            }
            return mensaje;

        } catch (Exception e) {

            mensaje.CambiarMensaje(mensaje.ERROR, "Excepción: " + e.getMessage());

            return mensaje;
        }

    }
    
    public ClsMensaje ActualizarCandidato(ClsCandidato candidato) {

        ClsMensaje mensaje = new ClsMensaje();

        try {

            String sql = "UPDATE tbl_candidatos SET nombre = ?, telefono = ?, correo = ?, ciudad_origen = ?, descripcion = ?, mensaje_campania = ?, propuestas = ?  WHERE id_candidato = ? ";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, candidato.getNombre());
            sentencia.setString(2, candidato.getTelefono());
            sentencia.setString(3, candidato.getCorreo());
            sentencia.setString(4, candidato.getCiudadOrigen()); 
            sentencia.setString(5, candidato.getDescripcion()); 
            sentencia.setString(6, candidato.getMensajeCampania()); 
            sentencia.setString(7, candidato.getPropuestas());
            sentencia.setString(8, candidato.getNumeroDocumento());

            int resultado = sentencia.executeUpdate();

            if (resultado == 1) {

                mensaje.CambiarMensaje(mensaje.OK, "Has editado al candidato " );

            } else {

                mensaje.CambiarMensaje(mensaje.ERROR, "Error no encontrado");

            }
            return mensaje;

        } catch (Exception e) {

            mensaje.CambiarMensaje(mensaje.ERROR, "Excepción: " + e.getMessage());

            return mensaje;
        }

    }



public ClsMensaje EliminarCandidato(String idCandidato){
        
        ClsMensaje mensaje = new ClsMensaje();
        
        try {
            
            String sql = "DELETE FROM tbl_candidatos WHERE id_candidato = ?";
            
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, idCandidato);
            

            int resultado = sentencia.executeUpdate();
            
            if (resultado == 1) {
                
                mensaje.CambiarMensaje(mensaje.OK, "Has eliminado al candidato: " + idCandidato);

            } else {

                mensaje.CambiarMensaje(mensaje.ERROR, "Error no encontrado");

            }
            return mensaje;

        } catch (Exception e) {

            mensaje.CambiarMensaje(mensaje.ERROR, "Excepción: " + e.getMessage());

            return mensaje;
        }

    }
    
    
    public LinkedList<ClsCandidato> ObtenerCandidatos() {

        try {

            LinkedList<ClsCandidato> listaCandidatos = new LinkedList<>();

            String sql = "SELECT * FROM tbl_candidatos";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {
                String partidoPolitico = resultados.getString("partido_politico");
                String descripcion = resultados.getString("descripcion");
                String numeroDocumento = resultados.getString("id_candidato");
                String nombre = resultados.getString("nombre");
                String telefono = resultados.getString("telefono");
                String correo = resultados.getString("correo");
                String propuestas = resultados.getString("propuestas");
                String ciudadOrigen = resultados.getString("ciudad_origen");
                String mensajeCampania = resultados.getString("mensaje_campania");
                

                ClsCandidato candi = new ClsCandidato(partidoPolitico, ciudadOrigen, descripcion, mensajeCampania, propuestas, numeroDocumento, nombre, telefono, correo);

                listaCandidatos.add(candi);
            }

            return listaCandidatos;

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return null;
        }

    }
    
    public ClsMensaje Votos(String candidato, String elecciones, String votante) {

        ClsMensaje mensaje = new ClsMensaje();

        try {

            String sql = "INSERT INTO tbl_votos VALUES(null, ?, ?, ?, now()) ";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, elecciones);
            sentencia.setString(2, candidato);
            sentencia.setString(3, votante);
           
            int resultado = sentencia.executeUpdate();
            if (resultado == 1) {
                mensaje.CambiarMensaje(mensaje.OK, "Su voto a sido ingresado");

            } else {

                mensaje.CambiarMensaje(mensaje.ERROR, "Error no encontrado");

            }
            return mensaje;

        } catch (Exception e) {

            mensaje.CambiarMensaje(mensaje.ERROR, "Excepción: " + e.getMessage());

            return mensaje;
        }

    }    
}
