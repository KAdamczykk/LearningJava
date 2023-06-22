import java.util.Iterator;
import java.util.Queue;

public class Konsumuj {
    public static void jedzonko(Queue<Command> queue){
        Iterator<Command> i = queue.iterator();
        while (i.hasNext()){
            i.next().Operation();
        }
    }
}
