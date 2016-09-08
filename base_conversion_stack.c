/*Base Conversion USING STACK

Given an integer num and an integer base. The integer num is given in form of decimal base. Write a program to convert the given decimal number into the form represented by base.
Constraints:
1 < num < 1000000
1 < base < 10*/

#include <stdlib.h>
#include <math.h>
#include <stdio.h>
int main()
{

	int num;
	int top = -1, rem, base, i;
	int stack[10000];
	scanf("%d",&num);
	scanf("%d",&base);
	while(num > 0)
	{
	    rem = num % base;
	    top = top + 1;
	    stack[top] = rem;
	    num = num / base;
	}
	while(top >= 0)
	{
	    printf("%d",stack[top]);
	    top = top - 1;
	}
}
