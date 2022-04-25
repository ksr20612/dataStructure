class Queue {
    constructor(){
        this.data = [];
    }
    dequeue(){
        const item = this.data[0];
        this.data = this.data.filter((v,i)=>i!==0);
        return item;
    }
    enqueue(item){
        this.data.push(item);
    }
    front() {
        return this.data[0];
    }
    front() {
        return this.data.length === 0;
    }
    get length(){
        return this.data.length;
    }
    indexOf(item){
        for(let i=0;i<=this.data.length-1;i++){
            if(this.data[i]===item){
                return i;
            }
        }
        return null;
    }
}

const myqueue = new Queue();
myqueue.push(1);
myqueue.push(3);
myqueue.push(5);

console.log(myqueue.pop());
console.log(myqueue.length());
console.log(myqueue.indexOf(3));
console.log(myqueue.indexOf(1));