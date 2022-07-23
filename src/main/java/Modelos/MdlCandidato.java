package Modelos;

import Clases.ClsCandidato;
import Clases.ClsJdbc;
import Clases.ClsMensaje;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                mensaje.CambiarMensaje(mensaje.OK, true, "Has creado un nuevo candidato");
            }else{
                mensaje.CambiarMensaje(mensaje.ERROR, false, "Error no encontrado");
            }
            return mensaje;
                    
        } catch (Exception e) {

            mensaje.CambiarMensaje(mensaje.ERROR, false, "Excepción: " + e.getMessage());
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
