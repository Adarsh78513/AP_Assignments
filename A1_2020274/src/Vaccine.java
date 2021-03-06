import java.util.ArrayList;
import java.util.Objects;

public class Vaccine {
    static int n = -1;
    String vaccineName;
    int numOfDoses;
    int gapBetweenDoses;
    int vaccineNumber;
    static ArrayList<Vaccine> allVaccines = new ArrayList();
    ArrayList<Hospital> vaccineInHospitals;


    Vaccine(String name, int numOfDoses, int gapBetweenDoses) {
        this.vaccineName = name;
        this.numOfDoses = numOfDoses;
        this.gapBetweenDoses = gapBetweenDoses;
        this.vaccineNumber = n + 1;
        n += 1;
        vaccineInHospitals = new ArrayList();
    }

    public static Vaccine findVaccine(int number){
        for ( Vaccine v: allVaccines){
            if ( v.vaccineNumber == number){
                return v;
            }
        }

        return null;
    }

    public static Vaccine findVaccine(String vac){
        for ( Vaccine v: allVaccines){
            if (Objects.equals(v.vaccineName, vac)){
                return v;
            }
        }

        return null;
    }

    public static void addVaccine(Vaccine v){
        allVaccines.add(v);
    }

    //TODO: Add in correct place
    public void addHospital(Hospital h){
        this.vaccineInHospitals.add(h);
    }

    public void removeHospital(Hospital h){
        this.vaccineInHospitals.remove(h);
    }

    public void printHospitalWithVaccines(){
        for ( Hospital h: this.vaccineInHospitals){
            System.out.println(h.uniqueIDHospital + " " + h.hospitalName);
        }
    }
}
