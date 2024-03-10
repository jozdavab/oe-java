package oe.lab05;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Adam", 3.5f, 20));
        students.add(new Student("Bill", 1.7f, 19));
        students.add(new Student("Chris", 4.1f, 22));

        try {
            // PrintWriter instance for writing to files
            PrintWriter pw = new PrintWriter(new File("test.txt"));
            // Or simply specifying the path as a string works too:
            // PrintWriter pw=new PrintWriter("test.txt");

            students.forEach(s -> pw.println(s));
            // Or another solution, using foreach:
            //for (Student student : students) {
            //    pw.println(student);
            //}
            pw.close(); // Closing the pw will flush the puffer and write the students to file.

        } catch (FileNotFoundException e) {
            System.out.println("Printwriter issue happened");
        }

        /*
        // Same behaviour, with a different approach:
        try {
            Files.write(Paths.get("test.txt"),
                    students.stream().map(Student::toString).collect(Collectors.toList()),
                    StandardOpenOption.CREATE);
        } catch (IOException ex) {
            System.out.println("Files.Write issue happened");
        }*/


        // Reading data
        try {
            BufferedReader br = Files.newBufferedReader(Paths.get("test.txt"));
            var lines = br.lines().toList();
            br.close();
            // Same behaviour, with a different approach:
            // var lines=Files.readAllLines(Paths.get("test.txt"));

            ArrayList<Student> studentsRead = new ArrayList<>();
            for (String line : lines) {
                String[] parts = line.split("\t");
                studentsRead.add(new Student(parts[0], Float.parseFloat(parts[1]), Integer.parseInt(parts[2])));
            }
            studentsRead.forEach(System.out::println);

            // Another, more compact alternative using Stream API
            /*BufferedReader br=Files.newBufferedReader(Paths.get("test.txt"));
            br.lines().map(line->{
                String[] parts=line.split("\t");
                return new Student(parts[0],Float.parseFloat(parts[1]), Integer.parseInt(parts[2]));
            }).forEach(System.out::println);
            br.close();*/

        } catch (IOException ex) {
        }


        // Serialize and deserialize using JAXB
        try {
            // Maven dependencies needed: jakarta.xml.bind: jakarta.xml.bind-api, com.sun.xml.bind: jaxb-impl
            // In pom.xml, click inside <project>...</project>, press Alt+Insert -> Dependency; Add both dependencies
            // If they won't be downloaded automatically: in Project tree, right click pom.xml, Maven/Reload project
            JAXBContext ctx = JAXBContext.newInstance(Student.class);
            Marshaller m = ctx.createMarshaller();
            // If this property is true then Marshaller will create a nicely formatted, easily readable format.
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // Serialize to console
            m.marshal(students.get(0), System.out);
            // Serialize to text file
            m.marshal(students.get(0), Files.newOutputStream(Paths.get("test2.txt"), StandardOpenOption.CREATE));
            // Or this also works:
            // m.marshal(students.get(0), new File("test2.txt"));

            // Serializing multiple objects without repeating the XML prolog
            /*m.setProperty(Marshaller.JAXB_FRAGMENT, true);
            for (Student student : students) {
               m.marshal(student, System.out);
           }*/

            // Deserialize one student from text file
            Unmarshaller um = ctx.createUnmarshaller();
            Object o = um.unmarshal(new File("test2.txt"));
            System.out.println((Student) o);
        } catch (JAXBException | IOException ex) {
            System.out.println(ex.getMessage());
        }

        // Serialize and deserialize using GSON
        // NOTE: works also without getters and setters and default constructor
        // print JSON serialization (works without setters and getters)
        System.out.println(new Gson().toJson(students)); // compact
        System.out.println(
                new GsonBuilder()
                        .setPrettyPrinting() // formatted output
                        .serializeNulls()    // save fields with null
                        .create()
                        .toJson(students));

        // serialize to file
        try (BufferedWriter out = Files.newBufferedWriter(Paths.get("test.json"))) {
            out.write(new Gson().toJson(students));
        } catch (IOException x) {
            System.out.println(x.getMessage());
        }

        // deserialize from file
        try (BufferedReader in = Files.newBufferedReader(Paths.get("test.json"))) {
            ArrayList<Student> newList = new Gson().fromJson(in, ArrayList.class);
            System.out.println("newlist: " + newList);
        } catch (IOException x) {
            System.out.println(x.getMessage());
        }
    }
}