package Modelos;

import Clases.ClsCandidato;
import Clases.ClsJdbc;
import Clases.ClsMensaje;
import Clases.ClsPropuesta;
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

            String sql = "INSERT INTO tbl_candidatos VALUES( ?, ?, ?, ?, ?, ?, ?, NULL)";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, candidato.getNumeroDocumento());
            sentencia.setString(2, candidato.getNombre());
            sentencia.setString(3, candidato.getTelefono());
            sentencia.setString(4, candidato.getCorreo());
            sentencia.setString(5, candidato.getPartidoPolitico());
            sentencia.setString(6, candidato.getCiudadOrigen());
            sentencia.setString(7, candidato.getDescripcion());

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
    public ClsMensaje AgregarPropuesta(ClsPropuesta propuesta) {

        ClsMensaje mensaje = new ClsMensaje();

        try {

            String sql = "INSERT INTO tbl_propuestas (id_candidato, fecha_creacion,"
                    + " descripcion, sector) VALUES ( ?, now(), ?, ?)";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            sentencia.setString(1, propuesta.getIdCandidato());
            sentencia.setString(2, propuesta.getDescripcion());
            sentencia.setString(3, propuesta.getSector());

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje.CambiarMensaje(mensaje.OK, "Has agregado una propuesta");

                ResultSet rs = sentencia.getGeneratedKeys();
                if (rs.next()) {
                    mensaje.setData(rs.getString(1) + "");
                }

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

            String sql = "UPDATE tbl_candidatos SET nombre = ?, descripcion = ?, telefono = ? WHERE id_candidato = ? ";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, candidato.getNombre());
            sentencia.setString(2, candidato.getDescripcion());
            sentencia.setString(3, candidato.getTelefono());
            sentencia.setString(4, candidato.getNumeroDocumento());

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
    public LinkedList<ClsPropuesta> ObtenerPropuestas(String idCandidato) {

        try {

            LinkedList<ClsPropuesta> listaPropuestas = new LinkedList<>();

            String sql = "SELECT * FROM tbl_propuestas WHERE id_candidato = " + idCandidato;
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {

                String id = resultados.getString("id_propuesta");
                String fechaCreacion = resultados.getString("fecha_creacion");
                String descripcion = resultados.getString("descripcion");
                String sector = resultados.getString("sector");

                ClsPropuesta propuesta = new ClsPropuesta(idCandidato, id, sector, descripcion, fechaCreacion);

                listaPropuestas.add(propuesta);

            }

            return listaPropuestas;

        } catch (Exception e) {

            System.out.println("Uy error" + e.getMessage());
            return null;
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

                ClsCandidato candi = new ClsCandidato(partidoPolitico, descripcion, numeroDocumento, nombre, telefono, correo);

                listaCandidatos.add(candi);
            }

            return listaCandidatos;

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return null;
        }

    }
}
