package CT_008;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class HistoricoDadosTest {

    private SistemaHistoricoDados sistema;

    @BeforeEach
    void setUp() {
        // Inicializa o sistema e autentica o usuário
        sistema = new SistemaHistoricoDados();
        sistema.autenticarUsuario("usuario", "senha123");

        // Pré-condição: Registrar dados históricos no sistema
        sistema.registrarConsumo("Vaca001", "2024-11-25", 10.0, "Silagem");
        sistema.registrarConsumo("Vaca001", "2024-11-26", 9.5, "Silagem");
        sistema.registrarAjusteDieta("Vaca001", "2024-11-27", "Adicionado 1 kg de ração concentrada");
        sistema.registrarAlerta("Vaca001", "2024-11-28", "Consumo abaixo do esperado");
    }

    @Test
    void CT_008_ConsultaHistoricoConsumo() {
        // Configuração dos parâmetros de consulta
        String vacaId = "Vaca001";
        String periodo = "últimos 7 dias";

        // Ação: Consultar histórico de dados
        Historico historico = sistema.consultarHistorico(vacaId, periodo);

        // Verificação 1: Mensagem de sucesso
        Assertions.assertEquals("Consulta ao histórico realizada com sucesso.", historico.getMensagem());

        // Verificação 2: Dados de consumo
        List<RegistroConsumo> consumos = historico.getRegistrosConsumo();
        Assertions.assertEquals(2, consumos.size());
        Assertions.assertEquals(10.0, consumos.get(0).getQuantidade(), 0.01);
        Assertions.assertEquals("Silagem", consumos.get(0).getTipoAlimento());
        Assertions.assertEquals(9.5, consumos.get(1).getQuantidade(), 0.01);

        // Verificação 3: Ajustes na dieta
        List<String> ajustes = historico.getAjustesDieta();
        Assertions.assertEquals(1, ajustes.size());
        Assertions.assertEquals("Adicionado 1 kg de ração concentrada", ajustes.get(0));

        // Verificação 4: Alertas gerados
        List<String> alertas = historico.getAlertas();
        Assertions.assertEquals(1, alertas.size());
        Assertions.assertEquals("Consumo abaixo do esperado", alertas.get(0));

        // Verificação 5: Exportação do histórico
        Assertions.assertTrue(sistema.exportarHistorico(vacaId, "PDF"), "Falha ao exportar histórico em PDF.");
        Assertions.assertTrue(sistema.exportarHistorico(vacaId, "Excel"), "Falha ao exportar histórico em Excel.");
    }
}
