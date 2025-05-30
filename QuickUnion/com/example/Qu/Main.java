package com.example.Qu;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of elements");
        int n=sc.nextInt();sc.nextLine();
        QuickUnion uni=new QuickUnion(n);
        System.out.println("Enter pairs");
        while(sc.hasNextInt()){
            int a=sc.nextInt();
            int b=sc.nextInt();
            sc.nextLine();
            uni.join(a,b);
        }
        sc.nextLine();
        while(true){
            System.out.println("Please select options\n1.check if same set(enter two elements)\n2.find ultimate parent\n3.exit");
            int ni=sc.nextInt();sc.nextLine();
            if(ni==1){
                int ax=sc.nextInt();
                int bx=sc.nextInt();
                sc.nextLine();
                System.out.println(uni.isSameSet(ax, bx));
            }
            if(ni==3)break;
            if(ni==2){
                int e=sc.nextInt();sc.nextLine();
                System.out.println(uni.findUltimateParent(e));
            }
        }
    }
}
