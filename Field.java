import java.util.Scanner;

class Field {
  Cell[][] cells;
  int      width;
  int      height;
  Scanner sc;
  
  
  Field() { //constructor
    sc = new Scanner(System.in);
    this.width = sc.nextInt();
    this.height = sc.nextInt();
    
    this.cells = new Cell[width+2][height+2];
    for( int i=1; i < width+1; i++) {
      for( int j=1; j < height+1; j++) {
        this.cells[i][j] = new Cell(sc.nextInt());
      } 
    }
    
    for(int i = 0; i < width+2; i++){
      cells[i][0] = new Cell(0);
      cells[i][height+1]= new Cell(0);
    }
    
    for(int j = 1; j < height+2; j++){
      cells[0][j] = new Cell(0);
      cells[width+1][j] = new Cell(0);
    }
    
  }
  
  int computeMedianForCell(int x, int y){
    int count = 0;
    for(int i=0; i<3; i++){
      for(int j=0; j<3; j++){
        if(this.cells[x-i+1][y-j+1].getValue()==1){
            count++;
        }
        else {
            count--;
        }
      }
    }
    if(count > 0 ){
    return 1;
    }
    else{
    return 0;
    }
  } 
  
  void updateField() { // updates every cell by replacing it with median value
 
    for (int i=1; i<width+1;i++) {
      for (int j=1; j<height+1;j++) {
      cells[i][j].newValue = computeMedianForCell(i,j);}
    }
     for (int i=1; i<width+1;i++) {
      for (int j=1; j<height+1;j++) {
      cells[i][j].value = cells[i][j].newValue;}
    }
  } 
  
  void printField() {
    for(int i = 1; i < width+1; i++) {
      for(int j = 1; j < height+1; j++) {
        System.out.print(cells[i][j].getValue() + " ");
      }
      System.out.println();
    }
  }
  
  void run() {
    System.out.println("The original field looks like this:");
    printField();
    updateField();
    System.out.println("The field after one median computation looks like this:");
    printField();
  } 
   public static void main(String[] args) {
    (new Field()).run();
  }
 
}

class Cell {
  
  int value;    // Current value of cell
  int newValue; // new value of cell
  
  
  Cell(int aValue) { //constructor
    value = aValue;
  }
  
  int getValue() {
    return value;
  } 
  int getNewValue(){
    return newValue;
  }
}
