class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* temp=head;
        set<int> values;
        set<int>::iterator itr;
        
        if(head == NULL)
            return head;
        
        //copy the values of each item in the list to a set 
        while(temp!=NULL)
        {
            values.insert(temp->val);
            temp=temp->next;
        }
        
        //iterate through the list and the set to overwrite the list with the set values.
        temp=head;
        for (itr = values.begin(); itr != values.end(); itr++)
        {
            temp->val = *itr;
            temp=temp->next;
        }
        
        //traverse to the last updated item and make it point to NULL
        temp=head;
        for (int i=1; i <values.size(); i++)
            temp=temp->next;
        
        temp->next=NULL;
        
        //return the updated list
        return head;
    }
};