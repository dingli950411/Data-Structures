public class LinkedListQueue<E> implements Queue<E> {


    private class Node {

        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head,tail;
    private int size;

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public void enqueue(E e){
        if(tail==null){
            tail = new Node(e);
            head = tail;
        }else{
            tail.next = new Node(e);
            tail = tail.next;
        }

        size++;
    }

    @Override
    public E dequeue(){
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        Node ret = head;
        head = head.next;
        ret.next=null;
        if(head==null){
            tail = head;
        }
        size--;
        return ret.e;
    }

    @Override
    public E getFront(){
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is empty");
        }
        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder("LinkedListQueue: front ");

        for(Node n = head;n!=null;n=n.next){
           res.append(n.e).append("->");
        }
        res.append("NULL tail");
        return res.toString();
    }
    public static void main(String[] args) {
        LinkedListQueue<Integer> arrayQueue = new LinkedListQueue<>();
        for(int i=0;i<10;i++){
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
            if(i%3==2){
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }
        }
    }


}
