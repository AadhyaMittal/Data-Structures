//to print the nth element from the last of a linked list

#include<stdio.h>
#include<conio.h>
struct node
{
    int data;
    struct node *next;
};

void insert_end(struct node **head, int data)
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
        printf("%d ", head -> data);
        head = head -> next;
    }
}

void nth_position(struct node *head, int n)
{
    int length = 0;
    int arr[20];
    int i = 1;
    struct node *temp = head;
    while(temp -> next != NULL)
    {
        length++;
        temp = temp -> next;
        arr[i] = temp -> data;
        i++;
    }
    printf("%d \n", arr[length - n + 1]);
}

int main()
{
    struct node *head = NULL;
    print(head);
    insert_end(&head, 1);
    insert_end(&head, 2);
    insert_end(&head, 3);
    insert_end(&head, 4);
    print(head);
    printf("\n");
    nth_position(head, 2);
    nth_position(head, 1);
}
