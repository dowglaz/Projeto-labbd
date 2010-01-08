/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view_projetofinallabbd;

/**
 *
 * @author Henry
 */

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ErrorMessages {

    public void printError( SQLException e, String message){
              JOptionPane.showMessageDialog(null,"O item que está tentando cadastrar já existe.");
    }

    public void seila(){

    }

}
