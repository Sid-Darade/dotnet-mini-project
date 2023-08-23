package com.Order.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
	  
	  
	    private List<Product> items;
	  //  private Product product;
	    private double totalBill;
	    
	    public Order(Product product) {
	      this.items = new ArrayList<>();
	    //  this.product = product;
	     // this.totalBill = 0;
	    }

	    public void addItem(Product prd) {
	    	Scanner scanner = new Scanner(System.in);
	   	    System.out.println("Enter the product name to add cart :");
	        String product = scanner.nextLine();
	        Product desiredProduct = prd.getProduct(product);
	        if(desiredProduct != null) {
	        	 if (prd.getQuantity(product) > 0) {
	                 items.add(desiredProduct);
	                 prd.reduceProductQuantity(product); // Reduce the quantity of the product
	                 System.out.println("Product added to cart.");
	                 totalBill += prd.getPrice(product);
	             } else {
	                 System.out.println("Product not available in stock.");
	             }
	         } else {
	             System.out.println("This product is not in the list.");
	         }
	     }
	    
	    public void displayOrder() {
	    	int i=1;
	    	System.out.println("Your ordered items list:");
	    	if (items.isEmpty()) {
	            System.out.println("No items added in the order.");
	        } else {
	        	for (Product product : items) {
	        		
	                System.out.println(i+":"+product);
	                i++;
	            }
	        }
	    }
	    
	    public void deleteOrder(Product prd){
	    	 Scanner scanner = new Scanner(System.in);
	    	    System.out.println("Enter the product name to delete from cart:");
	    	    String product = scanner.nextLine();

	    	    Product temp = prd.getProduct(product);

	    	    if (temp != null) {
	    	        items.remove(temp);
	    	        prd.increaseProductQuantity(product);
	    	        System.out.println("Product removed from cart.");
	    	        System.out.println("list :"+items);
	    	        totalBill -= prd.getPrice(product);
	    	    } else {
	    	        System.out.println("This product is not in the cart.");
	    	    }
	    }
	    
	    public void displayTotalBill() {
	        System.out.println("Total bill: " + totalBill);
	    }
}
