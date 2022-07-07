/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        //counter when traversign the list
        int i=1;
        //pointers to traverse throught the list
        ListNode *temp=head, *prev=NULL;

        //linked list size counter
        int N = 0;
        //count the size of the list
        while(temp!=NULL)
        {
            temp=temp->next;
            N++;
        }
        
        //if size is 1 delete the single node and return NULL
        if(N==1)
        {
            delete head;
            return NULL;
        }
        
        //traverse through the list until the desired node is found 
        temp=head;
        int m = N-n+1;
        //if the first node is to be deleted, then shift the head
        if(m==1)
        {
            head = temp->next;
            delete temp;
            return head;
        }
        while(i<m)
        {
            prev = temp;
            temp=temp->next;
            i++;
        }
        //delete that node and maintain the chain
        prev->next = temp->next;
        delete temp;
        
        //return the updated list
        return head;
    }
};