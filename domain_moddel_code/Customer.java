import java.util.HashSet;
import java.util.Set;

public class Customer {
    private final String Username;
    private String password;
    private final String Name;
    private final String Surname;
    private final String gender;
    private int age;
    private double height;
    private double weight;
    private Nutrition_Goal.Nutrition_Goal_Type goals;
    private Set<Excercise> excercises;
    private Set<Food>foods;
    private Set<FoodConsumption> foodConsumptions;
    private Set<ExcercisePerformance> excercisePerformances;
    public Customer(String Username,String password,String Name,String Surname,String gender,int age,double height,double weight,Nutrition_Goal.Nutrition_Goal_Type goals){
        try {
            check(Username);
            check(Surname);
        }catch(Exception e){
            e.printStackTrace();
        }
        this.Username=Username;
        this.password=password;
        this.Name=Name;
        this.Surname=Surname;
        this.gender=gender;
        setAge(age);
        setHeight(height);
        setWeight(weight);
        setGoals(goals);
        excercisePerformances=new HashSet<>();
        foods=new HashSet<>();
        foodConsumptions=new HashSet<>();
        excercisePerformances=new HashSet<>();

    }
    public void setPassword(String password){

    }
    public void setAge(int age){
        try {
            checkAge(age);
        }catch(Exception e){
            e.printStackTrace();
        }
        this.age=age;
    }
    public void setHeight(double height){
        try {
            checkHeight(height);
        }catch(Exception e){
            e.printStackTrace();
        }
        this.height=height;
    }
    public void setWeight(double weight){
        try {
            checkWeight(weight);
        }catch(Exception e){
            e.printStackTrace();
        }
        this.weight=weight;
    }
    public void setGoals(Nutrition_Goal.Nutrition_Goal_Type goals){
        this.goals=goals;
    }

    public void check(String characteristic)throws Exception {
        for(int i=0; i<characteristic.length(); i++)
            if (!Character.isLetter(characteristic.charAt(i))) throw new NameException();
        }
    public void checkAge(int age)throws Exception{
        if(age<10 || age>100) throw new AgeException();
    }
    public void checkHeight(double height)throws Exception{
        if(height<0 || height>7)throw new HeightException();
    }
    public void checkWeight(double weight)throws Exception{
        if(weight<0) throw new WeightException();
    }
    public void checkPassword(String password) throws Exception{
        if(password.length()<7)throw new PasswordException();
        int sum=0;
                boolean sum2=false,sum3=false;
        for(int i=0; i<password.length(); i++) {
            if (Character.isLetter(password.charAt(i)))
                sum++;
            else if(Character.isDigit(password.charAt(i)))sum2=!sum2;
            else sum3=!sum3;
        }
        if(sum<5||!sum2||!sum3)throw new PasswordException();
    }

    public Set<ExcercisePerformance> getExcercisePerformances() {
        return excercisePerformances;
    }

    public double getHeight() {
        return height;
    }

    public Set<FoodConsumption> getFoodConsumptions() {
        return foodConsumptions;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public Nutrition_Goal.Nutrition_Goal_Type getGoals() {
        return goals;
    }

    public Set<Excercise> getExcercises() {
        return excercises;
    }

    public Set<Food> getFoods() {
        return foods;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return password;
    }

    public String getSurname() {
        return Surname;
    }

    public String getUsername() {
        return Username;
    }
    public void addFood(Food f){
        foods.add(f);
    }
    public void addExcercise(Excercise e){
        excercises.add(e);
    }
    public void addFoodConsumption(FoodConsumption fc){
        foodConsumptions.add(fc);
    }
    public void addExcercisePerformance(ExcercisePerformance ep){
        excercisePerformances.add(ep);
    }
}

