function Set() {
    const item = {};

    this.add = function(element){
        return this.has(element)? -1 : item[element] = element;
    }
    this.remove = function(element) {
        return this.has(element)? delete item[element] : -1;
    }
    this.has = function(element){
        return item.hasOwnProperty(element);
    }
    this.clear = function(){
        return item = {};
    }
    this.size = function(){
        return item.length;
    }
    this.values = function() {
        return Object.keys(item);
        // return Object.values(item);
    }
}