function PriorityQueue() {
    
    const items = [];
    
    this.enqueue = function(elem, prior){
        const element = {
            "element" : elem,
            "priority" : prior
        };
        if(items.length){
            for(let i=0;i<items.length;i++) {
                if(element.priority < items[i].priority){
                    return items.splice(i,0,element);
                }
            }
            return items.push(element);
        }else {
            items.push(element);
        }
    }
    this.print = function(){
        console.log(items);
    }

};

const data = new PriorityQueue();
data.enqueue("kim",2);
data.enqueue("jane",3);
data.enqueue("ethan",1);
console.log("+++++++++++++");
data.print();
console.log(data.items);