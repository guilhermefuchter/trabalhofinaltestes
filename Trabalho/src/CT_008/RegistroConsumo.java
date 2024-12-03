package CT_008;

class RegistroConsumo {
    private String vacaId;
    private String data;
    private double quantidade;
    private String tipoAlimento;

    public RegistroConsumo(String vacaId, String data, double quantidade, String tipoAlimento) {
        this.vacaId = vacaId;
        this.data = data;
        this.quantidade = quantidade;
        this.tipoAlimento = tipoAlimento;
    }

    public String getVacaId() {
        return vacaId;
    }

    public String getData() {
        return data;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public String getTipoAlimento() {
        return tipoAlimento;
    }
}
