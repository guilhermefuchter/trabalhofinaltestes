package CT_004;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GeracaoAlertasConsumoTest {

    private SistemaMonitoramentoConsumo sistema;

    @BeforeEach
    void setUp() {
        // Inicializa o sistema e configura o consumo esperado
        sistema = new SistemaMonitoramentoConsumo();
        sistema.configurarConsumoEsperado("Vaca001", 10.0); // Consumo esperado: 10 kg/dia
    }

    @Test
    void CT_004_GeracaoDeAlertaPorConsumoAbaixoDoEsperado() {
        // Simula o consumo real registrado
        double consumoReal = 4.0; // Consumo abaixo do esperado
        String mensagemAlerta = sistema.registrarConsumo("Vaca001", consumoReal);

        // Verificação 1: Mensagem de alerta exibida corretamente
        Assertions.assertEquals("Alerta: Consumo abaixo do esperado para a vaca [Vaca001]. Verifique possíveis problemas.", mensagemAlerta);

        // Verificação 2: Alerta registrado no histórico
        Alerta alertaRegistrado = sistema.getHistoricoAlertas().stream()
                .filter(alerta -> alerta.getIdVaca().equals("Vaca001") &&
                        alerta.getDescricao().contains("Consumo abaixo do esperado"))
                .findFirst()
                .orElse(null);

        Assertions.assertNotNull(alertaRegistrado, "O alerta não foi registrado no histórico.");
        Assertions.assertEquals("Vaca001", alertaRegistrado.getIdVaca());
        Assertions.assertTrue(alertaRegistrado.getDescricao().contains("Consumo abaixo do esperado"));
    }
}
