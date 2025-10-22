import java.util.LinkedList;
import java.util.Queue;

public class ColaAutos {
    private Queue<Auto> cola;

    public ColaAutos(){
        cola = new LinkedList<Auto>();
    }

    public void encolar(Auto auto){
        cola.add(auto);
    }

    public Auto desencolar() throws Exception {
        if(cola.isEmpty())
            throw new Exception("No hay mas autos");
        return  cola.poll();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Auto auto:cola){ //For mejorado coleccion = cola, objeto que esta guardando la coleccion: Auto y variable = auto
            sb.append(auto.toString());
        }
        return sb.toString();
    }
}
