public class KolejkaDwustronnaGeneryczna <T>{
    private class node<T>{
        private T data;
        private node<T> next;
        private node<T> previous;
    }
    private static int cnt = 0;



    private node<T> head;
    private node<T> last;
    public KolejkaDwustronnaGeneryczna(){
        head = null;
        last = null;
    }
    public boolean isEmpty(){
        if (head == null){
            return true;
        }
        return false;
    }
    public int size(){
        node<T> p = new node<>();
        int counter =0;
        while (p.next != null){
            p = p.next;
            counter++;
        }
        return counter;
    }
    public void pushFront(T data){
        node<T> p= new node<>();
        p.data = data;
        p.next = head;
        head = p;
        cnt++;
        if (cnt == 1){
            last = head;
        }
    }
    public void pushLast(T data){
        node<T> p = new node<>();
        p.data = data;
        p.previous = last;
        last = p;
    }
    public void popFirst(){
        head = head.next;
    }
    public void popLast(){
        last = last.previous;
    }


    @Override
    public String toString() {
        String str = "";
        node<T> p= head;
        while (p.next!= null){
            String var = ""+p.data;
            str = str + var + " ";
            p = p.next;
        }
        return str;
    }
}
