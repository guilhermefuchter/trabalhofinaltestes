package CT_008;

import java.util.ArrayList;
import java.util.List;

class SistemaHistoricoDados {

    private boolean usuarioAutenticado;
    private List<RegistroConsumo> registrosConsumo;
    private List<RegistroAjuste> ajustesDieta;
    private List<RegistroAlerta> alertas;

    public SistemaHistoricoDados() {
        this.usuarioAutenticado = false;
        this.registrosConsumo = new ArrayList<>();
        this.ajustesDieta = new ArrayList<>();
        this.alertas = new ArrayList<>();
    }

    public void autenticarUsuario(String usuario, String senha) {
        if ("usuario".equals(usuario) && "senha123".equals(senha)) {
            this.usuarioAutenticado = true;
        }
    }

    public void registrarConsumo(String vacaId, String data, double quantidade, String tipoAlimento) {
        registrosConsumo.add(new RegistroConsumo(vacaId, data, quantidade, tipoAlimento));
    }

    public void registrarAjusteDieta(String vacaId, String data, String ajuste) {
        ajustesDieta.add(new RegistroAjuste(vacaId, data, ajuste));
    }

    public void registrarAlerta(String vacaId, String data, String alerta) {
        alertas.add(new RegistroAlerta(vacaId, data, alerta));
    }

    public Historico consultarHistorico(String vacaId, String periodo) {
        if (!usuarioAutenticado) {
            throw new IllegalStateException("Usuário não autenticado.");
        }

        // Filtra os dados para a vaca e o período configurado (simplificado para o exemplo)
        List<RegistroConsumo> consumosFiltrados = registrosConsumo.stream()
                .filter(r -> r.getVacaId().equals(vacaId))
                .toList();
        List<String> ajustesFiltrados = ajustesDieta.stream()
                .filter(r -> r.getVacaId().equals(vacaId))
                .map(RegistroAjuste::getAjuste)
                .toList();
        List<String> alertasFiltrados = alertas.stream()
                .filter(r -> r.getVacaId().equals(vacaId))
                .map(RegistroAlerta::getAlerta)
                .toList();

        return new Historico("Consulta ao histórico realizada com sucesso.", consumosFiltrados, ajustesFiltrados, alertasFiltrados);
    }

    public boolean exportarHistorico(String vacaId, String formato) {
        if (!usuarioAutenticado) {
            throw new IllegalStateException("Usuário não autenticado.");
        }
        return formato.equalsIgnoreCase("PDF") || formato.equalsIgnoreCase("Excel");
    }
}
