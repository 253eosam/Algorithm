#include <iostream>
#include <algorithm>
#define MAX_SIZE 1000
using namespace std;

int arr[MAX_SIZE+1];
int counting[MAX_SIZE + 1];
int main()
{
	int T; int tNum = 1;
	scanf_s("%d", &T);
	while (T--)
	{
		int n; 
		scanf_s("%d", &n);

		for (int i = 0; i < n; i++)
		{
			scanf_s("%d", &arr[i]);
		}

		for (int i = 0; i < n; i++)
			counting[i]++;

		for (int i = 1; i < n; i++)
		{
			for (int j = 0; j < i; j++)
			{
				if (arr[i] >= arr[j])
				{
					if (counting[i] < counting[j] + 1)
					{
						counting[i] = counting[j] + 1;
					}
				}
			}
		}

		int maximum = 0;
		for (int i = 0; i < n; i++)
			if (maximum < counting[i])
				maximum = counting[i];

		printf("#%d %d\n",tNum++, maximum);


		for (int i = 0; i < n; i++)
		{
			arr[i] = 0;
			counting[i] = 0;
		}

		
	}

	return 0;
}