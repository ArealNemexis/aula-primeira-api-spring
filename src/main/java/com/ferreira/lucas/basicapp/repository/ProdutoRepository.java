package com.ferreira.lucas.basicapp.repository;

import com.ferreira.lucas.basicapp.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProdutoRepository extends JpaRepository<Produto, String>{
    /*
    Uma repository manipula o banco de dado: faz queries, inserts, deletes, updates, etc.
    Recomendo fortemente ir a fundo nisso, pois é uma dificuldade de gente de mercado entender.
    */
}
