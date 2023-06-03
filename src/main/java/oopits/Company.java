package oopits;

public class Company {
    int id;
    String name;
    String usage;
    String month;

    Company(){
        this.id = 00;
        this.name="NULL";
        this.usage="NULL";
        this.month="NULL";

    }
    Company(int x, String a, String b, String c){
        this.id = x;
        this.name=a;
        this.usage=b;
        this.month=c;

    }
    public String getName() {
        return this.name;
    }
    public void setName(String a) {
        this.name=a;
    }
    public void usageInfo(){
        if(Integer.toString(id).length()<2){
            if(name.length()<7){
                System.out.printf("| ID: %d \tCompany: %s\t\tUsage: %s\tMonth: %s\t |\n",id,name,usage,month);
            } else {
                System.out.printf("| ID: %d \tCompany: %s\tUsage: %s\tMonth: %s\t |\n",id,name,usage,month);
            }
    } else {
        if(name.length()<7 && month.equals("September")){
            System.out.printf("| ID: %d \tCompany: %s\t\tUsage: %s\tMonth: %s |\n",id,name,usage,month);
        } else if(name.length()<7){
            System.out.printf("| ID: %d \tCompany: %s\t\tUsage: %s\tMonth: %s\t |\n",id,name,usage,month);
        } else {
        System.out.printf("| ID: %d\tCompany: %s\tUsage: %s\tMonth: %s\t |\n",id,name,usage,month);
        }
    }
    }
}
