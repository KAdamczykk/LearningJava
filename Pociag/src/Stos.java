import java.util.LinkedList;

public class Stos <T>{
    private LinkedList<T> stos = new LinkedList<>();
    public Stos(){}
    public boolean isEmpty(){
        if (stos.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
    public void push(T data){
        stos.addFirst(data);
    }
    public void pop(){
        stos.removeFirst();
    }
    public int size(){
       return stos.size();
    }
}
