package CT_001;

import CT_001.SistemaCadastroVacas;
import CT_001.Vaca;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CadastroRebanhoTest {

    private SistemaCadastroVacas sistema;

    @BeforeEach
    void setUp() {
        // Inicializa o sistema e autentica o usuário
        sistema = new SistemaCadastroVacas();
        sistema.autenticarUsuario("usuario", "senha123");
    }

    @Test
    void CT_001_CadastrarVacaComInformacoesValidas() {
        // Dados configurados para o teste
        Vaca vaca = new Vaca();
        vaca.setIdade(4); // anos
        vaca.setPeso(550.0); // kg
        vaca.setEspecie("Holandesa");
        vaca.setEstagioLactacao("Inicial");
        vaca.setCondicaoSaude("Boa");

        // Ação: Realizar o cadastro
        String mensagem = sistema.cadastrarVaca(vaca);

        // Verificação 1: Verificar mensagem de sucesso
        Assertions.assertEquals("Cadastro realizado com sucesso.", mensagem);

        // Verificação 2: Verificar se a vaca foi adicionada ao rebanho
        boolean vacaCadastrada = sistema.getRebanho().stream()
                .anyMatch(v -> v.getIdade() == vaca.getIdade() &&
                        v.getPeso() == vaca.getPeso() &&
                        v.getEspecie().equals(vaca.getEspecie()) &&
                        v.getEstagioLactacao().equals(vaca.getEstagioLactacao()) &&
                        v.getCondicaoSaude().equals(vaca.getCondicaoSaude()));

        Assertions.assertTrue(vacaCadastrada, "A vaca cadastrada não foi encontrada na lista de rebanho.");
    }
}
