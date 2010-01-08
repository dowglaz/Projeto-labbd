
package model_projetofinallabbd;

import java.util.*;

public class Aviao {

    private int id;
    private Vector<Poltrona> poltronas = new Vector<Poltrona>();
    private String registro;
    private String tipo;

    public Vector<Poltrona> getPoltronas(){
        return poltronas;
    }

    public Poltrona getPoltronaByIndex(int i){
        return poltronas.get(i);
    }

    public void setPoltronas(Vector<Poltrona> poltronas){
        this.poltronas = poltronas;
    }

    public void inserePoltrona(Poltrona poltrona){
        this.poltronas.add(poltrona);
    }

    public void removePoltrona(int i){
        this.poltronas.remove(i);
    }

    public int getTotalPoltronas() {
        return poltronas.size();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Aviao(int id, String registro, String tipo) {
        this.id = id;
        this.registro = registro;
        this.tipo = tipo;
    }

    public Aviao(int id, String registro, String tipo, Vector<Poltrona> poltronas){
        this(id,registro,tipo);
        this.poltronas = poltronas;
    }
    
}
