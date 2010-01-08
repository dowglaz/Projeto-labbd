

package model_projetofinallabbd;

import java.util.*;



public class Voo {

    private int numero;
    private String dia_semana;
    private String companhia_aerea;
    private Tarifas tarifas;
    private Vector<Trecho> trechos = new Vector<Trecho>();
    private Vector<InstanciaTrecho> instanciaTrechos = new Vector<InstanciaTrecho>();

    public void setTarifa(Classe classe, double tarifa){
        this.tarifas.setValor(classe, tarifa);
    }

    public void setTarifas(Tarifas tarifas){
        this.tarifas = tarifas.getInstance();
    }

    public void setTarifas(double valores[]){
        this.tarifas.setTarifas(valores);
    }

    public void setTarifa(String classe, double tarifa){
        this.tarifas.setValor(classe,tarifa);
    }

    public boolean setTarifa(int n, double tarifa){
        return this.tarifas.setValor(n, tarifa);
    }

    public double getTarifa(String nomeClasse){
        return this.tarifas.getValor(nomeClasse);
    }

    public double getTarifa(int n){
        return this.tarifas.getValor(n);
    }

    public double getTarifa(Classe classe){
        return this.tarifas.getValor(classe);
    }

    public Tarifas getTarifas(){
        return this.tarifas;
    }

    public boolean instanciaTrecho(int nTrecho, GregorianCalendar data, Aviao aviao){
        Trecho trecho = this.trechoPorNumero(nTrecho);
        if (trecho.getNumero() == -1)
            return false;
        InstanciaTrecho instancia = new InstanciaTrecho(trecho, data, aviao);
        this.instanciaTrechos.add(instancia);
        return true;
    }

    public boolean instanciaTrecho(GregorianCalendar data, Aviao aviao, int indiceTrecho){
        Trecho trecho = this.trechos.get(indiceTrecho);
        if (trecho.getNumero() == -1)
                return false;
        InstanciaTrecho instancia = new InstanciaTrecho(trecho, data, aviao);
        this.instanciaTrechos.add(instancia);
        return true;
    }

    public Vector<Trecho> getTrechos() {
        return trechos;
    }

    public Vector<Trecho> getInstanceTrechos(){
        Vector<Trecho> inst_trechos = new Vector<Trecho>();
        for (int i = 0; i < trechos.size(); i++){
            inst_trechos.add(this.trechos.get(i).getInstance());
        }
        return inst_trechos;
    }

    public void setTrechos(Vector<Trecho> trechos) {
        this.trechos.removeAllElements();
        for (int i = 0; i < trechos.size(); i++)
            this.trechos.add(trechos.get(i).getInstance());
    }

    public Trecho getTrecho(int index){
        Trecho trecho;
        if(index >=0 && index <= this.trechos.size())
            trecho = this.trechos.get(index);
        trecho = new Trecho();
        trecho.setNumero(-1);
        return trecho;
    }

    public Trecho trechoPorNumero(int n){
        for (int i = 0; i < n; i++){
            if (this.trechos.get(i).getNumero() == n)
                return this.trechos.get(i);
        }
        // retorna trecho com numero -1
        Trecho trecho = new Trecho();
        trecho.setNumero(-1);
        return trecho;
    }

    public void insereTrecho(Trecho trecho){
        this.trechos.add(trecho);
    }

    // Voo com trechos
    public Voo(int numero, String dia_semana, String companhia_aerea, Tarifas tarifas, Vector<Trecho> trechos) {
        this.numero = numero;
        this.dia_semana = dia_semana;
        this.companhia_aerea = companhia_aerea;
        this.trechos = trechos;
        this.instanciaTrechos = new Vector<InstanciaTrecho>();
        this.tarifas = tarifas;
    }

    // Voo sem trechos
    public Voo(int numero, String dia_semana, String comp_aerea, Tarifas tarifas){
        this.numero = numero; // Para obter o status do voo, faz-se uma consulta ao banco de dados
        this.dia_semana = dia_semana;
        this.companhia_aerea = comp_aerea;
        this.trechos = new Vector<Trecho>();
        this.instanciaTrechos = new Vector<InstanciaTrecho>();
        this.tarifas = tarifas;
    }

    public Voo(int numero, String dia_semana, String comp_aerea){
        this.numero = numero; // Para obter o status do voo, faz-se uma consulta ao banco de dados
        this.dia_semana = dia_semana;
        this.companhia_aerea = comp_aerea;
        this.trechos = new Vector<Trecho>();
        this.instanciaTrechos = new Vector<InstanciaTrecho>();
        this.tarifas = new Tarifas();
    }

    public Voo(){
        this.numero = -1;
        this.dia_semana = "";
        this.companhia_aerea = "";
        this.tarifas = new Tarifas();
        this.trechos = new Vector<Trecho>();
        this.instanciaTrechos = new Vector<InstanciaTrecho>();
    }

    public int getNumero(){
        return this.numero;
    }
    public String getDiaSemana(){
        return this.dia_semana;
    }
    public int getNDiaSemana(){
        if(this.dia_semana.toUpperCase().equals("DOMINGO"))
            return 0;
        else if(this.dia_semana.toUpperCase().equals("SEGUNDA"))
            return 1;
        else if(this.dia_semana.toUpperCase().equals("TERCA"))
            return 2;
        else if(this.dia_semana.toUpperCase().equals("QUARTA"))
            return 3;
        else if(this.dia_semana.toUpperCase().equals("QUINTA"))
            return 4;
        else if(this.dia_semana.toUpperCase().equals("SEXTA"))
            return 5;
        else if(this.dia_semana.toUpperCase().equals("SABADO"))
            return 6;
        return -1;
    }
    public String getCompanhiaAerea(){
        return this.companhia_aerea;
    }
    public void setNumero(int numero){
        this.numero = numero;
    }
    public void setCompanhia_aerea(String companhia_aerea) {
        this.companhia_aerea = companhia_aerea;
    }

    public void setDia_semana(String dia_semana) {
        this.dia_semana = dia_semana;
    }
}
