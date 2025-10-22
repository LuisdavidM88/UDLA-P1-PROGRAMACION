public class Cliente implements Comparable<Cliente> {
    private String nombre;
    private String tipoTransaccion;
    private int prioridad;

    //constructor generado
    public Cliente(String nombre, String tipoTransaccion, int prioridad) {
        this.nombre = nombre;
        this.tipoTransaccion = tipoTransaccion;
        this.prioridad = prioridad;
    }

    //toString generado
    @Override
    public String toString() {
        return "Cliente:" +
                "Nombre: " + nombre +
                ", Tipo de Transaccion: " + tipoTransaccion +
                ", prioridad: " + prioridad;
    }

    //metodo para Comparable<Cliente>
    @Override
    public int compareTo(Cliente o) {
        if(this.prioridad<o.prioridad)//estoy comparando 2 elementos de atributo prioridad
            return 1;//utilizo numero negativo para ordenar de mayor a menor
        else {
            return -1;//ordenar de manera menor a mayor
        }
    }
}
