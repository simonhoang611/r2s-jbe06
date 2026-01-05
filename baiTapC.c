#include <stdio.h>
#include <stdlib.h>
#define MAX_SIZE 100

void addValue(int *a, int *n, int value);
void printArray(int *a, int n);
int searchValue(int *a, int n, int value);
void printDescending(int *a, int n);
int isAllOdd(int *a, int n);
void printPrimeNum(int *a, int n);
int isPrime(int num);

void addValue(int *a, int *n,int value){
	if(*n >= MAX_SIZE){
		printf("Array is full.");
		return;
	}
	a[*n]=value;
	(*n)++;
}

void printArray(int *a, int n){
	for(int i = 0; i < n; i++){
		printf("%d ", a[i]);
	}
	printf("\n");
}

int searchValue(int *a, int n, int value){  
	int count=0;
   	for (int i=0;i<n;i++){
       	if (a[i] == value) 
			count++;
    }
   	return count;
}

void printDescending(int *a, int n){
	int descArray[MAX_SIZE];
	for(int i = 0; i<n; i++){
		descArray[i] = a[i];
	}
	
	for(int i = 0; i<n-1; i++){
		for(int j = i+1; j<n; j++){
			if(descArray[i]<descArray[j]){
				int t = descArray[i];
				descArray[i] = descArray[j];
				descArray[j] = t;
			}
		}
	}
	printArray(descArray, n);
} 

int isAllOdd(int *a, int n){
	if(n==0){
		return 0;
	}
	for(int i = 0; i<n; i++){
		if(a[i]%2==0){
			return 0;
		}
	}
	return 1;	
}

int isPrime(int num){
	if(num < 2){
		return 0;
	}
	if(num == 2){
		return 1;
	}
	if(num % 2 == 0){
		return 0;
	}
	for(int i = 3; i * i <= num; i += 2){
		if(num % i == 0){
			return 0;
		}
	}
	return 1;
}

void printPrimeNum(int *a, int n){
	int found = 0;
	printf("Prime numbers in array: ");
	for(int i = 0; i < n; i++){
		if(isPrime(a[i])){
			printf("%d ", a[i]);
			found = 1;
		}
	}
	if(!found){
		printf("No prime numbers found.");
	}
	printf("\n");
}

int main(){
	int a[MAX_SIZE];
	int n = 0;
	int choice, value, numElements;
	do {
		printf("\n====== MENU ======\n");
		printf("1. Input a array\n");
		printf("2. Output array\n");
		printf("3. Print the array in descending order\n");
		printf("4. Check if all elements are odd\n");
		printf("5. Search a value\n");
		printf("6. Print prime numbers in the array\n");
		printf("7. Quit\n");
		printf("Your choice: ");
		scanf("%d", &choice);
		
		switch(choice){
			case 1:
				printf("Enter the number of elements to add (1-100): ");
				scanf("%d", &numElements);
				
				if(numElements < 1 || numElements > MAX_SIZE){
					printf("Invalid number of elements. Must be between 1 and 100.\n");
					break;
				}
				
				if(n + numElements > MAX_SIZE){
					printf("Array doesn't have enough space left.");
					break;
				}
				
				for(int i = 0; i < numElements; i++){
					printf("Element %d: ", i + 1);
					scanf("%d", &value);
					addValue(a, &n, value);
				}
				break;
			case 2:
				if(n == 0){
					printf("Array is empty.\n");
				} else {
					printf("Current array: ");
					printArray(a, n);
				}
				break;
			case 3:
				if(n == 0){
					printf("Array is empty.\n");
				} else {
					printf("Descending order array: ");
					printDescending(a, n);
				}
				break;
			case 4:
				if(n == 0){
					printf("Array is empty.\n");
				}else if(isAllOdd(a, n)){
					printf("All elements are odd.\n");
				}else{
					printf("Not all elements are odd.\n");
				}
				break;
			case 5:
				if(n == 0){
					printf("Array is empty.\n");
				} else {
					printf("Enter value to search: ");
					scanf("%d", &value);
					int count = searchValue(a, n, value);
					if(count > 0){
						printf("Value %d appears %d time(s) in the array.\n", value, count);
					} else {
						printf("Value %d not found in the array.\n", value);
					}
				}
				break;
			case 6:
				if(n == 0){
					printf("Array is empty.\n");
				} else {
					printPrimeNum(a, n);
				}
				break;
			case 7:
				break;
			default:
				printf("Invalid choice. Please choose 1-7.\n");
				break;		
			}
	} while(choice != 7);
	return 0;
}