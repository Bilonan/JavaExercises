4import java.util.Scanner;

class CellulitisOneMethodLocal {
  Scanner sc = new Scanner( System.in );
  
  void readNexecute() {
    // constants for drawing
    final String EMPTY = " "; // for ease of understanding: just use them
    final String OCC = "*"; // just use them for outputating
    
    String machineType; // A, B or U
    int length;         // length of line of displayed cells
    int generations;    // number of generations to be displayed
    boolean[] rules = new boolean[8];//rule sequence for universal automaton
    int n; // the rule number in case Universal is added
    
    boolean[] line;
    boolean[] newline;
 
    
    machineType = sc.next();
    length = sc.nextInt();
    generations = sc.nextInt();
    line = new boolean[length+2];
    
    sc.next(); //init_start
    
    int nextTrue;
    while (sc.hasNextInt()) { 
      nextTrue = sc.nextInt();
      if (nextTrue>length) {break;} //thats for out of bounds exception
      //System.out.println("becoming true" + nextTrue);
      line[nextTrue] = true; }
    
    sc.next(); //init_end
    
    
    
    
    if (machineType.equals("U")) { 
      rules = new boolean[8];
        for(int i = 0; i < rules.length; i++) {
            int j = sc.nextInt();
            if (j == 1) {
                rules[i] = true;
            }
        }
        


        newline = new boolean[length+2];
        for(int j = 0; j < generations; j++) {  
            for(int i=1; i<=length; i++){
                if(line[i]){
                  System.out.print(OCC);      //prints a star if it is an occupied cell
                }
                else{
                  System.out.print(EMPTY);      //print a space if it is an empty cell
                }
            }
            System.out.println();
            for (int i = 1; i <= length; i++) {  //copy list into active lin
      
                int index = 0;  //binary index to locate right rule to apply
                if (line[i+1]) {
                  index += 1;
                }
                if (line[i]) {
                  index += 2;
                }
                if (line[i-1]) {
                  index += 4;
                }
                newline[i] = rules[index]; //applies rule from rule list
                //line[i] = newline[i];
            }
            line = newline.clone();

        //
        }
        //System.out.println();
    } else {
    //}
    
    
    
    
    
    
    
    // automaton 
   
    
    for (int j = 0; j < generations; j++) {
      //Sysrem.out.println("current generation: ")
      
      for(int i=1; i<=length; i++){
          if(line[i]){
            System.out.print(OCC);      //prints a star if it is an occupied cell
          }
          else{
            System.out.print(EMPTY);      //print a space if it is an empty cell
          }
        }
      
      System.out.println(); 
      
      newline = new boolean[length+2];
      newline[0] = false;
      newline[length+1] = false;
      
        if ( machineType.equals("A") ) { 
            for(int i = 1; i<=length; i++){
                if (line[i]) {newline[i] = line[i-1] ^ line[i+1];}
                else {newline[i] = line[i-1] || line[i+1]; } }
        }
        
        //machine B;
        
        if (machineType.equals("B")) {
          for(int i = 1; i<=length; i++){
            if  (line[i]) {
              // stay occupied if only the right neighbor is empty
              newline[i] = !line[i + 1];
            } else {
              // if it is empty, become occupied if exactly one neighbor is occupied
              newline[i] = line[i - 1] ^ line[i + 1];
            }
          }
        }
        //line = newline;
        
        line = newline.clone();
    }  
     // end readNexecute 
    }
  }
  public static void main(String[] args) {
    new CellulitisOneMethodLocal().readNexecute();
  }
}
