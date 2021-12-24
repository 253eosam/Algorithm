# Swap Nodes in Pairs [🔗](https://leetcode.com/problems/swap-nodes-in-pairs/)

## 풀이

1. 빈 노드를 만들고 head를 가르키도록한다.
2. 첫번째와 두번째 노드를 swap하기 위해서는 첫번째와 두번째, 세번째 노드를 저장해두고 첫번째가 세번째를 가르키고 두번째가 첫번째를 가르키게 만든다. 마지막으로 이전 노드가 첫번째가 아닌 두번째를 가르키도록한다.

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
 * @return {ListNode}
 */
var swapPairs = function(head) {
    
    const preHead = new ListNode(0,head)
    let rear = preHead
    
    while(rear.next?.next) {
        
        const third = rear.next.next.next
        const second = rear.next.next
        const first = rear.next
        
        first.next = third
        second.next = first
        rear.next = second
        
        rear = rear.next.next
    }
    
    
    return preHead.next
};
```

## 문제

![problem](/assets/swap-nodes-in-pairs.png)