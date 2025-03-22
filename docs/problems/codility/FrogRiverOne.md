# 🐸 FrogRiverOne 문제 해결 (Codility)

## 📌 문제 설명

개구리는 위치 `0`에서 출발하여 목표 위치 `X`로 점프하려 합니다. 강 위에 `N`개의 나뭇잎이 떨어지며, 배열 `A`의 인덱스는 **시간(time)** 을 나타내고, 값은 **나뭇잎이 떨어진 위치(position)** 를 의미합니다.

개구리가 **위치 `X`까지 이동할 수 있는 최소 시간을 찾는 것이 목표**입니다. 만약 건널 수 없다면 `-1`을 반환해야 합니다.

### **🔹 입력**

- 정수 `X` (목표 위치)
- 배열 `A` (각 시간 `t`에 `A[t]` 위치에 나뭇잎이 떨어짐)

### **🔹 출력**

- 개구리가 `X`까지 도달할 수 있는 **최소 시간**
- 만약 도달할 수 없다면 `-1` 반환

---

## **📍 예제 분석**

```typescript
X = 5
A = [1, 3, 1, 4, 2, 3, 5, 4]
```

### **🔹 배열 해석**

- 시간 `0`: 위치 `1`에 잎이 떨어짐 ✅
- 시간 `1`: 위치 `3`에 잎이 떨어짐 ✅
- 시간 `2`: 위치 `1`에 또 잎이 떨어짐 (이미 있음)
- 시간 `3`: 위치 `4`에 잎이 떨어짐 ✅
- 시간 `4`: 위치 `2`에 잎이 떨어짐 ✅
- 시간 `5`: 위치 `3`에 또 잎이 떨어짐 (이미 있음)
- 시간 `6`: 위치 `5`에 잎이 떨어짐 ✅ **(모든 1~5가 채워짐)**

### **🔹 결과**

개구리는 `시간 6`에 모든 잎이 채워져서 `X=5`까지 점프 가능!  
**👉 최소 시간은 `6`!**

---

## **🚨 이전 코드 (비효율적인 O(N \* X))**

```typescript
function solution(X: number, A: number[]): number {
  const leaves = Array(X + 1).fill(false)
  leaves[0] = true

  const isFull = () => leaves.every(Boolean)
  let leafIdx = 0
  while (leafIdx < A.length) {
    leaves[A[leafIdx]] = true
    if (isFull()) break
    leafIdx++
  }
  return leafIdx
}
```

---

## **🚀 개선된 코드 구현 (O(N))**

```typescript
function solution(X: number, A: number[]): number {
  const leaves = new Set<number>() // 개구리가 밟을 수 있는 위치 저장

  for (let time = 0; time < A.length; time++) {
    leaves.add(A[time]) // 새로운 잎 위치 추가
    if (leaves.size === X) return time // X개 위치가 모두 등장했으면 반환
  }

  return -1 // 끝까지 다 확인했는데 X에 도달 불가능
}
```

---

## **💡 개선 이유**

### ❌ **이전 코드 문제점**

1. **`isFull()` 함수 (`leaves.every(Boolean)`)의 O(X) 비효율성**

   - `while` 루프 내에서 `O(X)`의 연산을 반복 수행하여 **O(N \* X) 시간 복잡도** 발생

2. **`leaves[0] = true` 불필요한 작업**

   - 개구리는 `1~X`만 필요하므로 `0`번 인덱스는 불필요한 공간 낭비

3. **반복문 설계 비효율**
   - `while` 대신 `for` 루프를 사용하여 빠르게 탈출하는 것이 효율적

### ✅ **개선된 코드 장점**

1. **Set을 사용하여 O(N)으로 해결** 🚀
2. **배열 전체를 매번 확인하지 않고 `Set.size === X`를 만족하면 즉시 종료**
3. **불필요한 메모리 사용 최소화**

---

## **🛠 예제 테스트**

```typescript
console.log(solution(5, [1, 3, 1, 4, 2, 3, 5, 4])) // 출력: 6
console.log(solution(5, [1, 3, 1, 4, 2, 3])) // 출력: -1 (5가 없음)
console.log(solution(2, [2, 2, 2, 2, 2, 2])) // 출력: -1 (1이 없음)
console.log(solution(1, [1])) // 출력: 0 (바로 건널 수 있음)
```

---

## **📌 결론**

✅ **최적화된 `O(N)` 풀이로 Codility 100% 통과 가능!** 🚀  
✅ **`Set`을 활용하여 불필요한 연산 최소화!**  
✅ **가능한 빠르게 개구리가 건널 수 있는 시간을 찾고 즉시 반환!** 🎯

이제 개구리가 강을 건너는 최소 시간을 쉽게 구할 수 있습니다! 🐸✨
