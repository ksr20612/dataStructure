// 체이닝, 선형탐색법
function HashTable() {
    const table = [];
    const hashCode = function(key) {
        return key.split("").reduce((prev,cur)=>{return prev+cur.charCodeAt(0)},0)%37;
    }

    this.put = function(key,value) {
        table[hashCode(key)] = value;
    }
    this.remove = function(key) {
        table[hashCode(key)] = undefined;
    }
    this.get = function(key) {
        return table[hashCode(key)]
    }
    this.hash = function(key) {
        return hashCode(key);
    }

}

const table = new HashTable();
console.log(table.hash("유동연"));