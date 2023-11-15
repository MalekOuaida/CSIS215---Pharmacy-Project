// title: Pharmacy Project
// date: Friday 14, 2023
// author: Malek Ouaida
// The Pharmacy class manages a pharmacy's inventory of medicines. It has variables for
// the name, medicines, and quantities of prescription and non-prescription drugs.
// The class provides methods for adding new medicines, searching for medicines, and adjusting prices.
// list of methods:
        //Pharmacy(String name)
        //void addMedicine(Medicine medicine)
        //void raisePrices(double percentage)
        //int[] searchByName(String name)
        //int searchByNameAndDose(String name, double dose)
        //int[] searchByComposition(String composition)
        //void sellMedicine(int index, int quantity)
        //void setName(String name)
        //String getName()
        //int getOverTheCounterQuantity()
        //int getPrescriptionQuantity()
        //Medicine getMedicine(int index)
        //int getNumberOfMedicines()
        //int getMaxNumberOfMedicines()
        //void setMaxNumberOfMedicines(int maxNumberOfMedicines)
        //String toString()

//This line defines a class named Pharmacy.
public class Pharmacy {
        // This is a private String data field, that represents the name of the pharmacy
        private String name;
        // This is a private array of the Object Medicine.
        private Medicine[] medicines;
        // This is a private int that represents the quantity of medicines that do not need a prescription
        private int overTheCounterQuantity;
        // This is a private int that represents the quantity of medicines that need a prescription
        private int prescriptionQuantity;
        // This is a private int that represents the number of medicines.
        private int numberOfMedicines;
        // This is a static int that represents the max number of medicines
        private static int MaxNumberOfMedicines = 100;


    //This constructor sets the name of the pharmacy, and puts the medicines array,
    //over the counter quantity, the prescription quantity and the number of
    //medicines to their default values.

    public Pharmacy(String name) {
        setName(name);
        medicines = new Medicine[MaxNumberOfMedicines];
        overTheCounterQuantity = 0;
        prescriptionQuantity = 0;
        numberOfMedicines = 0;
    }

    //The addMedicine method is used to add a new medicine
    //to the array of medicines in the Pharmacy class.
    //It takes a new medicine object as an argument and
    //checks if this medicine already exists in the array or not.

    public void addMedicine(Medicine medicine){
        boolean medicineExists = false; //This is the default value of the boolean
        int index = -1; //This is the default value of the index

        //This for loop searches for the medicine in the array
        for (int i = 0; i < numberOfMedicines; i++){
            if (medicines[i].equals(medicine)){ //We search for the medicine depending on 'i' equals to the object
                                                //medicine
                medicineExists = true; // if it exists, return true;
                index = i;
                break;
            }
        }

        //Here, we check if the medicine already exists, if it does,
        //it displays a message.

        if (medicineExists){
            System.out.println("This medicine exists in the pharmacy");
        }

        //Here, we check if the pharmacy is full, if it is, it displays a
        //message.

        if (numberOfMedicines == MaxNumberOfMedicines){
            System.out.println("The Pharmacy is full, you can't add this medicine");
        }

        //Here, we add the new medicine to the array

        medicines[numberOfMedicines] = medicine;
        numberOfMedicines++;

        //If the medicine should have a prescription, we add the number of
        //medicine that needs a prescription.

        if (medicine instanceof Prescription){
            prescriptionQuantity += medicine.getQuantity();
        }

        //else, if it does not need a prescription, we add the medicine to
        //the overTheCounterQuantity.

        else {
            overTheCounterQuantity += medicine.getQuantity();
        }

    }

    //This method is used here to raise the prices of medicines.

    public void raisePrices(double percentage) {

        //This loop runs through all the medicine available in the
        //array and raises their price.

        for (int i = 0; i < numberOfMedicines; i++) {
            double oldPrice = medicines[i].getPrice();
            double newPrice = oldPrice * (1 + (percentage / 100));
            medicines[i].setPrice(newPrice);
        }
    }

    //This method searches for the medication by the name.

