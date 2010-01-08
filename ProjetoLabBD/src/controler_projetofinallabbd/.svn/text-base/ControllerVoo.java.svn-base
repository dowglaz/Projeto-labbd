/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controler_projetofinallabbd;

import BD.*;
import java.sql.*;
import java.util.*;
import model_projetofinallabbd.*;
import oracle.jdbc.*;

/**
 *
 * @author douglas
 */
public class ControllerVoo extends ConexaoBD{

    private TabelaVoo tabelaVoo;
    private TabelaTrecho tabelaTrecho;
    private TabelaTarifa tabelaTarifa;

    public ControllerVoo(){
        this.tabelaVoo = new TabelaVoo();
        this.tabelaTrecho = new TabelaTrecho();
        this.tabelaTarifa = new TabelaTarifa();
    }
    public static Vector<Voo> fetchVoos() throws Exception, SQLException {
        Vector<Voo> voo = new Vector<Voo>();
        Class.forName("oracle.jdbc.driver.OracleDriver");
//criar seção de login*************************************

        // Pega dados do voo
        Connection con = DriverManager.getConnection(controler_projetofinallabbd.Main.url,Main.user,Main.password);
        Statement st = con.createStatement();
        Statement st_trecho = con.createStatement();
        Statement st_tarifa = con.createStatement();
        ResultSet rs = st.executeQuery("select numero, dia_semana, companhia_aerea from voo order by numero"); // ordenando, a busca na interface pode ser bin.
        ResultSet rs_trecho;
        ResultSet rs_tarifa;
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
        return voo;
    }

    public Vector<Vector<Voo>> fetchVoosDatas(String aeroporto_origem, String aeroporto_destino, java.sql.Date data, String classe, java.sql.Timestamp hora_inferior, java.sql.Timestamp hora_superior){
        Vector<Voo> v_voos_diretos = new Vector<Voo>();
        Vector<Voo> v_voos_dois_trechos = new Vector<Voo>();
        Vector<Voo> v_voos_tres_trechos = new Vector<Voo>();
        Vector<Vector<Voo>> voos = new Vector<Vector<Voo>>();
        voos.add(v_voos_diretos);
        voos.add(v_voos_dois_trechos);
        voos.add(v_voos_tres_trechos);
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(controler_projetofinallabbd.Main.url,Main.user,Main.password);
            CallableStatement cstmt = con.prepareCall("{call voos.encontra_voos(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cstmt.setString(1, aeroporto_origem);
            cstmt.setString(2, aeroporto_destino);
            cstmt.setDate(3, data);
            cstmt.setString(4, classe);
            cstmt.setTimestamp(5, hora_inferior);
            cstmt.setTimestamp(6, hora_superior);
            cstmt.registerOutParameter(7, OracleTypes.CURSOR); // 1 de 2 trechos
            cstmt.registerOutParameter(8, OracleTypes.CURSOR); // 2 de 2 trechos
            cstmt.registerOutParameter(9, OracleTypes.CURSOR); // 1 de 3 trechos
            cstmt.registerOutParameter(10, OracleTypes.CURSOR); // 2 de 3 trechos
            cstmt.registerOutParameter(11, OracleTypes.CURSOR); // 3 de 3 trechos
            cstmt.registerOutParameter(12, OracleTypes.CURSOR); // 1 de 1 trecho - direto
            
            cstmt.execute();

            // Obs: serao preenchidos os trechos, ao inves de instancias, pois nao serao
            // necessarios dados da insancia no retorno

            // Voos diretos
            ResultSet voos_diretos = (ResultSet) cstmt.getObject(12);
            this.preencheTrechos(voos_diretos, v_voos_diretos, classe);
            voos_diretos.close();

            // Dois trechos
            ResultSet voos_dois_trechos_1 = (ResultSet) cstmt.getObject(7);
            this.preencheTrechos(voos_dois_trechos_1, v_voos_dois_trechos, classe);
            voos_dois_trechos_1.close();
            ResultSet voos_dois_trechos_2 = (ResultSet) cstmt.getObject(8);
            this.preencheMaisTrechos(voos_dois_trechos_2, v_voos_dois_trechos);
            voos_dois_trechos_2.close();

            // Tres trechos
            ResultSet voos_tres_trechos_1 = (ResultSet) cstmt.getObject(9);
            this.preencheTrechos(voos_tres_trechos_1, v_voos_tres_trechos, classe);
            voos_tres_trechos_1.close();
            ResultSet voos_tres_trechos_2 = (ResultSet) cstmt.getObject(10);
            this.preencheMaisTrechos(voos_tres_trechos_2, v_voos_tres_trechos);
            voos_tres_trechos_2.close();
            ResultSet voos_tres_trechos_3 = (ResultSet) cstmt.getObject(11);
            this.preencheMaisTrechos(voos_tres_trechos_3, v_voos_tres_trechos);
            voos_tres_trechos_3.close();

            cstmt.close();
            con.close();
            
        }catch (SQLException e){
            javax.swing.JOptionPane.showMessageDialog(null, "Erro sql: " + e.getMessage());
        }catch (ClassNotFoundException e){
            javax.swing.JOptionPane.showMessageDialog(null, "Erro de classe nao encontrada.");
        }catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(null, "Erro desconhecido. Entre em contato com os desenvolvedores.");
            e.printStackTrace();
        }

