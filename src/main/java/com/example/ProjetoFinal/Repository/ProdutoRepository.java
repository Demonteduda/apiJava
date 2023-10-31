package com.example.ProjetoFinal.Repository;

import com.example.ProjetoFinal.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository <Produto, Integer> {

    @Query("select p from Produto p where p.descricao like %?1%")
    List<Produto> buscarPorDescricao(String desc);

    @Query("select p from Produto p  where p.preco <= ?1")
     List<Produto> buscarPorValor(double valor);

    @Query("select p from Produto p where p.marca=?1")
    List<Produto> buscarPorMarca(String marca);

    @Query("select p from  Produto p where p.marca like %?1% and p.preco<= ?2")
    List<Produto> buscarMarcaePreco(String marca, double preco);

}
