package tads.BST;

import java.util.Iterator;

import tads.Queue.*;

public class AVL<T extends Comparable<T>> implements BST<T> {

    class Node{
        T data=null;
        Node left=null;
        Node right=null;
        int height=1;
    }

    private Node root=null;
    private int elements=0;

    @Override
    public boolean contains(T data) {
        Node aux=root;
        while(aux!=null){
            if(data.equals(aux.data)) return true;

            if(data.compareTo(aux.data)>0){
                aux=aux.right;
            }
            else aux=aux.left;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return elements==0;
    }

    @Override
    public void insert(T data) {
        root=insert(root,data);
    }

    @Override
    public void remove(T data) {
        root=remove(root, data);        
    }

    @Override
    public int height() {
        return height(root);
    }

    @Override
    public int size() {
        return elements;
    }

    /* ----------------------
          PRIVATE FUNCTIONS
       ---------------------- */


    private int height(Node n){
        if(n==null)return 0;
        else return n.height;
    }
    private Node insert(Node node,T data){
        if(node==null){
            Node newNode= new Node();
            newNode.data=data;    
            elements++;
            return newNode;
        }
        if(data.equals(node.data))return node;
        if(data.compareTo(node.data)> 0){
            node.right=insert(node.right,data);
        }
        else node.left=insert(node.left,data);

        node.height=1+max(height(node.left),height(node.right));
        
        
        int bF = balanceFactor(node);
        
        // desbalance derecha-*
        if (bF > 1) {
        // derecha-derecha
            if (data.compareTo(node.right.data) > 0) {
                return leftRotation(node);
            }
            // derecha-izquierda
            else {
                node.right=rightRotation(node.right);
                return leftRotation(node);
            }
        }
        // desbalance izquierda-*
        else if (bF < -1) {
        // izquierda-izquierda
            if (data.compareTo(node.left.data) < 0) {
                return rightRotation(node);
            }
            // izquierda-derecha
            else {
                node.left=leftRotation(node.left);
                return rightRotation(node);
            }
        }
        return node;
    }
    private Node remove(Node node,T data){
        // 1) DELETE STRUCTURLY NODE
        if(node==null)return null;

        if(node.data.compareTo(data)>0){
            node.left= remove(node.left,data);
        }
        else if(node.data.compareTo(data)<0){
            node.right= remove(node.right,data);
        }
        else{
            if(node.left!=null && node.right!=null){
                Node minNode=min(node.right);
                node.data=minNode.data;
                node.right=remove(node.right,minNode.data);
            }
            else{
                if(node.left==null && node.right==null) node=null;
                else if(node.left!=null) node=node.left;
                else node=node.right;

                elements--;
            }
        }
        if(node==null)return null;
        
        // 2) UPDATE HEIGH
        node.height=max(height(node.right),height(node.left));

        // 3) BALANCE
        int bF = balanceFactor(node);
        
        // desbalance derecha-*
        if (bF > 1) {
        // derecha-derecha
            if (balanceFactor(node.right)>0) {
                return leftRotation(node);
            }
            // derecha-izquierda
            else {
                node.right=rightRotation(node.right);
                return leftRotation(node);
            }
        }
        // desbalance izquierda-*
        else if (bF < -1) {
        // izquierda-izquierda
            if (balanceFactor(node.left) < 0) {
                return rightRotation(node);
            }
            // izquierda-derecha
            else {
                node.left=leftRotation(node.left);
                return rightRotation(node);
            }
        }
        return node;
    }
    private Node min(Node node){
        if(node==null)return null;
        while(node.left!=null) node=node.left;
        return node;
    }
    private int max(int a, int b){
        if(a>b) return a;
        else return b;
    }
    private int balanceFactor(Node n){
        return height(n.right)-height(n.left);
    }
    private Node rightRotation(Node z){

        Node y = z.left;
        Node yr=y.right;

        y.right=z;
        z.left=yr;

        z.height=1+max(height(z.left), height(z.right));
        y.height=1+max(height(y.left), height(y.right));

        return y;
    }
    
    private Node leftRotation(Node z){
        Node y = z.right;
        Node yl = y.left;
        
        y.left=z;
        z.right=yl;
        
        z.height=1+max (height(z.left), height(z.right));
        y.height=1+max (height(y.left), height(y.right));
        
        return y;
    }
    
    public Iterator iterator(){
        Queue<T> q = new QueueImp<T>();
        loadInOrder(root,q);
        return q.iterator();
    }    
    private void loadInOrder(Node n,Queue<T> q){
        if(n==null)return;
        loadInOrder(n.left, q);
        q.push(n.data);
        loadInOrder(n.right, q);
    }
}
