//import java.io.File;
import java.io.FileReader;
import java.util.List;
import javax.xml.bind.JAXBContext;
//import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

//import pojos.HealthProfile;
import pojos.Person;
import pojos.PeopleStore;

public class HealthProfileReaderUnMarshaler {  	
	public static PeopleStore NewPeople = new PeopleStore();

	public static void main(String[] args) throws Exception {
		JAXBContext jc = JAXBContext.newInstance(PeopleStore.class);
        System.out.println();
        System.out.println("Output from our XML File: ");
        Unmarshaller umars = jc.createUnmarshaller();
        PeopleStore NewPeople = (PeopleStore) umars.unmarshal(new FileReader("NewPeople.xml"));
        List<Person> list = NewPeople.getData();
        for (Person person : list) {
          System.out.println("Person: " + person.getFirstname() + " born "
              + person.getBirthdate());
        }

    }
}
