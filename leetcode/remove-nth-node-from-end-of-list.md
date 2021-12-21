# Remove Nth Node From End of List [🔗](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

## 풀이

1. 재귀함수를 이용해 주어진 ListNode의 깊이를 파악한다.
2. 깊이를 이용해서 제거할 바로 앞까지 이동한다. 
3. 제거하고자 하는 노드를 건너뛰고 제거할 노드가 가르키는 노드를 가르키도록 만든다.

## 코드

```javascript
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
    
    const getSize = node => {
        if (!node) return 0
        return getSize(node.next) +1
    }
    
    let nodeSize = getSize(head)

    
    let header = new ListNode(), temp = null
    header.next = head
    temp = header
    
    while(temp?.next) {
        if (nodeSize-- === n) {
            temp.next = temp.next.next
        }
        
        temp = temp.next
    }

    return header.next
};

```

## 문제

![problem](/assets/remove-nth-node-from-end-of-list.png)