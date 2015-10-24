import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import pojos.HealthProfile;
import pojos.Person;
import pojos.PeopleStore;

public class HealthProfileJson {  	
	public static PeopleStore people = new PeopleStore();

	public static void initializeDB() {
		Person Ruta = new Person();
		Person Biny = new Person(new Long(1), "Biniam", "Fetene", "2001-09-17");
		HealthProfile hp = new HealthProfile("1955-11-23",65.0, 1.67);
		Person Mahlu = new Person(new Long(2), "Mahlet", "Fetene", "2009-02-28", hp);

		people.getData().add(Ruta);
		people.getData().add(Biny);
		people.getData().add(Mahlu);
	}	

	public static void main(String[] args) throws Exception {
		
		initializeDB();
		
		// Jackson Object Mapper 
		ObjectMapper mapper = new ObjectMapper();
		
		// Adding the Jackson Module to process JAXB annotations
        JaxbAnnotationModule module = new JaxbAnnotationModule();
        
		// configure as necessary
		mapper.registerModule(module);
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);

        String result = mapper.writeValueAsString(people);
        System.out.println(result);
        mapper.writeValue(new File("people.json"), people);
    }
}
