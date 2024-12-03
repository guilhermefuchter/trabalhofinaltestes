package CT_008;

class RegistroAlerta {
    private String vacaId;
    private String data;
    private String alerta;

    public RegistroAlerta(String vacaId, String data, String alerta) {
        this.vacaId = vacaId;
        this.data = data;
        this.alerta = alerta;
    }

    public String getVacaId() {
        return vacaId;
    }

    public String getAlerta() {
        return alerta;
    }
}
