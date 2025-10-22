import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// Clase que administra la cola de prioridad de Personajes de Anime
public class ColaPersonajeAnime {
    private PriorityQueue<PersonajeAnime> personajes;

    // Constructor: inicializa la cola vacía
    public ColaPersonajeAnime() {
        personajes = new PriorityQueue<PersonajeAnime>();
    }

    // Añadir un personaje a la cola
    public void anadir(PersonajeAnime p){
        personajes.add(p);
    }

    // Quitar un personaje (el de mayor prioridad)
    public PersonajeAnime quitar() throws Exception{
        if (personajes.isEmpty()){
            throw new Exception("La lista de personajes está vacía...");
        }
        return personajes.poll();
    }

    // Listar todos los personajes actuales en la cola (no necesariamente en orden)
    public List<PersonajeAnime> listarPersonajes(){
        return new ArrayList<>(personajes);
    }
}
