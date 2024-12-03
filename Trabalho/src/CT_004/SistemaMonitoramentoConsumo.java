package CT_004;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SistemaMonitoramentoConsumo {

    private Map<String, Double> consumoEsperadoPorVaca;
    private List<Alerta> historicoAlertas;

    public SistemaMonitoramentoConsumo() {
        this.consumoEsperadoPorVaca = new HashMap<>();
        this.historicoAlertas = new ArrayList<>();
    }

    public void configurarConsumoEsperado(String idVaca, double consumoEsperado) {
        consumoEsperadoPorVaca.put(idVaca, consumoEsperado);
    }

    public String registrarConsumo(String idVaca, double consumoReal) {
        Double consumoEsperado = consumoEsperadoPorVaca.get(idVaca);

        if (consumoEsperado == null) {
            return "Erro: Consumo esperado não configurado para a vaca [" + idVaca + "].";
        }

        double desvio = consumoEsperado - consumoReal;
        if (desvio > 0) {
            String mensagemAlerta = "Alerta: Consumo abaixo do esperado para a vaca [" + idVaca + "]. Verifique possíveis problemas.";
            historicoAlertas.add(new Alerta(idVaca, mensagemAlerta));
            return mensagemAlerta;
        }

        return "Consumo registrado com sucesso para a vaca [" + idVaca + "].";
    }

    public List<Alerta> getHistoricoAlertas() {
        return historicoAlertas;
    }
}
