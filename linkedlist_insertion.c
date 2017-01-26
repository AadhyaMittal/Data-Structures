//To implement insertion functions in a linked list

#include<stdio.h>
#include<conio.h>
struct node
{
    int data;
    struct node *next;
};

void insert_beg(struct node **head, int data)                    //complexity -- O(1)
{
    struct node *new_node = (struct node*)malloc(sizeof(struct node));
    new_node -> data = data;
    new_node -> next = *head;
    *head = new_node;
}

void print(struct node *head)
{
    if(head == NULL)
    {
        printf("List is empty \n");
        return;
    }
    while(head != NULL)
    {
        printf("%d ", head -> data);
        head = head -> next;
    }
}

void insert_after(struct node *prev_node, int data)                 //complexity -- O(1)
{
    if(prev_node == NULL)
    {
        printf("previous Node can not be NULL \n");
        return;
    }
    struct node *new_node = (struct node*)malloc(sizeof(struct node));
    new_node -> data = data;
    new_node -> next = prev_node -> next;
    prev_node -> next = new_node;
}

void insert_end(struct node **head, int data)                       //complexity -- O(n)
{
    struct node *new_node = (struct node*)malloc(sizeof(struct node));
    struct node *prev = *head;
    new_node -> data = data;
    new_node -> next = NULL;
    if(*head == NULL)
    {
        *head = new_node;
        return;
    }
    while(prev -> next != NULL)
    {
        prev = prev -> next;
    }
    prev -> next  = new_node;
}

int main()
{
    struct node *head = NULL;
    print(head);
    insert_beg(&head, 5);
    insert_beg(&head, 7);
    insert_beg(&head, 11);
    print(head);
    printf("\n");
    insert_after(head, 1);
    print(head);
    printf("\n");
    insert_end(&head, 99);
    print(head);
    printf("\n");
}
