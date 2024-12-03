package CT_003;

import java.util.ArrayList;
import java.util.List;

class SistemaGeracaoDieta {

    private boolean usuarioAutenticado;
    private List<Vaca> rebanho;

    public SistemaGeracaoDieta() {
        this.usuarioAutenticado = false;
        this.rebanho = new ArrayList<>();
    }

    public void autenticarUsuario(String usuario, String senha) {
        if ("usuario".equals(usuario) && "senha123".equals(senha)) {
            this.usuarioAutenticado = true;
        }
    }

    public boolean isUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public void adicionarVaca(Vaca vaca) {
        rebanho.add(vaca);
    }

    public Dieta gerarDieta(Vaca vaca) {
        if (!usuarioAutenticado) {
            throw new IllegalStateException("Usuário não autenticado.");
        }

        // Simula cálculo de dieta com base nos parâmetros da vaca
        double proteinas = vaca.getPeso() * 0.03; // Exemplo: 3% do peso em proteínas
        double energia = vaca.getPeso() * 0.05;  // Exemplo: 5% do peso em energia

        return new Dieta(vaca, proteinas, energia);
    }
}
