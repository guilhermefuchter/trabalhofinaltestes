package CT_007;

class SistemaGeracaoRelatorios {

    private boolean usuarioAutenticado;

    public SistemaGeracaoRelatorios() {
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

    public RelatorioGerencial gerarRelatorioGerencial(
            int quantidadeVacas, double estoqueSilagem, double estoqueRacao,
            double consumoDiarioSilagem, double consumoDiarioRacao, int periodoDias) {

        if (!usuarioAutenticado) {
            throw new IllegalStateException("Usuário não autenticado.");
        }

        // Cálculos
        double custoSilagem = quantidadeVacas * consumoDiarioSilagem * periodoDias * 2.0; // R$ 2,00/kg
        double custoRacao = quantidadeVacas * consumoDiarioRacao * periodoDias * 3.0; // R$ 3,00/kg
        double custoTotal = custoSilagem + custoRacao;

        String detalhes = String.format(
                "Rebanho: %d vacas\nEstoque de Silagem: %.2f kg\nEstoque de Ração: %.2f kg\n" +
                        "Consumo Diário: %.2f kg de silagem/vaca, %.2f kg de ração/vaca\n" +
                        "Período: %d dias\nCusto Total: R$ %.2f",
                quantidadeVacas, estoqueSilagem, estoqueRacao,
                consumoDiarioSilagem, consumoDiarioRacao, periodoDias, custoTotal);

        return new RelatorioGerencial("Relatório gerado com sucesso.", quantidadeVacas, estoqueSilagem,
                estoqueRacao, consumoDiarioSilagem, consumoDiarioRacao, custoTotal, detalhes);
    }

    public boolean exportarRelatorio(String formato) {
        if (!usuarioAutenticado) {
            throw new IllegalStateException("Usuário não autenticado.");
        }

        // Simula a exportação do relatório
        return formato.equalsIgnoreCase("PDF") || formato.equalsIgnoreCase("Excel");
    }
}
