package dataSstructure;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueClass {
    public static void main(String[] args) {
        Queue q = new PriorityQueue();

        q.add(1);
        q.add(2);
        System.out.println(q.remove());
        System.out.println(q);
    }
}
