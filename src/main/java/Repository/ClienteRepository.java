package Repository;

import Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository <Cliente, Integer >{

    @Query("select a from Cliente a where a.codigo")
    List<Cliente> findByCodigo(int codigo);

    @Query("select a from Cliente a where a.nome like %?1%")
    List<Cliente> findBypartenome(String nome);

    @Query("select a from Cliente a where a.email")
    List<Cliente> findByEmail(String email);

    @Query("select a from Cliente a where a.nome like %?1% and a.email like %?1%")
    List<Cliente> findByNomeEmail(String nome, String email);


}
