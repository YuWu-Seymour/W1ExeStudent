/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.Property;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO Exercise 1.3 Step 2 Complete this class.
 * 
 * This class implements the PropertyRepository class. You will need to add the keyword
 * "implements" PropertyRepository. 
 * 
 * @author Junyang
 */
public class SimplePropertyRepositoryImpl implements PropertyRepository{
	private ArrayList<Property> listOfProperties;
	
    public SimplePropertyRepositoryImpl() {
        listOfProperties = new ArrayList<>();
    }
    
    public void addProperty(Property property) throws Exception {
    	int propertyID = property.getId();
    	int index = 0;
    	while (index < listOfProperties.size()) {
    		if (listOfProperties.get(index).getId() == propertyID) {
    			listOfProperties.set(index, property);
    			return;
    		}
    		index++;
    	}
    	listOfProperties.add(property);
    }
    
    public Property searchPropertyById(int id) throws Exception {
    	for (Property p : listOfProperties) {
    		if (p.getId() == id) {
    			return p;
    		}
    	}
    	return null;
    }
    
    public List<Property> getAllProperties() throws Exception {
    	return listOfProperties;
    }
}
