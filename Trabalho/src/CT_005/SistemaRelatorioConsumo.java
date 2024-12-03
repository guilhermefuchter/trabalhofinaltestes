package CT_005;

import java.util.ArrayList;
import java.util.List;

class SistemaRelatorioConsumo {

    private boolean usuarioAutenticado;
    private List<Vaca> rebanho;
    private List<Dieta> dietas;

    public SistemaRelatorioConsumo() {
        this.usuarioAutenticado = false;
        this.rebanho = new ArrayList<>();
        this.dietas = new ArrayList<>();
    }

    public void autenticarUsuario(String usuario, String senha) {
        if ("usuario".equals(usuario) && "senha123".equals(senha)) {
            this.usuarioAutenticado = true;
        }
    }

    public boolean isUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public void adicionarVacaComDieta(Vaca vaca, Dieta dieta) {
        rebanho.add(vaca);
        dietas.add(dieta);
    }

    public List<RelatorioConsumo> gerarRelatorioConsumo() {
        if (!usuarioAutenticado) {
            throw new IllegalStateException("Usuário não autenticado.");
        }

        List<RelatorioConsumo> relatorio = new ArrayList<>();
        for (int i = 0; i < rebanho.size(); i++) {
            Vaca vaca = rebanho.get(i);
            Dieta dieta = dietas.get(i);
            relatorio.add(new RelatorioConsumo(vaca.getId(), dieta.getProteinas(), dieta.getEnergia()));
        }
        return relatorio;
    }
}
