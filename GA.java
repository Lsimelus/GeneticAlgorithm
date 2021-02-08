import java.util.*;
import java.util.Random;
import java.util.ArrayList; 

/**
 * Write a description of class GA here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GA
{
    private int individuals;
    private String selection;
    private Double pC;
    private Double pM;
    private int generations;
    private int disInterval;
    private String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+=-[]{}|;’:,./<>? " + '"';
    private String GOAL = "I think this is a reasonable medium sized string!!";
    private String[] individualsList;

    /**
     * Constructor for objects of class GA
     */
    public GA(int individuals_, String selection_, Double pC_, Double pM_, int generations_, int disInterval_)
    {
        individuals = individuals_;
        selection = selection_;
        pC = pC_;
        pM = pM_;
        generations = generations_;
        disInterval = disInterval_;
        individualsList = new String[individuals];
    }

    public void init(){
        int i = 0;
        while(i < individuals){
            individualsList[i] = randomIndividual();
            i += 1;
        }
    }

    public String[] ts (){
        String[] parents = new String[individuals/2];
        Random rand = new Random();
        int i = 0;
        String poss1;
        String poss2;
        
        while(i < individuals/2){
            poss1 = individualsList[rand.nextInt(individuals)];
            poss2 = individualsList[rand.nextInt(individuals)];
            
            if (test(poss1) > test(poss2)){
                parents[i] = poss1;
            }else{
                parents[i] = poss2;
            }
            i += 1;
        }
        return parents;
    }

    public String[] bs (){
        double total = 0.0;
        double[] rawScores = new double[individuals];
        double curr = 0.0;
        String[] parent = new String[individuals/2];
        
        for (String individual : individualsList){
            total += Math.pow(Math.E,test(individual));
        }
        
        int i = 0;
        while(i < individuals){
            curr += Math.pow(Math.E,test(individualsList[i]))/total;
            rawScores[i] = curr;
            i += 1;
        }
        
        i = 0;
        while(i < individuals/2){
            int j = 0;
            double target = Math.random();
            while(rawScores[j] <= target){
                j += 1;
            }
            parent[i] = individualsList[j];
            i += 1;
        }

        return parent;
    }

    public String[] rs (){
        double total = 0.0;
        double[] rawScores = new double[individuals];
        double curr = 0.0;
        String[] parent = new String[individuals/2];
        
        for (String individual : individualsList){
            total += test(individual);
        }
        
        int i = 0;
        while(i < individuals){
            curr += test(individualsList[i])/total;
            rawScores[i] = curr;
            i += 1;
        }
        
        i = 0;

        while(i < individuals/2){
            int j = 0;
            double target = Math.random();
            while(rawScores[j] <= target){
                j += 1;
            }
            parent[i] = individualsList[j];
            i += 1;
        }

        return parent;
    }
    

    public String[] nextParents(){

        String[] parents;
        if("ts".equals(selection)){
            parents = ts();
        }else if("bs".equals(selection)){
            parents = bs();
        }else{
            parents = rs();
        }
        
        return parents;
    }
    
    public String share(String temp1, String temp2){
        Random rand = new Random();
        int point = rand.nextInt(GOAL.length()- 1) + 1;
        String part1 = temp1.substring(0, point);
        String part2 = temp2.substring(point, GOAL.length());
        return part1 + part2;
    }

    public void crossover(String[] parents){
        
        Random rand = new Random();
        int i = 0;
        
        String poss1;
        String poss2;
        String child;
        
        
        while(i < individuals){
            if(Math.random() <= pC){
                poss1 = parents[rand.nextInt(parents.length)];
                poss2 = parents[rand.nextInt(parents.length)];
                child = share(poss1, poss2);
            }else{
                child = parents[rand.nextInt(parents.length)];
            }
            individualsList[i] = child;
            
            i += 1;
        }
        
    }

    public void mutate(){
        Random rand = new Random();
        int i = 0;
        while(i < individuals){
            if (Math.random() <= pM){
                char letter = ALPHABET.charAt(rand.nextInt(ALPHABET.length()));
                char[] c = individualsList[i].toCharArray();
                c[rand.nextInt(GOAL.length())] = letter;
                individualsList[i] = new String(c);
            }
            i += 1;
        }
    }

    public int train(){
        init();
        int i = 0;
        String best = "";
        int num;
        double total = GOAL.length();

        String bestIndividual = "";
        int bestRating = 0;
        int bestGen = 0;
        double perc = 0.0;
        while(i < generations){
            
            
            crossover(nextParents());
            mutate();

            best = bestMatch();
            num = test(best);

            if(num > bestRating){
                bestIndividual = best;
                bestRating = num;
                bestGen = i;
            }

            if (GOAL.equals(best)){
                System.out.println("Hit the target!!");
                System.out.println("Target:            " + GOAL);
                System.out.println("Best individual:   " + GOAL);
                System.out.println("Generation found:  " + i);
                System.out.println("Score = "+ GOAL.length() + "/" + GOAL.length() + " = 100.0%");
                return i;
            }

            if (i % disInterval == 0){
                perc = num;
                System.out.println(i + " ( " + perc + "/ " + total + " =  " +(100* perc/total) + "%):   " + best);
            }
            i+=1;
        }
        System.out.println("Missed the target..");
        System.out.println("Target:            " + GOAL);
        System.out.println("Best individual:   " + bestIndividual);
        System.out.println("Generation found:  " + bestGen);
        perc = test(best);
        System.out.println("Score = "+ perc + "/" + total + " = "+ (100*perc/total) + "%");

        return i;
    }

    public int test(String sentence){
        int i = 0;
        int j = 0;
        while (i < GOAL.length()){
            if((GOAL.split("")[i]).equals(sentence.split("")[i])){
                j += 1;
            }
            i += 1;
        }
        return j;
    }

    public String bestMatch(){
        String message = "";
        int maxVal = 0;
        int maxi = 0;
        int i = 0;

        while(i < individuals){
            int curr = test(individualsList[i]);
            if (curr > maxVal){
                maxVal = curr;
                maxi = i;
            }
            i += 1;
        }

        return individualsList[maxi];
    }

    public String randomIndividual(){
        int i = 0;
        String message = "";
        Random rand = new Random();  

        while(i < GOAL.length()){
            message += ((ALPHABET).split("")[(rand.nextInt(ALPHABET.length()))]);
            i += 1;
        }

        return message;
    }

    public Boolean varCheck() throws Exception {
        String message = "Inavalid input: ";

        if (individuals < 1 ){
            message += "individuals.";
        }else if(!selection.equals("ts") && !selection.equals("bs") && !selection.equals("rs")){
            message += "selection.";
        }else if(pC < 0 || pC > 1){
            message += "pC.";
        }else if(pM < 0 || pM > 1){
            message += "pM.";
        }else if(generations < 1){
            message += "generations.";
        }else if(disInterval < 1 || disInterval >= generations){
            message += "disInterval.";
        }else{
            return null;
        }

        throw new ArithmeticException(message);
    }

}
