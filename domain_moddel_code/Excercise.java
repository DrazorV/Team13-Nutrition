import java.util.HashSet;
import java.util.Set;

public class Excercise {
    private String name;
    private double loss_callories;
    private double loss_carbonhydrates;
    private double loss_liquids;
    private double loss_fat;
    private double energy;
    private double how_many_times;
    private enum TypeSport{
        Light,Normal,Intense
    }
    private TypeSport type;
    private Set<ExcercisePerformance> excercisePerformances;
    public Excercise(String name,double loss_callories,double loss_carbonhydrates,double loss_liquids,double loss_fat,double energy,double how_many_times,TypeSport type){
        this.name=name;
        this.loss_callories=loss_callories;
        this.loss_carbonhydrates=loss_carbonhydrates;
        this.loss_liquids=loss_liquids;
        this.loss_fat=loss_fat;
        this.energy=energy;
        this.how_many_times=how_many_times;
        this.type=type;
        excercisePerformances=new HashSet<>();
    }
    public String getName(){
        return name;
    }
    public double getLoss_callories(){
        return  loss_callories;
    }

    public double getLoss_carbonhydrates() {
        return loss_carbonhydrates;
    }

    public double getLoss_liquids() {
        return loss_liquids;
    }

    public double getLoss_fat() {
        return loss_fat;
    }

    public double getEnergy() {
        return energy;
    }

    public double getHow_many_times() {
        return how_many_times;
    }

    public TypeSport getType() {
        return type;
    }
    public void addExcercisePerformance(ExcercisePerformance ep){
        excercisePerformances.add(ep);
    }

    public Set<ExcercisePerformance> getExcercisePerformances() {
        return excercisePerformances;
    }
}
