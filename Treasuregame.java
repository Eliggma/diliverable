package Treasuregame;
import java.util.Scanner;
import java.util.Random;
import java.util.*;
public class Treasuregame {
    public static void main(String[] args) {
     
    String ANSI_RED = "\u001B[31m";
    String ANSI_BLACK = "\u001B[30m";
    String ANSI_WHITE = "\u001B[37m";
    int x = 0;//defines the starting value of x
     Scanner myObj1 = new Scanner(System.in);//creates object for user charicter
     Scanner myObj4 = new Scanner(System.in);//creates object for board width
     Scanner myObj3 = new Scanner(System.in);//creates object for board heigth
     Scanner myObj2 = new Scanner(System.in);//creates object for user input
     int y = 0;//defines the starting value of y
     int z = 1;
     
     Hashtable<String, Integer> my_dict = new Hashtable<String, Integer>();//creates a dictonary for wasd to number conversion
     my_dict.put("w", -1);
     my_dict.put("a", -1);
     my_dict.put("s", 1);
     my_dict.put("d", 1);
     
     System.out.println("How wide do you want your map to be?");//sets the width and height of the map, max 20
     int width = myObj3.nextInt();
     if(width < 1){
         width = 1;
     }else if(width > 10){
         width = 10;
     }
     System.out.println("How tall do you want your map to be?");
     int height = myObj4.nextInt();
     if(height < 1){
        height = 1;
    }else if(height > 10){
        height = 10;
    }
    
    Random rand = new Random();
    int upperbound = (height*width);
    int treasure = rand.nextInt(upperbound);//assigns a random number on the grid to treasure
     
    System.out.println("Choose your fighter (pick a letter)");//lets the player pick a char
     char fighter = myObj2.next().charAt(0);//assigns the char to fighter
    
    int f = width-1;
    int p = height;

     for(int r = 0; r < 1; r += 0){//loops the movement code untill r =1 
     int mynum = x+(y*width);
     int hisnum = f+(p*width);
     if(mynum == hisnum){
        System.out.println("You got caught! Game over...");
        r++;
        z++;
     }
     if(mynum == treasure){//if mynum = treasure set r to 1
        r += 1;
    }for(int a = 1; a <= height; a++){//runs loop for the heights
         for(int b = 1; b <= width; b++){//runs loop for the width
            if((mynum > -1) && (mynum < 1)){//if my num = 0, print the charicter and if num = treasure win
                System.out.print(ANSI_BLACK + fighter + " " + ANSI_BLACK);
                mynum--;
                hisnum--;
            }else if((hisnum > -1) && (hisnum < 1)){
                System.out.print(ANSI_RED + "! " + ANSI_RED);
                mynum--;
                hisnum--;
            }else{
                System.out.print(ANSI_WHITE + "X " + ANSI_WHITE);//if my num dosn't = 0, print x
                mynum--;
                hisnum--;
         }
        }
        System.out.print("\n");
     }

     if(y == p){
         if(x > f){
             f++;
         }else{
             f--;
         }
     }else if(y > p){
         p++;
     }else{
         p--;
     }


     String movement = myObj2.nextLine();//takes player inpute and turns into movement
     if((movement.equals("w")) || (movement.equals("s"))){//if movement = w or s convert movement to values using my_dict
        y += (my_dict.get(movement));
        if(y >= height ){
            y = 0;
        }else if(y < 0){
            y = (height-1);
        }
    }else if((movement.equals("a")) || (movement.equals("d"))){//if movement = a or d convert movement to values using my_dict
        x += (my_dict.get(movement));
        if(x >= width ){
            x = 0;
        }else if(x < 0){
            x = (width-1);
        }
        }
        System.out.print("\n\n");

}
    if(z == 1){
        System.out.println("You won!");
    }
}
}


