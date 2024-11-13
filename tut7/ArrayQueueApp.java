package DSA.tut7;

public class ArrayQueueApp {
    public static void main(String[] args) {
        // Create a queue with a maximum size of 5
        ArrayQueue queue = new ArrayQueue(5);

        // Enqueue items to the queue and print after each enqueue
        System.out.println("Enqueue items to the queue:");
        queue.enqueue(1);
        printQueue(queue);
        queue.enqueue(2);
        printQueue(queue);
        queue.enqueue(3);
        printQueue(queue);

        // Dequeue and print items from the queue
        System.out.println("Dequeue and print items from the queue:");
        while (!queue.isEmpty()) {
            int dequeuedItem = queue.dequeue();
            System.out.println("Dequeued item: " + dequeuedItem);
            // Print the queue after dequeue operation
            printQueue(queue);
        }
    }

    public static void printQueue(ArrayQueue queue) {
        System.out.print("Queue: ");
        for (int i = queue.front; i <= queue.rear - 1; i++) {
            System.out.print(queue.array[i] + " ");
        }
        System.out.println();
    }
}
