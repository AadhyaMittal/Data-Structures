//to remove duplicate elements in a sorted linked list

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

void remove_dup(struct node **head)
{
    struct node *temp = *head;
    struct node *next_node;
    while(temp -> next != NULL)
    {
        next_node = temp -> next;
        if(temp -> data == next_node -> data)
        {
            temp -> next = next_node -> next;
            free(next_node);
        }
        else
            temp = temp -> next;
    }
}

int main()
{
    struct node *head = NULL;
    print(head);
    insert_end(&head, 1);
    insert_end(&head, 1);
    insert_end(&head, 1);
    insert_end(&head, 1);
    insert_end(&head, 2);
    insert_end(&head, 2);
    insert_end(&head, 2);
    insert_end(&head, 3);
    insert_end(&head, 4);
    insert_end(&head, 4);
    print(head);
    printf("\n");
    remove_dup(&head);
    print(head);
    printf("\n");
}

