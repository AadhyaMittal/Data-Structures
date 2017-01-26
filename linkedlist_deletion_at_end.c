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
        printf("Linked list is empty \n");
        return;
    }
    while(head != NULL)
    {
        printf("%d ", head -> data);
        head = head -> next;
    }
}

void delete_end(struct node **head)
{
    struct node *temp = *head;
    struct node *prev;
    if(*head == NULL)
    {
        printf("List is empty. Nothing to delete \n");
    }
    else
    {
        while(temp -> next != NULL)
        {
            prev = temp;
            temp = temp -> next;
        }
        if(temp == *head)                                   //if the linked list has a single node then *head will be made NULL to remove that single node
        {
            *head = NULL;
        }
        else
        {
            prev -> next = NULL;
        }
        free(temp);
    }

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
        delete_end(&head);
        print(head);
}
