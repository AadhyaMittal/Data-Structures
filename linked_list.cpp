//To print the elements of a LINKED LIST

/*
  Print elements of a linked list on console 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  struct Node
  {
     int data;
     struct Node *next;
  }
*/

void Print(Node *head)
{
  // This is a "method-only" submission. 
  // You only need to complete this method.
    struct Node *ptr;
    ptr = head;
    while(ptr != NULL)
    {
        cout<<ptr->data<<endl;
        ptr = ptr->next;
    }
}
