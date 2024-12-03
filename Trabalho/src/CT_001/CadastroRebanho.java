package CT_001;

import java.util.ArrayList;
import java.util.List;

class Vaca {
    private int idade;
    private double peso;
    private String especie;
    private String estagioLactacao;
    private String condicaoSaude;

    // Getters e Setters
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getEstagioLactacao() {
        return estagioLactacao;
    }

    public void setEstagioLactacao(String estagioLactacao) {
        this.estagioLactacao = estagioLactacao;
    }

    public String getCondicaoSaude() {
        return condicaoSaude;
    }

    public void setCondicaoSaude(String condicaoSaude) {
        this.condicaoSaude = condicaoSaude;
    }
}

class SistemaCadastroVacas {
    private boolean usuarioAutenticado;
    private List<Vaca> rebanho;

    public SistemaCadastroVacas() {
        this.usuarioAutenticado = false;
        this.rebanho = new ArrayList<>();
    }

    public void autenticarUsuario(String usuario, String senha) {
        // Simula autenticação (simplificada para o exemplo)
        if ("usuario".equals(usuario) && "senha123".equals(senha)) {
            this.usuarioAutenticado = true;
        }
    }

    public boolean isUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public String cadastrarVaca(Vaca vaca) {
        if (!usuarioAutenticado) {
            return "Usuário não autenticado. Faça login antes de cadastrar.";
        }
        rebanho.add(vaca);
        return "Cadastro realizado com sucesso.";
    }

    public List<Vaca> getRebanho() {
        return rebanho;
    }
}
