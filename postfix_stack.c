#include <stdlib.h>
#include <math.h>
#include <stdio.h>
#include<string.h>
int main()
{
    char str[50];
    int stack[50];
    int i, top, x, a, b, c,sum, l;
    i = 0;
    top = -1;
    scanf("%[^\n]s",str);
    l = strlen(str);
    while(i < l)
    {
        sum = 0;
        if(str[i] == '+' || str[i] == '-' || str[i] == '*' || str[i] == '/')
        {
            b = stack[top];
            a = stack[top - 1];
            if(str[i] == '+')
            {
                c = a+b;
                top = top - 1;
                stack[top] = c;

            }
            else if(str[i] == '-')
            {
                c = a-b;
                top = top - 1;
                stack[top] = c;

            }
            else if(str[i] == '*')
            {
                c = a*b;
                top = top - 1;
                stack[top] = c;

            }
            else if(str[i] == '/')
            {
                c = a/b;
                top = top - 1;
                stack[top] = c;

            }
        }
        else if(str[i] >= '0' && str[i] <= '9')
        {

            if(str[i+1] != ' ')
            {
                while(str[i] != ' ')
                {
                    sum = (sum*10) + (str[i] - '0');
                    i++;
                }
                top = top + 1;
                stack[top] = sum;
            }
            else
            {
                x = str[i] - '0';
                top = top + 1;
                stack[top] = x;
            }


        }
        i++;
    }
    printf("%d",stack[top]);
}
