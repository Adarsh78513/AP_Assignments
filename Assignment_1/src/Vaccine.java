import java.util.ArrayList;

public class Vaccine {
    static int n = -1;
    String vaccineName;
    int numOfDoses;
    int gapBetweenDoses;
    int vaccineNumber;
    static ArrayList<Vaccine> allVaccines = new ArrayList();


    Vaccine(String name, int numOfDoses, int gapBetweenDoses) {
        this.vaccineName = name;
        this.numOfDoses = numOfDoses;
        this.gapBetweenDoses = gapBetweenDoses;
        this.vaccineNumber = n + 1;
        n += 1;
    }

    public static Vaccine findVaccine(int number){
        for ( Vaccine v: allVaccines){
            if ( v.vaccineNumber == number){
                return v;
            }
        }

        return null;
    }

    public static void addVaccine(Vaccine v){
        allVaccines.add(v);
    }

}
