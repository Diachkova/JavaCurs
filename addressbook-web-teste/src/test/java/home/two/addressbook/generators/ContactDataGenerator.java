package home.two.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import home.two.addressbook.model.ContactData;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ndya on 15.12.2016.
 */
public class ContactDataGenerator {

    @Parameter(names = "-a", description = "Contact count")
    public int count;

    @Parameter(names = "-b", description = "Target file")
    public String file;

    @Parameter(names = "-c", description = "Data format")
    public String format;


    public static void main(String[] args) throws IOException {
      ContactDataGenerator generator = new ContactDataGenerator();
      JCommander jCommander = new JCommander(generator);
      try {
        jCommander.parse(args);
      } catch (ParameterException ex) {
        jCommander.usage();
        return;
      }
      generator.run();
    }

    public void run() throws IOException {
      List<ContactData> contacts = generateContacts(count);
      if (format.equals("csv")) {
        saveAsCsv(contacts, new File(file));
      } else if (format.equals("xml")) {
        saveAsXml(contacts, new File(file));
      } else if (format.equals("json")) {
        saveAsJson(contacts, new File(file));
      } else {
        System.out.println("Unrecognized format "+format);
      }
    }

    private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
      Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
      String json = gson.toJson(contacts);
      try (Writer writer = new FileWriter(file)) {
        writer.write(json);
      }
    }

    private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
      XStream xstream = new XStream();
      xstream.processAnnotations(ContactData.class);
      String xml = xstream.toXML(contacts);
      try (Writer writer = new FileWriter(file)) {
        writer.write(xml);
      }
    }


    private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
     try (Writer writer = new FileWriter(file)) {
       for (ContactData contact : contacts) {
         writer.write(String.format("%s;%s;%s\n", contact.getName(), contact.getSurname(), contact.getAddress(),
                 contact.getEmail(), contact.getHome(), contact.getGroup()));
       }
     }
    }

    private List<ContactData> generateContacts(int count) {
      List<ContactData> contacts = new ArrayList<ContactData>();
      for (int i = 0; i < count; i++) {
        contacts.add(new ContactData().withName(String.format("Name%s", i)).withSurname(String.format("Surname%s", i))
                .withAddress(String.format("Address%s", i)).withEmail(String.format("Email@%s", i))
                .withHome(String.format("11111%s", i)).withGroup(String.format("test0")));

      }
      return contacts;
    }

  }


