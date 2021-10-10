import java.util.ArrayList;

public class Hospital {
    static int hospitalNumber = 100000;
    int PinCode;
    int uniqueIDHospital;
    ArrayList<Slot> allSLots;
    String hospitalName;
    static ArrayList<Hospital> allHospital = new ArrayList();
    Slot slots;

    Hospital(String hospitalName, int PinCode){
        this.hospitalName = hospitalName;
        this.PinCode = PinCode;
        this.uniqueIDHospital = hospitalNumber + 1;
        hospitalNumber += 1;
        allSLots = new ArrayList<>();

    }

    public void addSlot(int dayNumber, int quantity, int vaccineNumber){
        Vaccine vacc = Vaccine.findVaccine(vaccineNumber);
        Slot s = new Slot(dayNumber, quantity, vacc, allSLots.size());
        allSLots.add(s);
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

    public Slot findSlot(int slotNumber){
        for ( Slot s : this.allSLots){
            if ( s.slotNumber == slotNumber){
                return s;
            }
        }
        return null;
    }
}
