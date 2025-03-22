# ✅ Max Counters 문제 해결 (Codility)

## 📌 문제 설명

정수 `N`과 배열 `A`가 주어졌을 때, 길이 `N`의 배열 `answer`를 생성하고, `A`의 요소에 따라 연산을 수행하는 문제입니다.

### **🔹 연산 종류**

1. `A[k] = X` (1 ≤ X ≤ N) → `answer[X-1]` 값을 1 증가시킴.
2. `A[k] = N + 1` → 모든 요소를 현재 최대값 `maxNum`으로 설정.

### **🔹 입력**

- `N`: 정수 (배열 크기)
- `A`: 연산을 나타내는 정수 배열

### **🔹 출력**

- `N` 길이의 배열 `answer`

---

## **📍 예제 분석**

```typescript
N = 5
A = [3, 4, 4, 6, 1, 4, 4]
```

| 연산                     | 배열 상태         |
| ------------------------ | ----------------- |
| `A[0] = 3`               | `[0, 0, 1, 0, 0]` |
| `A[1] = 4`               | `[0, 0, 1, 1, 0]` |
| `A[2] = 4`               | `[0, 0, 1, 2, 0]` |
| `A[3] = 6` (max counter) | `[2, 2, 2, 2, 2]` |
| `A[4] = 1`               | `[3, 2, 2, 2, 2]` |
| `A[5] = 4`               | `[3, 2, 2, 3, 2]` |
| `A[6] = 4`               | `[3, 2, 2, 4, 2]` |

👉 **최종 결과:** `[3, 2, 2, 4, 2]`

---

## **🚨 이전 코드 (비효율적인 O(N \* M))**

```typescript
function solution(N: number, A: number[]): number[] {
  let answer = Array(N).fill(0)
  let maxNum = 0

  for (let element of A) {
    if (element === N + 1) answer = Array(N).fill(maxNum) // O(N) 재할당 문제 발생 🚨
    else {
      maxNum = Math.max(maxNum, ++answer[element - 1])
    }
  }
  return answer
}
```

### ❌ **문제점**

1. `A[k] = N + 1`이 등장할 때마다 `answer = Array(N).fill(maxNum)`을 실행하여 **O(N) 연산**이 발생 → **비효율적!**
2. `O(N * M)`의 비효율적인 시간 복잡도 → 큰 `N, M`에서는 성능 문제 발생.

---

## **🚀 개선된 코드 (O(N + M))**

```typescript
function solution(N: number, A: number[]): number[] {
  let answer = Array(N).fill(0)
  let maxNum = 0 // 현재 최대 값
  let lastMaxUpdate = 0 // N+1 연산 이후 모든 요소가 가져야 할 최소값

  for (let element of A) {
    if (element === N + 1) {
      lastMaxUpdate = maxNum // N+1 연산이 나왔을 때 갱신
    } else {
      if (answer[element - 1] < lastMaxUpdate) {
        answer[element - 1] = lastMaxUpdate // 이전 max 업데이트 적용
      }
      answer[element - 1] += 1
      maxNum = Math.max(maxNum, answer[element - 1])
    }
  }

  // 마지막으로 업데이트 안 된 값들을 일괄 업데이트
  for (let i = 0; i < N; i++) {
    if (answer[i] < lastMaxUpdate) {
      answer[i] = lastMaxUpdate
    }
  }

  return answer
}
```

---

## **💡 개선 이유**

### ❌ **이전 코드 문제점**

1. **배열 전체를 매번 재할당하여 O(N \* M) 발생** 🚨
2. **불필요한 O(N) 초기화로 성능 저하**

### ✅ **개선된 코드 장점**

1. **O(N + M) 복잡도로 최적화** 🚀
2. **배열을 매번 초기화하지 않고, `lastMaxUpdate` 변수를 활용해 필요한 순간에만 업데이트**
3. **불필요한 연산을 제거하여 실행 속도 개선**

---

## **🛠 예제 테스트**

```typescript
console.log(solution(5, [3, 4, 4, 6, 1, 4, 4])) // 출력: [3, 2, 2, 4, 2]
console.log(solution(3, [1, 1, 2, 2, 3, 3, 3])) // 출력: [2, 2, 3]
console.log(solution(5, [6, 6, 6, 6])) // 출력: [0, 0, 0, 0, 0]
```

---

## **📌 결론**

✅ **최적화된 O(N + M) 풀이로 Codility 100% 통과 가능!** 🚀
✅ **Lazy propagation 기법을 사용해 불필요한 연산을 제거!** 🎯
✅ **배열 전체 초기화를 최소화하여 실행 속도 개선!** 🔥
