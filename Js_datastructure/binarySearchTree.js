function BinarySearchTree() {

    const Node = function(key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
    const insertNode = function(node, newNode) {
        if(node.key > newNode.key){
            // 달아주는 시점
            if(node.left){
                insertNode(node.left,newNode);
            }else {
                node.left = newNode;
            }
        }else {
            // 달아주는 시점
            if(node.right) {
                insertNode(node.right,newNode);
            }else {
                node.right = newNode;
            }
        }
        
    }
    const inOrderTraverseNode = function(node, callback) {
        if(node) {
           inOrderTraverseNode(node.left,callback);
           callback(node.key);
           inOrderTraverseNode(node.right,callback);
        }
    }
    const preOrderTraverseNode = function(node, callback) {
        if(node) {
            callback(node.key);
            preOrderTraverseNode(node.left,callback);
            preOrderTraverseNode(node.right,callback);
        }
    }
    const postOrderTraverseNode = function(node, callback) {
        if(node) {
            postOrderTraverseNode(node.left,callback);
            postOrderTraverseNode(node.right,callback);
            callback(node.key);
        }
    }
    const minNode = function(node) {
        return node.left? minNode(node.left) : node;
    }
    const maxNode = function(node) {
        return node.left? maxNode(node.right) : node;
    }
    const searchNode = function(node, key) {
        if(!node) return false; // node가 존재하지 않는 경우 false 

        if(node.key === key) {
            return node;
        }else if(node.key < key){
            return searchNode(node.right, key);
        }else {
            return searchNode(node.left, key);
        }
    }
    const removeNode = function(root, key) {
        const target = searchNode(root,key);
        if(target){
            
        }else {
            return false;
        }

    }
    let root = null;

    this.insert = function(key) {
        const node = new Node(key);
        if(root){
            insertNode(root,node);
        }else {
            root = node;
        }
    }
    this.search = function(key) {
        return searchNode(root,key);
    }
    this.inOrderTraverse = function(callback) {
        inOrderTraverseNode(root,callback);
    }
    this.preOrderTraverse = function(callback) {
        preOrderTraverseNode(root,callback);
    }
    this.postOrderTraverse = function(callback) {
        postOrderTraverseNode(root,callback);
    }
    this.min = function() {
        return console.log(minNode(root));
    }
    this.max = function() {
        return console.log(maxNode(root));
    }
    this.remove = function(key) {
        root = removeNode(root, key);
    }
    this.print = function() {
        console.log(root);
    }
}

const tree = new BinarySearchTree();
tree.insert(3);
tree.insert(5);
tree.insert(6);
tree.insert(1);
tree.insert(2);
tree.insert(4);
