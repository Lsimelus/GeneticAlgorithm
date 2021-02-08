
/**
 * Write a description of class Controller here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Controller
{
    public static void main(String[] args) 
    {
        int i = 0;
        int var = 0;
        

        GA temp = new GA(100, "bs", .7, .01 , 10000 ,60);
        try {
            temp.varCheck();
            temp.train();
        }catch(Exception e){
            System.out.println(e);
        }
        

        /*
        while(i < 5){
            GA book =  new GA(100, "ts", .7, .01 , 10000 ,1000);

            try {
                book.varCheck();
                var += book.train();
            }catch(Exception e){
                System.out.println(e);
            }
            i += 1;
        } 
        var = var/5;
        System.out.println("selectionT:" + var);
        
        
        i = 0;
        var = 0;
        while(i < 5){
            GA book =  new GA(100, "bs", .7, .01 , 10000 ,1000);

            try {
                book.varCheck();
                var += book.train();
            }catch(Exception e){
                System.out.println(e);
            }
            i += 1;
        } 
        var = var/5;
        System.out.println("selectionB:" + var);
        
        
        i = 0;
        var = 0;
        while(i < 5){
            GA book =  new GA(100, "rs", .7, .01 , 10000 ,1000);

            try {
                book.varCheck();
                var += book.train();
            }catch(Exception e){
                System.out.println(e);
            }
            i += 1;
        } 
        var = var/5;
        System.out.println("selectionR:" + var);
        
        
        i = 0;
        var = 0;
        while(i < 5){
            GA book =  new GA(100, "bs", .0, .01 , 10000 ,5000);

            try {
                book.varCheck();
                var += book.train();
            }catch(Exception e){
                System.out.println(e);
            }
            i += 1;
        } 
        var = var/5;
        System.out.println("Crossover 0:" + var);
        
        
        i = 0;
        var = 0;
        while(i < 5){
            GA book =  new GA(100, "bs", .3, .01 , 10000 ,5000);

            try {
                book.varCheck();
                var += book.train();
            }catch(Exception e){
                System.out.println(e);
            }
            i += 1;
        } 
        var = var/5;
        System.out.println("Crossover .3:" + var);
        
        
        i = 0;
        var = 0;
        while(i < 5){
            GA book =  new GA(100, "bs", .7, .01 , 10000 ,5000);

            try {
                book.varCheck();
                var += book.train();
            }catch(Exception e){
                System.out.println(e);
            }
            i += 1;
        } 
        var = var/5;
        System.out.println("Crossover .7:" + var);
        
        
        i = 0;
        var = 0;
        while(i < 5){
            GA book =  new GA(100, "bs", 1.0, .01 , 10000 ,5000);

            try {
                book.varCheck();
                var += book.train();
            }catch(Exception e){
                System.out.println(e);
            }
            i += 1;
        } 
        var = var/5;
        System.out.println("Crossover 1:" + var);
       
        
        i = 0;
        var = 0;
        while(i < 5){
            GA book =  new GA(100, "bs", .7, .0 , 10000 ,5000);

            try {
                book.varCheck();
                var += book.train();
            }catch(Exception e){
                System.out.println(e);
            }
            i += 1;
        } 
        var = var/5;
        System.out.println("M 0:" + var);
        
        i = 0;
        var = 0;
        while(i < 5){
            GA book =  new GA(100, "bs", .7, .0001 , 10000 ,5000);

            try {
                book.varCheck();
                var += book.train();
            }catch(Exception e){
                System.out.println(e);
            }
            i += 1;
        } 
        var = var/5;
        System.out.println("M .0001:" + var);
        
        i = 0;
        var = 0;
        while(i < 5){
            GA book =  new GA(100, "bs", .7, .005 , 10000 ,5000);

            try {
                book.varCheck();
                var += book.train();
            }catch(Exception e){
                System.out.println(e);
            }
            i += 1;
        } 
        var = var/5;
        System.out.println("M .005:" + var);
        
        i = 0;
        var = 0;
        while(i < 5){
            GA book =  new GA(100, "bs", .7, .01 , 10000 ,5000);

            try {
                book.varCheck();
                var += book.train();
            }catch(Exception e){
                System.out.println(e);
            }
            i += 1;
        } 
        var = var/5;
        System.out.println("M .01:" + var);
        
        i = 0;
        var = 0;
        while(i < 5){
            GA book =  new GA(100, "bs", .7, .05 , 10000 ,5000);

            try {
                book.varCheck();
                var += book.train();
            }catch(Exception e){
                System.out.println(e);
            }
            i += 1;
        } 
        var = var/5;
        System.out.println("M .05:" + var);
        
        i = 0;
        var = 0;
        while(i < 5){
            GA book =  new GA(100, "bs", .7, .1 , 10000 ,5000);

            try {
                book.varCheck();
                var += book.train();
            }catch(Exception e){
                System.out.println(e);
            }
            i += 1;
        } 
        var = var/5;
        System.out.println("M .1:" + var);
        
        i = 0;
        var = 0;
        while(i < 5){
            GA book =  new GA(100, "bs", .7, .2 , 10000 ,5000);

            try {
                book.varCheck();
                var += book.train();
            }catch(Exception e){
                System.out.println(e);
            }
            i += 1;
        } 
        var = var/5;
        System.out.println("M .2:" + var);
        */
        
    }
}
