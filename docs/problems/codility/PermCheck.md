# ✅ PermCheck 문제 해결 (Codility)

## 📌 문제 설명

배열 `A`가 1부터 `N`까지 모든 숫자를 포함하는 **순열(permutation)** 인지 확인하는 문제입니다. 만약 `A`가 순열이면 `1`을 반환하고, 그렇지 않으면 `0`을 반환해야 합니다.

### **🔹 입력**

- 정수 배열 `A` (길이 `N`, 원소 값 범위 `1` ~ `N`)

### **🔹 출력**

- `A`가 순열이면 `1`, 아니면 `0`

---

## **📍 예제 분석**

```typescript
A = [4, 1, 3, 2]
```

✅ **1부터 4까지 모든 숫자가 포함 → 순열!** `👉 출력: 1`

```typescript
A = [4, 1, 3]
```

❌ **2가 없어서 순열이 아님** `👉 출력: 0`

```typescript
A = [1, 1, 2, 3]
```

❌ **1이 중복되어 순열이 아님** `👉 출력: 0`

---

## **🚨 이전 코드 (비효율적인 O(N log N))**

```typescript
function solution(A: number[]): number {
  A.sort((a, b) => a - b)
  for (let i = 0; i < A.length; i++) {
    if (A[i] !== i + 1) return 0
  }
  return 1
}
```

---

## **🚀 개선된 코드 구현 (O(N))**

```typescript
function solution(A: number[]): number {
  const seen = new Set<number>()
  for (const num of A) {
    if (num > A.length || seen.has(num)) return 0
    seen.add(num)
  }
  return 1
}
```

---

## **💡 개선 이유**

### ❌ **이전 코드 문제점**

1. **정렬을 사용해 O(N log N) 시간 소요** 🚨
2. **중복 검사 없이 `A[i] !== i + 1` 만 체크 → 중복 허용 가능성**

### ✅ **개선된 코드 장점**

1. **`Set`을 사용해 O(N)으로 해결** 🚀
2. **배열 크기를 초과하는 값(`num > A.length`) 체크로 빠른 예외 처리**
3. **중복(`seen.has(num)`)을 즉시 감지하여 불필요한 연산 방지**

---

## **🛠 예제 테스트**

```typescript
console.log(solution([4, 1, 3, 2])) // 출력: 1
console.log(solution([4, 1, 3])) // 출력: 0
console.log(solution([1, 1, 2, 3])) // 출력: 0
console.log(solution([2, 3, 4, 5])) // 출력: 0
```

---

## **📌 결론**

✅ **최적화된 `O(N)` 풀이로 Codility 100% 통과 가능!** 🚀
✅ **`Set`을 활용하여 중복 및 범위 초과 검사를 빠르게 처리!**
✅ **배열 정렬 없이 효율적으로 순열 여부 판별!** 🎯
