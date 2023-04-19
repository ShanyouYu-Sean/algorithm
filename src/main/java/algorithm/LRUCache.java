package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU：
 * 哈希表 + 双向链表
 * put时，存在就 moveToHead，不存在就 addToHead，超了容量就 removeTail
 * get时，moveToHead
 */
class LRUCache {

    // LRU：哈希表 + 双向链表
    // put时，存在就 moveToHead，不存在就 addToHead，超了容量就 removeTail
    // get时，moveToHead
    class Node {
        int key, val;
        Node next, pre;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
        public Node(){ }
    }
    int capacity;
    Map<Integer, Node> map = new HashMap<>();
    Node dummyHead = new Node();
    Node dummyTail = new Node();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)){
            Node node = new Node(key, value);
            map.put(key, node);
            addToHead(node);
            if (map.size() > capacity){
                map.remove(dummyTail.pre.key);
                removeTail();
            }
        }else {
            Node node = map.get(key);
            node.val = value;
            moveToHead(node);
        }
    }

    private void moveToHead(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        addToHead(node);
    }

    private void addToHead(Node node){
        Node formerHead = dummyHead.next;
        dummyHead.next = node;
        node.pre = dummyHead;
        node.next = formerHead;
        formerHead.pre = node;
    }

    private void removeTail(){
        Node formerTail = dummyTail.pre;
        dummyTail.pre = formerTail.pre;
        formerTail.pre.next = dummyTail;
        formerTail.pre = null;
        formerTail.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */