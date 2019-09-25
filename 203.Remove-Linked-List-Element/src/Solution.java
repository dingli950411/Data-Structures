public class Solution {

    /**
     * 输入: 1->2->6->3->4->5->6, val = 6
     * 输出: 1->2->3->4->5
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prev = dummyNode;
//        for(ListNode cur = prev.next;cur!=null;cur = cur.next){
//            if(cur.val==val){
//                prev.next = cur.next;
//                cur.next = null;
//            }else{
//                prev = prev;
//            }
//        }

        while (prev.next!=null){
            if(prev.next.val==val){
                prev.next = prev.next.next;
            }else{
                prev=prev.next;
            }
        }

        return dummyNode.next;

    }
}
