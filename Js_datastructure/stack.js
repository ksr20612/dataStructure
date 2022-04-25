class Stack {
    constructor() {
        this.data = [];
    }
    pop(){
        return this.data.pop();
    }
    push(item){
        for(let i=0;i<=this.data.length;i++){
            if(!this.data[i]) {
                return this.data[i] = item;
            }
        }
        return this.data.push(item);
    }
    peek(){
        return this.data[this.data.length-1];
    }
    isEmpty () {
        return this.data.length === 0;
    }
    clear() {
        return this.data = [];
    }
    get length(){
        return this.data.length;
    }
    indexOf(item){
        for(let i=0;i<=this.data.length-1;i++){
            if(this.data[i]===item) {
                return i;
            }
        }
        return null;
    }
}

const mystack = new Stack(5);
console.log(mystack);
mystack.push(1);
console.log(mystack);
mystack.push(3);
mystack.push(5);

console.log(mystack.length());
console.log(mystack.pop());
console.log(mystack.indexOf(3));
