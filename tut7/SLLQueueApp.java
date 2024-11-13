package DSA.tut7;

public class SLLQueueApp {
    public static void main(String[] args) {
        SLLQueue queue = new SLLQueue();

        // Enqueue items to the queue
        queue.enqueue(5);
        queue.enqueue(3);
        queue.enqueue(8);

        // Print the original queue
        System.out.println("Original Queue:");
        printQueue(queue);
        System.out.println();

        // Find and print the maximum and minimum numbers in the queue
        System.out.println("Maximum number in the queue: " + findMax(queue));
        System.out.println("Minimum number in the queue: " + findMin(queue));
    }

    // Utility method to print all items of the queue
    public static void printQueue(SLLQueue q) {
        SLLQueue tempQueue = new SLLQueue();

        System.out.println("Printing items of the queue:");
        while (!q.isEmpty()) {
            QueueNode node = q.dequeue();
            System.out.println(node.getData());
            tempQueue.enqueue(node.getData());
        }

        // Restore the original queue
        while (!tempQueue.isEmpty()) {
            q.enqueue(tempQueue.dequeue().getData());
        }
    }

    // Utility method to find the maximum number in the queue
    public static int findMax(SLLQueue q) {
        int max = Integer.MIN_VALUE;
        SLLQueue tempQueue = new SLLQueue();

        while (!q.isEmpty()) {
            QueueNode node = q.dequeue();
            int data = node.getData();
            max = Math.max(max, data);
            tempQueue.enqueue(data);
        }

        // Restore the original queue
        while (!tempQueue.isEmpty()) {
            q.enqueue(tempQueue.dequeue().getData());
        }

        return max;
    }

    // Utility method to find the minimum number in the queue
    public static int findMin(SLLQueue q) {
        int min = Integer.MAX_VALUE;
        SLLQueue tempQueue = new SLLQueue();

        while (!q.isEmpty()) {
            QueueNode node = q.dequeue();
            int data = node.getData();
            min = Math.min(min, data);
            tempQueue.enqueue(data);
        }

        // Restore the original queue
        while (!tempQueue.isEmpty()) {
            q.enqueue(tempQueue.dequeue().getData());
        }

        return min;
    }

    public static void printQueue(SLLQueue src, SLLQueue des) {

    }
}