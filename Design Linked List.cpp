class MyLinkedList {
private:
    //create a node structure
    struct Node
    {
        int val;
        Node* next;
    };
    
    Node* head;
    int length;

public:

    //initialize head and length
    MyLinkedList() {
        head = NULL;
        length=0;
    }
    
    int get(int index) {
        //traverse through list until i == index or until end of list and return the result
        Node* temp = head;
        int i = 0;
        while(temp!=NULL)
        {
            if(i == index)
                return temp->val;
            i++;
            temp = temp->next;
        }
        return -1;
    }
    
    void addAtHead(int val) {
        //add node to head, if list is empty just assign head to the node
        if(head == NULL)
        {
            head = new Node;
            head->val = val;
            head->next = NULL;
        }
        else
        {
            Node* temp = new Node;
            temp->val = val;
            temp->next = head;
            head = temp;
        }
        
        //increment length
        length++;
    }
    
    void addAtTail(int val) {
        //add node at the end of list, if list is empty, then assign head to new node
        if(head == NULL)
        {
            head = new Node;
            head->val = val;
            head->next = NULL;
        }
        
        else
        {
            Node* temp = head;
            while(temp->next != NULL)
                temp=temp->next;
            Node* temp2 = new Node;
            temp2->val = val;
            temp2->next = NULL;
            temp->next = temp2;
        }
        
        //increment length
        length++;
    }
    
    void addAtIndex(int index, int val) {
        //add node to specific index, if index == length then add node at tail
        if(index == length)
            addAtTail(val);

        //else add node at the given index
        else if(index < length)
        {
            //if index == 0 then add node at head
            if(index == 0)
                addAtHead(val);
            
            //else use two pointers to put node at given index
            else
            {
                int i=1;
                Node *p1=head, *p2 = head->next;
                while(i!=index)
                {
                    p1=p2;
                    p2=p2->next;
                    i++;
                }
                Node* temp = new Node;
                temp->val = val;
                temp->next = p2;
                p1->next = temp;
                
                //increment length
                length++;
            }
        }
    }
    
    void deleteAtIndex(int index) {
        //delete node, if list is empty or index is invalid, then tehre is nothing to delete
        if(head == NULL || index >= length)
            return;
        
        //else delete a node at given index
        else
        {
            //if there is only one node, then just assign head to null
            if(head->next == NULL)
                head = NULL;
            
            //else delete specific node
            else
            {
                //if index i== 0, move the head pointer one step forward
                if(index == 0)
                    head = head->next;
                
                //else, use two pointers to delete the node
                else
                {
                    int i=1;
                    Node *p1=head, *p2=head->next;
                    while(i!=index)
                    {
                        p1=p2;
                        p2=p2->next;
                        i++;
                    }
                    p1->next = p2->next;
                }
            }
            
            //decrement length
            length--;
        }
    }
};

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList* obj = new MyLinkedList();
 * int param_1 = obj->get(index);
 * obj->addAtHead(val);
 * obj->addAtTail(val);
 * obj->addAtIndex(index,val);
 * obj->deleteAtIndex(index);
 */