package Modelo.DAO;

import java.sql.*;
import Utilidades.*;
public class ProyectoBancoDao {
    public static ResultSet consulta(String banco) {
        Statement smtt=null;
        ResultSet rs=null;
        String csql="SELECT Id_Proyecto as ID, Constructora, Ciudad, Proyecto.Clasificacion, Estrato, Nombre||' '||Primer_Apellido||' '||Segundo_Apellido as LIDER FROM Proyecto JOIN Tipo USING(ID_Tipo) JOIN Lider USING(ID_Lider) WHERE Banco_Vinculado='"+banco+"' ORDER BY Fecha_Inicio DESC, Ciudad ASC, Constructora;";
            
        try {
            var conn=JDBCUtilities.getConnection();
            
            smtt=conn.createStatement();
            rs=smtt.executeQuery(csql);

        
        } catch (Exception e) {
            //TODO: handle exception
        }

    return rs;        
    }
}
