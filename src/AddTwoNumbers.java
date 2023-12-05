/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:
    2 -> 4 -> 3
    5 -> 6 -> 4
    -----------
    7 -> 0 -> 8

    Input: l1 = [2, 4, 3],  l2 = [5, 6, 4]
    Output: [7, 0, 8]
    Explanation: 342 + 465 = 807

 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode result = new ListNode();
        ListNode temp = result;
        while (l1 != null || l2 != null || carry != 0) {
            int val1;
            int val2;
            int sum;
            if (l1==null) val1 = 0; else val1 = l1.val;
            if (l2==null) val2 = 0; else val2 = l2.val;
            sum = val1 + val2 + carry;
            if (sum > 9) {
                carry = 1;
                sum = sum%10;
            } else {
                carry = 0;
            }
            temp.val = sum;

            if (l1!=null && l1.next !=null){
                l1 = l1.next;
            }else{
                l1 = null;
            }
            if (l2!=null && l2.next !=null){
                l2 = l2.next;
            }else{
                l2 = null;
            }
            if (l1 !=null || l2 != null || carry!=0){
                temp.next = new ListNode();
                temp = temp.next;
            }
        }
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
    }

}
