package fit5042.tutex;

import fit5042.tutex.repository.PropertyRepository;
import fit5042.tutex.repository.PropertyRepositoryFactory;
import fit5042.tutex.repository.entities.Property;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * TODO Exercise 1.3 Step 3 Complete this class. Please refer to tutorial instructions.
 * This is the main driver class. This class contains the main method for Exercise 1A
 * 
 * This program can run without the completion of Exercise 1B.
 * 
 * @author Junyang
 */
public class RealEstateAgency {
    private String name;
    private final PropertyRepository propertyRepository;

    public RealEstateAgency(String name) throws Exception {
        this.name = name;
        this.propertyRepository = PropertyRepositoryFactory.getInstance();
    }
    
    // this method is for initializing the property objects
    // complete this method
    public void createProperty() throws Exception {
    	propertyRepository.addProperty(new Property(1, "Address1", 11, 111, 1111.0));
    	propertyRepository.addProperty(new Property(2, "Address2", 22, 222, 2222.0));
    	propertyRepository.addProperty(new Property(3, "Address3", 33, 333, 3333.0));
    	propertyRepository.addProperty(new Property(4, "Address4", 44, 444, 4444.0));
    	propertyRepository.addProperty(new Property(5, "Address5", 55, 555, 5555.0));
    	System.out.println("5 properties added successfully");
    }
    
    // this method is for displaying all the properties
    // complete this method
    public void displayProperties() throws Exception {
        for (Property p : propertyRepository.getAllProperties()) {
        	System.out.println(p.toString());
        }
    }
    
    // this method is for searching the property by ID
    // complete this method
    public void searchPropertyById() {
    	Scanner sc = new Scanner(System.in);
        System.out.print("Enter the property ID you want to search: ");
        String id = sc.nextLine();
        sc.close();
        try {
        	Property property = propertyRepository.searchPropertyById(Integer.parseInt(id));
        	if (property != null) System.out.println(property.toString());
        	else System.out.println("There is no property with ID " + id);
        } catch (Exception ex) {
        	System.out.println("There is no property with ID " + id);
        }
        
    }
    
    public void run() throws Exception {
        createProperty();
        System.out.println("********************************************************************************");
        displayProperties();
        System.out.println("********************************************************************************");
        searchPropertyById();
    }
    
    public static void main(String[] args) {
        try {
            new RealEstateAgency("FIT5042 Real Estate Agency").run();
        } catch (Exception ex) {
            System.out.println("Application fail to run: " + ex.getMessage());
        }
    }
}
