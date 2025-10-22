import java.util.Stack;

public class Pila {
    Stack<Character>pila;

    public Pila() {
        pila=new Stack<Character>();
    }

    public boolean esVacia(){
        return pila.isEmpty();
    }

    public void push(Character c){
        pila.push(c);
    }

    public Character pop() throws Exception{
        if(esVacia())
        throw new Exception("Codigo no Balanceado");
        return pila.pop();
    }
    public boolean balanceado(String codigo){
        Pila p1=new Pila();

        for(int i=0; i<codigo.length(); i++){
            if(codigo.charAt(i)==')') {
                p1.push(codigo.charAt(i));
            } else {
                if(codigo.charAt(i)==')'){
                    return false;
                }
            }

        }
        if (p1.esVacia()){
            return true;
        }
        return false;
    }
}
