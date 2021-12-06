# Median of Two Sorted Arrays

## 풀이

두 배열을 합치고 숫자를 기준으로 오름차순 정렬을 한다.<br/>
중간 인덱스를 찾는데 짝수일경우 중간 두값, 홀수일경우 중간값을 소수점 5개까지 표시하여 리턴한다.

## 코드

```js
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    const nums = nums1.concat(nums2)
    nums.sort((a,b) => a-b)
   
    
    const mid = parseInt(nums.length / 2)
     
    return nums.length % 2 === 0 ? (sum(nums[mid-1],nums[mid])/2).toFixed(5) : nums[mid].toFixed(5)
};
    
const sum = (...args) => args.reduce((acc,cur) => acc + cur, 0)
```

## 문제

![problems](/assets/problems4.png)