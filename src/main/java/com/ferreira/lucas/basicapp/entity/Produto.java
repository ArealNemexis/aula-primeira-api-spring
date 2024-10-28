package com.ferreira.lucas.basicapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;

@Entity // Entity é a classe java que simboliza uma tabela do banco.
public class Produto {

    /*
    Precisamos de um identificador do registro
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // recomendo pesquisar sobre UUIDS
    private String identificador;
    
    private String nome;
    
    private BigDecimal preco; // pode usar Double, mas recomendo pesquisar sobre BIGDECIMAL

    public String getIdentificador() {
        return identificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
