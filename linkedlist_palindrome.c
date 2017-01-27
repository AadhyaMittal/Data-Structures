//To check if a linked list is palindrome or not

#include<stdio.h>
#include<conio.h>
struct node
{
    char data;
    struct node *next;
};

void insert_end(struct node **head, char data)
{
    struct node *new_node = (struct node*)malloc(sizeof(struct node));
    new_node -> data = data;
    new_node -> next = NULL;
    if(*head == NULL)
    {
        *head = new_node;
        return;
    }
    struct node *prev = *head;
    while(prev -> next != NULL)
    {
        prev = prev -> next;
    }
    prev -> next = new_node;
}

void print(struct node *head)
{
    if(head == NULL)
    {
        printf("Linked list is empty \n");
        return;
    }
    while(head != NULL)
    {
        printf("%c ", head -> data);
        head = head -> next;
    }
}

void palindrome(struct node *head)
{
    char stack[50];
    struct node *temp = head;
    int top = -1;
    int flag;
    while(temp != NULL)
    {
        top++;
        stack[top] = temp -> data;
        temp = temp -> next;
    }
    temp = head;
    while(temp != NULL)
    {
        if(temp -> data != stack[top])
        {
            flag = 0;
            break;
        }
        flag = 1;
        top--;
        temp = temp -> next;
    }
    if(flag == 1)
        printf("palindrome \n");
    else
        printf("Not palindrome \n");
}

int main()
{
    struct node *head = NULL;
    print(head);
    /*insert_end(&head, 'R');
    insert_end(&head, 'A');
    insert_end(&head, 'D');
    insert_end(&head, 'A');
    insert_end(&head, 'R');
    print(head);
    printf("\n");*/
    /*palindrome(head);
    insert_end(&head, 'A');
    insert_end(&head, 'P');
    insert_end(&head, 'P');
    insert_end(&head, 'L');
    insert_end(&head, 'E');
    print(head);
    printf("\n");
    palindrome(head);*/
    insert_end(&head, 'A');
    insert_end(&head, 'N');
    insert_end(&head, 'S');
    insert_end(&head, 'S');
    insert_end(&head, 'N');
    insert_end(&head, 'A');
    print(head);
    printf("\n");
    palindrome(head);
}

