package CT_005;

class RelatorioConsumo {
    private int idVaca;
    private double proteinas;
    private double energia;

    public RelatorioConsumo(int idVaca, double proteinas, double energia) {
        this.idVaca = idVaca;
        this.proteinas = proteinas;
        this.energia = energia;
    }

    public int getIdVaca() {
        return idVaca;
    }

    public double getProteinas() {
        return proteinas;
    }

    public double getEnergia() {
        return energia;
    }
}
