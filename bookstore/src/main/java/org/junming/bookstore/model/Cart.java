package org.junming.bookstore.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
   private  List<Book> books;

   public Cart(){
	 books=new ArrayList<Book>();
 }
   public int getSize(){
	   return books.size();
   }
   public Book getBookAt(int i){
	   return (Book)books.get(i);
   }
   public void addBook(Book bo){
	   //System.out.println(bID.length()+" & "+a.intValue());
	   books.add(bo);
   }
   public String toString(){
	   String result="";
	   for(int i=0;i<getSize();i++){
		   result+=" BookID: "+books.get(i);
	   }
	   return result;
   }
   public List<Book> getBooks(){
	   return books;
   }
   public void setBooks(List<Book> s){
	   this.books=s;
   }
    public void clearCart(){books.clear();}
	
}