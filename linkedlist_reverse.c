//To reverse a linked list

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

void reverse(struct node **head)
{
    struct node *prev_node, *cur_node, *next_node;
    prev_node = NULL;
    cur_node = *head;
    while(cur_node != NULL)
    {
        next_node = cur_node -> next;
        cur_node -> next = prev_node;
        prev_node = cur_node;
        cur_node = next_node;
    }
    *head = prev_node;
}

int main()
{
    struct node *head = NULL;
    print(head);
    insert_end(&head, 5);
    insert_end(&head, 6);
    insert_end(&head, 7);
    insert_end(&head, 8);
    print(head);
    printf("\n");
    reverse(&head);
    print(head);
    printf("\n");
}
