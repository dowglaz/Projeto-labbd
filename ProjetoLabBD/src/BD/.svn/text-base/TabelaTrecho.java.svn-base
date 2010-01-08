/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

/**
 *
 * @author douglas
 */
public class TabelaTrecho extends Tabela{
    public TabelaTrecho(){
        super("TRECHO_VOO");
        insereCampo(new TipoDado("NRO_TRECHO","INTEGER"));
        insereCampo(new TipoDado("NRO_VOO","INTEGER"));
        insereCampo(new TipoDado("AEROPORTO_PARTIDA","VARCHAR2"));
        insereCampo(new TipoDado("HORA_PARTIDA","TIME"));
        insereCampo(new TipoDado("AEROPORTO_CHEGADA","VARCHAR2"));
        insereCampo(new TipoDado("HORA_CHEGADA","TIME"));
        insereChave(new TipoDado("NRO_TRECHO","INTEGER"));
        insereChave(new TipoDado("NRO_VOO","INTEGER"));
    }
}
