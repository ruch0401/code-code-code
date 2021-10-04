public class Problem013 {
    ListNode head = null;

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public void add(int node) {
        ListNode newNode = new ListNode(node);
        newNode.next = head;
        head = newNode;
    }

    public static void main(String[] args) {
        Problem013 p = new Problem013();
        p.add(4);
        p.add(7);
        p.add(3);
        p.add(8);

//        p.add(1);
//        p.add(4);
//        p.add(3);

        printLinkedList(p.head);
        System.out.println();
        ListNode nh = p.sortList(p.head);
        printLinkedList(nh);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode middle = getMiddle(head);
        ListNode nextOfMiddle = middle.next;
        middle.next = null;

        ListNode a = sortList(head);
        ListNode b = sortList(nextOfMiddle);
        return merge(a, b);
    }

    public ListNode getMiddle(ListNode head) {
        if (head == null)
            return null;

        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode a, ListNode b) {
        ListNode ans = new ListNode(-1);
        ListNode anshead = ans;

        while (a != null && b != null) {
            if (a.val < b.val) {
                ans.next = new ListNode(a.val);
                ans = ans.next;
                a = a.next;
            } else {
                ans.next = new ListNode(b.val);
                ans = ans.next;
                b = b.next;
            }
        }

        if (a != null) {
            ans.next = a;
            a = a.next;
        }

        if (b != null) {
            ans.next = b;
        }

        return anshead.next;
    }

    private static void printLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "\t");
            temp = temp.next;
        }
    }
}