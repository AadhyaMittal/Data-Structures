//to delete a node at a particular position in a linked list

#include<stdio.h>
#include<conio.h>
struct node
{
    int data;
    struct node *next;
};

void insert_beg(struct node **head, int data)
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
        printf("Linked list is empty \n");
        return;
    }
    while(head != NULL)
    {
        printf("%d ", head -> data);
        head = head -> next;
    }
}

void delete(struct node **head, int pos)
{
    if(*head == NULL)
    {
        printf("List is empty. Nothing to delete \n");
        return;
    }
    struct node *temp = *head;
    struct node *prev;
    int count = 0;
    if(pos == 0)                             //if we want to delete the first node
    {
        *head = temp -> next;
        free(temp);
        return;
    }
    while(temp != NULL && count < pos)
    {
        count++;
        prev = temp;
        temp = temp -> next;
    }
    if(temp == NULL)
    {
        printf("Node not available \n");
        return;
    }
    prev -> next = temp -> next;
    free(temp);
}

int main()
{
    struct node *head = NULL;
    print(head);
    printf("\n");
    insert_beg(&head, 5);
    insert_beg(&head, 1);
    insert_beg(&head, 2);
    insert_beg(&head, 4);
    insert_beg(&head, 7);
    print(head);
    printf("\n");
    delete(&head, 1);
    print(head);
    printf("\n");
    delete(&head, 3);
    print(head);
    printf("\n");
    delete(&head, 0);
    print(head);
    printf("\n");
    delete(&head, 3);
    print(head);
    printf("\n");
}
