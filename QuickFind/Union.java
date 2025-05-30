public class Union {
    int N;
    int[] arr;
Union(int N){
this.N=N;
arr=new int[N];
for(int i=0;i<N;i++){
    arr[i]=i;
}
}
public void join(int a,int b){
if(arr[a]!=arr[b]){
    for(int i=0;i<N;i++){
        if(arr[i]==arr[b]){
            arr[i]=arr[a];
        }
    }
}
System.out.println("Joined");
for(int i=0;i<N;i++){
    System.out.print(arr[i] +" ");
}
System.out.println();
}
public boolean joined(int a, int b){
    if(arr[a]==arr[b]){
        return true;
    }
    return false;
}
}
