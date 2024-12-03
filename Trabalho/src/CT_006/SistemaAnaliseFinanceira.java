package CT_006;

import java.util.ArrayList;
import java.util.List;

class SistemaAnaliseFinanceira {

    private boolean usuarioAutenticado;

    public SistemaAnaliseFinanceira() {
        this.usuarioAutenticado = false;
    }

    public void autenticarUsuario(String usuario, String senha) {
        if ("usuario".equals(usuario) && "senha123".equals(senha)) {
            this.usuarioAutenticado = true;
        }
    }

    public boolean isUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    public RelatorioFinanceiro gerarRelatorioFinanceiro(
            int quantidadeVacas, double consumoDiarioPorVaca, double custoPorKg, double producaoDiariaPorVaca) {

        if (!usuarioAutenticado) {
            throw new IllegalStateException("Usuário não autenticado.");
        }

        double custoPorVaca = consumoDiarioPorVaca * custoPorKg;
        double custoPorLitro = custoPorVaca / producaoDiariaPorVaca;
        double custoTotal = custoPorVaca * quantidadeVacas;

        String detalhes = String.format(
                "Quantidade de Vacas: %d\nConsumo Diário por Vaca: %.2f kg\nCusto por kg de Alimento: R$ %.2f\n" +
                        "Produção Diária por Vaca: %.2f litros\nCusto Total de Alimentação: R$ %.2f\n" +
                        "Custo Médio por Vaca: R$ %.2f\nCusto por Litro de Leite: R$ %.2f",
                quantidadeVacas, consumoDiarioPorVaca, custoPorKg, producaoDiariaPorVaca,
                custoTotal, custoPorVaca, custoPorLitro);

        return new RelatorioFinanceiro("Relatório gerado com sucesso.", custoPorVaca, custoPorLitro, detalhes);
    }

    public boolean exportarRelatorio(String formato) {
        if (!usuarioAutenticado) {
            throw new IllegalStateException("Usuário não autenticado.");
        }

        // Simula a exportação do relatório
        return formato.equalsIgnoreCase("PDF") || formato.equalsIgnoreCase("Excel");
    }
}
