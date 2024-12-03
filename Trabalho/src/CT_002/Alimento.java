package CT_002;

import java.time.LocalDate;

class Alimento {
    private String tipo;
    private double quantidade;
    private LocalDate validade;

    public Alimento(String tipo, double quantidade, LocalDate validade) {
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.validade = validade;
    }

    public String getTipo() {
        return tipo;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public LocalDate getValidade() {
        return validade;
    }
}
