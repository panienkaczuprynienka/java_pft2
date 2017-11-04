package ru.stqa.pft.addressbook.generators;

        import com.beust.jcommander.JCommander;
        import com.beust.jcommander.Parameter;
        import com.beust.jcommander.ParameterException;
        import com.google.gson.Gson;
        import com.google.gson.GsonBuilder;
        import com.thoughtworks.xstream.XStream;
        import ru.stqa.pft.addressbook.model.AddressData;


        import java.io.File;
        import java.io.FileWriter;
        import java.io.IOException;
        import java.io.Writer;
        import java.util.ArrayList;
        import java.util.List;

public class AddressDataGenerator {

  @Parameter(names = "-c", description = "Address count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    AddressDataGenerator generator = new AddressDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<AddressData> addresses = generateAddresses(count);
    if (format.equals("csv")){
      saveAsCsv(addresses, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(addresses, new File(file));
    } else if (format.equals("json")) {
      saveAsJson(addresses, new File(file));
    } else {
      System.out.println("Unrecognized format" + format);
    }

  }

  private void saveAsJson(List<AddressData> addresses, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(addresses);
    Writer writer = new FileWriter(file);
    writer.write(json);
    writer.close();
  }

  private void saveAsXml(List<AddressData> addresses, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(AddressData.class);
    String xml = xstream.toXML(addresses);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();
  }


  private void saveAsCsv(List<AddressData> addresses, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (AddressData address : addresses) {
      writer.write(String.format("%s;%s;%s\n", address.getFirstname(), address.getLastname(), address.getPersonalAddress(), address.getAllEmails(), address.getAllPhones()));
    }
    writer.close();
  }


  private List<AddressData> generateAddresses(int count) {
    List<AddressData> addresses = new ArrayList<AddressData>();
    for (int i = 0; i < count; i++) {
      addresses.add(new AddressData().withFirstname(String.format("imie %s", i))
              .withLastname(String.format("nazwisko %s", i)).withPersonalAddress(String.format("adres zamieszkania %s", i))
              .withAllEmails(String.format("emaile %s", i)).withAllPhones(String.format("telefony %s", i)));
    }
    return addresses;
  }
}