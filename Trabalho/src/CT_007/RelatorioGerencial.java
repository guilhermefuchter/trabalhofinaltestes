package CT_007;

class RelatorioGerencial {
    private String mensagem;
    private int quantidadeVacas;
    private double estoqueSilagem;
    private double estoqueRacao;
    private double consumoDiarioSilagem;
    private double consumoDiarioRacao;
    private double custoTotal;
    private String detalhes;

    public RelatorioGerencial(String mensagem, int quantidadeVacas, double estoqueSilagem,
                              double estoqueRacao, double consumoDiarioSilagem, double consumoDiarioRacao,
                              double custoTotal, String detalhes) {
        this.mensagem = mensagem;
        this.quantidadeVacas = quantidadeVacas;
        this.estoqueSilagem = estoqueSilagem;
        this.estoqueRacao = estoqueRacao;
        this.consumoDiarioSilagem = consumoDiarioSilagem;
        this.consumoDiarioRacao = consumoDiarioRacao;
        this.custoTotal = custoTotal;
        this.detalhes = detalhes;
    }

    public String getMensagem() {
        return mensagem;
    }

    public int getQuantidadeVacas() {
        return quantidadeVacas;
    }

    public double getEstoqueSilagem() {
        return estoqueSilagem;
    }

    public double getEstoqueRacao() {
        return estoqueRacao;
    }

    public double getConsumoDiarioSilagem() {
        return consumoDiarioSilagem;
    }

    public double getConsumoDiarioRacao() {
        return consumoDiarioRacao;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public String getDetalhes() {
        return detalhes;
    }
}
