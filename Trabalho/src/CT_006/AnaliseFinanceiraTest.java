package CT_006;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnaliseFinanceiraTest {

    private SistemaAnaliseFinanceira sistema;

    @BeforeEach
    void setUp() {
        // Inicializa o sistema e autentica o usuário
        sistema = new SistemaAnaliseFinanceira();
        sistema.autenticarUsuario("usuario", "senha123");
    }

    @Test
    void CT_006_AnaliseFinanceiraCalculosCorretos() {
        // Configuração dos parâmetros do teste
        int quantidadeVacas = 5;
        double consumoDiarioPorVaca = 10.0; // kg
        double custoPorKg = 2.0; // R$
        double producaoDiariaPorVaca = 25.0; // litros

        // Ação: Gerar o relatório financeiro
        RelatorioFinanceiro relatorio = sistema.gerarRelatorioFinanceiro(
                quantidadeVacas, consumoDiarioPorVaca, custoPorKg, producaoDiariaPorVaca);

        // Verificação 1: Mensagem de sucesso
        Assertions.assertEquals("Relatório gerado com sucesso.", relatorio.getMensagem());

        // Verificação 2: Cálculo do custo de alimentação por vaca
        double custoEsperadoPorVaca = consumoDiarioPorVaca * custoPorKg;
        Assertions.assertEquals(custoEsperadoPorVaca, relatorio.getCustoAlimentacaoPorVaca());

        // Verificação 3: Cálculo do custo por litro de leite
        double custoPorLitroEsperado = custoEsperadoPorVaca / producaoDiariaPorVaca;
        Assertions.assertEquals(custoPorLitroEsperado, relatorio.getCustoPorLitro());

        // Verificação 4: Formato detalhado do relatório
        Assertions.assertNotNull(relatorio.getDetalhes(), "O relatório detalhado não foi gerado.");

        // Verificação 5: Exportação de relatórios
        Assertions.assertTrue(sistema.exportarRelatorio("PDF"), "Falha ao exportar relatório em PDF.");
        Assertions.assertTrue(sistema.exportarRelatorio("Excel"), "Falha ao exportar relatório em Excel.");
    }
}
