public class Solution {

    public static void main(String[] args) {

    }

    public ListNode reverseBetween(ListNode A, int m, int n) {
        ListNode FakeHead = new ListNode(0);
        FakeHead.next = A;

        ListNode prevStart =FakeHead;
        ListNode start = A;
        ListNode curr = A;
        ListNode prev = null;
        ListNode nxt = A.next;

        int t = m-1;
        int range = n-m+1;

        while(t>0)
        {
            prevStart = prevStart.next;
            t--;
        }

        start = prevStart.next;
        // System.out.println(start.val);
        curr = start;
        prev=null;
        nxt = curr.next;
        //  System.out.println(range);

        while(curr!=null && range>0)
        {
            curr.next = prev;
            prev = curr;
            curr=nxt;
            range--;

            if(range!=0)
            {
                nxt = nxt.next;
            }

        }

        prevStart.next = prev;
        start.next = nxt;

        return FakeHead.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = curr.next;
        while(next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        return curr;
    }

    class ListNode {
      public int val;
      public ListNode next;
     ListNode(int x) { val = x; next = null; }
  }
}
