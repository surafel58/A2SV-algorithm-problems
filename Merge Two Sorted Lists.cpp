class Solution {
public:
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        //a vector used to put the sorted result
        vector<int> sorted_result;
        //pointers to traverse through the lists
        ListNode* temp1=list1;
        ListNode* temp2=list2;
        //if both lists are empty, return null
        if(temp1==NULL && temp2==NULL)
           return NULL;
           
        //else, iterate through both lists to put the values of each list into the vector in sorted manner until one of them are finished being iterated
        while(temp1!=NULL && temp2!=NULL)
        {
            //conditions used to put the values of the lists in the vector in sorted manner
            if(temp1->val <= temp2->val)
            {
                sorted_result.push_back(temp1->val);
                temp1 = temp1->next;
            }
            else
            {
                sorted_result.push_back(temp2->val);
                temp2 = temp2->next;
            }
        }

        //if there are some values of the lists left unstored in the vector add them to it
        while(temp1!=NULL)
        {
            sorted_result.push_back(temp1->val);
            temp1 = temp1->next;
        }

        while(temp2!=NULL)
        {
            sorted_result.push_back(temp2->val);
            temp2 = temp2->next;
        }
        
        //put new nodes in a new list with corresponding values in the vector 
        ListNode* head = new ListNode;
        ListNode *temp3 = head;
        ListNode *prev = NULL;
        
        //iterate through the vector to copy the values of it into the new created list
        for(int i=0; i<sorted_result.size(); i++)
        {
            temp3 -> val = sorted_result[i];
            temp3 -> next = new ListNode;
            prev = temp3;
            temp3 = temp3 -> next;   
        }
        prev -> next = NULL;
        
        //return the new list
        return head;
    }
};