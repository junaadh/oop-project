package oopsdg;
/**
 *
 * @author Sheridan Sai
 * 
 * This is the company class file. It defines the attributes of company
  which data we store and process in this program. It has several attributes,
  and several method. The company is then constructed in Initializer file inside
  the cList, and the data will be loaded in several places.
 */
public class Company {
    int id;
    String name;
    String energy;
    String month;
    String water;
        
    
    Company(int x, String a, String b, String c, String d){
        this.id= x;
        this.name=a;
        this.energy=b;
        this.month=c;
        this.water=d;
        
    }
    
    public String getName(){
        return this.name;
        
    }

    public int getID() {
        return this.id;
    }

    public String getEnergy() {
        return this.energy;
    }

    public String getMonth() {
        return this.month;
    }

    public String getWater() {
        return this.water;
    }
    
    public void setName(String a) {
        this.name=a;
    }
    
    public void usageInfo(boolean a){
        if (a){
        if(Integer.toString(id).length()<2){
            if(name.length()<7){
                System.out.printf("| ID: %d\t\tCompany: %s\t\tUsage: %s\tMonth: %s\t |\n", id, name, energy, month);
            } else {
                System.out.printf("| ID: %d\t\tCompany: %s\tUsage: %s\tMonth: %s\t |\n", id, name, energy, month);
            }
        }else{
            if(name.length()<7 && month.equals("September")){
                System.out.printf("| ID: %d \tCompany: %s\t\tUsage: %s\tMonth: %s |\n", id, name, energy, month);
            } else if(name.length()>7 && month.equals("September")){
                System.out.printf("| ID: %d \tCompany: %s\tUsage: %s\tMonth: %s |\n", id, name, water, month);
            } else if(name.length()<7){
                System.out.printf("| ID: %d \tCompany: %s\t\tUsage: %s\tMonth: %s\t |\n",id, name, energy, month);
            } else {
                System.out.printf("| ID: %d\tCompany: %s\tUsage: %s\tMonth: %s\t |\n", id, name, energy, month);
            }
                
                
        }
        }else{
            if(Integer.toString(id).length()<2){
            if(name.length()<7){
                System.out.printf("| ID: %d\t\tCompany: %s\t\tUsage: %s\tMonth: %s\t |\n", id, name, water, month);
            } else {
                System.out.printf("| ID: %d\t\tCompany: %s\tUsage: %s\tMonth: %s\t |\n", id, name, water, month);
            }
        }else{
            if(name.length()<7 && month.equals("September")){
                System.out.printf("| ID: %d \tCompany: %s\t\tUsage: %s\tMonth: %s |\n", id, name, water, month);
            } else if(name.length()>7 && month.equals("September")){
                System.out.printf("| ID: %d \tCompany: %s\tUsage: %s\tMonth: %s |\n", id, name, water, month);
            } else if(name.length()<7){
                System.out.printf("| ID: %d \tCompany: %s\t\tUsage: %s\tMonth: %s\t |\n",id, name, water, month);
            } else {
                System.out.printf("| ID: %d\tCompany: %s\tUsage: %s\tMonth: %s\t |\n", id, name, water, month);
            }
            
        }
        } 
    }

}   
  
  