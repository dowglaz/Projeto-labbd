

package model_projetofinallabbd;

import java.util.*;


public class Trecho {

    private int numero;
    private String hora_partida;
    private Aeroporto aeroporto_partida;
    private String hora_chegada;
    private Aeroporto aeroporto_chegada;

    public String getHora_chegada() {
        return hora_chegada;
    }

    public void setHora_chegada(String hora_chegada) {
        this.hora_chegada = hora_chegada;
    }

    public String getHora_partida() {
        return hora_partida;
    }

    public void setHora_partida(String hora_partida) {
        this.hora_partida = hora_partida;
    }

    public Aeroporto getAeroporto_chegada() {
        return aeroporto_chegada;
    }

    public void setAeroporto_chegada(Aeroporto aeroporto_chegada) {
        this.aeroporto_chegada = aeroporto_chegada;
    }

    public Aeroporto getAeroporto_partida() {
        return aeroporto_partida;
    }

    public void setAeroporto_partida(Aeroporto aeroporto_partida) {
        this.aeroporto_partida = aeroporto_partida;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Trecho(int numero, String hora_partida, Aeroporto aeroporto_partida, String hora_chegada, Aeroporto aeroporto_chegada) {
        this.numero = numero;
        this.hora_partida = hora_partida;
        this.aeroporto_partida = aeroporto_partida;
        this.hora_chegada = hora_chegada;
        this.aeroporto_chegada = aeroporto_chegada;
    }

    public Trecho(int numero, String hora_partida, String aeroporto_partida, String hora_chegada, String aeroporto_chegada){
        this.numero = numero;
        this.hora_partida = hora_partida;
        this.aeroporto_partida = new Aeroporto(aeroporto_partida);
        this.hora_chegada = hora_chegada;
        this.aeroporto_chegada = new Aeroporto(aeroporto_chegada);
    }

    public Trecho(int numero, Aeroporto partida, Aeroporto chegada){
        this.numero = numero;
        this.aeroporto_partida = partida;
        this.aeroporto_chegada = chegada;
    }

    public Trecho() {
    }

    public Trecho getInstance(){
        return new Trecho(this.numero, this.hora_partida, this.aeroporto_partida, this.hora_chegada, this.aeroporto_chegada);
    }

}
