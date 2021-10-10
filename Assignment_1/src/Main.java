import java.util.Timer;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println("CoVin Portal initialised...");
        System.out.println("--------------------------------");
        Reader.init(System.in);

        Timer timer = new Timer();

        int menu;
        boolean portalRunning = true;
        while ( portalRunning ){
            System.out.println("""
                    1. Add Vaccine
                    2. Register Hospital
                    3. Register Citizen
                    4. Add Slot for Vaccination
                    5. Book Slot for Vaccination
                    6. List all slots for a hospital
                    7. Check Vaccination Status
                    8. Exit""");
            System.out.println("--------------------------------");

            menu = Reader.nextint();
            switch (menu) {
                case 1 -> {
                    System.out.print("Vaccine Name: ");
                    String vaccineName = Reader.next();
                    System.out.print("Number of doses: ");
                    int numOfDoses = Reader.nextint();
                    int gapBetweenDoses = 0;
                    if (numOfDoses > 1) {
                        System.out.print("Gap between Doses: ");
                        gapBetweenDoses = Reader.nextint();
                    }

                    //call for the function
                    Vaccine v = new Vaccine(vaccineName, numOfDoses, gapBetweenDoses);
                    Vaccine.addVaccine(v);
                    System.out.println("Vaccine Name: " + v.vaccineName + ", Number of Doses: " +
                            v.numOfDoses + ", Gap between Doses: " + v.gapBetweenDoses);
                }
                case 2 -> {
                    System.out.print("Hospital name: ");
                    String hospitalName = Reader.next();
                    System.out.print("PinCode: ");
                    int pinCode = Reader.nextint();
                    Hospital h = new Hospital(hospitalName, pinCode);
                    Hospital.allHospital.add(h);

                    //Make and print unique ID
                    System.out.println("Hospital Name: " + h.hospitalName + ", PinCode: " + h.PinCode +
                            " Unique ID: " + h.uniqueIDHospital);
                }
                case 3 -> {
                    System.out.print("Citizen Name: ");
                    String citizenName = Reader.next();
                    System.out.print("Age: ");
                    int age = Reader.nextint();
                    System.out.print("Unique ID: ");
                    long uniqueIDCitizen = Reader.nextlong();

                    //stop if age under 18
                    if (age > 18) {
                        Citizen c = new Citizen(citizenName, age, uniqueIDCitizen);
                        Citizen.allCitizen.add(c);
                        //Make and print unique ID
                        System.out.println("Citizen Name: " + c.citizenName + " , Age: " + c.age +
                                ", Unique ID: " + c.uniqueIDCitizen);
                    } else {
                        System.out.println("Only above 18 are allowed");
                    }
                }
                case 4 -> {
                    System.out.print("Enter Hospital ID: ");
                    int hospitalID = Reader.nextint();
                    Hospital ho = Hospital.findHospital(hospitalID);
                    System.out.print("Enter number of Slots to be added: ");
                    int numberOfSlot = Reader.nextint();
                    for (int i = 0; i < numberOfSlot; i++) {
                        System.out.print("Enter Day Number: ");
                        int dayNumber = Reader.nextint();
                        System.out.print("Enter Quantity: ");
                        int quantity = Reader.nextint();
                        System.out.println("Select Vaccine ");

                        //print all the vaccines we have available
                        for (Vaccine va : Vaccine.allVaccines) {
                            System.out.println(va.vaccineNumber + ". " + va.vaccineName);
                        }
                        int vaccineNumber = Reader.nextint();

                        //call the function to add the slot
                        ho.addSlot(dayNumber, quantity, vaccineNumber, ho);
                        Vaccine vac = Vaccine.findVaccine(vaccineNumber);
                        //TODO: clarify what quantity has to be printed
                        System.out.println("Slot added by Hospital " + ho.uniqueIDHospital +
                                " for Day: " + dayNumber +
                                ", Available Quantity: " + quantity +
                                " of Vaccine " + vac.vaccineName);

                    }
                }
                case 5 -> {
                    System.out.print("Enter patient Unique ID: ");
                    long patientID = Reader.nextlong();
                    Citizen c = Citizen.findCitizen(patientID);
                    System.out.println("""
                            1. Search by area
                            2. Search by Vaccine
                            3. Exit""");
                    System.out.print("Enter option: ");
                    int option = Reader.nextint();
                    if (option == 1) {
                        System.out.print("Enter PinCode: ");
                        int PinCode = Reader.nextint();

                        //print the near hospital
                        Hospital.printHospitalWithPin(PinCode);

                        System.out.print("Enter the Hospital ID: ");
                        int hosID = Reader.nextint();

                        //print the available slots
                        Hospital h1 = Hospital.findHospital(hosID);

                        h1.printAllSlots();
//                        for ( Slot s: h1.allSLots) {
//                            System.out.println( s.slotNumber + "-> Day: " +
//                                    s.dayNumber + " Vaccine: " +
//                                    s.vacc.vaccineName + " Qty: " + s.Quantity);
//
//                        }

                        System.out.print("Choose Slot: ");
                        int slotNumber = Reader.nextint();
                        Slot s = h1.findSlot(slotNumber);

//                        Citizen c = Citizen.findCitizen(patientID);
                        c.vaccinateCitizen(s, h1);

                    }
                    else if (option == 2) {
                        System.out.print("Enter Vaccine name: ");
                        String temp = Reader.next();
                        Vaccine vac = Vaccine.findVaccine(temp);

//                        //print all the hospital with this vaccine
//                        vac.printHospitalWithVaccines();
                        //print all the hospital
                        Hospital.printAllHospital();
                        System.out.print("Enter hospital ID: ");
                        int hosID = Reader.nextint();
                        Hospital hospt = Hospital.findHospital(hosID);

                        if (hospt.vaccineAvailable(vac)){
                            hospt.printAllSlotsWithVaccines(vac);

                            System.out.print("Choose Slot: ");
                            int chosenSlot = Reader.nextint();
                            Slot s = hospt.findSlot(chosenSlot);

                            c.vaccinateCitizen(s, hospt);
                        }
                        else{
                            System.out.println("No slots available");
                        }


                    } else if (option == 3) {
                        System.out.println("Exiting");
                    } else {
                        System.out.println("Choose correct option");
                    }
                }
                case 6 -> {
                    System.out.print("Enter Hospital Id: ");
                    int hospID = Reader.nextint();
                    Hospital h2 = Hospital.findHospital(hospID);

                    //print the available slots
                    for (Slot s : h2.allSLots) {
                        System.out.println("Day: " + s.dayNumber + " Vaccine: " +
                                s.vacc.vaccineName + " Qty: " + s.Quantity);
                    }
                }
                case 7 -> {
                    System.out.print("Enter Patient ID: ");
                    long patID = Reader.nextlong();
                    Citizen c = Citizen.findCitizen(patID);
                    c.VaccinationCondition();
                }
                case 8 -> {
                    System.out.print("Exiting the portal ");
                    portalRunning = false;
                }
                default -> {
                    System.out.println("Please choose a valid menu :)");
                    System.out.println("--------------------------------");
                }
            }
        }
    }
}
