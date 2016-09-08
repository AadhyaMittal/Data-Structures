#include <stdlib.h>
#include <math.h>
#include <stdio.h>
#include<string.h>
int main()
{
	char str[20], stack[20];
	int top , i, l, size, flag;
	flag = 1;
	i = 0;
	size = 0;
	top = top - 1;

	scanf("%s",str);
	l = strlen(str);
	//printf("%d",l);
	while(str[i] != 'c')
	{
	    top = top + 1;
	    size = size + 1;
	    stack[top] = str[i];
	    i++;
	}
	i++;
	while(size-- && flag != 0)
	{
	    if(stack[top] == str[i] )
	    {
	        top = top - 1;
	        i++;
	    }
	    else
	    {
	        flag = 0;
	    }
	}
	printf("%d",flag);
}
