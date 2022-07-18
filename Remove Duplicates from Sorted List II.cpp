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
    ListNode* deleteDuplicates(ListNode* head) {
        //two pointers 
        ListNode *p1 = head, *p2;
        //to store intermediate value
        int val;
        
        //preconditions
        if(head==NULL)
            return NULL;
        
        else if(head->next == NULL)
            return head;
        
        else if(head->next->next == NULL)
            return removeTwoDuplicate(head);
        
        //start p1 from head and p2 one node away from p1 (p1 -> a node -> p2)  
        p2 = p1->next->next;
        //store the value of the node between them
        val = p1->next->val;
        //booleans to check if p2 is pointing to a duplicate and the same with p1
        bool isFoundp2 = false, isFoundp1 = false;
        //iterate and delete duplicates until p2 is NULL
        while(p2!=NULL)
        {
            //if duplicate is found 
            if(val == p2->val)
            {
                //if p1 and p2 are pointing to the same number, move p2 but indicate that p1 is pointing to a duplicate
                if(p1->val == p2->val)
                {
                    isFoundp1 = true;
                    //if p2 is the last node, which means all of them are duplicates of the same number, delete all the nodes and return NULL 
                    if(p2->next==NULL)
                        return NULL;
                    p2=p2->next;
                }
                //else move p2 also but indicate that  p2 is pointing to a duplicate
                else
                {
                    isFoundp2=true;
                    //if p2 is the last node then make p1 point to NULL and break out of the loop 
                    if(p2->next==NULL)
                    {
                        p1->next = NULL;
                        break;
                    }
                    p2=p2->next;
                }
            }
            //if no duplicate is found, delete the duplicates that are already found if it exist.
            else
            {
                //if p1 is pointing to a duplicate, make p1 point to the node p2 is pointing too, and adjust the head pointer also, and move p2  
                if(isFoundp1)
                {
                    isFoundp1=false;
                    p1 = p2;
                    head = p1;
                    //if it is the last node return it
                    if(head->next==NULL)
                        return head;
                    //if there are last two nodes left, remove them if they are duplicates and get out of the loop
                    else if(head->next->next==NULL)
                        return removeTwoDuplicate(head);
                    
                    p2=p2->next;
                }
                //if p2 is pointing to a duplicate, make the node next to p1 point to the node p2 is pointing too
                else if(isFoundp2)
                {
                    isFoundp2=false;
                    p1->next = p2;
                }
                //else move p1 
                else
                    p1=p1->next;
                //move p2 and store the value of the node between p1 and p2
                val = p2->val;
                p2=p2->next;                    
            }
        }
        //if there are reamining two nodes delete them if they are duplicates 
        if(head->next !=NULL && head->val == head->next->val)
            head = head->next->next;
        //return the updated list
        return head;
    }
    
    //remove a duplicate(if two only, i.e - 1,1,3,4,5) from beginning of the list 
    ListNode* removeTwoDuplicate(ListNode* head)
    {
        if(head->val == head->next->val)
        {
            head = NULL;
            return head;
        }
        return head;
    }
};