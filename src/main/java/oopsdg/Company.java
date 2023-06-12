package oopsdg;
/**
 *
 * @author Sheridan Sai
 */
public class Company {
    int id;
    String name;
    String usage;
    String month;
    String water;
        
    
    Company(int x, String a, String b, String c, String d){
        this.id= x;
        this.name=a;
        this.usage=b;
        this.month=c;
        this.water=d;
        
    }
    
    public String getName(){
        return this.name;
        
    }

    public int getID() {
        return this.id;
    }

    public String getUsage() {
        return this.usage;
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
                System.out.printf("| ID: %d\t\tCompany: %s\t\tUsage: %s\tMonth: %s\t |\n", id, name, usage, month);
            } else {
                System.out.printf("| ID: %d\t\tCompany: %s\tUsage: %s\tMonth: %s\t |\n", id, name, usage, month);
            }
        }else{
            if(name.length()<7 && month.equals("September")){
                System.out.printf("| ID: %d \tCompany: %s\t\tUsage: %s\tMonth: %s |\n", id, name, usage, month);
            } else if(name.length()<7){
                System.out.printf("| ID: %d \tCompany: %s\t\tUsage: %s\tMonth: %s\t |\n",id, name, usage, month);
            } else {
                System.out.printf("| ID: %d\tCompany: %s\tUsage: %s\tMonth: %s\t |\n", id, name, usage, month);
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
            } else if(name.length()<7){
                System.out.printf("| ID: %d \tCompany: %s\t\tUsage: %s\tMonth: %s\t |\n",id, name, water, month);
            } else {
                System.out.printf("| ID: %d\tCompany: %s\tUsage: %s\tMonth: %s\t |\n", id, name, water, month);
            }
            
        }
        } 
    }

}   
  
  