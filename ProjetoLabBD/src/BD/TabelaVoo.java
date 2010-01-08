/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

/**
 *
 * @author douglas
 */
public class TabelaVoo extends Tabela{
    public TabelaVoo(){
        super("VOO");
        insereCampo(new TipoDado("NUMERO","INTEGER"));
        insereCampo(new TipoDado("DIA_SEMANA","VARCHAR2"));
        insereCampo(new TipoDado("COMPANHIA_AEREA","VARCHAR2"));
        insereChave(new TipoDado("NUMERO","INTEGER"));
    }
}
