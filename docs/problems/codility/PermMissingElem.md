# 🧩 PermMissingElem 문제 해결

## 문제 설명

길이가 `N`인 배열 `A`에는 `1`부터 `N+1`까지의 정수 중 **하나의 숫자만 빠져 있습니다.**  
이 누락된 숫자를 찾아 반환하는 문제입니다.

---

## 문제 조건

- 배열 `A`의 크기는 `N` (즉, `N`개의 숫자가 포함됨)
- 배열에는 `1`부터 `N+1`까지의 숫자가 하나씩 포함되어 있어야 하지만, **단 하나의 숫자가 누락됨**
- **누락된 숫자를 찾아 반환해야 함**

---

## 예제

| 입력 (`A`)     | 기대 출력 (`결과`) |
| -------------- | ------------------ |
| `[2, 3, 1, 5]` | `4`                |
| `[1]`          | `2`                |
| `[]`           | `1`                |
| `[2, 3, 4, 5]` | `1`                |
| `[1, 2, 3, 4]` | `5`                |

#### 예제 설명 (첫 번째 케이스)

- 원래 있어야 할 숫자: `[1, 2, 3, 4, 5]`
- 실제 배열: `[2, 3, 1, 5]`
- **누락된 숫자: `4`**

---

## 해결 방법

1. **`1부터 N+1까지의 합`을 구함**

   - 원래 배열에 있어야 할 모든 숫자의 합을 계산 (`totalSum`)
   - 공식:  
     \[
     \text{totalSum} = \frac{(N+1) \times (N+2)}{2}
     \]

2. **현재 배열의 합(`actualSum`)을 구함**

   - 배열 `A` 내 모든 숫자의 합 계산

3. **차이를 반환 (`totalSum - actualSum`)**
   - 누락된 숫자는 `totalSum - actualSum`과 같음

---

## 코드 구현

```typescript
function solution(A: number[]): number {
  const N = A.length + 1 // 원래 있어야 하는 배열 크기
  const totalSum = (N * (N + 1)) / 2 // 1부터 N까지의 합
  const actualSum = A.reduce((sum, num) => sum + num, 0) // 배열 내 숫자의 합

  return totalSum - actualSum // 누락된 숫자 반환
}
```

---

## 코드 설명

1. **`N+1` 크기의 정렬된 배열을 가정하고 합을 계산**

   ```typescript
   const N = A.length + 1
   const totalSum = (N * (N + 1)) / 2
   ```

   - `1`부터 `N+1`까지의 합을 공식으로 계산

2. **현재 배열의 합(`actualSum`)을 구함**

   ```typescript
   const actualSum = A.reduce((sum, num) => sum + num, 0)
   ```

   - 배열에 들어 있는 숫자들의 합을 계산

3. **누락된 숫자를 반환**
   ```typescript
   return totalSum - actualSum
   ```
   - 전체 합에서 현재 배열의 합을 빼면 누락된 숫자가 나옴

---

## 시간 복잡도

- **`O(N)`** (배열을 한 번만 순회)
- 기존 `sort()`를 이용하는 방법은 **`O(N log N)`** → 더 비효율적
- 이 방법은 **`O(N)`**으로 최적화되어 빠름

---

## 실행 예제

```typescript
console.log(solution([2, 3, 1, 5])) // 출력: 4
console.log(solution([1])) // 출력: 2
console.log(solution([])) // 출력: 1
console.log(solution([2, 3, 4, 5])) // 출력: 1
console.log(solution([1, 2, 3, 4])) // 출력: 5
```

---

## 최종 정리

✅ **`O(N)`의 빠른 연산**  
✅ **정렬 없이 공식(`N(N+1)/2`) 활용**  
✅ **누락된 숫자를 정확하게 찾음**

이제 **누락된 숫자를 쉽고 빠르게 찾을 수 있습니다!** 🚀