        return voos;
    }

    private void preencheTrechos(ResultSet rs, Vector<Voo> voos, String classe) throws SQLException {
        while(rs.next()){
            Voo voo_direto = new Voo();
            // dados do voo
            voo_direto.setNumero(Integer.parseInt(rs.getObject(1).toString()));
            voo_direto.setCompanhia_aerea(rs.getObject(7).toString());
            voo_direto.setTarifa(classe, Double.parseDouble(rs.getObject(8).toString()));
            // dados do trecho
            Aeroporto partida = new Aeroporto();
            partida.setNome(rs.getObject(3).toString());
            Aeroporto chegada = new Aeroporto();
            chegada.setNome(rs.getObject(5).toString());
            Trecho trecho_direto = new Trecho();
            trecho_direto.setNumero(Integer.parseInt(rs.getObject(2).toString()));
            trecho_direto.setAeroporto_partida(partida);
            trecho_direto.setHora_partida(rs.getObject(4).toString());
            trecho_direto.setAeroporto_chegada(chegada);
            trecho_direto.setHora_chegada(rs.getObject(6).toString());
            voo_direto.insereTrecho(trecho_direto);
            voos.add(voo_direto);
        }
    }

    private void preencheMaisTrechos(ResultSet rs, Vector<Voo> voos) throws SQLException {
        int i = 0;
        while(rs.next()){
            // dados do trecho
            Aeroporto partida = new Aeroporto();
            partida.setNome(rs.getObject(2).toString());
            Aeroporto chegada = new Aeroporto();
            chegada.setNome(rs.getObject(4).toString());
            Trecho trecho = new Trecho();
            trecho.setNumero(Integer.parseInt(rs.getObject(1).toString()));
            trecho.setAeroporto_partida(partida);
            trecho.setHora_partida(rs.getObject(3).toString());
            trecho.setAeroporto_chegada(chegada);
            trecho.setHora_chegada(rs.getObject(5).toString());
            voos.get(i).insereTrecho(trecho);
            i++;
        }
    }
    /*
    public boolean existeVoo(int numero) throws SQLException{

    }

    public Voo fetchVoo(int numero) throws SQLException{

    }
    */

    public boolean insereTarifa(Voo voo, String classe, Double valor) throws SQLException{
        String valores[] = {
            classe,
            Integer.toString(voo.getNumero()),
            Double.toString(valor)
        };
        try{
            this.insere(tabelaTarifa, valores);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insereTrecho(int nro_voo, Trecho trecho) throws SQLException{
        String valores[] = {
            Integer.toString(trecho.getNumero()),
            Integer.toString(nro_voo),
            trecho.getAeroporto_chegada().getCodigo(),
            trecho.getHora_chegada(),
            trecho.getAeroporto_partida().getCodigo(),
            trecho.getHora_partida()            
        };
        // problema: uma campo a mais esta sendo encontrado na insercao e a string esta errada...
        try{
            this.insere(tabelaTrecho, valores);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insereVoo(Voo voo) throws SQLException{
        String valores[] = {
            Integer.toString(voo.getNumero()),
            voo.getDiaSemana().toUpperCase(),
            voo.getCompanhiaAerea()
        };
        try{
            this.insere(tabelaVoo, valores);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        for(int i = 0; i < 3; i++){
            insereTarifa(voo,Classe.getNomeByIndex(i),voo.getTarifa(i));
        }
        /*javax.swing.JOptionPane.showMessageDialog(null, Integer.toString(voo.getTrechos().size()));
        for(int i = 0; i < voo.getTrechos().size(); i++){
            Trecho trecho_tmp = voo.getTrecho(i);
            javax.swing.JOptionPane.showMessageDialog(null, Integer.toString(trecho_tmp.getNumero()));
            insereTrecho(voo.getNumero(), voo.getTrecho(i));
        }*/
        return true;
    }
    /*
    public boolean removeVoo(int numero) throws SQLException{

    }

    public boolean updateVoo(Voo voo) throws SQLException{

    }

    public Vector<Trecho> fetchTrechos(int nro_voo) throws SQLException{

    }

    public Trecho fetchTrecho(int nro_voo, int nro_trecho) throws SQLException{

    }
    */
    public boolean insereTrecho(Voo voo, Trecho trecho) throws SQLException{
        String valores[] = {Integer.toString(trecho.getNumero()),
            Integer.toString(voo.getNumero()),
            trecho.getAeroporto_partida().getCodigo(),
            trecho.getHora_partida(),
            trecho.getAeroporto_chegada().getCodigo(),
            trecho.getHora_chegada()
        };
        try{
            this.insere(tabelaTrecho, valores);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /*
    public boolean updateTrecho(Trecho trecho) throws SQLException{

    }

    public boolean removeTrecho(int nro_trecho) throws SQLException{

    }

    public boolean existeInstancia(int nro_voo, int nro_trecho, java.sql.Date data) throws SQLException{

    }

    public InstanciaTrecho fetchInstancia(int nro_voo, int nro_trecho, java.sql.Date data) throws SQLException{

    }

    public Vector<InstanciaTrecho> fetchInstancias(int nro_voo, int nro_trecho) throws SQLException{
        
    }

    public boolean insereInstancia(Voo voo, InstanciaTrecho insTrecho) throws SQLException{

    }

    public boolean removeInstancia(Instancia insTrecho) throws SQLException{

    }

    public boolean updateInstancia(Instancia insTrecho) throws SQLException{

    }
    */
}
