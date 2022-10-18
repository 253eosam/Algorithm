/**
> 재귀함수로 구현해볼것

1. 1부터 n까지 출력 
2. 1부터 n까지 역순으로 출력
3. 두 수 사이의 홀수 출력
4. 1부터 n까지의 합
5. 팩토리얼 계산
6. 피보나치 수열
7. 피보나치 수열2 - x 메모이제이션을 이용하여 속도 향상시키기
8. 2진수 변환
9. 계단 오르기 - x 앞으로만 올라가는 사람
10. 계단 오르기 2 - x 앞뒤로 갈수 있는 사람
 */

const N = 10
console.log(("==============================================="));

function fn1 (N, val = 1) {
  if (val === N + 1) return
  console.log("fn1 :: " + val)
  fn1(N, val+1)
}
fn1(N)
console.log(("==============================================="));

function fn2 (N, val = N) {
  if (val === 0) return
  console.log("fn2 :: " + val)
  fn2(N, val-1)
}
fn2(N)
console.log(("==============================================="));

function fn3 (start, end) {
  if (end < start) return
  if (start % 2 === 1) console.log("fn3 :: " + start)
  fn3(start+1, end)
}
fn3(1, N)
console.log(("==============================================="));

function fn4 (N, val = 1) {
  if (val === N) return val
  return val + fn4(N, val+1)
}
console.log("fn4 :: " + fn4(N));
console.log(("==============================================="));

function fn5 (N) {
  if (N === 1) return 1
  return N * fn5(N-1)
}
console.log("fn5 :: " + fn5(N));
console.log(("==============================================="));

function fn6 (N) {
  if (N === 0 || N === 1) return N
  return fn6(N-2) + fn6(N-1)
}
console.time("fn6")
console.log("fn6 :: " + fn6(N));
console.timeEnd("fn6")
console.log(("==============================================="));

function fn7 () {
  let cache = [0, 1]
  return function fibonacci (N) {
    if (!isNaN(cache[N])) return cache[N]
    return cache[N] = fibonacci(N-2) + fibonacci(N-1)
  }
}
console.time("fn7")
console.log("fn7 :: " + fn7()(N))
console.timeEnd("fn7")
console.log(("==============================================="));

function fn8 (N) {
  if (N === 1) return `${N}`
  const rest = N % 2
  return fn8(Math.floor(N / 2)) + `${rest}`
}
console.log("fn8 :: " + fn8(N));
console.log(("==============================================="));

function  fn9 (N, step, position = 0, cnt = 0) {
  if (N < position) return `Person(${step}) don't arrive a Target(${N})`
  position &&  console.log("fn9 :: position :: " + position)
  if (N === position) return cnt
  return fn9(N, step, position + step, cnt+1)
}
console.log("fn9 :: " + fn9(N, 2))
console.log(("==============================================="));

function fn10 (N, step, position = 0, cnt = 0) {
  if (N < position) return false
  position && console.log("fn10 :: position :: " + position)
  if (N === position) return cnt
  return fn10(N, step, position + step, cnt+1) || fn10(N, step, position - 1, cnt+1)
}
console.log("fn10 :: " + fn10(N, 3))
console.log(("==============================================="));
