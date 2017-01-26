//to delete the first occurence of a node in a linked list

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

void delete(struct node **head, int data)
{
    struct node *temp = *head;
    struct node *prev;
    if(temp != NULL && temp -> data == data)                    //if head node contains the value to be deleted
    {
        *head = temp -> next;
        free(temp);
        return;
    }
    while(temp != NULL && temp -> data != data)
    {
        prev = temp;
        temp = temp -> next;
    }
    if(temp == NULL)                                    //if the value was not present in the list
    {
        return;
    }
    prev -> next = temp -> next;
    free(temp);
}

int main()
{
        struct node *head = NULL;
        insert_beg(&head, 5);
        insert_beg(&head, 7);
        insert_beg(&head, 5);
        insert_beg(&head, 8);
        print(head);
        printf("\n");
        delete(&head, 5);
        print(head);
}
