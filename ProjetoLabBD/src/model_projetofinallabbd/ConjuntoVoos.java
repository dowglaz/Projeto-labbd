/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model_projetofinallabbd;

/**
 *
 * Uma simples classe que se comporta basicamente como uma struct e
 * guarda um voo e se
 */
 public class ConjuntoVoos{
    public Voo voo;
    public Trecho trecho;
    public ConjuntoVoos(Voo voo, Trecho trecho) {
        this.voo = voo;
        this.trecho = trecho;
    }
}
