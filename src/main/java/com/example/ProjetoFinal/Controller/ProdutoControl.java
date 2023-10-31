package com.example.ProjetoFinal.Controller;


import com.example.ProjetoFinal.Model.Produto;
import com.example.ProjetoFinal.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/apiProduto")


public class ProdutoControl {

    @Autowired
    ProdutoRepository alpro;

    @PostMapping("/inserir")
    public void inserirProd (@RequestBody Produto prod)
    {
        alpro.save(prod);
    }

    @GetMapping("/todosProd")
    public List<Produto> buscarTodosProd()
    {
        return alpro.findAll();
    }

    @GetMapping("/todosProd/cod/{codp}")
    public Optional<Produto> buscarPorCod(@PathVariable("codp") int codp)
    {
        return alpro.findById(codp);
    }

    @GetMapping("/todosProd/desc/{descricao}")
    public List<Produto> buscarPorDescricao(@PathVariable("descricao")String descricao)
    {
        return alpro.buscarPorDescricao(descricao);
    }

    @GetMapping("todosProd/preco/{preco}")
    public List<Produto> buscarPorPreco(@PathVariable("preco") double preco)
    {
        return  alpro.buscarPorValor(preco);
    }

    @GetMapping("todosProd/marca/{marca}")
    public List<Produto> buscarPorMarca(@PathVariable("marca") String marca)
    {
        return alpro.buscarPorMarca(marca);
    }

    @GetMapping("todosProd/marcaepreco/{marca}/{preco}")
    public List<Produto> buscaMarcaePreco(@PathVariable("marca") String marca, @PathVariable("preco") double preco)
    {
    return alpro.buscarMarcaePreco(marca, preco);
    }

    @DeleteMapping("/removerProd")
    public void removerProd(@RequestBody Produto prod)
    {
        alpro.delete(prod);
    }

    @DeleteMapping("/removerProd/cod/{codp}")
    public  void removerporCod(@PathVariable("codp")int codig)
    {
        alpro.deleteById(codig);
    }

    @PutMapping("/atualizarProd")
    public void atualizarProd(@RequestBody Produto prod1)
    {
        alpro.save(prod1);
    }


}
