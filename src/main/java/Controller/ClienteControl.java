package Controller;

import Model.Cliente;
import Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/apiCliente")
public class ClienteControl {

    @Autowired
    ClienteRepository alcli;

    @GetMapping("/todoscli")
    public List<Cliente> buscartodosClientes()
    {
        return alcli.findAll();
    }

    @GetMapping("/todoscli/codigo/{codigo}")
    public List<Cliente> buscarporCodigo (@PathVariable ("codigo") int codigo)
    {
        return alcli.findByCodigo(codigo);
    }

    @GetMapping("/todoscli/nome/{nome}")
    public List<Cliente> buscarporNome (@PathVariable ("nome") String nome)
    {
        return alcli.findBypartenome(nome);
    }

    @GetMapping("/todoscli/email/{email}")
    public List<Cliente> buscarporEmail (@PathVariable ("email") String email)
    {
        return alcli.findByEmail(email);
    }

    @GetMapping("/todoscli/nomeemail/{nome}/{email}")
    public List<Cliente> buscarporNomeEmail (@PathVariable("nome") String nome, @PathVariable ("email") String email)
    {
        return alcli.findByNomeEmail(nome,email);
    }

    @PostMapping("/inserir")
    public void inserirCliente(@RequestBody Cliente cli)
    {
        alcli.save(cli);
    }

    @DeleteMapping("/removercli")
    public void removerClientes (@RequestBody Cliente cli)
    {
        alcli.delete(cli);
    }

    @DeleteMapping("/removercli/codigo/{codigo}")
    public  void removerporcodigo (@PathVariable ("codigo") int codigo)
    {
        alcli.deleteById(codigo);
    }

    @PutMapping("/atualizar")
    public void atualizarCliente (@RequestBody Cliente cli)
    {
        alcli.save(cli);
    }
    



}
