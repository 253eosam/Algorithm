# Four Sum [🔗](https://leetcode.com/problems/4sum/)

## 풀이

[3Sum](https://github.com/253eosam/Algorithm/blob/master/leetcode/three-sum.md)문제 풀이와 같음. (반복문 k를 추가함)

## 코드

```javascript
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[][]}
 */
var fourSum = function(nums, target) {
  let answer = [],
    visited = new Set() // 중복 처리를 위해서 key만 가질 수 있는 데이터 타입인 set을 이용
  const numCnts = new Map() // 숫자의 개수를 저장하기 위함. 음수를 처리하기위해 map사용

  // 숫자의 개수를 저장하는 반복 로직 : 기존의 값이 존재하면 +1, 없으면 1로 초기화
  nums.forEach(num => {
    if (numCnts.has(num)) numCnts.set(num, numCnts.get(num) + 1)
    else numCnts.set(num, 1)
  })

  // 정렬을하여 iterator가 접근할때 다음수가 무조건 크거나 같다를 이용함.
  nums.sort((a, b) => a - b)

  for (let i = 0; i < nums.length; i++) {
    numCnts.set(nums[i], numCnts.get(nums[i]) - 1)  // 사용된 숫자를 카운팅

    for (let j = i + 1; j < nums.length; j++) {
      numCnts.set(nums[j], numCnts.get(nums[j]) - 1) // 임시로 사용중인 숫자를 카운팅 (-)

      for(let k = j + 1 ; k < nums.length; k++) {
        numCnts.set(nums[k], numCnts.get(nums[k]) - 1) // 임시로 사용중인 숫자를 카운팅 (-)

        const rest = parseInt(target-(nums[i] + nums[j] + nums[k])) // 타겟 숫자를 찾음
        const tempArr = [nums[i], nums[j], nums[k], rest]
        // 중복을 제거하기 위한 조건처리 : rest가 존재하거나 1이상인 값이 있는지 확인, rest가 존재하더라도 큰 수가와서 인덱스가 뒤로탐지하는 것을 방지, 정답 배열에 같은 형식이 들어갔는지 확인
        if (numCnts.get(rest) && nums[k] <= rest && !visited.has(tempArr.toString())) {
          answer.push(tempArr)
          visited.add(tempArr.toString())
        }

        numCnts.set(nums[k], numCnts.get(nums[k]) + 1) // 임시로 사용중인 숫자를 카운팅 (+)
      }

      numCnts.set(nums[j], numCnts.get(nums[j]) + 1) // 임시로 사용중인 숫자를 카운팅 (+)
    }
  }
  return answer
}
```

## 문제

![problem](/assets/four-sum.png)