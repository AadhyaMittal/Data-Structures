//add 1 to the linked list.
/*Number is represented in linked list such that each digit corresponds to a node in linked list.
 Add 1 to it. For example 1999 is represented as (1-> 9-> 9 -> 9) and adding 1 to it should change it to (2->0->0->0)*/

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

void add1(struct node **head)
{
    struct node *temp = *head;
    int carry = 1;
    int raw;
    while(temp != NULL)
    {
        raw = temp -> data + carry;
        if(raw > 9)
        {
            temp -> data = raw % 10;
            carry = raw / 10;
        }
        else
        {
            temp -> data = raw;
            carry = 0;
        }
        temp = temp -> next;
    }
}

int main()
{
    struct node *head = NULL;
    print(head);
    insert_end(&head, 1);
    insert_end(&head, 9);
    insert_end(&head, 9);
    insert_end(&head, 9);
    print(head);
    printf("\n");
    reverse(&head);
    add1(&head);
    reverse(&head);
    print(head);
    printf("\n");
    struct node *head2 = NULL;
    print(head2);
    insert_end(&head2, 8);
    insert_end(&head2, 9);
    insert_end(&head2, 7);
    insert_end(&head2, 8);
    print(head2);
    printf("\n");
    reverse(&head2);
    add1(&head2);
    reverse(&head2);
    print(head2);
}


