# OddOccurrencesInArray 문제 해결

## 문제 설명

배열 `A`가 주어졌을 때, **한 번만 등장하는 요소를 찾는 문제**입니다.  
배열에는 **짝을 이루는 숫자들이 있으며, 단 하나의 숫자만 짝이 없습니다.**  
이 **짝이 없는 유일한 숫자를 찾아 반환**해야 합니다.

### 예제

| 입력 (`A`)              | 이진 표현                    | 결과 (`출력`) |
| ----------------------- | ---------------------------- | ------------- |
| `[9, 3, 9, 3, 9, 7, 9]` | `9-3-9-3-9-7-9` → 7이 유일함 | `7`           |
| `[1, 1, 2, 2, 3]`       | `1-1-2-2-3` → 3이 유일함     | `3`           |
| `[42]`                  | `42` → 유일한 숫자           | `42`          |

---

## 해결 방법

1. **`Set`을 활용하여 중복을 제거**
   - Set은 같은 값이 들어오면 삭제하는 특징이 있음
   - 한 번 등장한 숫자는 Set에 추가하고, 두 번째 등장하면 삭제
   - 마지막에 남은 값이 유일한 숫자

---

## 코드 구현

```typescript
function solution(A: number[]): number {
  const set = new Set<number>()

  for (let element of A) {
    if (set.has(element)) set.delete(element) // 이미 존재하면 제거
    else set.add(element) // 없으면 추가
  }

  return +Array.from(set.values())[0] // 남은 하나의 값 반환
}
```

---

## 코드 설명

1. **`Set`을 이용하여 짝이 맞는 숫자는 제거**

   ```typescript
   const set = new Set<number>()
   ```

   - `Set`은 중복을 허용하지 않음
   - 같은 숫자가 두 번 등장하면 삭제

2. **배열을 순회하면서 `Set`을 업데이트**

   ```typescript
   for (let element of A) {
     if (set.has(element)) set.delete(element)
     else set.add(element)
   }
   ```

   - 이미 존재하는 숫자는 제거
   - 처음 등장하는 숫자는 추가

3. **마지막 남은 요소 반환**
   ```typescript
   return +Array.from(set.values())[0]
   ```
   - `Set`에 남은 **유일한 숫자**를 배열로 변환하여 반환

---

## 시간 복잡도

- **배열 순회:** `O(N)`
- **Set 추가/삭제:** 평균 `O(1)`
- **최종 시간 복잡도:** **`O(N)`**  
  → 배열을 한 번만 순회하기 때문에 매우 효율적

---

## 실행 예제

```typescript
console.log(solution([9, 3, 9, 3, 9, 7, 9])) // 출력: 7
console.log(solution([1, 1, 2, 2, 3])) // 출력: 3
console.log(solution([42])) // 출력: 42
```

---

## 최종 정리

✅ **`Set`을 활용한 짝 제거 방식**  
✅ **효율적인 `O(N)` 해결 방법**  
✅ **유일한 숫자를 빠르게 찾음**

이제 **단 하나만 존재하는 숫자**를 쉽게 찾을 수 있습니다! 🚀
