package CT_002;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class CadastroAlimentosTest {

    private SistemaGerenciamentoEstoque sistema;

    @BeforeEach
    void setUp() {
        // Inicializa o sistema e autentica o usuário
        sistema = new SistemaGerenciamentoEstoque();
        sistema.autenticarUsuario("usuario", "senha123");
    }

    @Test
    void CT_002_CadastroDeAlimentoValido() {
        // Configuração dos dados do novo alimento
        String tipo = "Silagem";
        double quantidade = 500.0; // kg
        LocalDate validade = LocalDate.of(2025, 12, 1);

        // Ação: Cadastrar o alimento
        String mensagem = sistema.cadastrarAlimento(tipo, quantidade, validade);

        // Verificação 1: Mensagem de sucesso
        Assertions.assertEquals("Cadastro de alimento realizado com sucesso.", mensagem);

        // Verificação 2: Confirmação do alimento no estoque
        Alimento alimentoCadastrado = sistema.getEstoque().stream()
                .filter(a -> a.getTipo().equals(tipo) &&
                        a.getQuantidade() == quantidade &&
                        a.getValidade().equals(validade))
                .findFirst()
                .orElse(null);

        Assertions.assertNotNull(alimentoCadastrado, "O alimento não foi encontrado no estoque.");
        Assertions.assertEquals(tipo, alimentoCadastrado.getTipo());
        Assertions.assertEquals(quantidade, alimentoCadastrado.getQuantidade(), 0.01);
        Assertions.assertEquals(validade, alimentoCadastrado.getValidade());
    }
}
