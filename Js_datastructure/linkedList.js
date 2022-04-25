function LinkedList(...args){

    let head = null;
    let length = 0;
    const Node = function(element) {
        this.element = element;
        this.next = null;
    }

    this.append = function(element){
        if(head){
            let current = head; // 현재 위치
            while(current.next){
                current = current.next;
            }
            current.next = new Node(element);
        }else {
            head = new Node(element);
        }
        length++;
    }
    this.insert = function(position, element){
        if(position >= 0 && position <= length){
            if(position === 0) {
                const temp = head;
                head = new Node(element);
                head.next = temp;
            }else {
                let current = head;
                for(let i=0;i<position-1;i++) {
                    current = current.next;
                }
                const temp = current.next;
                current.next = new Node(element);
                current.next.next = temp;
            }
            length++;
        }else {
            return new Error("invalid position");
        }
    }
    this.removeAt = function(position){
        if(position >= 0 && position <= length) {
            if(position === 0) {
                head = head.next;
            }else {
                let current = head;
                for(let i=0;i<position-1;i++){
                    current = current.next
                }
                current.next = current.next.next;
            }
            length--;
        }else {
            return new Error("invalid position");
        }
    }
    this.remove = function(element){
        let current = head;
        let previous = null;
        while(current){
            if(current.element === element) {
                if(previous){
                    previous.next = current.next;
                }else {
                    head = current.next;
                }
                length--;
            }
            previous = current;
            current = current.next;
        }
        return new Error("invalid element");
    }
    this.indexOf = function(element){
        let current = head;
        while(current){
            if(current.element === element) {
                return current.element;
            }
            current = current.next;
        }
        return -1;
    }
    this.isEmpty = function(){
        return length === 0;
    }
    this.size = function(){
        return length;
    }
    this.toString = function(){
        let temp;
        let current = head;
        while(current){
            temp += current.item;
            current = current.next;
        }
        return temp;
    }
    this.print = function(){
        let current = head;
        while(current){
            console.log(current.element);
            current = current.next;
        }
    }

}

function HashTable() {
    const items = [];
    const valuePair = function(key, element) {
        this.key = key;
        this.element = element;
    }
    const hash = function(key) {
        return key.split("").reduce((prev,cur)=>{return prev+cur.charCodeAt(0)},0)%37;
    }

    this.put = function(key, element) {
        const loc = hash(key);
        console.log(loc);
        if(!items[loc]) {
            items[loc] = new LinkedList();
        }
        const pair = new valuePair(key,element);
        items[loc].append(pair);
        console.log(items[loc]);
    }

    this.print = function(){
        
    }
}

const table = new HashTable();
table.put("ethan",28);
table.put("john",30);