package Modelo.VO;
import java.sql.*;
import Modelo.DAO.*;
public class DeudasPorProyectoVo {
    public static void valores(Double limiteInferior) {
        try {
         
            ResultSet rs=DeudasPorProyectoDao.consulta(limiteInferior);
         
            while(rs.next()){
                int id=rs.getInt("ID_proyecto");
                Float valor= rs.getFloat("VALOR");

                System.out.println(String.format("%3d %,15.1f", id, valor));
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
