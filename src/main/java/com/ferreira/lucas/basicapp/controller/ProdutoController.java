package com.ferreira.lucas.basicapp.controller;

import com.ferreira.lucas.basicapp.entity.Produto;
import com.ferreira.lucas.basicapp.model.ProdutoDTO;
import com.ferreira.lucas.basicapp.service.ProdutoService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
Controller é a classe responsável por comunicar sua app Spring com o mundo externo
Ela faz parte do pacote spring web e é definida pelas anotações abaixo
*/
@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor // dever de casa Lombok
public class ProdutoController {
    private final ProdutoService produtoService;
    /*
        Conceito de ENDPOINT, passagem de dados, 
        recebe uma request e devolve uma response
    */
    @GetMapping
    public String helloWorld() {
        return "Hello World!!! :D";
    }
    
    // R do crud
    @GetMapping("/buscar")
    public List<Produto> listarTodosOsProdutos(){
        return produtoService.listar();
    }
    
    // C do CRUD
    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody final ProdutoDTO body){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(produtoService.cadastraProduto(body));
    }
	
    // D do CRUD
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(@PathVariable final String id){
                      Optional<Produto> produto = produtoService.buscarProduto(id);

            if(produto.isEmpty()) {
                    return ResponseEntity.notFound().build();
            }

            produtoService.deletarProduto(produto.get());

            return ResponseEntity.ok().build();
    }

    // U do crud
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable String id, @RequestBody ProdutoDTO produtoAtualizado) {
        Optional<Produto> produto = produtoService.buscarProduto(id);
        if (produto.isPresent()) {
        	Produto atualizado = produtoService.atualizarProduto(id, produtoAtualizado, produto.get());
            return ResponseEntity.ok(atualizado);
        }
        return ResponseEntity.notFound().build();
    }
    
}
