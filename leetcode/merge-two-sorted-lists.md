# Merge Two Sorted Lists [🔗](https://leetcode.com/problems/merge-two-sorted-lists/)

## 풀이

1. list1과 list2 중에서 값이 작은 노드를 head 노드가 가르키게한다.
2. 작은 노드로 선정된 노드는 다음노드를 가르키도록한다.
3. 그렇게 두 list 노드가 `null`을 가르킬때까지 head에 이어붙어나간다.

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
 * @param {ListNode} list1
 * @param {ListNode} list2
 * @return {ListNode}
 */
var mergeTwoLists = function(list1, list2){
    
  const head = new ListNode()
  
  let node = {
      l1 : list1,
      l2 : list2,
      rear: head
  }

  const getValMvNode = (node,keyStr) => {
    const { val, next } = node[keyStr]
    node[keyStr] = next
    return val
  }
  
  while(node.l1 || node.l2) {
    let curNodeVal = null
    if (node.l1 && node.l2) {
      curNodeVal = node.l1.val < node.l2.val ? getValMvNode(node,'l1') : getValMvNode(node,'l2')
    }
    else if (node.l1) curNodeVal = getValMvNode(node,'l1')
    else if (node.l2) curNodeVal = getValMvNode(node,'l2')
      
    // console.log(l1, l2)
    
    node.rear.next = new ListNode(curNodeVal)
    node.rear = node.rear.next
  }
  
  return head.next
}
```

## 문제

![problem](/assets/merge-two-sorted-lists.png)