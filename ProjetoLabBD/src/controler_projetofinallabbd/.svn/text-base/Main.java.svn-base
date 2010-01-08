package controler_projetofinallabbd;

import BD.ConexaoBD;
import BD.TabelaTrecho;
import BD.TabelaVoo;
import view_projetofinallabbd.*;
import java.util.*;

 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author douglas
 */
public class Main {

    public static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    public static String user;
    public static String password;

    public static java.sql.Date converteData(String data){
        if(data == null)
            return null;
        java.sql.Date nova_data;
        char separador = ' ';
        if(data.indexOf('/') != -1)
            separador = '/';
        else if (data.indexOf('-') != -1)
            separador = '-';
        else if (data.indexOf('.') != -1)
            separador = '.';
        else{ // nao encontrou separador: retorna nulo
            return null;
        }
        char c_data[] = data.toCharArray();
        char year[] = new char[2];
        int maxi = 7;
        if (c_data.length == 10){
            year = new char[4];
            maxi = 9;
        }
        char month[] = new char[2];
        char day[] = new char[2];
        int j = 0;
        for(int i = 0; i < c_data.length; i++){
            if(c_data[i] != separador){
                if(i>=0 && i<=1){
                    day[j] = c_data[i];
                    j++;
                }
                if(i>=3 && i<=4){
                    month[j] = c_data[i];
                    j++;
                }
                if(i>=6 && i<=maxi){
                    year[j] = c_data[i];
                    j++;
                }
            }else{
                // econtrou o separador, zera
                j = 0;
            }
        }
        nova_data = new java.sql.Date(Integer.parseInt(String.valueOf(year))-1900,Integer.parseInt(String.valueOf(month))-1,Integer.parseInt(String.valueOf(day)));
        return nova_data;
    }

    /**
     * this class is the main class of the project =P
     * @param args the command line arguments
     */

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //efetua login
                new Login().setVisible(true);
            }
        });
    }

}
