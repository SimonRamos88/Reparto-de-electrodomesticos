package com.mycompany.repartoelectro;

import java.util.Scanner;
public class Main{
    public static void main(String [] args){
        int cases, elements, amountOfStores,temp;
        Scanner read= new Scanner(System.in);
        cases=read.nextInt();
        for(int i=1;i<=cases;i++){
            Queue<String> reparto= new Queue();
            elements=read.nextInt();
            read.nextLine();
            String word= read.nextLine();
            String[] things= word.split("[   ]+");
            for(int j=0;j<things.length;j++){
                if(things[j].equals(" ")!=true){
                    reparto.push(things[j]); 
                }
            }
            
            amountOfStores=read.nextInt();
            while(amountOfStores>0 && reparto.empty()==false){
                temp=read.nextInt();
                if(temp==0){
                    System.out.println("[]");
                    amountOfStores--;
                }
                else{
                    System.out.print("[");
                for(int k=1;k<temp;k++){
                    if(reparto.length()==1){
                        String tempS=reparto.pop();
                        System.out.print(tempS);
                    }
                    else{
                        String tempS=reparto.pop();
                        if(tempS==null){
                            break; 
                        }
                        System.out.print(tempS+" ");
                    }
                }
                String tempS=reparto.pop();
                    if(tempS!=null){
                        System.out.print(tempS+"");
                    }
                System.out.println("]");
                amountOfStores--;
                    
                }
                
            }
            if(amountOfStores>=1){
                while(amountOfStores>=1){
                    temp=read.nextInt();
                    System.out.println("[]");
                    amountOfStores--;
                }
            }
            
            
            
        }
       
    }
  
}
class Queue <T>{
    Node head,tail;
    int size;
    public Queue(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }
    public void push(T data){
         if(this.head!=null){
            Node<T> p= new Node<>(data);
            p.next=tail;
            this.tail.back=p;
            this.tail=p;
            this.size=this.size+1;
        }
         else{
             Node<T> p= new Node<>(data);
             this.tail=p;
             this.head=p;
             this.size=this.size+1;
         }
    }
    public T pop(){
        if(empty()){
            
        }
        else if(this.size==1){
            T data= (T) head.data;
            head=null;
            tail=null;
            this.size=size-1;
            return data;
        }
        else {
            T data= (T) head.data;
            head.back.next=null;
            head=head.back;
            this.size=size-1;
            return data;
        }
        return null;
    }
    public int length (){
        return this.size;
    }
    public boolean empty(){
        return this.size==0;
    }
}
class Stack <T>{
    Node top;
    int size;
    public Stack(){
        this.top=null;
        this.size=0;
    }
  
    public void push(T data){
        if(top!=null){
            Node<T> p= new Node<>(data);
            p.back=this.top;
            this.top.next=p;
            this.top=p;
            this.size=this.size+1;
        }
        else{
            Node<T> p= new Node<>(data);
            this.top=p;
            this.size=this.size+1;
        } 
    }
    public T pop(){
        Node temp;
        if(this.size>1){
            T data=(T) this.top.data;
            this.top.back.next=null;
            this.top=this.top.back;
            this.size=this.size-1;
            return data;
        }
        else if(this.size==1){
             T data=(T) this.top.data;
            this.top=null;
            this.size=this.size-1;
            return data;
        }
        else{
           System.out.println("No Hay datos disponibles");
        } 
        return null;
    }
    public int length(){
        return this.size;
    }
    
}
class Node <T>{
    T data ;
    Node next;
    Node back;
    Node(T data){
        this.data=data;
        this.next=null;
        this.back=null;
    }
    
}