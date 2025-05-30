import java.util.*;
public class Hello {
   public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of objects: ");
    int N=sc.nextInt();
    sc.nextLine();
    Union un= new Union(N);
    System.out.println("Enter pairs");
    while(sc.hasNextInt()){
        un.join(sc.nextInt(),sc.nextInt());
        sc.nextLine();
    }
    System.out.println("checking");
    sc.nextLine();
    int x=sc.nextInt();
    int y=sc.nextInt();
    System.out.println(un.joined(x, y));
    for(int i=0;i<N;i++){
        System.out.print(un.arr[i]);
    }
    System.out.println("Hello World!");
   }
}