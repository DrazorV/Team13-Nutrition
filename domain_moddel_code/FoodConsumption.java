import java.util.Date;

public class FoodConsumption {
    private int quantity;
    private Date date;
    private enum MealType {
        Breakfast, Lunch, Dinner
    }
    private MealType mealType;

    public FoodConsumption(int quantity,MealType mealType){
        this.quantity=quantity;
        this.mealType=mealType;
        date=new Date();
    }
    public int getQuantity(){
        return quantity;
    }
    public Date getDate(){
        return date;
    }
    public MealType getMealType(){
        return mealType;
    }
}
