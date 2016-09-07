//A C program to implement BALANCED PARENTHESIS in STACK using an array

#include<stdio.h>
char is_open(char);
char is_close(char);
int main()
{
    char str[50], stack[50];
    scanf("%s",str);
    int top, i;
    i = 0;
    top = -1;
    while(str[i])
    {
        if(str[i] == is_open(str[i]))
        {
            //push(str[i]);
            top = top + 1;
            stack[top] = str[i];

        }
        else
        {
            if(stack[top] == is_close(str[i]))
            {
                top = top - 1;
            }
            else
            {
                printf("The string is not balanced ");
                break;

            }
        }
        /*printf("%c ",str[i]);
        printf("%d ",i);
        printf("%d \n",top);*/
        i++;
    }
    if(top == -1)
    {
        printf("The string is balanced ");
    }
    else
    {
        printf("The string is not balanced ");
    }
}
char is_open(char x)
{
    if(x == '(' || x == '{' || x == '[')
    {
        return x;
    }
    else
    {
        return 0;
    }
}
char is_close(char x)
{
    if(x == ')')
    {
        return '(';
    }
    else if(x == '}')
    {
        return '{';
    }
    else if(x == ']')
    {
        return '[';
    }
    else
    {
        return 0;
    }
}

