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
    public ListNode rev(ListNode head){
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode f=temp.next;
            temp.next=prev;
            prev=temp;
            temp=f;
        }
        return prev;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev=null;
        ListNode res=head;
        ListNode i=head;
        ListNode j=head;
        int count=0;
        while(i!=null){
            prev=i;
            i=i.next;
            count++;
        }
        if(n==count){
            return head.next;
        }
        int presentcount=0;
        while(j!=null){
            if((count-n-1)==presentcount && (j.next!=null) ){
                     System.out.println(j.val);
                     j.next=j.next.next;
                     break;
            }else{
                presentcount++;
                j=j.next;
            }
        }
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }

        return res;

    
    }
}