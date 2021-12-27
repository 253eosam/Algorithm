# Reverse Nodes in k-Group [🔗](https://leetcode.com/problems/reverse-nodes-in-k-group/)

## 풀이

1. 첫번째 노드를 가르키는 빈 preHead 노드를 생성한다 (head를 가르킴).
2. 첫번째 노드부터 k개의 노드를 reverse하기 위해서 노드를 이동하면서 각 노드를 배열에 보관해둔다. 
    - 이때 마지막노드가 가르키는 노드를 기억한다.
3. 배열을 뒤집은다음 각 노드의 가르키는 방향을 반대 방향으로 바꿔준다.
4. 시작 노드가 방향이 바뀐 노드를 가르키게 만들고, 뒤집힌 마지막노드가 이전에 저장해둔 원래 마지막노드가 가르키는 노드를 가르키도록한다.
5. 뒤집는데 k만큼 배열에 넣을 수 없다면 실행을 중지한다.

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
 * @param {number} k
 * @return {ListNode}
 */
var reverseKGroup = function(head, k) {
    
    const preHead = new ListNode(0,head)
    let rear = preHead
    
    const reverseNode = (node) => {
        let mvNode = node
        let start = new ListNode()
        let end = null
        let pointer = start
        let arr = []
        
        for(let i = 0 ; i < k ; i++) {
            if (!mvNode) return node
            if (i === k-1) end = mvNode.next
            arr.push({...mvNode})
            mvNode = mvNode.next
        }
        
        arr.reverse().forEach(item => {
            if(!start.next) start.next = item
            pointer.next = item
            pointer = pointer.next
        })
        
        pointer.next = end
        
        return start.next
    }
    
    while(rear) {
        
        const temp = reverseNode(rear.next)
        // console.log(temp)
        if (!preHead.next) preHead.next = temp
        rear.next = temp
        for(let i = 0 ; i < k ; i++) {
            if (!rear) break
            rear = rear.next
        }
    }
    
    return preHead.next
};
```

## 문제

![problem](/assets/reverse-nodes-in-k-group.png)