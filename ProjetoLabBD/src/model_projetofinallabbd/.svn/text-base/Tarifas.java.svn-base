/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model_projetofinallabbd;

/**
 *
 * @author douglas
 */
public class Tarifas {
    
    private double[] valor;

    public Tarifas(){
        this.valor = new double[3];
    }

    public Tarifas(double[] valor) {
        this.valor = valor;
    }

    public Tarifas getInstance(){
        Tarifas tarifas = new Tarifas();
        tarifas.setTarifas(this.valor);
        return tarifas;
    }

    public void setTarifas(double valor[]){
        for (int i = 0; i < 3; i++){
            this.valor[i] = valor[i];
        }
    }

    public void setValor(Classe classe, double valor){
        if (classe.isEconomica()){
            this.valor[0] = valor;
        }else if (classe.isExecutiva()){
            this.valor[1] = valor;
        }else if (classe.isPrimeira_Classe()){
            this.valor[2] = valor;
        }
    }

    public boolean setValor(String nomeClasse, double valor){
        Classe classe = new Classe(nomeClasse);
        if (!classe.setNome(nomeClasse))
            return false;
        this.setValor(classe,valor);
        return true;
    }

    public boolean setValor(int i, double valor){
        if (i >= 0 && i <= 2){
            this.valor[i] = valor;
            return true;
        }else
            return false;
    }

    public double[] getValores(){
        return this.valor;
    }

    public double getValor(int i){
        if (i < 0 || i > 2)
            return -1;
        return valor[i];
    }

    public double getValor(String nomeClasse){
        Classe classe = new Classe(nomeClasse);
        if(classe.setNome(nomeClasse) == false)
            return -1;
        if(classe.isEconomica())
            return valor[0];
        else if(classe.isExecutiva())
            return valor[1];
        else if(classe.isPrimeira_Classe())
            return valor[2];
        // nunca retorna isso
        return 0;
    }

    public double getValor(Classe classe){
        if(classe.isEconomica())
            return valor[0];
        else if(classe.isExecutiva())
            return valor[1];
        else if(classe.isPrimeira_Classe())
            return valor[2];
        // nunca retorna isso
        return 0;
    }

}
