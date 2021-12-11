# Container With Most Water [🔗](https://leetcode.com/problems/container-with-most-water/)

## 풀이

1. 왼쪽 인덱스와 오른쪽 인덱스를 이용해서 두 값중 작은 높이를 가지고있는 값을 높이로 잡는다
2. 물을 채운 너비의 최고값을 저장한다.
3. 작은 사이즈의 높이를 가지고있는 인덱스를 이동한다. 1~2번 행동을 반복한다.

## 코드

```javascript
/**
 * @param {number[]} heights
 * @return {number}
 */
var maxArea = function(heights) {
  let max = 0, left = 0, right = heights.length-1

  while (left < right) {
    const h = Math.min(heights[left], heights[right])
    const w = right - left

    heights[left] < heights[right] ? left++ : right--
    max = Math.max(max, h * w)
  }

  return max
}
```

## 문제

Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.

### Example 1

![problem](/assets/container-with-most-water.jpg)

```
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
```

### Example 2

```
Input: height = [1,1]
Output: 1
```

### Example 3

```
Input: height = [4,3,2,1,4]
Output: 16
```

### Example 4

```
Input: height = [1,2,1]
Output: 2
```

### Constraints

- n == height.length
- 2 <= n <= 105
- 0 <= height[i] <= 104