    public int[] searchByName(String name) {
        int[] indices = new int[numberOfMedicines];  // initialize an array to store the indices of matching medicines
        int count = 0;  // initialize a counter for matching medicines

        for (int i = 0; i < numberOfMedicines; i++) {  // iterate over the array of medicines
            if (medicines[i].getName().equals(name)) {  // if the name of the medicine at index i matches the given name
                indices[count] = i;  // add the index i to the indices array
                count++;  // increment the counter for matching medicines
            }
        }

        int[] result = new int[count];  // create a new array of the exact size needed for the matching medicines
        for (int i = 0; i < count; i++) {  // copy the matching indices to the result array
            result[i] = indices[i];
        }

        return result;  // return the array of indices of matching medicines
    }


    public int searchByNameAndDose(String name, double dose) {
        // This method takes two arguments: name (String) and dose (double).

        for (int i = 0; i < numberOfMedicines; i++) { //It iterates over the medicines array using a for loop and
            //checks if the name and dose of each medicine match the given parameters using an if statement.

            if (medicines[i].getName().equals(name) && medicines[i].getDose() == dose) {
                //If a medicine is found with the given name and dose, the index of that medicine is returned.
                //If the method completes the for loop without finding a medicine with
                //the given name and dose, -1 is returned to indicate that the medicine was not found.

                return i;
            }
        }
        return -1;
    }

    public int[] searchByComposition(String composition) { //The method takes a String parameter composition
                                                            //which represents the composition to search for.
        int count = 0;
        for (int i = 0; i < numberOfMedicines; i++) { //This for loop counts the number of medicines
            //in the array that have the specified composition.
            if (medicines[i].getComposition().equals(composition)) {
                count++;
            }
        }
        int[] result = new int[count]; //An integer array result is created to store the
        //indices of the medicines with the specified composition.

        int index = 0;
        for (int i = 0; i < numberOfMedicines; i++) { //This for-loop fills the result array with the
            //indices of the medicines with the specified composition.
            if (medicines[i].getComposition().equals(composition)) {
                result[index] = i;
                index++;
            }
        }
        return result; //The method returns the result array containing
        //the indices of the medicines with the specified composition.
    }

    public void sellMedicine(String name, double dose, int quantity) {
        int index = searchByNameAndDose(name, dose); // get the index of the medicine by name and dose
        if (index == -1) { // medicine not found
            System.out.println("Medicine not found.");
        } else {
            Medicine medicine = medicines[index]; // get the medicine object
            if (medicine.getQuantity() >= quantity) { // check if available quantity is enough
                medicine.setQuantity(medicine.getQuantity() - quantity); // reduce the quantity
                System.out.println("Selling successful.");
            } else {
                System.out.println("Available quantity is not enough.");
            }
        }
    }

    //This method searches for the name of the medicine, and if it's available, it adds to the quantity, else, it
    //returns false
    public boolean restock(String name, double dose, int quantity) {
        // Search for medicine by name and dose
        int index = searchByNameAndDose(name, dose);

        if (index != -1) { // Medicine found
            medicines[index].setQuantity(medicines[index].getQuantity() + quantity);
            return true;
        } else { // Medicine not found
            return false;
        }
    }

    //This is a getter for the array medicine
    public Medicine[] getMedicines() {
        return medicines;
    }

    //This is a getter for the Over The Counter Quantity
    public int getOverTheCounterQuantity() {
        return overTheCounterQuantity;
    }

    //This is a getter for the Prescription Quantity
    public int getPrescriptionQuantity() {
        return prescriptionQuantity;
    }

    //This is a getter for the number of medicines
    public int getNumberOfMedicines() {
        return numberOfMedicines;
    }

    public String getName(){
        return name;
    }

    //This is a getter for the max number of medicines
    public static int getMaxNumberOfMedicines() {
        return MaxNumberOfMedicines;
    }

    //This is the setter for the name
    public void setName(String name) {
        this.name = name;
    }

    //This is the setter for the Max Number Of Medicines
    public static void setMaxNumberOfMedicines(int maxNumberOfMedicines) {
        MaxNumberOfMedicines = maxNumberOfMedicines;
    }

    //This toString method sets the name of the pharmacy, \n numberOfMedicines, \n OverTheCounterQuantity, \n
    //the prescriptionQuantity

    public String toString() {
        return "Pharmacy: " + name + "\n" +
                "Number of Medicines: " + numberOfMedicines + "\n" +
                "Over the counter quantity: " + overTheCounterQuantity + "\n" +
                "Prescription quantity: " + prescriptionQuantity;
    }
}
