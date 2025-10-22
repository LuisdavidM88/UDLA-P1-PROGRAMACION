public class Auto {
    private String placa;
    private String marca;
    private String modelo;
    private int year;

    public Auto(String placa, String marca, String modelo, int year) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return "AUTO:" +
                "placa: " + placa +
                ", marca: " + marca +
                ", modelo: " + modelo +
                ", año: " + year + "\n";
    }
}
