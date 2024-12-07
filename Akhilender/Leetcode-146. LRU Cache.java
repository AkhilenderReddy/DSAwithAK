
class DLL{
    int key;
    int val;
    DLL next;
    DLL prev;
    public DLL(int key,int val){
        this.key=key;
        this.val=val;
        next=null;
        prev=null;
    }
}
class LRUCache {
    HashMap<Integer,DLL> lru;
    int cap=0;
    DLL head,tail,curr;
    public LRUCache(int capacity) {
        lru=new HashMap<>(capacity);
        cap=capacity;
        System.out.println(lru.size());
        head=new DLL(-1,-1);
        tail=new DLL(-1,-1);
        head.next=tail;
        tail.prev=head; 
    }
    public void add(DLL node){
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;    

    }
    public void del(DLL node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
        node.next=null;
        node.prev=null;
    }
    public int get(int key) {
        if(lru.containsKey(key)){
            DLL res=lru.get(key);
            int ans=res.val;
            del(res);
            add(res);
            curr=res;
            // System.out.println("------GET-------");
            // DLL trav=head;
            // while(trav!=null){
            //     System.out.println(trav.key);
            //     trav=trav.next;
            // }
            // System.out.println("-----------------");  
            return ans;

        }else{
            return -1;
        }  
         
    }
    
    public void put(int key, int value) {
        if(lru.containsKey(key)){
            DLL res=lru.get(key);
            res.val=value;
            del(res);
            add(res);            
        }else{
            if(cap==lru.size()){
                lru.remove(tail.prev.key);
                del(tail.prev); 
            }
                DLL newNode=new DLL(key,value);
                lru.put(key,newNode);
                add(newNode);
        }
        DLL trav=head;
        // System.out.println("------POST-------");
        // while(trav!=null){
        //     System.out.println(trav.key);
        //     trav=trav.next;
        // }
        // System.out.println("-------------------------");

        
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */