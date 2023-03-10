package arquitetura.spring.hexagonal.application.core.service;


import arquitetura.spring.hexagonal.application.core.domain.Usuario;
import arquitetura.spring.hexagonal.application.ports.in.SalvarUsuarioServicePortIn;
import arquitetura.spring.hexagonal.application.ports.out.BuscarEnderecoPort;
import arquitetura.spring.hexagonal.application.ports.out.SalvarUsuarioPortOut;

public class SalvarUsuarioService implements SalvarUsuarioServicePortIn {

    private final SalvarUsuarioPortOut salvarUsuarioPort;

    private final BuscarEnderecoPort buscarEnderecoPort;


    public SalvarUsuarioService(SalvarUsuarioPortOut salvarUsuarioPort, BuscarEnderecoPort buscarEnderecoPort) {
        this.salvarUsuarioPort = salvarUsuarioPort;
        this.buscarEnderecoPort = buscarEnderecoPort;
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario, String cep) {

        var endereco = buscarEnderecoPort.buscar(cep);
        usuario.setEndereco(endereco);

        return salvarUsuarioPort.salvar(usuario);
    }
}
