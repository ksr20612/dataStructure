function Dictionary() {

    const item = {};

    this.set = function(key,value) {
        item.key = value;
    }
    this.remove = function() {
        if(this.has(key)){
            delete item.key;
            return true; 
        }
        return false;
    }
    this.has = function(key) {
        return item.hasOwnProperty(key);
    }
    this.get = function(key) {
        if(this.has(key)){
            return item.key;
        }
        return false;
    }
    this.clear = function() {
        item = {};
    }
    this.size = function() {
        return this.keys().length();
    }
    this.keys = function() {
        return item.keys();
    }
    this.values = function() {
        const temp = [];
        for(const val in item) {
            temp.push(item.val);
        }   
        return temp;
    }
}

const dict = new Dictionary();