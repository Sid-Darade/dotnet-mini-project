package com.Order.main;

import java.util.Objects;
import java.util.Scanner;

public class Product {
	
	private Node head;
	private String pdata;
	
	private class Node {
		private String data;
		private Node next;
		private double price;
		private int quantity;
		
		public Node(String data,double price,int quantity) {
			this.data = data;
			this.price = price;
			this.quantity = quantity;
		}
		
		public int quantityProduct() {
			return quantity;
		}

		public void increaseQuantity() {
			quantity++;
			
		}
		
		public void reduceQuantity() {
			  if (quantity > 0) {
			        quantity--;
			    }
		}
		
	//	public double productPrice() {
	//		return price;
	//	}
	}
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String data) {
		this.pdata = data;
	}
	
	@Override
	public String toString() {
		return pdata ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pdata);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(pdata, other.pdata);
	}

	public void traverseProduct() {
		
		if(head == null) {
			System.out.println("Product list is empty , can not display");
			return;
		}
		
		if(head.next == null) {
			System.out.println(head.data);
			return;
		}
		
		Node temp = head;
		int i=1;
		while(temp != null) {
			System.out.println("|--------------------------------------------|");
			System.out.println("| "+i + " " + temp.data +"   "+ " Price: " + temp.price+" rs/kg"+" Quantity:"+temp.quantity);
			temp = temp.next;
			i++;
		}
		System.out.println("|--------------------------------------------|");
		System.out.println();
	}
	
	public void addProduct(String data, double price, int quantity) {
		
	Node n = new Node(data, price, quantity);
		
		if(head == null) {
			head = n;
			System.out.println("new product added...");
			return;
		}
		
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = n;
		//n.next = null; optional step
		System.out.println("product added...");
	}
		
	public void deleteProduct(String value) {

		Node temp = null;
		Node prev = null;
		
		if(head == null) {
			System.out.println("Product list is empty , can not delete");
			return;
		}
		
		//below code runs when element to be deleted is at the first node
		if (head.data.equals(value)) {
			head = head.next;
			System.out.println("Product deleted");
			return;
		}

		//node to be deleted is somewhere else
		temp = head;
		
		while(temp != null && !temp.data.equals(value)) {
			prev = temp;
			temp = temp.next;
		}
		
		//below code runs if element is found
		if(temp != null) {
			prev.next = temp.next;
			temp.next = null;
			System.out.println("Product deleted");
			return;
		}
		
		//below code runs if element is not found
		if(temp == null) {
			System.out.println("no such item found");
			return;
		}
}

	public Product getProduct(String productName) {
	    Node temp = head;
	    while (temp != null) {
	        if (temp.data.equalsIgnoreCase(productName)) {
	        	return new Product(temp.data);
	        }
	        temp = temp.next;
	    }
	    return null; 
	}
	
	public void reduceProductQuantity(String productName) {
	    Node temp = head;
	    while (temp != null) {
	        if (temp.data.equalsIgnoreCase(productName)) {
	            temp.reduceQuantity();
	            return;
	        }
	        temp = temp.next;
	    }
	}
	
	

	public int getQuantity(String pname) {
		 Node temp = head;
	        while (temp != null) {
	            if (temp.data.equalsIgnoreCase(pname)) {
	                return temp.quantityProduct();
	            }
	            temp = temp.next;
	        }
	        return 0;
		
	}

	public void increaseProductQuantity(String pname) {
		Node temp = head;
	    while (temp != null) {
	        if (temp.data.equalsIgnoreCase(pname)) {
	            temp.increaseQuantity();
	            return;
	        }
	        temp = temp.next;
	    }
		
	}

	public double getPrice(String pname) {
		 Node temp = head;
		    while (temp != null) {
		        if (temp.data.equalsIgnoreCase(pname)) {
		        	return temp.price;
		        }
		        temp = temp.next;
		    }
		    return 0.0; 
	}

	
}

	