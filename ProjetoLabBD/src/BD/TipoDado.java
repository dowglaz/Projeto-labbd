/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

/**
 *
 * @author douglas
 */
public class TipoDado {

    private String nome;
    private String tipo;

    public TipoDado(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
