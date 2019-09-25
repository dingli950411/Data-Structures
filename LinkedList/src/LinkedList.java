public class LinkedList<E> {

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

    private Node dummyhead;//索引为0的前面一个节点
    private int size;

    public LinkedList() {
        dummyhead = new Node(null, null);
        size = 0;
    }

    //获取链表中的元素个数
    public int getSize() {
        return size;
    }

    //返回链表中是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 在链表的index（0-based）位置添加新的元素
    // 在链表中不是一个常用的操作，练习用
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed,Illegal index");
        }
        Node prev = dummyhead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//        Node node = new Node(e);
//        node.next = prev.next;
//        prev.next = node;

        prev.next = new Node(e, prev.next);
        size++;
    }

    // 在链表头里添加新的元素
    public void addFirst(E e) {
//        head = new Node(e,head);
//        size++;
        add(0, e);
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }

    // 获得链表的第index（0-based）个位置的元素
    // 在链表中不是一个常用的操作，练习用
    public E get(int index){

        if(index<0||index>size){
            throw new IllegalArgumentException("Get failed.Illegal index.");
        }

        Node cur = dummyhead.next;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }

        return cur.e;

    }

    // 获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast(){
        return get(size);
    }


    // 修改链表的第index（0-based）个位置的元素为e
    // 在链表中不是一个常用的操作
    public void set(int index,E e){

        if(index<0||index>size){
            throw new IllegalArgumentException("Set failed.Illegal index.");
        }

        Node cur = dummyhead.next;
        for(int i=0;i<index;i++){
            cur = cur.next;
        }
        cur.e = e;

    }

    // 查找链表中是否有元素
    public boolean contains(E e){
        Node cur = dummyhead.next;
        while(cur.next!=null){
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    // 从链表中删除你index（0-based）位置的元素，返回删除的元素
    // 在链表中不是一个常用的操作，练习用
    public E remove(int index){
        if(index<0||index>size){
            throw new IllegalArgumentException("Delete failed.Illegal index.");
        }

        Node prev = dummyhead;
        for(int i=0;i<index;i++){
            prev = prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    // 从链表中删除第一个元素，返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从链表中删除最后一个元素，返回删除的元素
    public E removeLast(){
        return remove(size-1);
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        Node cur = dummyhead.next;

        while (cur!=null){
            str.append(cur.e+"->");
            cur = cur.next;
        }

//        for(Node cur = dummyhead.next;cur.next!=null;cur=cur.next){
//            str.append(cur.e+"->");
//        }
        str.append("NULL");
        return str.toString();

    }



}
