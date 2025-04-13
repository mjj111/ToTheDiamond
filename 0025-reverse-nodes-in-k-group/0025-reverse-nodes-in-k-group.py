class Solution:

    def reverseLinkedList(self, head, k):
        new_head, ptr = None, head
        while k:
            next_node = ptr.next

            ptr.next = new_head
            new_head = ptr

            ptr = next_node

            k -= 1
        return new_head

    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        ptr = head
        ktail = None
        new_head = None

        while ptr:
            count = 0
            ptr = head

            while count < k and ptr:
                ptr = ptr.next
                count += 1

            if count == k:
                revHead = self.reverseLinkedList(head, k)

                if not new_head:
                    new_head = revHead

                if ktail:
                    ktail.next = revHead

                ktail = head
                head = ptr

        if ktail:
            ktail.next = head

        return new_head if new_head else head