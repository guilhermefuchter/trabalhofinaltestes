package CT_003;

class Dieta {
    private Vaca vacaAssociada;
    private double proteinas;
    private double energia;

    public Dieta(Vaca vaca, double proteinas, double energia) {
        this.vacaAssociada = vaca;
        this.proteinas = proteinas;
        this.energia = energia;
    }

    public Vaca getVacaAssociada() {
        return vacaAssociada;
    }

    public double getProteinas() {
        return proteinas;
    }

    public double getEnergia() {
        return energia;
    }
}
