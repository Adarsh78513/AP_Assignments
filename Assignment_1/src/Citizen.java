import java.util.ArrayList;

public class Citizen {
    String citizenName;
    int age;
    long uniqueIDCitizen;
    int dosesGiven;
    int lastDoseDate;
    Vaccine v;
    static ArrayList<Citizen> allCitizen = new ArrayList();

    Citizen(String name, int age, long uniqueIDCitizen) {
        this.citizenName = name;
        this.age = age;
        this.uniqueIDCitizen = uniqueIDCitizen;
        this.dosesGiven = 0;
    }

    public static Citizen findCitizen(long uniqueIDCitizen){
        for ( Citizen c: allCitizen){
            if ( c.uniqueIDCitizen == uniqueIDCitizen){
                return c;
            }
        }
        return null;
    }

    public void VaccinationCondition(){
        if ( this.dosesGiven == 0){
            System.out.println("NOT VACCINATED");
        }
        else if ( this.dosesGiven < v.numOfDoses){
            System.out.println("PARTIALLY VACCINATED");
            System.out.println("Vaccine Given: " + v.vaccineName);
            System.out.println("Number fo doses given" + this.dosesGiven);
            System.out.println("Next Dose due date: " + this.lastDoseDate + v.gapBetweenDoses);
        }
        else {
            System.out.println("FULLY VACCINATED");
            System.out.println("Vaccine Given: " + v.vaccineName);
            System.out.println("Number fo doses given" + this.dosesGiven);
        }
    }

    public void vaccinateCitizen(Vaccine v, int day){
        if(this.dosesGiven == 0){
            this.v = v;
            this.dosesGiven += 1;
            System.out.println(this.citizenName + " vaccinated with " + v.vaccineName);
        }
        else if ( this.dosesGiven < v.numOfDoses ){
            this.dosesGiven += 1;
            this.lastDoseDate += day;
            System.out.println(this.citizenName + " vaccinated with " + v.vaccineName);
        }
        else {
            System.out.println("You are fully vaccinated.");
        }
    }
}