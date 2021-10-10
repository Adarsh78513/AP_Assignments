import java.util.ArrayList;
import java.util.Objects;

public class Hospital {
    static int hospitalNumber = 100000;
    int PinCode;
    int uniqueIDHospital;
    ArrayList<Slot> allSLots;
    String hospitalName;
    static ArrayList<Hospital> allHospital = new ArrayList();

    Hospital(String hospitalName, int PinCode){
        this.hospitalName = hospitalName;
        this.PinCode = PinCode;
        this.uniqueIDHospital = hospitalNumber + 1;
        hospitalNumber += 1;
        allSLots = new ArrayList<>();

    }

    public void addSlot(int dayNumber, int quantity, int vaccineNumber, Hospital ho){
        Vaccine vacc = Vaccine.findVaccine(vaccineNumber);
        Slot s = new Slot(dayNumber, quantity, vacc, allSLots.size());
        allSLots.add(s);
        vacc.addHospital(ho);
    }

    public static Hospital findHospital(int hospitalNumber){
        for ( Hospital h: allHospital){
            if ( h.uniqueIDHospital == hospitalNumber){
                return h;
            }
        }

        return null;
    }
    public static Hospital printHospitalWithPin(int pinCode){
        for ( Hospital h: allHospital){
            if ( h.PinCode == pinCode) {
                System.out.println(h.uniqueIDHospital + " " + h.hospitalName);
            }
        }

        return null;
    }

    public void printAllSlots(){
	    for (Slot s: this.allSLots){
            System.out.println( s.slotNumber + "-> Day: " +
                    s.dayNumber + " Vaccine: " +
                    s.vacc.vaccineName + " Qty: " + s.Quantity);
	    }
    }

    public static void printAllHospital(){
        for ( Hospital h: allHospital){
            System.out.println(h.uniqueIDHospital + " " + h.hospitalName);
        }
    }

    public void printAllSlotsWithVaccines(Vaccine vac){
        for (Slot s: this.allSLots){
            if (Objects.equals(s.vacc.vaccineName, vac.vaccineName)){
                System.out.println( s.slotNumber + "-> Day: " +
                        s.dayNumber + " Vaccine: " +
                        s.vacc.vaccineName + " Qty: " + s.Quantity);
            }
        }
    }


    public boolean vaccineAvailable(Vaccine v){
        for ( Slot s: this.allSLots){
            if (Objects.equals(s.vacc.vaccineName, v.vaccineName)){
                return true;
            }
        }
        return false;
    }

    public Slot findSlot(int slotNumber){
        for ( Slot s : this.allSLots){
            if ( s.slotNumber == slotNumber){
                return s;
            }
        }
        return null;
    }
}
