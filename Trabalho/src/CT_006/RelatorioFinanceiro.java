package CT_006;

class RelatorioFinanceiro {
    private String mensagem;
    private double custoAlimentacaoPorVaca;
    private double custoPorLitro;
    private String detalhes;

    public RelatorioFinanceiro(String mensagem, double custoAlimentacaoPorVaca, double custoPorLitro, String detalhes) {
        this.mensagem = mensagem;
        this.custoAlimentacaoPorVaca = custoAlimentacaoPorVaca;
        this.custoPorLitro = custoPorLitro;
        this.detalhes = detalhes;
    }

    public String getMensagem() {
        return mensagem;
    }

    public double getCustoAlimentacaoPorVaca() {
        return custoAlimentacaoPorVaca;
    }


    public double getCustoPorLitro() {
        return custoPorLitro;
    }

    public String getDetalhes() {
        return detalhes;
    }
}
