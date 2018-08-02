package com.me.cl.java.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by CL on 7/30/18.
 */
public class tree {
    private static int count = 0;

    public static void main(String[] args) {
        NQueen(8);
    }
//    Using a regular chess board, the challenge is to place eight queens on the board such that no queen is attacking any of the others. (For those not familiar with chess pieces, the queen is able to attack any square on the same row, any square on the same column, and also any square on either of the diagonals).
//    Using BFS Recursive, iterative and DFS recursive, iterative
    public static void NQueen(int n) {
        DFSRecursive(n, -1, -1, new int[n]);
        System.out.println("DFSRecursive:"+count);
        count = 0;
        DFSIterative(n);
        System.out.println("DFSIterative:"+count);
        count=0;
        BFSRecursive(n);
        System.out.println("BFSRecursive:"+count);
        count=0;
        BFSIterative(n);
        System.out.println("BFSIterative:"+count);
    }

//    DFS Recursive solution -- start
    private static void DFSRecursive(int n, int decisionLevel, int decision, int[] decisionArray) {
        if (decisionLevel == -1 || checkVaild(decisionLevel, decision, decisionArray)) {
            if (decisionLevel >= 0) {
                decisionArray[decisionLevel] = decision;
            }
            if (decisionLevel >= n - 1) {
                count++;
//                    printResult(n,decisionArray);
                return;
            }
            for (int i = 0; i < n; i++) {
                DFSRecursive(n, decisionLevel + 1, i, decisionArray);
            }
        }


    }

    private static boolean checkVaild(int decisionLevel, int decision, int[] decisionArray) {
        for (int i = 0; i < decisionLevel; i++) {
            if (decisionArray[i] == decision || Math.abs(decision - decisionArray[i]) == decisionLevel - i) {
                return false;
            }
        }
        return true;
    }

    private static void printResult(int n, int[] validArray) {
        System.out.println();
        for (int i : validArray) {
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    System.out.print(" Q ");
                } else {
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }
        System.out.println();

    }

//    DFS Recursive solution -- end

//    DFS Stack solution -- start
    private static void DFSIterative(int n) {
        Stack<Node> backStack = new Stack<>();
        Node root = new Node(-1,true);
        backStack.push(root);
        while (backStack.size() > 0) {
            Node top = backStack.peek();
            boolean shouldPop=true;
            for (int i = 0; i < n; i++) {
                Node child = top.getChildAt(i);
                if (child == null) {
                    Node node=new Node(i,true);
                    top.addChild(node);
                    if(isValid(backStack,node)){
                        backStack.push(node);
                        shouldPop=false;
                        break;
                    }
                } else if(!child.isVisited()){
                    child.setVisited(true);
                    if(isValid(backStack,child)){
                        backStack.push(child);
                        shouldPop=false;
                        break;
                    }
                }
            }

            if(backStack.size()==n+1){
                count++;
                backStack.pop();
            }else if(shouldPop){
                backStack.pop();
            }
        }
    }

    private static boolean isValid(Stack decisions, Node current) {
        Stack<Node> temp = (Stack) decisions.clone();
        int totalLevels = temp.size() - 1;
        for (int i = 0; i < totalLevels; i++) {
            Node last = temp.pop();
            if (last.getCurrentValue() == current.getCurrentValue() || Math.abs(current.getCurrentValue() - last.getCurrentValue()) == i + 1) {
                return false;
            }
        }
        return true;
    }

    public static class Node {
        int currentValue = -1;
        List<Node> children;

        boolean visited;

        public Node(int currentValue, boolean visited) {
            children = new ArrayList<>();
            this.currentValue=currentValue;
            this.visited=visited;
        }

        public int getCurrentValue() {
            return currentValue;
        }

        public boolean isVisited() {
            return visited;
        }

        public void addChild(Node child) {
            if (!children.contains(child)) {
                children.add(child);
            }
        }

        public Node getChildAt(int index) {
            if (children.size() - 1 < index || index < 0) {
                return null;
            } else {
                return children.get(index);
            }
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }
    }

//    DFS Stack solution -- end

//    BFS Recursive -- start
    public static void BFSRecursive(int n){
        List<Node2> children=new ArrayList();
        for(int i=0;i<n;i++){
            children.add(new Node2(i,null));
        }
        BFSRecursive(n,children);
    }

    public static void BFSRecursive(int n, List<Node2> children){
        List<Node2> descChildern=new ArrayList<>();
        for(Node2 child:children){
            if(isValid(child,n)){
                List<Node2> directchildren=new ArrayList();
                for(int i=0;i<n;i++){
                    directchildren.add(new Node2(i,child));
                }
                descChildern.addAll(directchildren);
            }
        }
        if(descChildern.size()>0){
            BFSRecursive(n,descChildern);
        }
    }

    private static boolean isValid(Node2 node,int n){
        int offset=1;
        Node2 ancesNode=node.parent;
        while(ancesNode!=null){
            if(node.currentValue==ancesNode.currentValue||Math.abs(ancesNode.currentValue-node.currentValue)==offset){
                return false;
            }
            ancesNode=ancesNode.parent;
            offset++;
        }
        if(offset==n){
            count++;
            return false;
        }
        return true;
    }

public static class Node2 {
    public int currentValue = -1;
    public Node2 parent;

   public Node2(int currentValue, Node2 parent){
       this.currentValue=currentValue;
       this.parent=parent;
   }
}
//    BFS Recursive -- end


//    BFS queue -- start
    public static void BFSIterative(int n){
        Queue<Node2> backQueue=new LinkedList<>();
        for(int i=0;i<n;i++){
            backQueue.offer(new Node2(i,null));
        }
        while(backQueue.size()>0){
            Node2 first=backQueue.poll();
            for(int i=0;i<n;i++){
                Node2 current=new Node2(i,first);
                if(isValid(current,n)){
                    backQueue.offer(current);
                }
            }
        }
    }


//    BFS queue -- end


}
