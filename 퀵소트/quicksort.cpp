#include <iostream>
using namespace std;

/* 
	퀵소트는 배열의 기준점을 두어 기준점의 값을 
	양쪽항의 값과 비교하며 자리 배치를 바꾸며 
	정렬하는 방식이다. 
*/ 
void quickSort(int* arr , int front , int end ){
	int pivot = arr[(front+end)/2];
	int startForFront = front;
	int startForEnd = end;
	while(startForFront < startForEnd){
		while(arr[startForFront] < pivot) { startForFront++; }
		while(pivot < arr[startForEnd]) { startForEnd--; }
		if(startForFront <= startForEnd){
			int temp = arr[startForFront];
			arr[startForFront] = arr[startForEnd];
			arr[startForEnd] = temp;
			startForFront++; startForEnd--;
		}
		if(startForFront < end) { quickSort(arr,startForFront,end); }
		if(front < startForEnd) { quickSort(arr,front,startForEnd);}
	}
}
int main(void){
	int arr[] = { 5,3,7,2,1,8,9,9};
	int length = sizeof(arr)/sizeof(*arr);
	quickSort(arr,0,length-1);
	for(int i = 0 ; i < length; i++) printf("%d ",arr[i]);
	return 0;
}
