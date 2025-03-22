# Binary Gap 문제 해결

## 문제 설명

양의 정수 `N`이 주어졌을 때, 이 숫자를 **이진수(Binary)** 로 변환한 후, 가장 긴 **0으로 이루어진 연속적인 부분(이진 간격, Binary Gap)** 의 길이를 구하는 문제입니다.

이진 간격(Binary Gap)이란:

- **1로 시작하고 1로 끝나는 0들의 연속적인 부분**을 의미합니다.
- 만약 연속된 `0`이 있어도 **1로 둘러싸여 있지 않다면** 이는 유효한 Binary Gap이 아닙니다.

### 예시

| N (십진수) | 이진수 표현  | Binary Gap 길이 |
| ---------- | ------------ | --------------- |
| `9`        | `1001`       | `2`             |
| `529`      | `1000010001` | `4`             |
| `20`       | `10100`      | `1`             |
| `15`       | `1111`       | `0`             |

---

## 해결 방법

1. **입력된 숫자 `N`을 이진수로 변환**합니다.
2. **이진수 문자열을 탐색**하며, 가장 긴 Binary Gap을 찾습니다.
3. **현재 숫자가 `1`일 경우**, 그 이후에 나오는 `1`까지의 `0` 개수를 계산합니다.
4. **최대값을 갱신**하면서, 더 긴 Binary Gap이 나오면 업데이트합니다.

---

## 코드 구현

```typescript
function solution(N: number): number {
  // 1. N을 이진수로 변환
  const binary = N.toString(2)
  console.log('🔹 253eosam > solution > binary:', binary)

  let answer = 0 // 가장 긴 Binary Gap 저장

  // 2. 이진수를 순회하면서 Binary Gap 찾기
  for (let i = 0; i < binary.length; i++) {
    if (binary[i] === '0') continue // 0이면 패스

    for (let j = i + 1; j < binary.length; j++) {
      console.log(i, j)
      if (binary[j] === '1') {
        // 1을 만나면 길이 계산
        answer = Math.max(answer, j - i - 1)
        i = j - 1 // 다음 탐색 위치 업데이트
        break
      }
    }
  }

  return answer
}
```

---

## 코드 설명

1. **이진수 변환**

   ```typescript
   const binary = N.toString(2)
   ```

   - `toString(2)`를 사용해 숫자를 이진수 문자열로 변환합니다.

2. **Binary Gap 탐색**

   - **`1`을 기준으로 탐색을 시작**합니다.
   - `j`를 `i+1`부터 탐색하면서 `1`을 찾을 때까지 이동합니다.
   - `1`을 찾으면 `(j - i - 1)`을 계산하여 최대값을 갱신합니다.

3. **최대 Binary Gap 업데이트**
   ```typescript
   answer = Math.max(answer, j - i - 1)
   ```
   - 현재 찾은 Binary Gap의 길이를 `answer`와 비교하여 **최대값을 저장**합니다.

---

## 시간 복잡도

- **이진 변환**: `O(log N)` → 숫자 `N`을 이진수로 변환하는 데 걸리는 시간
- **이진수 탐색**: `O(log N)` → 숫자 `N`의 비트 수만큼 순회
- **최종 시간 복잡도**: `O(log N)`

---

## 실행 예제

```typescript
console.log(solution(9)) // 출력: 2
console.log(solution(529)) // 출력: 4
console.log(solution(20)) // 출력: 1
console.log(solution(15)) // 출력: 0
```

---

## 최종 정리

✅ **이진 변환 후 탐색**: `toString(2)`로 변환 후 순회  
✅ **1을 기준으로 Binary Gap 탐색**: `j` 포인터를 활용한 탐색 방식  
✅ **최대값 업데이트**: `Math.max()` 사용  
✅ **시간 복잡도 `O(log N)`**: `N`의 비트 길이에 비례

이제 효율적으로 `Binary Gap`을 구할 수 있습니다! 🚀
