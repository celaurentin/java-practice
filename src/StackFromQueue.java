import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a Queue data structure that supports standard operations like enqueue() and dequeue(). The task is to
 * implement a Stack data structure using only instances of Queue and Queue operations allowed on the instances.
 */
public class StackFromQueue {

    Queue<Integer> stack = new LinkedList<>();

    public Integer pop(){
        if (stack.size()!=0) return stack.remove();
        else return -1;
    }

    public Integer peek(){
        return stack.peek();
    }

    public void push(Integer input){
        stack.add(input);
        for (int i=0; i < stack.size()-1; i++){
            stack.add(stack.remove());
        }
    }

}
