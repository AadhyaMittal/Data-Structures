//To check if two linked lists are identical or not

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

int identical(struct node *head1, struct node *head2)
{
    while(head1 != NULL && head2 != NULL)
    {
        if(head1 -> data != head2 -> data)
            return 0;
        head1 = head1 -> next;
        head2 = head2 -> next;
    }
    return (head1 == NULL && head2 == NULL);

}

int main()
{
    struct node *head1 = NULL;
    struct node *head2 = NULL;
    insert_end(&head1, 1);
    insert_end(&head1, 2);
    insert_end(&head1, 3);
    insert_end(&head2, 1);
    insert_end(&head2, 2);
    insert_end(&head2, 3);
    identical(head1, head2) ? printf("Identical \n") : printf("Not identical \n");
    struct node *head3 = NULL;
    struct node *head4 = NULL;
    insert_end(&head3, 1);
    insert_end(&head3, 2);
    insert_end(&head3, 3);
    insert_end(&head4, 1);
    insert_end(&head4, 2);
    insert_end(&head4, 3);
    insert_end(&head4, 5);
    identical(head3, head4) ? printf("Identical \n") : printf("Not identical \n");
}


