# Merge k Sorted Lists [🔗](https://leetcode.com/problems/merge-k-sorted-lists/)

## 풀이

[Merge Two Sorted Lists](https://github.com/253eosam/Algorithm/blob/master/leetcode/merge-two-sorted-lists.md) 문제와 풀이방법은 같음

1. 모든 노드가 값을 잃을때까지 반복문을 실행
2. 가장 작은 값을 가진 노드를 찾음.
3. 해당 노드를 이동하고 가지고있던 값을 이용해 새로운 노드를 생성하고 `head`에 이어붙임.

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
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
var mergeKLists = function(lists) {
    const head = new ListNode()
    let rear = head
    
    const getNodeVal = (lists, idx) => {
        const { val, next } = lists[idx]
        lists[idx] = next
        return val
    }
    
    while(lists.some(node => node)) {
        const minVal = lists.reduce((acc,cur) => (acc?.val ?? Number.MAX_SAFE_INTEGER) < (cur?.val ?? Number.MAX_SAFE_INTEGER) ? acc : cur).val
        const minValNodeIdx = lists.findIndex(node => node && node.val === minVal)
        const newNode = new ListNode(getNodeVal(lists, minValNodeIdx))
        if (!head.next) head.next = newNode
        else rear.next = newNode
        
        rear = rear.next
    }
    
    return head.next
};
```

## 문제

![problem](/assets/merge-k-sorted-lists.png)