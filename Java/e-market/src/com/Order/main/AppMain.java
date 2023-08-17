package com.Order.main;

import java.util.Scanner;

public class AppMain {

	public static void main(String[] args) {
		
		        int ch=0;
		        Scanner scanner = new Scanner(System.in);
		        Product a = new Product();
		        do {
		        	System.out.println("|-----------------------------------------|");
		            System.out.println("| ...WELCOME TO E-MARKET ORDER SYSTEM ... |");
		            System.out.println("|-----------------------------------------|");
		            System.out.println("| Admin                        |  press 1 |");
		            System.out.println("| User                         |  press 2 |");
		            System.out.println("| Exit                         |  press 3 |");
		            System.out.println("|-----------------------------------------|");
		            System.out.println("\nEnter your choice:");
		            ch = scanner.nextInt();
		            
		            switch (ch) {
		                case 1://ADMIN
		                	
		                	  Scanner sc = new Scanner(System.in);
		                	  
		                      do {
		                    	  System.out.println("|-----------------------------------------|");
		                          System.out.println("| ...WELCOME TO E-MARKET ORDER SYSTEM ... |");
		                          System.out.println("|-----------------------------------------|");
		                          System.out.println("| Add products                 |  press 1 |");
		                          System.out.println("| Display Products             |  press 2 |");
		                          System.out.println("| Delete items                 |  press 3 |");
		                          System.out.println("| Exit                         |  press 4 |");
		                          System.out.println("|-----------------------------------------|");
		                          System.out.println("\nEnter your choice:");
		                          ch = sc.nextInt();

		                          switch (ch) {
		                              case 1:
		                            	  System.out.println("Enter product name to add:");
		                            	  String pname=sc.next();
		                            	  System.out.println("Enter price product:");
		                            	  double price=sc.nextDouble();
		                            	  System.out.println("Set quantity:");
		                            	  int quantity=sc.nextInt();
		                                  a.addProduct(pname,price,quantity);
		                                  break;
		                              case 2:
		                                  a.traverseProduct();
		                                  break;
		                              case 3:
		                            	  pname=sc.next();
		                                  a.deleteProduct(pname);
		                                  break;
		                              case 4:
		                                  System.out.println("\n...Admin Logged Out...");
		                                  break;
		                          }

		                          System.out.println("\n\nDo you want to go to the main menu (press 6 for yes and 4 for switch user):");
		                          ch = sc.nextInt();
		                      } while (ch == 6 || ch != 4);
		                	
		                      	break;
		                	 
		                		
		                	
		                		
		                case 2://USER
		                	 Order ord = new Order(a);
		                	 Scanner sc1 = new Scanner(System.in);
		                	  
		                      do {
		                    	  System.out.println("|-----------------------------------------|");
		                          System.out.println("| ...WELCOME TO E-MARKET ORDER SYSTEM ... |");
		                          System.out.println("|-----------------------------------------|");
		                          System.out.println("| Add to cart                  |  press 1 |");
		                          System.out.println("| Display Product list         |  press 2 |");
		                          System.out.println("| Display ordered items        |  press 3 |");
		                          System.out.println("| To remove from cart          |  press 4 |");
		                          System.out.println("| Exit                         |  press 5 |");
		                          System.out.println("|-----------------------------------------|");
		                          System.out.println("\nEnter your choice:");
		                          ch = sc1.nextInt();

		                          switch (ch) {
		                              case 1:
		                            	  ord.addItem(a);
		                                  break;
		                              case 2:
		                                  a.traverseProduct();
		                                  break;
		                              case 3:
		                            	  ord.displayOrder();
		                                  break;
		                              case 4:
		                                  ord.deleteOrder(a);
		                                  break;
		                              case 5:
		                                  System.out.println("\n....THANK YOU FOR VISITING...");
		                                  break;    
		                              
		                          }

		                          System.out.println("\n\nDo you want to go to the main menu (press 6 for yes 4 for switch user):");
		                          ch = sc1.nextInt();
		                      } while (ch == 6);
		                 
		                      	break;	
		            	
		                
		                case 3:
		                	System.out.println("\n....THANK YOU FOR VISITING...");
                            System.exit(0);
		            			break;
		            	}
		        	 }while (ch != 3);       
		        	 
		          
	}
}