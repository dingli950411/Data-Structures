public class Solution3 {

    /**
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val,int depth) {

        String depthString = generateDepthString(depth);

        System.out.print(depthString);
        System.out.println("Call:remove "+val+" in "+head);

       if(head==null){
           System.out.print(depthString);
           System.out.println("return: "+head);
           return null;
       }

       ListNode res = removeElements(head.next,val,depth+1);
        System.out.print(depthString);
        System.out.println("After remove: "+val+" in "+res);

        ListNode ret;
       if(head.val==val){
           ret = res;
       }else {
           head.next = res;
           ret = head;
       }

//        head.next = removeElements(head.next,val,depth+1);

//        if(head.val==val){
//            return head.next;
//        }else {
//            return head;
//        }
//        return head.val==val?head.next:head;
        System.out.print(depthString);
        System.out.println("return: "+ret);
        return ret;
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder(depth+":");
        for(int i=0;i<depth-1;i++){
            res.append("--");
        }
        return res.toString();
    }


    public static void main(String[] args) {
        int[] nums = {1,2,6,3,4,5,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution3()).removeElements(head,6,0);
        System.out.println(res);
    }
}
