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
    bool isPalindrome(ListNode* head) {
        ListNode* temp=head;
        vector<int> values;
        
        //copy each list value into a vector
        while(temp!=NULL)
        {
            values.push_back(temp->val);
            temp=temp->next;
        }
        
        //compare the list values to the values in the vector starting from the end to check if it is palindrome
        temp=head;
        int i=0;
        while(temp!=NULL)
        {
            //if there exist some values that are not equal, then it is not palindrome 
            if(temp->val != values[(values.size()-1)-i])
                 return false;
            
            i++;
            temp=temp->next;
        }
        
        //if all values are equal it is palindrome
        return true;
    }
};