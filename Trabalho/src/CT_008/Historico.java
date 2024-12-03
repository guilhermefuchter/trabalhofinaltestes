package CT_008;

import java.util.List;

class Historico {
    private String mensagem;
    private List<RegistroConsumo> registrosConsumo;
    private List<String> ajustesDieta;
    private List<String> alertas;

    public Historico(String mensagem, List<RegistroConsumo> registrosConsumo, List<String> ajustesDieta, List<String> alertas) {
        this.mensagem = mensagem;
        this.registrosConsumo = registrosConsumo;
        this.ajustesDieta = ajustesDieta;
        this.alertas = alertas;
    }

    public String getMensagem() {
        return mensagem;
    }

    public List<RegistroConsumo> getRegistrosConsumo() {
        return registrosConsumo;
    }

    public List<String> getAjustesDieta() {
        return ajustesDieta;
    }

    public List<String> getAlertas() {
        return alertas;
    }
}
