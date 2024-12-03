package CT_008;

class RegistroAjuste {
    private String vacaId;
    private String data;
    private String ajuste;

    public RegistroAjuste(String vacaId, String data, String ajuste) {
        this.vacaId = vacaId;
        this.data = data;
        this.ajuste = ajuste;
    }

    public String getVacaId() {
        return vacaId;
    }

    public String getAjuste() {
        return ajuste;
    }
}
