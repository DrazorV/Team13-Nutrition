import java.util.*;

//0.45kg=3500 callories
//1       x
public class Customer {
    public enum JobType{Light,Normal,Intense}
    private final String Username;
    private String password;
    private final String Name;
    private final String Surname;
    private final String gender;
    private int age;
    private double height;
    private double weight;
    private JobType jobType;
    private Nutrition_Goal.Nutrition_Goal_Type goals;
    private Set<Excercise> excercises;
    private Set<Food>foods;
    private Set<FoodConsumption> foodConsumptions;
    private Set<ExcercisePerformance> excercisePerformances;
    private Set<WeightStatus>weightStatuses;
    private Set<Nutrition_Goal> nutriton_goals;
    public Customer(String Username,String password,String Name,String Surname,String gender,int age,double height,double weight,Nutrition_Goal.Nutrition_Goal_Type goals,String jobt){
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
        if(jobt.equals("Light"))jobType=JobType.Light;
        else if(jobt.equals("Normal"))jobType=JobType.Normal;
        else jobType=JobType.Intense;
        nutriton_goals=new HashSet<>();
        excercisePerformances=new HashSet<>();
        foods=new HashSet<>();
        foodConsumptions=new HashSet<>();
        excercisePerformances=new HashSet<>();

    }
    public void setPassword(String password){
           try{
               checkPassword(password);
           }catch (Exception e){
               e.printStackTrace();
           }
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
    private double BMR(double w) {
            double[] lm = {17.7, 15.1, 11.5, 11.9, 8.4};
            double[] lf = {13.4, 14.8, 8.3, 9.2, 9.8};
            int[] bm = {657, 692, 873, 700, 821};
            int[] bf = {692, 487, 687, 687, 624};
            double[] choosel;
            int[] chooseb;
            if (gender.equals("male")) {
                choosel = lm;
                chooseb = bm;
            } else {
                choosel = lf;
                chooseb = bf;
            }
            int i = 0;
            int[] boundary_ages = {18, 30, 60, 75};
            for (int j = 0; j < 4; j++) {
                if (boundary_ages[j] >= age) break;
                i++;
            }
            double bmr = choosel[i] * w + chooseb[i];

            if (BMI(w) > 30 && BMI(w) < 40) {
                bmr = 5 + 10 * w + 6.25 * height - 5 * age;
                if (gender.equals("female")) bmr -= 166;
            } else if (BMI(w) > 40)
                try{throw new Exception();}catch (Exception e){
                    System.out.println("Sorry friend I am afraid I canot help you.Advise your doctor Immediately");
                }
        return bmr;
    }
    private double BMI(double w){
        return w/(height*height);
    }
    public void addWeightSatus(){
        weightStatuses.add(new WeightStatus(weight,BMR(this.weight),BMI(this.weight)));
    }

    public double PAL(){
        Excercise.TypeSport ts;
        ArrayList<Date>dates=new ArrayList<>();
        Date maxdate=null;
        Excercise maxex=null;
       for (Excercise e:excercises){
           Date d=e.getMostRecent();
           if(maxdate==null||maxdate.compareTo(d)<0){
                 maxdate=d;
                 maxex=e;
           }
       }
       ts=maxex.getType();
       //continue
        if(jobType.equals(JobType.Light)){
            if(ts.equals(Excercise.TypeSport.Light)){
                return 1.4;
            }else if(ts.equals(Excercise.TypeSport.Normal)){
                return 1.5;
            }else{
              return 1.6;
            }
        }else if(jobType.equals(JobType.Normal)){
            double pal;
            if(ts.equals(Excercise.TypeSport.Light)){
                pal=1.6;
            }else if(ts.equals(Excercise.TypeSport.Normal)){
                pal=1.7;
            }else{
                pal=1.8;
            }
            if(gender.equals("female")){
                pal-=0.1;
            }
            return pal;
        }else{
            double pal;
            if(ts.equals(Excercise.TypeSport.Light)){
                pal=1.7;
            }else if(ts.equals(Excercise.TypeSport.Normal)){
                pal=1.8;
            }else{
                pal=1.9;
            }
            if(gender.equals("female")){
                pal-=0.2;
            }
            return pal;
        }


    }
    public double callories(double w){
          double callories=PAL()*BMR(w);
          if(BMI(w)>=18.5&&BMI(w)<=25){
              return callories;
          }else if(BMI(w)<18.5){
              return callories+500;
          }else if(BMI(w)>25&&BMI(w)<=30) {
              return callories - 500;
          }else if(BMI(w)>30&&BMI(w)<=40){
              return BMR(w)*1.4-500;
          }
          return -1;
    }
    public HashMap calculateFoodsAndExcercises(){
        //link :https://www.healthline.com/nutrition/how-many-calories-per-day#section1
        HashMap<String,Object> hashMap=new HashMap<>();
        ArrayList<String> fe=new ArrayList<>();
        fe.add("food");
        fe.add("excersice");
        ArrayList<Food> neededfoods=new ArrayList<>();
        ArrayList<Excercise> neededexcersice=new ArrayList<>();
        double targetweight=0;
        for(Nutrition_Goal ng:nutriton_goals){
            if(ng.isActive()){
                targetweight=ng.getTargetWeight();
            }
        }
        if(targetweight==weight) return null;
          else{
             //case1
            double neededCallories=callories(targetweight);
            if(neededCallories<callories(this.weight)){
                foods.stream().sorted(Comparator.comparing(Food::getCallories));
                for(Food f:foods){
                    neededfoods.add(f);
                    neededCallories+=f.getCallories();
                    if(neededCallories>callories(this.weight))break;
                }
            }else{
                excercises.stream().sorted(Comparator.comparing(Excercise::getLoss_callories));
                for(Excercise e:excercises){
                    neededexcersice.add(e);
                    neededCallories-=e.getLoss_callories();
                    if(neededCallories<callories(this.weight))break;
                }
            }
          hashMap.put(fe.get(0),neededfoods);
            hashMap.put(fe.get(1),neededexcersice);
            return hashMap;

        }
    }



}

