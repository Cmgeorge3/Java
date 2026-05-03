import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Driver <inputfilename>");
            return;
        }

        String filename = args[0];
        ArrayList<Dwelling> dwellings = new ArrayList<>();

        try {
            Scanner fileScanner = new Scanner(new File(filename));

            // Read until end of file
            while (fileScanner.hasNextLine()) {
                String dwellingType = fileScanner.nextLine().trim();

                // Dwelling fields
                String streetAddress = fileScanner.nextLine().trim();
                String city = fileScanner.nextLine().trim();
                String state = fileScanner.nextLine().trim();
                String zip = fileScanner.nextLine().trim();
                int bedrooms = Integer.parseInt(fileScanner.nextLine().trim());
                double bathrooms = Double.parseDouble(fileScanner.nextLine().trim());

                if (dwellingType.equalsIgnoreCase("H")) {
                    // House: acreage and garage size
                    double acreage = Double.parseDouble(fileScanner.nextLine().trim());
                    int garageSize = Integer.parseInt(fileScanner.nextLine().trim());

                    House h = new House();
                    h.setStreetAddress(streetAddress);
                    h.setCity(city);
                    h.setState(state);
                    h.setZip(zip);
                    h.setBedrooms(bedrooms);
                    h.setBathrooms(bathrooms);
                    h.setAcreage(acreage);
                    h.setGarageSize(garageSize);

                    dwellings.add(h);
                }
                else if (dwellingType.equalsIgnoreCase("A")) {
                    // Apartment: apt number and laundry (0 or 1)
                    String aptNum = fileScanner.nextLine().trim();
                    boolean laundry = Integer.parseInt(fileScanner.nextLine().trim()) == 1;

                    Apartment a = new Apartment();
                    a.setStreetAddress(streetAddress);
                    a.setCity(city);
                    a.setState(state);
                    a.setZip(zip);
                    a.setBedrooms(bedrooms);
                    a.setBathrooms(bathrooms);
                    a.setApptNum(aptNum);
                    a.setLaundry(laundry);

                    dwellings.add(a);
                }
            }

            fileScanner.close();

            // Output all dwellings
            System.out.println("===== Dwelling Report =====");
            for (Dwelling d : dwellings) {
                System.out.println(d.toString());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + filename);
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

