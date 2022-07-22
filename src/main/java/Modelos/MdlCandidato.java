
package Modelos;

import Clases.ClsCandidato;
import Clases.ClsJdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class MdlCandidato {
    ClsJdbc jdbc; 
    
    public MdlCandidato(){
        this.jdbc = new ClsJdbc();
        this.jdbc.CrearConexion();
    }
    
    public boolean agregarCandidato(ClsCandidato candidato){
        
        return true;
        
    }
    
    public LinkedList<ClsCandidato> ObtenerCandidatos(){
        
        try{
            
            LinkedList<ClsCandidato> listaCandidatos= new LinkedList<>();
            
            
            String sql = "SELECT * FROM tbl_candidatos";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            ResultSet resultados = sentencia.executeQuery();
            
            while(resultados.next()){
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
            
        }catch (Exception e){
            System.out.println("Error" + e.getMessage());
            return null;
        }
        
    }
}
