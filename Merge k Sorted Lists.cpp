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

//USING TWO POINTERS
class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        
        //if list of array is empty return NULL
        if(lists.size() == 0)
            return NULL;
        
        //return the merged list
        return merge(lists, 0, lists.size()-1);
    }
    
    //method to get the merged list
    ListNode* merge(vector<ListNode*>& lists, int s, int e)
    {
        //divide and conquer approach
        if (s<e)
        {
            //divide part
            int q = (s+e)/2;
            ListNode* list1 = merge(lists, s, q);
            ListNode* list2 = merge(lists, q+1, e);
            
            //merge two lists
            
            //temp1 - pointer to list1, temp2 - pointer to list2, temp3 - pointer to mergedList, mergedList - new linked list to store merged List
            ListNode *temp1 = list1, *temp2 = list2, *temp3 = NULL, *mergedList = NULL;
            
            //the same with mergesort approach
            //conquer part
            while(temp1!=NULL && temp2!=NULL)
            {
                if(temp1->val <= temp2->val)
                {
                    //copy node to mergedList
                    if (mergedList == NULL)
                    {
                        mergedList = new ListNode;
                        mergedList->val = temp1->val;
                        mergedList->next = NULL;
                        temp3 = mergedList;
                    }
                    else
                    {
                        temp3->next = new ListNode;
                        temp3 = temp3->next;
                        temp3->val = temp1->val;
                        temp3->next = NULL;
                    }
                    
                    temp1 = temp1->next;
                }
                else
                {                    
                    if (mergedList == NULL)
                    {
                        mergedList = new ListNode;
                        mergedList->val = temp2->val;
                        mergedList->next = NULL;
                        temp3 = mergedList;
                    }
                    else 
                    {
                        temp3->next = new ListNode;
                        temp3 = temp3->next;
                        temp3->val = temp2->val;
                        temp3->next = NULL;
                    }
                    
                    temp2 = temp2->next;
                }
                
            }

            
            //add the remaining nodes to the mergedList
            while(temp1!=NULL)
            {                
                if (mergedList == NULL)
                {
                    mergedList = new ListNode;
                    mergedList->val = temp1->val;
                    mergedList->next = NULL;
                    temp3 = mergedList;
                }
                else 
                {
                    temp3->next = new ListNode;
                    temp3 = temp3->next;
                    temp3->val = temp1->val;
                    temp3->next = NULL;
                }
                
                temp1 = temp1->next;
            }

            while(temp2!=NULL)
            {
                if (mergedList == NULL)
                {
                    mergedList = new ListNode;
                    mergedList->val = temp2->val;
                    mergedList->next = NULL;
                    temp3 = mergedList;
                }
                else 
                {
                    temp3->next = new ListNode;
                    temp3 = temp3->next;
                    temp3->val = temp2->val;
                    temp3->next = NULL;
                }
                
                temp2 = temp2->next;
                // temp3 = temp3->next;   
            }
            
            //return the merged List
            return mergedList;
        }
        
        //base case
        else
            return lists[s];
    }
};





//USING HEAP
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        //if list of array is empty return NULL
        if(lists.length == 0)
            return null;
        
        //min Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); 
        
        //copy values of lists to minHeap
        for(int i=0; i<lists.length; i++)
        {
            ListNode temp = lists[i];
            while(temp!=null)
            {
                minHeap.add(temp.val);
                temp = temp.next;
            }
        }
        
        //initialize pointers
        ListNode mergedList = null, temp2 = null;
        
        //keep polling items from min heap and add it to the new list(mergedList)
        while(minHeap.size() != 0)
        {
            int val = minHeap.poll();
            
            //copy node to mergedList
            if (mergedList == null)
            {
                mergedList = new ListNode();
                mergedList.val = val;
                mergedList.next = null;
                temp2 = mergedList;
            }
            else
            {
                temp2.next = new ListNode();
                temp2 = temp2.next;
                temp2.val = val;
                temp2.next = null;
            }
        }
        
        //return the merged list
        return mergedList;
    }
}
