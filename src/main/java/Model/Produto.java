package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Produto {

    @Id
    private int codP;

    @Column
    private  String descricao;

    @Column
    private  String marca;

    @Column
    private double preco;

    public Produto(int codP, String descricao, String marca, double preco) {
        this.codP = codP;
        this.descricao = descricao;
        this.marca = marca;
        this.preco = preco;
    }

    public int getCodP() {
        return codP;
    }

    public void setCodP(int codP) {
        this.codP = codP;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
