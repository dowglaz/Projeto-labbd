/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controler_projetofinallabbd;

import BD.ConexaoBD;
import model_projetofinallabbd.Aeroporto;
import java.util.*;
import java.sql.*;
/**
 *
 * @author douglas
 */
public class ControllerAeroporto extends ConexaoBD{
    private String query;
    public ControllerAeroporto(){
         this.query = "select codigo, nome, cidade, estado from aeroporto order by nome";
    }
    public Vector<Aeroporto> atualizaAeroportos() throws Exception {
        Vector<Aeroporto> aeroportos = new Vector<Aeroporto>();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

    //criar seção de login*************************************
            Connection con = DriverManager.getConnection(controler_projetofinallabbd.Main.url,Main.user,Main.password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(this.query);
            while (rs.next()){
                Aeroporto aeroporto = new Aeroporto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                aeroportos.add(aeroporto);
            }
            rs.close();
            st.close();
            con.close();
            }catch (SQLException e){
                javax.swing.JOptionPane.showMessageDialog(null, "Erro no banco de dados. Não foi possível buscar os aeroportos de origem!");
            }
        return aeroportos;
    }
    
    public static Vector<Aeroporto> fetchAeroporotos() throws Exception{
        Vector<Aeroporto> aeroportos = new Vector<Aeroporto>();
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(controler_projetofinallabbd.Main.url,Main.user,Main.password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select codigo, nome, cidade, estado from aeroporto order by nome"); // ordenando, a busca na interface pode ser bin.
        while (rs.next()){
            Aeroporto aeroporto = new Aeroporto(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
            aeroportos.add(aeroporto);
        }
        rs.close();
        st.close();
        con.close();
        return aeroportos;
    }
}
