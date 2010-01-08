
package model_projetofinallabbd;


public class Aeroporto {
    
    private String codigo;
    private String nome;
    private String cidade;
    private String estado;

    public Aeroporto(String codigo, String nome, String cidade, String estado) {
        this.codigo = codigo;
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
    }

    // Instancia pela chave, depois busca no banco
    public Aeroporto(String codigo){
        this.codigo = codigo;
    }

    public Aeroporto(){
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
