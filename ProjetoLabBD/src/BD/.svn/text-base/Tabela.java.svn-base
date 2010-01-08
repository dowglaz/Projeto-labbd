/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

import java.util.*;

/**
 *
 * @author douglas
 */
public abstract class Tabela {

    protected String nome;
    protected Vector<TipoDado> campos;
    protected Vector<TipoDado> chaves;

    public Tabela(String nome, Vector<TipoDado> campos, Vector<TipoDado> chaves) {
        this.nome = nome;
        this.campos = campos;
        this.chaves = chaves;
    }

    public Tabela(String nome){
        this.nome = nome;
        this.campos = new Vector<TipoDado>();
        this.chaves = new Vector<TipoDado>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Vector<TipoDado> getCampos() {
        return campos;
    }

    public TipoDado getCampo(int i){
        return this.campos.get(i);
    }

    public String getTipoCampo(int i){
        return this.campos.get(i).getTipo();
    }

    public String getNomeCampo(int i){
        return this.campos.get(i).getNome();
    }

    public Vector<String> getNomesCampos(){
        Vector<String> nomesCampos = new Vector<String>();
        for (int i = 0; i < campos.size(); i++){
            nomesCampos.add(campos.get(i).getNome());
        }
        return nomesCampos;
    }

    public void setCampos(Vector<TipoDado> campos) {
        this.campos = campos;
    }

    public void insereCampo(TipoDado campo){
        this.campos.add(campo);
    }

    public Vector<TipoDado> getChaves() {
        return chaves;
    }

    public void setChaves(Vector<TipoDado> chaves) {
        this.chaves = chaves;
    }

    public void insereChave(TipoDado chave){
        this.chaves.add(chave);
    }

}
