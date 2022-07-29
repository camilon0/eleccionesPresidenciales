package Modelos;

import Clases.ClsJdbc;
import Clases.ClsMensaje;
import Clases.ClsVotante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

public class MdlVotante {
    
    ClsJdbc jdbc;
    
    public MdlVotante() {
        this.jdbc = new ClsJdbc();
        this.jdbc.CrearConexion();
    }
    public ClsMensaje agregarVotante(ClsVotante votante) {

        ClsMensaje mensaje = new ClsMensaje();

        try {

            String sql = "INSERT INTO tbl_votantes VALUES ( ?, ?, ?, ?)";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, votante.getNumeroDocumento());
            sentencia.setString(2, votante.getNombre());
            sentencia.setString(3, votante.getTelefono());
            sentencia.setString(4, votante.getCorreo());
            
            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                mensaje.CambiarMensaje(mensaje.OK, "Has creado un nuevo votante");
            } else {

                mensaje.CambiarMensaje(mensaje.ERROR, "Error no encontrado");
            }

            return mensaje;

        } catch (Exception e) {
            mensaje.CambiarMensaje(mensaje.ERROR, "Excepción: " + e.getMessage());
            return mensaje;
        }

    }
    public LinkedList<ClsVotante> ObtenerVotante() {

        try {

            LinkedList<ClsVotante> listaVotantes = new LinkedList<>();

            String sql = "SELECT * FROM tbl_votantes";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            ResultSet resultados = sentencia.executeQuery();

            while (resultados.next()) {
                String numeroDocumento = resultados.getString("id_votante");
                String nombre = resultados.getString("nombre");
                String telefono = resultados.getString("telefono");
                String correo = resultados.getString("correo");
              
                ClsVotante votan = new ClsVotante(numeroDocumento, nombre, telefono, correo);
                    
                listaVotantes.add(votan);
            }

            return listaVotantes;

        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return null;
        }

    }
    public ClsMensaje EliminarVotante(String idVotante){
        
        
        ClsMensaje mensaje = new ClsMensaje();
        
        try {
            
            String sql = "DELETE FROM tbl_votantes WHERE id_votante = ?";
            
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, idVotante);
            

            int resultado = sentencia.executeUpdate();
            
            if (resultado == 1) {
                
                mensaje.CambiarMensaje(mensaje.OK, "Has eliminado al votante: " + idVotante);

            } else {

                mensaje.CambiarMensaje(mensaje.ERROR, "Error no encontrado");

            }
            return mensaje;

        } catch (Exception e) {

            mensaje.CambiarMensaje(mensaje.ERROR, "Excepción: " + e.getMessage());

            return mensaje;
        }

    }
    public ClsMensaje ActualizarVotante(ClsVotante votante) {

        ClsMensaje mensaje = new ClsMensaje();

        try {
            System.out.println("errorsd");
            String sql = "UPDATE tbl_votantes SET nombre = ?, telefono = ?, correo = ? WHERE id_votante = ? ";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, votante.getNombre());
            sentencia.setString(2, votante.getTelefono());
            sentencia.setString(3, votante.getCorreo());
            sentencia.setString(4, votante.getNumeroDocumento());

            int resultado = sentencia.executeUpdate();

            if (resultado == 1) {

                mensaje.CambiarMensaje(mensaje.OK, "Has editado al votante " );

            } else {

                mensaje.CambiarMensaje(mensaje.ERROR, "Error no encontrado");

            }
            return mensaje;

        } catch (Exception e) {

            mensaje.CambiarMensaje(mensaje.ERROR, "Excepción: " + e.getMessage());

            return mensaje;
        }

    }
    

    public boolean ObtenerCedulaVotante(String cedula) {
        
        try {

            String sql = "SELECT * FROM tbl_votantes WHERE id_votante =" + cedula;
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            ResultSet resultados = sentencia.executeQuery();
            
            if (!resultados.next() ) {
            return false;
            }else   
            {
            return true;
            }
            
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return false;
        }

   } 
   public boolean ComprobarVotante(String idVotante) {
        
        try {

            String sql = "SELECT * FROM tbl_votos WHERE id_votante = " + idVotante;
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            System.out.println(sql);
            ResultSet resultados = sentencia.executeQuery();
            
            if (!resultados.next() ) {
            return false;
            }else   
            {
            return true;
            }
            
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return false;
        }

   }
   
   
    public LinkedList<String> ObtenerAnios() {
        
        try {
            
            LinkedList<String> listaAnios = new LinkedList<>();
            String sql = "SELECT id_eleccion FROM tbl_elecciones GROUP BY 1";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            ResultSet resultados = sentencia.executeQuery();
            System.out.println(sql);
            
            while (resultados.next()) {
                String anio = resultados.getString("id_eleccion");
                   
                listaAnios.add(anio);
            }

            return listaAnios;
            
        }catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return null;
        }

   }
}
