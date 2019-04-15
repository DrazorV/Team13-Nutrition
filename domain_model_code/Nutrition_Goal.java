import java.util.Date;
public class Nutrition_Goal {
    private Date startDate;
    private Date endDate;
    private double targetWeight;
    private boolean active;

    public enum Nutrition_Goal_Type {
        Maintain_Weight, Weight_Loss, Gain_Weight
    }

   private Nutrition_Goal_Type Goal_Type;

    public Nutrition_Goal(String type,double targeWeight) {
        startDate = new Date();
        active=true;
        this.targetWeight=targeWeight;
        if(type.equals("Maintain_Weight")) Goal_Type=Nutrition_Goal_Type.Maintain_Weight;
        else if(type.equals("Weight_Loss"))  Goal_Type=Nutrition_Goal_Type.Weight_Loss;
        else Goal_Type=Nutrition_Goal_Type.Gain_Weight;

    }
    public void diactivateGoal(){
        endDate=new Date();
        active=false;
    }
    public boolean isActive(){
        return  active;
    }
    public Date getStartDate(){
        return startDate;
    }
    public Date getEndDate(){
        return endDate;
    }
    public double getTargetWeight(){
        return targetWeight;
    }
    public Nutrition_Goal_Type getGoal_Type(){
        return  Goal_Type;
    }
}