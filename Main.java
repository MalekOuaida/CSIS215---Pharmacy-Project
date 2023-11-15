// title: Pharmacy Project
// date: Friday 14, 2023
// author: Malek Ouaida
// purpose: The purpose of this Java program is to create a pharmacy system that allows the user
// to add new medicines to the pharmacy's inventory, search for medicines by name or composition,
// sell medicines, restock medicines, display all medicines, and display information about the pharmacy.
// list of methods:
    //public static void main(String[] args)
    //public static int menu()
    //public static void addNewMedicine()
    //public static void searchByName()
    //public static void searchByComposition()
    //public static void sellMedicine()
    //public static void restockMedicine()
    //public static void displayAllMedicines()
    //public static void displayPharmacyInfo()

import java.util.Scanner; // This here we call the scanner package inside of Java JVM.

public class Main { // This line declares the main class.

    // This line creates a new instance of the Pharmacy class, with the name "myPharma".
    public static Pharmacy pharmacy = new Pharmacy("myPharma");

    public static void main(String[] args) {
        System.out.println("Welcome to ''myPharma'' pharmacy system"); // This is a print statement
        System.out.println("-----------------------------------------------"); // This is a print statement
        int choice = 0; // The variable "choice" is an integer used to store a user's selected option.
        do { // This is the beginning of the do-while loop.
            choice = menu(); // We use the menu method with the choice number.
            switch (choice) { // This is the switch for the choice selection.
                case 1: // This case implements the method addNewMedicine
                    addNewMedicine(); // Here we call the method addNewMedicine
                    break; // The case stops
                case 2: // This case implements the method searchByName
                    searchByName(); // Here we call the method searchByName
                    break; // The case stops
                case 3: // This case implements the method searchByComposition
                    searchByComposition(); // Here we call the method searchByComposition
                    break; // The case stops
                case 4: // This case implements the method sellMedicine
                    sellMedicine(); // Here we call the method sellMedicine
                    break; // The case stops
                case 5: // This case implements the restockMedicine
                    restockMedicine(); // Here we call the method restockMedicine
                    break; // The case stops
                case 6: // This case implements displayAllMedicines
                    displayAllMedicines(); // Here we call the method displayAllMedicines
                    break; // The case stops
                case 7: // This case implements the method displayPharmacyInfo
                    displayPharmacyInfo(); // Here we call the method displayPharmacyInfo
                    break; // The case stops
                case 8: // This case stops the run
                    System.out.println("Exiting program..."); // This is a print statement
                    break; // This case stops
                default: // If there is a wrong choice input, the default is sent.
                    System.out.println("Invalid choice, please try again."); // This is a print statement
                    break; // This case stops
            }
        } while (choice != 8); // The loop continues while the choice is different than 8.
    }

    public static int menu() {  // This is a static method that prints the menu
        Scanner input = new Scanner(System.in); // This is the call for Scanner
        // This is a print statement
        System.out.println("Choose one of the following options\n"
                + "1- Add a new medicine\n"
                + "2- Search for a medicine by name\n"
                + "3- Search for a medicine by composition\n"
                + "4- Sell a medicine\n"
                + "5- Restock a medicine\n"
                + "6- Display all medicines\n"
                + "7- Display information\n"
                + "8- Exit");
        System.out.print("Enter your choice (between 1 and 8): "); // This is a print statement
        System.out.println(); // This is a print statement
        return input.nextInt(); // This returns the input the user has set
    }

    public static void addNewMedicine() { // This is a static method that adds the medicine
        System.out.println("Enter the information of the new medicine:"); // This is a print statement
        System.out.println(); // This is a print statement
        Scanner input = new Scanner(System.in); // This is the call for Scanner
        System.out.print("Choose O or o for over the counter medicine and p or P for " +
                "prescription medicine:  "); // This is a print statement
        char type = input.next().charAt(0); // This is the input for the char to know if its P or O
        if (type == 'O' || type == 'o') { // if the medicine is an over the counter medicine, implement the code below
            System.out.print("Enter medicine name: "); // This is a print statement
            input.nextLine(); // This is a input line that allows the code to run smoothly
            String name = input.nextLine(); // This is the input line for the medicine name
            System.out.print("Enter medicine composition: "); // This is a print statement
            String composition = input.nextLine(); // This is the input line for the medicine composition
            System.out.print("Enter the dose: "); // This is a print statement
            int dose = input.nextInt(); // This is the input line for the medicine dose
            System.out.print("Enter medicine quantity: "); // This is a print statement
            int quantity = input.nextInt(); // This is the input line for the medicine quantity
            System.out.print("Enter medicine price: "); // This is a print statement
            double price = input.nextDouble(); // This is the input line for the medicine quantity
            System.out.print("Enter the minimum age for this medicine: "); // This is a print statement
            int age = input.nextInt();
            // Below we create an object for an over the counter medicine
            OverTheCounter medicine = new OverTheCounter(name, composition, dose, quantity, price, age);
            pharmacy.addMedicine(medicine); // Here we add the object to the array pharmacy
            System.out.println("New medicine is added successfully"); // This is a print statement
            System.out.println(); // This is a print statement
            System.out.println("-----------------------------------------------"); // This is a print statement
            System.out.println(); // This is a print statement
        } else if (type == 'P' || type == 'p') { //else if the medicine needs a prescription, implement the code below
            System.out.print("Enter medicine name: "); // This is a print statement
            input.nextLine(); // This is a input line that allows the code to run smoothly
            String name = input.nextLine(); // This is a input line that sets the name of the medicine
            System.out.print("Enter medicine composition: "); // This is a print statement
            String composition = input.nextLine(); // This is the input line for the medicine composition
            System.out.print("Enter the dose: "); // This is a print statement
            int dose = input.nextInt(); // This is the input line for the medicine dose
            System.out.print("Enter medicine quantity: "); // This is a print statement
            int quantity = input.nextInt(); // This is the input for the price
            System.out.print("Enter medicine price: "); // This is a print statement
            double price = input.nextDouble(); // This is the input for the price
            System.out.print("Doctor Specialization: "); // This is a print statement
            input.nextLine(); // This is a input line that allows the code to run smoothly
            String doctorSpecialization = input.nextLine(); // This is a input line for the doctor specialization
            // Below we create an object for a prescription medicine
            Prescription medicine = new Prescription(name, composition, dose, quantity , price, doctorSpecialization);
            pharmacy.addMedicine(medicine); // We add the medicine to the array in pharmacy
            System.out.println("New medicine is added successfully"); // This is a print statement
            System.out.println("-----------------------------------------------"); // This is a print statement
        }
    }

