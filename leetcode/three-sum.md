# 3Sum [🔗](https://leetcode.com/problems/3sum/)

## 풀이

" 자세한 내용은 코드에 설명

1. 주어진 배열을 정렬한다. 주어진 수의대하여 값을 카운팅해둔다.
2. 순차적으로 두개의 반복문을 이용해서 나머지 값을 찾아낸다. 이때 사용한 숫자를 카운팅에서 빼준다.
3. 나머지값이 카운팅해둔 값에 존재하는지 확인한다. 
    - 존재하면 저장 , 저장한 값을 저장(배열은 주소이므로 문자열로 바꿔 저장)
4. 2~3번 과정을 반복한다. 이전에 저장해둔 값이 있다면 겹치지 않는지 확인한다.

## 코드

```javascript
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function (nums) {
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

      const rest = parseInt(-(nums[i] + nums[j])) // 타겟 숫자를 찾음
      const tempArr = [nums[i], nums[j], rest]
      // << 중복을 제거하기 위한 조건처리 >>
      // 1. rest가 존재하거나 1이상인 값이 있는지 확인
      // 2. rest가 존재하더라도 큰 수가와서 인덱스가 뒤로탐지하는 것을 방지
      // 3. 정답 배열에 같은 형식이 들어갔는지 확인
      if (numCnts.get(rest) && nums[j] <= rest && !visited.has(tempArr.toString())) { 
        answer.push(tempArr)
        visited.add(tempArr.toString())
      }

      numCnts.set(nums[j], numCnts.get(nums[j]) + 1) // 임시로 사용중인 숫자를 카운팅 (+)
    }
  }
  return answer
}
```

## 문제

![problem](/assets/three-sum.png)
