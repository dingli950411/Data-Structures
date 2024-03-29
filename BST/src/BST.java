import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private int size;
    private Node root;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
//        if (root == null) {
//            root = new Node(e);
//            size++;
//        } else {
//
//        }

        root = add(root,e);

    }

    // 向以node为根的二分搜索树中插入元素E，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, E e) {

        // 第一步写终止条件
//        if (node.equals(e)) {
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//
//        if (e.compareTo(node.e) < 0) {
//            add(node.left, e);
//        } else {
//            add(node.right, e);
//        }

        if(node==null){
            size++;
            return new Node(e);
        }

        if(e.compareTo(node.e)<0){
            node.left = add(node.left,e);
        }else if(e.compareTo(node.e)>0){
            node.right = add(node.right,e);
        }
        return node;

    }

    // 查看二叉树中是否包含元素e
    public boolean contains(E e){
        return  contains(root,e);
    }

    // 查看以node为根的二分搜索树种是否包含元素e，递归算法
    private boolean contains(Node node,E e){

        if(node==null){
            return false;
        }

        if(e.compareTo(node.e)==0){
            return true;
        }else if(e.compareTo(node.e)<0){
            return contains(node.left,e);
        }else/* if(e.compareTo(node.e)>0)*/{
            return contains(node.right,e);
        }
    }

    // 二分搜索树的前序遍历
    public void preOrder(){
        preOrder(root);
    }

    // 前序遍历以node为根的二分搜索树，递归算法
    private void preOrder(Node node){
//        if(node==null){
//            return;
//        }
        if(node!=null) {
            System.out.println(node.e);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 二分搜索树的非递归前序遍历
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){

            Node node = stack.pop();
            System.out.println(node.e);

            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
    }

    // 二分搜索树的中序遍历
    public void inOrder(){
        inOrder(root);
    }

    // 中序遍历以node为根的二分搜索树，递归算法
    private void inOrder(Node node){
        if(node == null){
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 二分搜索树的后序排列
    public void postOrder(){
        postOrder(root);
    }
    // 后序遍历以node为根的二分搜索树，递归算法
    private void postOrder(Node node){

        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);

    }

    // 二分搜索树的层序遍历
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);

            if(cur.left!=null){
                queue.add(cur.left);
            }
            if(cur.right!=null){
                queue.add(cur.right);
            }
        }
    }

    // 寻找二分搜索树的最小元素
    public E minimun(){
        if(size==0){
            throw new IllegalArgumentException("BST is empty");
        }
        return minimun(root).e;
    }

    // 分为以node为根的二分搜索树的最小值所在的节点
    private Node minimun(Node node){
        if(node.left==null){
            return node;
        }

        return minimun(node.left);
    }

    // 寻找二分搜索树的最大元素
    public E maximum(){
        if(size==0){
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    // 分为以node为根的二分搜索树的最大值所在的节点
    private Node maximum(Node node){
        if(node.right==null){
            return node;
        }

        return maximum(node.right);
    }

    // 从二分搜索树中删除最小值所在节点，返回最小值
    public E removeMin(){
        E ret = minimun();
        root = removeMin(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){

        if(node.left==null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除最大值所在节点
    public E removeMax(){
        E res = maximum();
        root = removeMax(root);
        return res;
    }

    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜书树的根
    private Node removeMax(Node node){
        if(node.right==null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    // 二分搜索树中删除元素为e的节点
    public void remove(E e){

    }

    // 删除以node为根的二分搜索树中值为e的节点，递归算法
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node,E e){
        if(node == null){
            return null;
        }

        if(e.compareTo(node.left.e)<0){
            node.left = remove(node.left, e);
            return node;
        }else if(e.compareTo(node.right.e)<0){
            node.right = remove(node.right, e);
            return node;
        }else{ //e.compareTo(node.e)==0

            if(node.left==null){
                Node rightNode = node.right;
                node.right=null;
                size--;
                return rightNode;
            }
            if(node.right==null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            Node successor = minimun(node);
            successor.right = removeMin(node);

            successor.left = node.left;

            node.left = node.right =null;

            return successor;

        }
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }

    private void generateBSTString(Node node,int depth,StringBuilder res){

        if(node == null){
            res.append(generatedepthString(depth)+"null\n");
            return;
        }

        res.append(generatedepthString(depth)+node.e+"\n");
        generateBSTString(node.left,depth+1,res);
        generateBSTString(node.right,depth+1,res);

    }

    private String generatedepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

}
