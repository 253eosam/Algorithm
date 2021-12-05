# Longest Substring Without Repeating Characters.

## 풀이

**슬라이딩 윈도우** 방법을 사용함.<br>
시작과 끝 인덱스를 이동하며 중복이 없는 문자열을 확인하고 길이를 저장한다.

1. 마지막 인덱스를 늘린다.
2. 시작과 끝 인덱스를 이용해서 문자열을 추출화여 반복되는 문자열이 있는지 검사한다.
3. 반복이 없다면 길이를 비교하여 저장한다.
4. 2번 작업을 진행한다. 문자열에 반복이 있다면 시작 인덱스를 늘린다.

## 코드

```js
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    let [start, end] = [0,0]
    let maxLen = 0
    
    while(end <= s.length) {
        
        if (isRepeatChar(s.substring(start, end))) {
            start++
            continue;
        }
        maxLen = Math.max(maxLen , end-start)
        end++
    }
    
    return maxLen
};

const isRepeatChar = (str) => {
    return !!Array.from(str)
                .find((item, idx, arr) => arr.indexOf(item) !== idx)
}
```


## 문제

Given a string s, find the length of the longest substring without repeating characters.


### Example 1:

```
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
```

### Example 2:

```
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
```

### Example 3:

```
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
```

### Constraints:

- The number of nodes in each linked list is in the range [1, 100].
- 0 <= Node.val <= 9
- It is guaranteed that the list represents a number that does not have leading zeros.
