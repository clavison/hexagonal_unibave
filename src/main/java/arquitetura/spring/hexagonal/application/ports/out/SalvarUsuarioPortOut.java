package arquitetura.spring.hexagonal.application.ports.out;


import arquitetura.spring.hexagonal.application.core.domain.Usuario;

public interface SalvarUsuarioPortOut {
    Usuario salvar(Usuario usuario);
}
