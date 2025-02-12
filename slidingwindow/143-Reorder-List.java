/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        Stack<ListNode>st=new Stack<>();
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            st.push(slow);
            fast=fast.next;
            slow=slow.next;
        }
        ListNode head2=head;
        int n=st.size();
        for(int i=0;i<n/2;i++){
            ListNode newnode=st.peek();
            st.pop();
            newnode.next=head2.next;
            head2.next=newnode;
            head2=newnode.next;
        }
        if(head2!=null) head2.next=null;
        
    }
}