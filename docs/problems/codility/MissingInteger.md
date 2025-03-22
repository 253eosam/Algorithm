# ✅ Missing Integer 문제 해결 (Codility)

## 📌 문제 설명

배열 `A`가 주어졌을 때, 배열에 존재하지 않는 가장 작은 양의 정수(1 이상)를 찾는 문제입니다.

### **🔹 입력**

- `A`: 정수 배열 (-1, 0, 1, 2, 3 등 음수와 양수 포함 가능)

### **🔹 출력**

- 배열 `A` 내에서 존재하지 않는 가장 작은 양의 정수

---

## **📍 예제 분석**

```typescript
A = [1, 3, 6, 4, 1, 2]
```

👉 **1, 2, 3, 4, 6이 존재하므로 가장 작은 누락된 숫자는 `5`**

✅ **출력:** `5`

---

## **🚀 코드 (O(N))**

```typescript
// you can write to stdout for debugging purposes, e.g.
// console.log('this is a debug message');

function solution(A: number[]): number {
  const set = new Set<number>(A)
  let answer = 1
  while (set.has(answer)) {
    answer++
  }
  return answer
}
```

---

## **💡 해결 방법**

1. **Set 자료구조를 사용하여 중복 제거 및 빠른 검색 활용**
2. **가장 작은 양의 정수(`answer = 1`)부터 존재하는지 체크**
3. **존재하지 않는 첫 번째 수를 반환**

### ✅ **시간 복잡도: O(N)**

- `Set`에 모든 요소를 저장하는 데 **O(N)**
- `while`문에서 `set.has()`를 반복하여 확인하지만, 최악의 경우 **O(N)**
- 전체적으로 **O(N)**의 선형 시간 복잡도를 가짐

---

## **🛠 예제 테스트**

```typescript
console.log(solution([1, 3, 6, 4, 1, 2])) // 출력: 5
console.log(solution([1, 2, 3])) // 출력: 4
console.log(solution([-1, -3])) // 출력: 1
console.log(solution([2])) // 출력: 1
console.log(solution([5, 6, 7, 8])) // 출력: 1
```

---

## **📌 결론**

✅ **Set을 사용하여 빠른 검색을 수행하여 O(N) 해결 가능!** 🚀
✅ **배열의 모든 요소를 탐색하면서 가장 작은 양의 정수를 찾음!** 🎯
✅ **효율적인 공간 활용으로 최적의 성능 제공!** 🔥
