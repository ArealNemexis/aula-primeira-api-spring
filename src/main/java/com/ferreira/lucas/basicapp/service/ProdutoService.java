package com.ferreira.lucas.basicapp.service;

import com.ferreira.lucas.basicapp.entity.Produto;
import com.ferreira.lucas.basicapp.model.ProdutoDTO;
import com.ferreira.lucas.basicapp.repository.ProdutoRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/*
Uma service é a classe responsavel por uma parte da regra de négocio de uma app
Regra de negócio é a logica.
além disso, geralmente é utilizada como camada entre o banco (repository e entity)
e a camada de comunicação externa/http, vulgo controller ;D
*/
@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    
    //retornar todos os produtos R do C[R]UD
    public List<Produto> listar(){
        return produtoRepository.findAll(); // find ALL (encontre todos) do banco
    }
    
    public Produto cadastraProduto(final ProdutoDTO produto) {
        Produto produtoNovo = new Produto();
        produtoNovo.setNome(produto.getNome());
        produtoNovo.setPreco(produto.getPreco());
        return produtoRepository.save(produtoNovo);
    }

    public Optional<Produto> buscarProduto(final String id){
            return produtoRepository.findById(id);
    }

    public Produto atualizarProduto(String id, ProdutoDTO produtoNovo, Produto produtoBuscado) {
            produtoBuscado.setNome(produtoNovo.getNome());
            produtoBuscado.setPreco(produtoNovo.getPreco());
    return produtoRepository.save(produtoBuscado);

    }

    public void deletarProduto(final Produto produto) {
            produtoRepository.delete(produto);
    }
}
