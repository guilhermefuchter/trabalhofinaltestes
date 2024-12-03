package CT_004;

class Alerta {
    private String idVaca;
    private String descricao;

    public Alerta(String idVaca, String descricao) {
        this.idVaca = idVaca;
        this.descricao = descricao;
    }

    public String getIdVaca() {
        return idVaca;
    }

    public String getDescricao() {
        return descricao;
    }
}
