class Node(val name: String, val next: Node? = null)

val node = Node("A", Node("B", Node("C", Node("D", Node("E")))))

fun main(args: Array<String>) {
    printNode(node) // Output: A->B->C->D->E->
    remove(node, 2)?.let {
        printNode(it) // Output: A->B->D->E-> (C will be removed)
    }
}

fun printNode(node: Node) {
    var tmp: Node? = node
    while (tmp != null) {
        print("${tmp.name}->")
        tmp = tmp.next
    }
    println("")
}

fun remove(node: Node, index: Int): Node? {
     var front:Node?=null
     var delete:Node=node
     if(index==0){
       return node.next
     }
     for(i in 1..index){
       front=delete
       if(delete.next!=null){
           delete=delete.next!!
       } else{
           throw IllegalArgumentException("no such element")
       }

     }

     if(front!=null){
         val nodeClass=Class.forName("Node")
         val next=nodeClass.getDeclaredField("next")
         next.isAccessible=true
         next.set(front,delete.next)
     }

    return node
}