/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model_projetofinallabbd;

/**
 *
 * @author douglas
 */
public class Classe {
    
    private String nome;

    public static String getNomeByIndex(int n){
        if (n == 0){
            return new String("ECONOMICA");
        }else if (n == 1){
            return new String("EXECUTIVA");
        }else if (n == 2){
            return new String("PRIMEIRA CLASSE");
        }else{
            return "";
        }
    }

    public boolean setNome(String nome){
        if (nome.toUpperCase().equals("ECONOMICA")){
            this.nome = "ECONOMICA";
        }else if (nome.toUpperCase().equals("EXECUTIVA")){
            this.nome = "EXECUTIVA";
        }else if (nome.toUpperCase().equals("PRIMEIRA CLASSE")){
            this.nome = "PRIMEIRA CLASSE";
        }else{
            this.nome = "";
            return false;
        }
        return true;
    }

    public boolean setNome(int n){
        if (n == 0){
            this.nome = "ECONOMICA";
        }else if (n == 1){
            this.nome = "EXECUTIVA";
        }else if (n == 2){
            this.nome = "PRIMEIRA CLASSE";
        }else{
            this.nome = "";
            return false;
        }
        return true;
    }

    public String getNome(){
        return this.nome;
    }

    public boolean isEconomica(){
        return this.nome.equals("ECONOMICA");
    }

    public boolean isExecutiva(){
        return this.nome.equals("EXECUTIVA");
    }

    public boolean isPrimeira_Classe(){
        return this.nome.equals("PRIMEIRA CLASSE");
    }

    public Classe(String nome){
        setNome(nome);
    }

    public Classe(int i){
        setNome(i);
    }
    
}
