/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

import controler_projetofinallabbd.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author douglas
 */
public abstract class ConexaoBD {
    /**
     *
     * Returns a String object with all Strings of an Array,
     * separated by comma (",")
     *
     * @param strings
     * @return serial
     */
    public static String serializeStringArray(String strings[]){
        String serial = new String("");
        for (int i = 0; i < strings.length - 1; i++){
            serial += strings[i] + ", ";
        }
        serial += strings[strings.length - 1];
        return serial;
    }

    public static String serializeStringVector(Vector<String> strings){
        String serial = new String("");
        for (int i = 0; i < strings.size() - 1; i++){
            serial += strings.get(i) + ", ";
        }
        serial += strings.get(strings.size() - 1);
        return serial;
    }

    public static String serializeTipoDadoArray(Tabela tabela, String valores[]){
        String serial = new String("");
        String tipo = new String();
        for (int i = 0; i < valores.length - 1; i++){
            tipo = tabela.getTipoCampo(i);
            if(!valores[i].isEmpty()){
                if (tipo.equals("VARCHAR") || tipo.equals("VARCHAR2"))
                    serial += "'";
                else if (tipo.equals("TIMESTAMP"))
                    serial += "to_date('";
                else if (tipo.equals("TIME"))
                    serial += "to_date('";
                else if (tipo.equals("DATE"))
                    serial += "to_date('";
                serial += valores[i];
                if (tipo.equals("DATE"))
                serial += "', 'dd-mm-yyyy'), ";
                else if (tipo.equals("TIME"))
                    serial += "', 'hh24:mi'), ";
                else if (tipo.equals("TIMESTAMP"))
                    serial += "', 'dd-mm-yyyy hh24:mi'), ";
                else if (tipo.equals("VARCHAR") || tipo.equals("VARCHAR2"))
                    serial += "',";
                else if (tipo.equals("INTEGER"))
                    serial += ", ";
                else if (tipo.length() >= 6 && tipo.substring(0,6).equals("NUMBER"))
                    serial += ", ";
            }
        }
        tipo = tabela.getTipoCampo(valores.length - 1);
            if (tipo.equals("VARCHAR") || tipo.equals("VARCHAR2"))
                serial += "'";
            else if (tipo.equals("TIMESTAMP"))
                serial += "to_date('";
            else if (tipo.equals("TIME"))
                serial += "to_date('";
            else if (tipo.equals("DATE"))
                serial += "to_date('";
            serial += valores[valores.length - 1];
            if (tipo.equals("DATE"))
                serial += "', 'dd-mm-yyyy')";
            else if (tipo.equals("TIME"))
                serial += "', 'hh24:mi')";
            else if (tipo.equals("TIMESTAMP"))
                serial += "', 'dd-mm-yyyy hh24:mi')";
            else if (tipo.equals("VARCHAR") || tipo.equals("VARCHAR2"))
                serial += "'";
        return serial;
    }

    public static String serializeTipoDadoVector(Tabela tabela, Vector<String> valores){
        String serial = new String("");
        String tipo = new String();
        for (int i = 0; i < valores.size() - 1; i++){
            tipo = tabela.getTipoCampo(i);
            if (tipo.equals("VARCHAR") || tipo.equals("VARCHAR2"))
                serial += "'";
            serial += valores.get(i);
            if (tipo.equals("VARCHAR") || tipo.equals("VARCHAR2"))
                serial += "', ";
            else
                serial += ", ";
        }
        tipo = tabela.getTipoCampo(valores.size() - 1);
            if (tipo.equals("VARCHAR") || tipo.equals("VARCHAR2"))
                serial += "'";
            serial += valores.get(valores.size() - 1);
            if (tipo.equals("VARCHAR") || tipo.equals("VARCHAR2"))
                serial += "'";
        return serial;
    }

    private String constroiStringInsert(Tabela tabela, String valores[]){
        return "insert into " + tabela.getNome() + " ( " + serializeStringVector(tabela.getNomesCampos()) + ") values ( "+ serializeTipoDadoArray(tabela,valores) + ")";
    }

    public int insere(Tabela tabela, String valores[]) throws SQLException, Exception{
        int rows = 0;
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(controler_projetofinallabbd.Main.url,Main.user,Main.password);
        Statement st = con.createStatement();
        javax.swing.JOptionPane.showMessageDialog(null, constroiStringInsert(tabela, valores));
        rows = st.executeUpdate(constroiStringInsert(tabela, valores));
        st.close();
        con.close();
        return rows;
    }

    /* Ideia interessante, mas deixa pra fazer esta api depois =/
    public Object fetch(Tabela tabelas[], String colunas[]) throws SQLException {
        Object obj = new Object();
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(controler_projetofinallabbd.Main.url,Main.user,Main.password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select numero, dia_semana, companhia_aerea from voo order by numero"); // ordenando, a busca na interface pode ser bin.
        while (rs.next()){
            Voo voo_tmp = new Voo(rs.getInt(1), rs.getString(2), rs.getString(3));
            // simples : sem data por ora
            rs_trecho = st_trecho.executeQuery("select nro_trecho, a1.codigo, a1.nome, a1.cidade, a1.estado, " +
                    "a2.codigo, a2.nome, a2.cidade, a2.estado, to_char(hora_chegada,'hh24:mi'), to_char(hora_partida,'hh24:mi') from trecho_voo tr join aeroporto a1 on tr.aeroporto_partida = a1.codigo " +
                    "join aeroporto a2 on tr.aeroporto_chegada = a2.codigo " +
                    "where nro_voo = " + voo_tmp.getNumero());
            while (rs_trecho.next()){
                Aeroporto partida = new Aeroporto(rs_trecho.getString(2), rs_trecho.getString(3), rs_trecho.getString(4), rs_trecho.getString(5));
                Aeroporto chegada = new Aeroporto(rs_trecho.getString(6), rs_trecho.getString(7), rs_trecho.getString(8), rs_trecho.getString(9));
                Trecho trecho = new Trecho(rs_trecho.getInt(1), rs_trecho.getString(10), partida, rs_trecho.getString(11), chegada);
                voo_tmp.insereTrecho(trecho);
            }

            rs_trecho.close();

            rs_tarifa = st_tarifa.executeQuery("select valor, classe from tarifa where nro_voo = " + Integer.toString(voo_tmp.getNumero()));

            Tarifas tarifas = new Tarifas();

            while (rs_tarifa.next()){
                tarifas.setValor(rs_tarifa.getString(2),rs_tarifa.getDouble(1));
            }

            voo_tmp.setTarifas(tarifas);

            voo.add(voo_tmp);

            rs_tarifa.close();
        }
        st_tarifa.close();
        st_trecho.close();
        rs.close();
        st.close();
        con.close();
        return Object;
    }*/
    /*
    public boolean remove(Object object){

    }
    public boolean update(Object object){

    }
    public boolean existe(Object object){

    }*/
}
