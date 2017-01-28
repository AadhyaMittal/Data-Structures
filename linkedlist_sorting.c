//to sort a given linked list

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

void sort(struct node *head)
{
    struct node *ptr1 = head;
    struct node *ptr2;
    struct node *dup;
    while(ptr1 != NULL && ptr1 -> next != NULL)
    {
        ptr2 = ptr1;
        while(ptr2 -> next != NULL)
        {
            if(ptr1 -> data > ptr2 -> next -> data)
            {
                dup = ptr1 -> data;
                ptr1 -> data = ptr2 -> next -> data;
                ptr2 -> next -> data = dup;
            }
            else
                ptr2 = ptr2 -> next;
        }
        ptr1 = ptr1 -> next;
    }
}
int main()
{
    struct node *head = NULL;
    print(head);
    insert_end(&head, 1);
    insert_end(&head, 4);
    insert_end(&head, 1);
    insert_end(&head, 7);
    insert_end(&head, 2);
    insert_end(&head, 2);
    insert_end(&head, 4);
    insert_end(&head, 3);
    insert_end(&head, 1);
    insert_end(&head, 3);
    print(head);
    printf("\n");
    sort(head);
    print(head);
    printf("\n");
    /*print(head);
    insert_end(&head, 10);
    insert_end(&head, 12);
    insert_end(&head, 11);
    insert_end(&head, 10);
    insert_end(&head, 9);
    insert_end(&head, 2);
    print(head);
    printf("\n");
    sort(head);
    print(head);
    printf("\n");*/
}

