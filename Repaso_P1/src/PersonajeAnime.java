// Clase que representa a un Personaje de Anime
// Implementa Comparable para permitir comparar objetos por nivel de poder
public class PersonajeAnime implements Comparable<PersonajeAnime> {

    // Atributos básicos del personaje
    private int id;
    private String nombre;
    private String universo;   // Ej: "Dragon Ball", "Naruto", etc.
    private double nivelPoder;
    private String habilidad;

    // Setter: permite modificar el nivel de poder después de crear el objeto
    public void setNivelPoder(double nivelPoder) {
        this.nivelPoder = nivelPoder;
    }

    // Constructor con parámetros: inicializa el personaje con sus datos
    public PersonajeAnime(int id, String nombre, String universo, int nivelPoder, String habilidad) {
        this.id = id;
        this.nombre = nombre;
        this.universo = universo;
        this.nivelPoder = nivelPoder;
        this.habilidad = habilidad;
    }

    // Representación en texto del personaje (para mostrar en los JTextArea)
    @Override
    public String toString() {
        return "PersonajeAnime: " +
                "id= " + id +
                ", nombre= " + nombre +
                ", universo= " + universo  +
                ", nivelPoder= " + nivelPoder +
                ", habilidad= " + habilidad;
    }

    // Método de comparación (para la PriorityQueue)
    // Retorna -1 si este personaje tiene más poder (mayor prioridad)
    // Retorna 1 en caso contrario
    @Override
    public int compareTo(PersonajeAnime o) {
        if (this.nivelPoder > o.nivelPoder){
            return -1; // mayor poder => más prioridad
        }
        return 1;
    }
}
