import java.util.*;

//0.45kg=3500 callories
//1       x
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
    private Set<WeightStatus>weightStatuses;
    private Set<Nutrition_Goal> nutriton_goals;
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
        nutriton_goals=new HashSet<>();
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
    private double BMR(){
        double[]lm={17.7,15.1,11.5,11.9,8.4};
        double[]lf={13.4,14.8,8.3,9.2,9.8};
        int []bm={657,692,873,700,821};
        int[]bf={692,487,687,687,624};
        double []choosel;
        int []chooseb;
        if(gender.equals("male")){
            choosel=lm;
            chooseb=bm;
        }else{
            choosel=lf;
            chooseb=bf;
        }
        int i=0;
        int []boundary_ages={18,30,60,75};
        for(int j=0; j<4; j++){
            if(boundary_ages[j]>=age)break;
            i++;
        }
        return choosel[i]*weight+chooseb[i];
    }
    private double BMI(){
        return weight/(height*height);
    }
    public void addWeightSatus(){
        weightStatuses.add(new WeightStatus(weight,BMR(),BMI()));
    }
    public double Callories() {
        double sum = 0;
        for(Food f:foods)sum=sum+f.how_many_foods();
        return sum;
    }
    public HashMap calculateFoodsAndExcercises(){
        //link :https://www.healthline.com/nutrition/how-many-calories-per-day#section1
        double targetweight=0;
        for(Nutrition_Goal ng:nutriton_goals){
            if(ng.isActive()){
                targetweight=ng.getTargetWeight();
            }
        }
        if(targetweight==weight) return null;
        double neededcallories=0;
        if(goals==Nutrition_Goal.Nutrition_Goal_Type.Maintain_Weight){
            if(gender.equals("male")){
                neededcallories=2500;
            }else{
                neededcallories=2000;
            }
        }else if(goals==Nutrition_Goal.Nutrition_Goal_Type.Weight_Loss){
            if(gender.equals("male")){
                neededcallories=2000;
            }else{
                neededcallories=1500;
            }
        }else{
            if(gender.equals("male")){
                neededcallories=2000;
            }else{
                neededcallories=1500;
            }
        }
        double sum=0;
        ArrayList<Food> neededFoods=new ArrayList<>();
        ArrayList<Excercise> neededExcercise=new ArrayList<>();
        for(Food f:foods){
            if(sum>neededcallories) break;
            sum=sum+f.getCallories();
            neededFoods.add(f);
        }
        excercises.stream().sorted(Comparator.comparing(Excercise::getLoss_callories));//link: https://stackoverflow.com/questions/22391350/how-to-sort-a-hashset
        for(Excercise e:excercises){
            if(sum<=neededcallories)break;
            sum=sum-e.getLoss_callories();
        }ArrayList<String> fe=new ArrayList<>();
        fe.add("food");
        fe.add("excersice");
            HashMap < String,Object> hm = new HashMap<>();

        hm.put(fe.get(0),neededFoods);
        hm.put(fe.get(1),neededExcercise);
         return hm;
    }

}

