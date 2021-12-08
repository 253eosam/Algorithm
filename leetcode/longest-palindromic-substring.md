# Longest Palindromic Substring

## 풀이

1. palindromic 함수를 만든다.
2. 문자열을 처음부터 시작한다.
3. 마지막 문자 값을 비교하며 팰린드롬인지 확인한다.
4. 맞다면 그 길이를 저장하고 아니라면 3번과정을 반복한다.
5. 마지막 문자에서 처음 시작문자까지 도착하면 처음에서 다음 문자로 이동하고 3~4번 과정을 반복한다.

- 팰린드롬인지 파악하기전에 이전에 팰린드롬인적이 있다면 길이를 가지고있다가 비교할 문자열 길이를 비교하여 조건처리를한다. <br/> 속도를 올릴 수 있다.


## 코드

```js
/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function (s) {
  let maxLenStr = ''

  for (let i = 0; i < s.length; i++) {
    if (maxLenStr.length > s.length - i) break

    let j = s.lastIndexOf(s[i])
    let temp = s.substring(i, j + 1)

    while (i < j) {
      if (maxLenStr.length < temp.length && isPalindromic(temp)) {
        maxLenStr = temp
        break
      }
      j = s.lastIndexOf(s[i], j - 1)
      temp = s.substring(i, j + 1)
    }
  }

  return maxLenStr || s[0]
}

const isPalindromic = str => {
  let [start, end] = [0, str.length - 1]

  while (start < end) {
    if (str[start++] !== str[end--]) return false
  }

  return true
}
```

## 문제

Given a string s, return the longest palindromic substring in s.

### Example 1:

```
Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
```

### Example 2:

```
Input: s = "cbbd"
Output: "bb"
```

### Example 3:

```
Input: s = "a"
Output: "a"
```

### Example 4:

```
Input: s = "ac"
Output: "a"
```

### Constraints:

- 1 <= s.length <= 1000
- s consist of only digits and English letters.
