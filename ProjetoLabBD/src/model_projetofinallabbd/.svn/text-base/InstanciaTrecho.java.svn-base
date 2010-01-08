

package model_projetofinallabbd;

import java.util.*;


public class InstanciaTrecho {

    // Este trecho contera os dados do trecho instanciado
    private Trecho trecho;
    private GregorianCalendar data;
    private Aviao aviao;
    
    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public void setData(GregorianCalendar data) {
        this.data = data;
    }

    public Trecho getTrecho() {
        return trecho;
    }

    public void setTrecho(Trecho trecho) {
        this.trecho = trecho;
    }

    public InstanciaTrecho(Trecho trecho, GregorianCalendar data, Aviao aviao) {
        this.trecho = trecho.getInstance();
        this.data = data;
        this.aviao = aviao;
    }

    // Caso tenha ocorrido mudança nos valores do trecho original, os dados devem ser inserido neste construtor
    public InstanciaTrecho(int numero, String hora_partida, Aeroporto aeroporto_partida, String hora_chegada, Aeroporto aeroporto_chegada, GregorianCalendar data, Aviao aviao) {
        this.trecho = new Trecho(numero, hora_partida, aeroporto_partida, hora_chegada, aeroporto_chegada);
        this.data = data;
        this.aviao = aviao;
    }

}
