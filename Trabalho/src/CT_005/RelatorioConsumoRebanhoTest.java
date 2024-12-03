package CT_005;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class RelatorioConsumoRebanhoTest {

    private SistemaRelatorioConsumo sistema;

    @BeforeEach
    void setUp() {
        // Inicializa o sistema e autentica o usuário
        sistema = new SistemaRelatorioConsumo();
        sistema.autenticarUsuario("usuario", "senha123");

        // Configura vacas e dietas para o rebanho
        Vaca vaca1 = new Vaca(1, 600.0, "Lactação inicial");
        Dieta dieta1 = new Dieta(vaca1, 18.0, 30.0); // Proteína e energia em kg
        sistema.adicionarVacaComDieta(vaca1, dieta1);

        Vaca vaca2 = new Vaca(2, 500.0, "Lactação intermediária");
        Dieta dieta2 = new Dieta(vaca2, 15.0, 25.0);
        sistema.adicionarVacaComDieta(vaca2, dieta2);
    }

    @Test
    void CT_005_GeracaoRelatorioConsumoRebanho() {
        // Ação: Gerar o relatório de consumo alimentar
        List<RelatorioConsumo> relatorio = sistema.gerarRelatorioConsumo();

        // Verificação 1: Garantir que o relatório não está vazio
        Assertions.assertNotNull(relatorio, "O relatório não foi gerado.");
        Assertions.assertEquals(2, relatorio.size(), "O relatório deve conter dados de duas vacas.");

        // Verificação 2: Verificar os dados do relatório
        RelatorioConsumo vaca1Relatorio = relatorio.get(0);
        Assertions.assertEquals(1, vaca1Relatorio.getIdVaca(), "O ID da vaca 1 está incorreto.");
        Assertions.assertEquals(18.0, vaca1Relatorio.getProteinas(), "O consumo de proteínas da vaca 1 está incorreto.");
        Assertions.assertEquals(30.0, vaca1Relatorio.getEnergia(), "O consumo de energia da vaca 1 está incorreto.");

        RelatorioConsumo vaca2Relatorio = relatorio.get(1);
        Assertions.assertEquals(2, vaca2Relatorio.getIdVaca(), "O ID da vaca 2 está incorreto.");
        Assertions.assertEquals(15.0, vaca2Relatorio.getProteinas(), "O consumo de proteínas da vaca 2 está incorreto.");
        Assertions.assertEquals(25.0, vaca2Relatorio.getEnergia(), "O consumo de energia da vaca 2 está incorreto.");
    }
}
