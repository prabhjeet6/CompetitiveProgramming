package leetcode;



// Definition for a CustomNode.

class CustomNode {
    public int val;
    public leetcode.CustomNode prev;
    public leetcode.CustomNode next;
    public leetcode.CustomNode child;
}

class FlattenAMultilevelDoublyLinkedList {
    
    public CustomNode flatten(CustomNode head) {
        CustomNode temp=head;
        while(temp!=null){
            if(temp.child!=null){
                CustomNode nextOfTemp=temp.next;
                temp.next=temp.child;
                CustomNode child=temp.child;
                child.prev=temp;
                while(child!=null){
                    if(child.next==null){
                        break;
                    }
                    child=child.next;
                }
                if(nextOfTemp!=null){
                    nextOfTemp.prev=child;
                    child.next=nextOfTemp;
                }
            }
            temp.child=null;
            temp=temp.next;
        }
        return head;
    }
}