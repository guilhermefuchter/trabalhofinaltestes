package CT_002;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class SistemaGerenciamentoEstoque {

    private boolean usuarioAutenticado;
    private List<Alimento> estoque;

    public SistemaGerenciamentoEstoque() {
        this.usuarioAutenticado = false;
        this.estoque = new ArrayList<>();
    }

    public void autenticarUsuario(String usuario, String senha) {
        if ("usuario".equals(usuario) && "senha123".equals(senha)) {
            this.usuarioAutenticado = true;
        }
    }

    public String cadastrarAlimento(String tipo, double quantidade, LocalDate validade) {
        if (!usuarioAutenticado) {
            return "Usuário não autenticado. Faça login para cadastrar alimentos.";
        }

        Alimento novoAlimento = new Alimento(tipo, quantidade, validade);
        estoque.add(novoAlimento);
        return "Cadastro de alimento realizado com sucesso.";
    }

    public List<Alimento> getEstoque() {
        return estoque;
    }
}
