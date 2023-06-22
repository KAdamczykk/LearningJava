import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Kueue {

    public static Queue wypelnij(Queue<Command> queue, Command[] commands){
        Collections.addAll(queue, commands);
        return queue;
    }

}


