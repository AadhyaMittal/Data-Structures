//Deletion at Beginning

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
        printf("List is empty \n");
        return;
    }
    while(head != NULL)
    {
        printf("%d ", head -> data);
        head = head -> next;
    }
}

void delete_begin(struct node **head)
{
    if(*head == NULL)
    {
        printf("List is empty thus Nothing to delete \n");
        return;
    }
    struct node *temp = *head;
    *head = temp -> next;
    free(temp);
}
int main()
{
        struct node *head = NULL;
        insert_beg(&head, 5);
        insert_beg(&head, 7);
        insert_beg(&head, 5);
        insert_beg(&head, 8);
        insert_beg(&head, 1);
        print(head);
        printf("\n");
        delete_begin(&head);
        print(head);
}
