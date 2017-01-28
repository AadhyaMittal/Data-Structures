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

void remove_dup_unsorted(struct node *head)
{
    struct node *ptr1 = head;
    struct node *ptr2;
    struct node *dup;
    while(ptr1 != NULL && ptr1 -> next != NULL)            //ptr1 goes from 1st node till 2nd last node
    {
        ptr2 = ptr1;
        while(ptr2 -> next != NULL)                         //ptr2 goes from 1st node till 2nd last node
        {
            if(ptr1 -> data == ptr2 -> next -> data)
            {
                dup = ptr2 -> next;
                ptr2 -> next = ptr2 -> next -> next;
                free(dup);
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
    remove_dup_unsorted(head);
    print(head);
    printf("\n");
}

