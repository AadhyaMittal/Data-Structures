//to find the length of a linked list

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

int length(struct node *head)
{
    int len = 0;
    if(head == NULL)
    {
        return 0;
    }
    while(head != NULL)
    {
        len++;
        head = head -> next;
    }
    return len;
}


int main()
{
    struct node *head = NULL;
    print(head);
    int len = length(head);
    printf("The length of the list is %d\n", len);
    insert_end(&head, 5);
    insert_end(&head, 8);
    insert_end(&head, 10);
    insert_end(&head, 9);
    print(head);
    printf("\n");
    len = length(head);
    printf("The length of the list is %d\n", len);
}
