
public class Array<E> {

    private int size;
    private E[] data;

    //初始化数组，传入一个容量参数capacity
    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    //无参构造方法，默认数组的容量capacity=10
    public Array(){
        this(10);
    }

    //获取数组中元素的个数
    public int getSize(){
        return size;
    }

    //获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    // 返回数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //向所有元素后添加一个新元素 O(1)
    public void addLast(E e){

        /*if(size == data.length){
            throw new IllegalArgumentException("AddLast failed,Array is full.");
        }

        data[size] = e;
        size++;*/
        add(size,e);
    }

    //向所有元素前添加一个元素 O(n)
    public void addFirst(E e){
        add(0,e);
    }

    //向指定位置添加元素，在第index个位置插入一个元素e O(n/2)=O(n)
    public void add(int index,E e){


        if(index<0||index >size){
            throw new IllegalArgumentException("AddLast failed,Require index >= 0 or index <= size.");
        }

        if(size == data.length){
            resize(2*data.length);
        }
        for(int i = size-1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 获取index索引位置的元素
    E get(int index){
        if(index <0||index >=size){
            throw new IllegalArgumentException("Get failed.Index is illegal");
        }
        return data[index];
    }

    void set(int index,E e){
        if(index <0||index >=size){
            throw new IllegalArgumentException("Set failed.Index is illegal");
        }
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(E e){
        for(int i=0;i<data.length;i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e){
        for(int i=0;i<data.length;i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    // 从数组中删除index位置的元素，返回删除的元素
    public E remove(int index){
        if(index <0||index >=size){
            throw new IllegalArgumentException("Remove failed.Index is illegal");
        }
        E res = data[index];
        for(int i=index+1;i<size;i++){
            data[i-1]=data[i];
        }
        size--;
        data[size]=null; //loitering objects != memory leak

        /*if(size==data.length/2){
            resize(data.length/2);
        }*/
        if(size==data.length/4 && data.length/2 !=0){ //防止复杂度震荡
            resize(data.length/2);
        }
        return res;
    }

    // 从数组中删除第一个元素，返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从数组中删除最后一个元素，返回删除的元素
    public E removeLast(){
        return remove(size-1);
    }

    // 从数组删除元素e
    public void removeElement(E e){
        int index=find(e);
        if(index!=-1){
            remove(index);
        }
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d，capacity = %d\n",size,data.length));
        res.append("[");
        for(int i=0;i<size;i++){
            res.append(data[i]);
            if( i!=size-1){
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

    // 动态扩展 O(n)
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for(int i=0;i<size;i++){
            newData[i]=data[i];
        }
        data = newData;


    }
}
