Introduction to service design and engineering
Assignment 01: Reading/Writing objects to and from XML and JSON

There are four folders in this assignment,which are build, ivy, lib and HealthProfileReader folder. In the HealthProfileReader folder,there is one folder (src) which contains the PeopleStore and pojos packages. In addition, it contains HealthProfileReader, HealthProfileWriter, HealthProfileReaderUnmarshaler, HealthProfileJson. The Pojos package on the other hand contains HealthProfile, PeopleStore and Person java files. In addition to the the folders listed above, the parent directory contains xml (build, Ivy, MyPeople, NewPeople and People), xsd (people) and json (people) files.

For running the tasks from number 1-3, I have created the people.xml file and then I created the pojo package and put the HelthProfile and person java classes within it. Next I created the HealthProfileReader java class under the src package in order to carry out all of the tasks. For the marshaling and unmarshaling process of task number 4-6, I created three persons then marshal to xml file by using the HealthProfileWriter class, which is placed under the main parent directory as NewPeople.xml.Next, in order to unmarshal it I have first changed the NewPeople.xml file to People.xsd in order to validate it and then unmarshal it using the HealthProfileReaderUnmarshaler java class. At the end, I have created the People.json file using the HealthProfileJson class. 

In order to execute the code for this assignment, you can open your terminal in your local machine and use the execute.evaluation to run it.

