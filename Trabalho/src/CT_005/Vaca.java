package CT_005;

class Vaca {
    private int id;
    private double peso;
    private String estagioProdutivo;

    public Vaca(int id, double peso, String estagioProdutivo) {
        this.id = id;
        this.peso = peso;
        this.estagioProdutivo = estagioProdutivo;
    }

    public int getId() {
        return id;
    }

    public double getPeso() {
        return peso;
    }

    public String getEstagioProdutivo() {
        return estagioProdutivo;
    }
}
