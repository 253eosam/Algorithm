#include <iostream>
#include <algorithm>
#define MAX_SIZE 200
using namespace std;

int arr[MAX_SIZE];
int main()
{
	int n;
	scanf_s("%d", &n);
	
	for (int i = 0; i < n; i++)
	{
		scanf_s("%d", &arr[i]);
	}

	sort(arr,arr+n);

	printf("%d", arr[n / 2]);

	return 0;
}