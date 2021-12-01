# Add Two Numbers [🔗](https://leetcode.com/problems/add-two-numbers/)

## 풀이

Linked list를 사용하여 데이터를 저장하는 문제.

- 숫자의 범위가 매우 길어 BigInt를 사용하여 수를 계산
- 10으로 나눈 나머지값을 노드 데이터(ListNode)로 만들고 head 노드에 연결함. 

1. 파라메타로 내려온 노드를 숫자로 바꾸는 작업.
2. 숫자로 바꾼 두 값을 더함
3. 합한 값에서 10의 나머지를 head 노드에 연결. 그리고 합한 값을 10씩 나눠주면서 자릿수를 줄임.
4. head 노드에 temp를 이용하여 값을들 이어붙임.
5. head 노드의 역할은 첫번째 데이터를 가르키는 역할

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
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    return toNode(
            toBigNumber(l1) + toBigNumber(l2)
        )

};

const toBigNumber = (node) => {
    let sum = 0n;
    let digit = 1n
    let temp = node
    
    while(temp) {
        sum += BigInt(temp.val) * digit
        temp = temp.next
        digit *= 10n
    }
    
    return sum
}

const toNode = (num) => {
    if (num === 0n) return new ListNode(0)
    
    let head = new ListNode()
    let temp = new ListNode()
    while(num > 0) {
        const last = num % 10n
        temp.next = new ListNode(last)
        if (!head.next) head.next = temp.next
        num /= 10n
        temp = temp.next
    }
    
    return head.next
}
```

## 문제

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.


### Example 1:

![exam](/assets/linked-list.png)

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

### Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]

### Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

### Constraints:

- The number of nodes in each linked list is in the range [1, 100].
- 0 <= Node.val <= 9
- It is guaranteed that the list represents a number that does not have leading zeros.

