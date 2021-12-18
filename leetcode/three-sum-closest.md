# 3Sum Closest [🔗](https://leetcode.com/problems/3sum-closest/)

## 풀이

0. 정렬을하여 인덱스를 순차적으로 접근했을때 오름차순이 나오도록 유도한다.
1. 반복문을 이용해서 인덱스를 접근한다.
2. 모두 더한 값을 타겟숫자에서 빼서 남은 숫자의 절대값으로 타겟과의 거리를 알아낸다.
3. 거리를 비교하며 작은 값을 저장한다. 

> 모든 인덱스를 비교하는것은 비효율적이므로 타겟에서 점점 멀어지는 부분을 조건처리 <br>
-2, -1 < Target < +1, +2 ... (플러스 부분을 조건처리하여 동작하지않게함.)

## 코드

```javascript
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function (nums, target) {
  let closetValue = Number.MAX_SAFE_INTEGER
  let answer = 0

  nums.sort((a,b) => a-b)

  for(let i = 0 ; i < nums.length; i++) {
    for(let j = i+1 ; j < nums.length ; j++) {
      for(let k = j+1 ; k < nums.length ; k++) {
        const threeSum = (nums[i] + nums[j] + nums[k])
        const rest = target - threeSum

        if (rest === 0) return target
        else if (Math.abs(rest) < closetValue) {
          closetValue = Math.abs(rest)
          answer = threeSum
        }

        if (rest < 0 && closetValue < Math.abs(rest)) break
      }
    }
  }

  return answer
}
```

## 문제

![problem](/assets/three-sum-closest.png)