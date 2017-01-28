//to segregate even and odd nodes in a linked list. Place even nodes before the odd nodes

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

void even_odd(struct node *head)
{
    struct node *first_even, *first_odd, *last_even, *last_odd;
    struct node *temp = head;
    first_even = NULL;
    first_odd = NULL;
    last_even = NULL;
    last_odd = NULL;
    while(temp != NULL)
    {
        if(temp -> data % 2 == 0)
        {
            if(first_even == NULL)
            {
                first_even = last_even = temp;
            }
            else
            {
                last_even -> next = temp;              //even nodes are being linked together
                last_even = temp;
            }
        }
        else
        {
            if(first_odd == NULL)
            {
                first_odd = last_odd = temp;
            }
            else
            {
                last_odd -> next = temp;             //odd nodes are being linked together
                last_odd = temp;
            }
        }
        temp = temp -> next;
    }
    if(first_even != NULL)
        head = first_even;                            //head points to the first even node
    if(first_odd != NULL)
        last_even -> next = first_odd;                //last even node points to the first odd node
    if(last_odd != NULL)
        last_odd -> next = NULL;                      //last odd node points to NULL
}

int main()
{
    struct node *head = NULL;
    print(head);
    insert_end(&head, 2);
    insert_end(&head, 1);
    insert_end(&head, 6);
    insert_end(&head, 7);
    insert_end(&head, 9);
    insert_end(&head, 0);
    insert_end(&head, 12);
    print(head);
    printf("\n");
    even_odd(head);
    print(head);
    printf("\n");
}
