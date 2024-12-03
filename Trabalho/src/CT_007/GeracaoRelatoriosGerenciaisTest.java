package CT_007;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GeracaoRelatoriosGerenciaisTest {

    private SistemaGeracaoRelatorios sistema;

    @BeforeEach
    void setUp() {
        // Inicializa o sistema e autentica o usuário
        sistema = new SistemaGeracaoRelatorios();
        sistema.autenticarUsuario("usuario", "senha123");
    }

    @Test
    void CT_007_GeracaoRelatorioGerencialCompleto() {
        // Configuração dos parâmetros do teste
        int quantidadeVacas = 50;
        double estoqueSilagem = 2000.0; // kg
        double estoqueRacao = 500.0; // kg
        double consumoDiarioSilagem = 10.0; // kg/vaca
        double consumoDiarioRacao = 2.0; // kg/vaca
        int periodoDias = 30;

        // Ação: Gerar o relatório gerencial
        RelatorioGerencial relatorio = sistema.gerarRelatorioGerencial(
                quantidadeVacas, estoqueSilagem, estoqueRacao, consumoDiarioSilagem, consumoDiarioRacao, periodoDias);

        // Verificação 1: Mensagem de sucesso
        Assertions.assertEquals("Relatório gerado com sucesso.", relatorio.getMensagem());

        // Verificação 2: Informações do rebanho
        Assertions.assertEquals(quantidadeVacas, relatorio.getQuantidadeVacas());
        Assertions.assertEquals(consumoDiarioSilagem, relatorio.getConsumoDiarioSilagem());
        Assertions.assertEquals(consumoDiarioRacao, relatorio.getConsumoDiarioRacao());

        // Verificação 3: Informações do estoque
        Assertions.assertEquals(estoqueSilagem, relatorio.getEstoqueSilagem());
        Assertions.assertEquals(estoqueRacao, relatorio.getEstoqueRacao());

        // Verificação 4: Dados financeiros (cálculos simplificados para o exemplo)
        double custoTotalEsperado = (quantidadeVacas * consumoDiarioSilagem * periodoDias * 2.0) +
                (quantidadeVacas * consumoDiarioRacao * periodoDias * 3.0); // Exemplo de custos
        Assertions.assertEquals(custoTotalEsperado, relatorio.getCustoTotal(), 0.01);

        // Verificação 5: Exportação de relatórios
        Assertions.assertTrue(sistema.exportarRelatorio("PDF"), "Falha ao exportar relatório em PDF.");
        Assertions.assertTrue(sistema.exportarRelatorio("Excel"), "Falha ao exportar relatório em Excel.");
    }
}
