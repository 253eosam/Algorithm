# TapeEquilibrium 문제 해결 (Codility)

## 문제 설명

배열 `A`가 주어졌을 때, 배열을 두 부분으로 나눈 후 두 부분의 합의 차이(절대값)를 최소화하는 문제입니다.

### 예제

```typescript
A = [3, 1, 2, 4, 3]
결과: 1
```

## 해결 접근 방식

이 문제는 **Prefix Sum (누적 합)** 을 활용하여 O(N) 시간 복잡도로 해결할 수 있습니다.

1. **배열의 전체 합(totalSum) 구하기**

   - 배열의 모든 요소를 합산하여 `totalSum`을 구합니다.

2. **왼쪽 부분 합(leftSum)과 최소 차이 계산**

   - 배열을 한 요소씩 순회하며 `leftSum`을 증가시킵니다.
   - 오른쪽 부분 합은 `rightSum = totalSum - leftSum`으로 계산할 수 있습니다.
   - 두 부분의 차이 `|leftSum - rightSum|` 을 구하여 최소값을 갱신합니다.

3. **최소 차이 반환**
   - 최소 차이를 저장하면서 반복문을 돌리고, 최종적으로 최소 차이를 반환합니다.

## 코드 구현

```typescript
function solution(A: number[]): number {
  let totalSum = A.reduce((acc, num) => acc + num, 0)
  let leftSum = 0
  let minDiff = Infinity

  for (let i = 0; i < A.length - 1; i++) {
    leftSum += A[i] // 왼쪽 부분합 증가
    let rightSum = totalSum - leftSum // 오른쪽 부분합 계산
    let diff = Math.abs(leftSum - rightSum) // 차이 계산
    minDiff = Math.min(minDiff, diff) // 최소 차이 갱신
  }

  return minDiff
}
```

## 시간 복잡도 분석

- `totalSum`을 구하는데 **O(N)**
- `for` 루프에서 **O(N)**  
  **→ 총 O(N)으로 최적의 해결책** 🚀

## 예제 테스트

```typescript
console.log(solution([3, 1, 2, 4, 3])) // 출력: 1
console.log(solution([-10, 10])) // 출력: 20
console.log(solution([1, 2, 3, 4, 5])) // 출력: 3
```

## 결론

- 이 방법을 사용하면 **효율적으로 최소 차이를 구할 수 있습니다.** 🎯
- `O(N)`으로 최적화된 접근 방식으로 **Codility 테스트를 통과할 수 있습니다.** ✅
