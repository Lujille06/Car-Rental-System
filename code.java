import java.util.Scanner;
public class Main
{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int operation, carNumber;
		
		//Available cars 
	  	Cars[] car = new Cars[3]; //array of objects
	  	car[0] = new Cars("Toyota", "Vios", 1500.0, true);
	  	car[1] = new Cars("Honda", "Civic", 2000.0, true);
	  	car[2] = new Cars("Ford", "Ranger", 2500.0, true);
		
		System.out.println("----------------------------");
		System.out.println("Welcome to Car Rental System");
	  	System.out.println("----------------------------\n");
		
		//Displaying available cars
    	System.out.println("Available Cars: ");
    	for (int i = 0; i < car.length; i++){
        	System.out.print("[" + i + "] ");
        	car[i].displayCars();
    	}	    
		
		do{
	    //Operation
    	System.out.println("\nChoose an option: ");
    	System.out.println("1. Rent a car");
    	System.out.println("2. Return a car");
    	System.out.println("3. View cars");
    	System.out.println("4. Exit");
    	System.out.print("Enter your choice: ");
    	operation = scanner.nextInt();
    		
    	switch(operation){
    	    //Rent a car
    	    case 1:
    	        carNumber = inputCarNumber(scanner, car.length);
    	        if(car[carNumber].isAvailable){
       		        System.out.print("Enter number of rental days: ");
       		        int rentalDays = scanner.nextInt();
       		        car[carNumber].rentCar(rentalDays);
       		        System.out.println("----------------------------\n");
    	        } else {
    	            System.out.println("[Invalid Operation] The car is already rented\n");
    	        }
    	        break;
    		    
    	    //Return a car  
    	    case 2:
    	        carNumber = inputCarNumber(scanner, car.length);
    	        if (!(car[carNumber].isAvailable)){
    	            car[carNumber].returnCar();
    	            System.out.println("----------------------------\n");
    	        } else {
    	           System.out.println("[Invalid Operation] The car hasn't been rented\n"); 
    	        }
    	        break;
    	    
    	    //View cars
    	    case 3:
           		System.out.println("\nAvailable Cars: ");
           		for (int i = 0; i < 3; i++){
           		    System.out.print("[" + i + "] ");
           		    car[i].displayCars();
           	    }
           	    System.out.println("----------------------------\n");
    	        break;
    	    
    	    //Exit system
    	    case 4:
    	        System.out.println("\nThank you for using Simple Car Rental System!");
    	        System.exit(0);
    	        break;
    	        
    	    default:
    	        System.out.println("[Invalid Operation] Enter a valid number!\n");
    	        break;
    	} 
		} while(operation != 4);
    
    scanner.close();
	}
	
	//Asks car number
	static int inputCarNumber(Scanner scanner, int carCount){
	    int carNumber;
        do{
            System.out.print("\nEnter the car number: ");
            carNumber = scanner.nextInt();
            if (carNumber < 0 || carNumber > (carCount-1)) {
                System.out.println("[Invalid car number] Please try again!");
            }
        } while (carNumber < 0 || carNumber > (carCount-1));
        return carNumber;
	}
}

//Car class
class Cars{
    //Attributes of Cars class
    String name;
    String model;
    double dailyRate;
    boolean isAvailable;
    
    //Constructor to define the attributes of particular object
    Cars(String name, String model, double dailyRate, boolean isAvailable){
        this.name = name;
        this.model = model;
        this.dailyRate = dailyRate;
        this.isAvailable = isAvailable;
    }
    
    //Method to rent a car
    void rentCar(int rentalDays){
        double total;
        this.isAvailable = false;
        System.out.println("You have rented the " + this.name + " " + this.model + 
                            " for " + rentalDays + " day/s." );
        total = this.dailyRate * rentalDays;
        System.out.printf("Total cost: $%.2f%n", total);
        System.out.println("Car rented successfully!\n");            
    }
    
    //Method to return a car
    void returnCar(){
        this.isAvailable = true;
        System.out.println(this.name + " " + this.model + " has been returned.");
        System.out.println("Car is now available again!\n");
    }
    
    //Method to display available cars
    void displayCars(){
        String yesNo = this.isAvailable ? "Yes" : "No";
        System.out.println("Brand: " + this.name + " | Model: " + this.model + " Rate: " + this.dailyRate + " | Available: " + yesNo);
    }
}
