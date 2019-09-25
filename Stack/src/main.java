import java.util.Random;

public class main {

    private static  double testQueue(Queue<Integer> queue,int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for(int i=0;i<opCount;i++){
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i=0;i<opCount;i++){
            queue.dequeue();
        }

        long endTime = System.nanoTime();

        return (endTime-startTime)/1000000000.0;
    }

    // 测试使用stack运行OpCount个push和pop操作所需要的时间，单位秒
    private static  double testStack(Stack<Integer> stack,int opCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for(int i=0;i<opCount;i++){
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for(int i=0;i<opCount;i++){
            stack.pop();
        }

        long endTime = System.nanoTime();

        return (endTime-startTime)/1000000000.0;
    }

    public static void main(String[] args) {
//        LinkedListStack<Integer> stack = new LinkedListStack<>();
//
//        for(int i=0;i<5;i++){
//            stack.push(i);
//            System.out.println(stack);
//        }
//        System.out.println(stack);
//
//        stack.pop();
//        System.out.println(stack);
        int optime = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        System.out.println("ArrayQueue, time is :"+testQueue(arrayQueue,optime)+"s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        System.out.println("LoopQueue,time is :"+testQueue(loopQueue,optime)+"s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        System.out.println("linkedListQueue,time is :"+testQueue(linkedListQueue,optime)+"s");

//        int optime = 10000000;
//        ArrayStack<Integer> arrayQueue = new ArrayStack<>();
//        System.out.println("ArrayStack,time is :"+testStack(arrayQueue,optime)+"s");
//
//        LinkedListStack<Integer> loopQueue = new LinkedListStack<>();
//        System.out.println("LinkedList,time is :"+testStack(loopQueue,optime)+"s");


    }
}
