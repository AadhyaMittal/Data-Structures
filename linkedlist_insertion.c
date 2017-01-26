//To implement insertion functions in a linked list

#include<stdio.h>
#include<conio.h>
struct node
{
    int data;
    struct node *next;
};
void printList(struct node *head)
{
    struct node *last = head;
    while(last != NULL)
    {
        printf("%d ", last -> data);
        last = last->next;
    }

}

void insert_beg(struct node **head, int data)                                   //complexity -- O(1)
{
    struct node *new_node = (struct node*)malloc(sizeof(struct node));
    new_node -> data = data;
    new_node -> next = *head;
    *head = new_node;
}

void insert_end(struct node **head, int data)                                   //complexity -- O(1)
{
    struct node *new_node = (struct node*)malloc(sizeof(struct node));
    new_node -> data = data;
    new_node -> next = NULL;
    struct node *last = *head;
    if(*head == NULL)
    {
        *head = new_node;
        return;
    }
    while(last -> next != NULL)
    {
        last = last -> next;
    }
    last -> next = new_node;
}

void insert_after(struct node *prev_node, int data)                             //complexity -- O(n)
{
    struct node* new_node = (struct node*)malloc(sizeof(struct node));
    if(prev_node == NULL)
    {
        printf("prev_node can not be NULL");
        return;
    }
    new_node -> data = data;
    new_node -> next = prev_node -> next;
    prev_node -> next = new_node;
}
int main()
{
    struct node *head = NULL;
    insert_beg(&head,2);
    insert_beg(&head,5);
    insert_beg(&head,1);
    insert_after(head -> next,15);
    insert_end(&head,8);
    insert_end(&head,18);
    printList(head);
}
