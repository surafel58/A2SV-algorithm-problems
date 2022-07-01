class Solution {
public:
    void deleteNode(ListNode* node) {
        //temp pointer that points to the node next to the node to be deleted
        ListNode* temp;
        //swap the values of the node to be deleted and the node next to it
        temp = node->next;
        int value = node->val;
        node->val = temp->val;
        temp->val = value;
        //connect the linked list
        node->next = temp->next;
        //delete the node
        delete temp;
    }
};