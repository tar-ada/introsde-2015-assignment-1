import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import pojos.HealthProfile;
import pojos.Person;
import pojos.PeopleStore;

public class HealthProfileWriter {  	
	public static PeopleStore NewPeople = new PeopleStore();

	public static void initializeDB() {
		Person tare = new Person();
		Person tariku = new Person(new Long(1), "Tariku", "Gelaw", "1987-03-13");
		HealthProfile hp = new HealthProfile("1988-11-23", 68.0, 1.72);
		Person tadele = new Person(new Long(2), "Tadele", "Dagne", "1986-09-20", hp);

		NewPeople.getData().add(tare);
		NewPeople.getData().add(tariku);
		NewPeople.getData().add(tadele);
	}	

	public static void main(String[] args) throws Exception {
		
		initializeDB();
		
		JAXBContext jc = JAXBContext.newInstance(PeopleStore.class);
        Marshaller mars = jc.createMarshaller();
        mars.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        mars.marshal(NewPeople,new File("NewPeople.xml")); // marshalling into a file
        mars.marshal(NewPeople, System.out);			  // marshalling into the system default output
    }
}
