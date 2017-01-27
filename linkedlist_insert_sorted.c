//to insert node in a sorted linked list

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

void insert_sorted(struct node **head, int data)
{
    struct node *new_node = (struct node*)malloc(sizeof(struct node));
    new_node -> data = data;
    struct node *temp = *head;
    struct node *prev;
    if(*head == NULL)                       //if the list is empty
    {
        new_node -> next = NULL;
        *head = new_node;
        return;
    }
    while(temp != NULL && temp -> data < data)
    {
        prev = temp;
        temp = temp -> next;
    }
    if(temp == *head)                           //if the element to be added is less than the first element of the linked list
    {
        new_node -> next = *head;
        *head = new_node;
        return;
    }
    new_node -> next = prev -> next;
    prev -> next = new_node;
}


int main()
{
    struct node *head = NULL;
    print(head);
    insert_sorted(&head, 5);
    insert_sorted(&head, 8);
    insert_sorted(&head, 5);
    insert_sorted(&head, 10);
    print(head);
    printf("\n");
    insert_sorted(&head, 3);
    print(head);
    printf("\n");
    insert_sorted(&head, 4);
    print(head);
    printf("\n");
    insert_sorted(&head, 11);
    print(head);
    printf("\n");
}
