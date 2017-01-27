//to find the number of occurences of an element in a linked list

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

void occurence(struct node *head, int value)
{
    int count = 0;
    while(head != NULL)
    {
        if(head -> data == value)
            count++;
        head = head -> next;
    }
    printf("%d has occured %d times \n", value, count);
}

int main()
{
    struct node *head = NULL;
    print(head);
    insert_end(&head, 1);
    insert_end(&head, 2);
    insert_end(&head, 1);
    insert_end(&head, 2);
    insert_end(&head, 1);
    insert_end(&head, 2);
    insert_end(&head, 1);
    insert_end(&head, 1);
    print(head);
    printf("\n");
    occurence(head, 1);
    occurence(head, 2);
}
