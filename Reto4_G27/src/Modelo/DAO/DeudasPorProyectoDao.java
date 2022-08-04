package Modelo.DAO;
import java.sql.*;
import Utilidades.*;
public class DeudasPorProyectoDao {
    public static ResultSet consulta(Double limiteInferior) {
        Statement smtt=null;
        ResultSet rs=null;
        String csql="SELECT ID_proyecto, SUM(Cantidad*Precio_Unidad) as VALOR FROM Compra JOIN MaterialConstruccion USING(ID_MaterialConstruccion) WHERE Pagado='No' GROUP BY ID_proyecto HAVING VALOR>"+limiteInferior+" ORDER BY VALOR DESC;";
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