    public static void searchByName() { // This is a static method that search for the medicine by its name
        Scanner input = new Scanner(System.in); // This is the call for Scanner
        System.out.print("Enter medicine name: "); // This is a print statement
        String name = input.nextLine(); // This is the input for the medicine name
        int[] indices = pharmacy.searchByName(name); // Here we call the method inside of the pharmacy class to search
        // the medicines name
        if (indices.length == 0) { // If the medicine is not found, implement the code below
            System.out.println("Medicine not found."); // This is a print statement
            System.out.println("-----------------------------------------------"); // This is a print statement
        } else { // Else if the medicine is found, implement the code below
            System.out.println("Search results for " + name + ":"); // This is a print statement
            for (int i = 0; i < indices.length; i++) { // Iterate the loop till we find the index of the medicine
                System.out.println(pharmacy.getMedicines()[indices[i]]); // This is a print statement
                System.out.println("-----------------------------------------------"); // This is a print statement
            }
        }
    }

    public static void searchByComposition() { // This is a static method that searches for the medicine by composition
        Scanner input = new Scanner(System.in); // This is the call for Scanner
        System.out.print("Enter composition: "); // This is a print statement
        String composition = input.nextLine(); // This is an input statement for the medicine composition
        int[] indices = pharmacy.searchByComposition(composition); // // Here we call the method inside of
        // the pharmacy class to search the medicines by it's composition
        if (indices.length == 0) { // If the composition is not found, implement the code below
            System.out.println("Medicine not found."); // This is a print statement
            System.out.println("-----------------------------------------------"); // This is a print statement
        } else { // If the composition is found, implement the code below
            System.out.println("Search results for " + composition + ":"); // This is a print statement
            for (int i = 0; i < indices.length; i++) { // Iterate the loop till we find the index of the medicine
                System.out.println(pharmacy.getMedicines()[indices[i]]); // This is a print statement
                System.out.println("-----------------------------------------------"); // This is a print statement
            }
        }
    }

    public static void sellMedicine() { // This is a static method that sells the medicine
        Scanner input = new Scanner(System.in); // This is the call for Scanner
        System.out.print("Enter medicine name: "); // This is a print statement
        String name = input.nextLine(); // This is an input to write the medicine name
        System.out.print("Enter medicine dose: "); // This is a print statement
        int dose = input.nextInt(); // This is an input to the medicine's dose
        System.out.print("Enter quantity: "); // This is a print statement
        int quantity = input.nextInt(); // This is an input for the quantity we want to sell

        pharmacy.sellMedicine(name, dose, quantity); // We call the method sell medicine available in the pharmacy
        //class
        System.out.println("-----------------------------------------------"); // This is a print statement
    }

    public static void restockMedicine() { // This is a static method to restockMedicine
        Scanner input = new Scanner(System.in); // This is the call for Scanner
        System.out.print("Enter medicine name: "); // This is a print statement
        String name = input.nextLine(); // This is the input statement to write the medicines name
        System.out.print("Enter medicine dose: "); // This is a print statement
        int dose = input.nextInt(); // This is the input statement to write the medicines dose
        System.out.print("Enter quantity to add: "); // This is a print statement
        int quantity = input.nextInt(); // This is the input statement to write the medicines quantity

        boolean isRestocked = pharmacy.restock(name, dose, quantity); //We call the method restock
        // available in the pharmacy class

        if (isRestocked) { // if Medicine restocked, print below
            System.out.println("Medicine restocked successfully."); // This is a print statement
            System.out.println("-----------------------------------------------"); // This is a print statement
        } else { // else if Medicine not restocked, print below
            System.out.println("Medicine not found."); // This is a print statement
            System.out.println("-----------------------------------------------"); // This is a print statement
        }
    }
    public static void displayAllMedicines() { // This is a static method to displayAllMedicines
        System.out.println("List of all medicines:"); // This is a print statement
        System.out.println("======================"); // This is a print statement
        for (int i = 0; i < pharmacy.getNumberOfMedicines(); i++) { // We iterate the loop to know the number
            // of medicines available
            System.out.println(pharmacy.getMedicines()); // This is a print statement
        }
        System.out.println("-----------------------------------------------"); // This is a print statement
    }

    public static void displayPharmacyInfo() { // This is a static method to displayPhamacyInfo
        System.out.println("Pharmacy: " + pharmacy.getName()); // This is a print statement
        System.out.println("Number of Medicines: " + pharmacy.getNumberOfMedicines()); // This is a print statement
        // This is a print statement
        System.out.println("Over the counter quantity: " + pharmacy.getOverTheCounterQuantity());
        System.out.println("Prescription quantity: " + pharmacy.getPrescriptionQuantity()); //This is a print statement
        System.out.println("-----------------------------------------------"); // This is a print statement
    }
}
