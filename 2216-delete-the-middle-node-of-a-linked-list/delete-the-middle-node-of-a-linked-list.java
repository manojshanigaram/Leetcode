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
    public ListNode deleteMiddle(ListNode head) {
        ListNode n=head;
        ListNode n1=head;
        ListNode n2=head;
        
        
        int x=0;
        while(n.next!=null){
            x++;
            n=n.next;
        }
        if(x==0 && n.next==null){
            head=null;
            return head;
        }
        if(x%2==0){
            x=x/2;
        }else{
            x=(x/2)+1;
        }
        int y=0;
        while(y!=x){
            n2=n1;
            n1=n1.next;
            y++;
        }
        n2.next=n1.next;
        return head;
    }
}