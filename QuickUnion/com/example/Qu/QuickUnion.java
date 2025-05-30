package com.example.Qu;
class QuickUnion{
    int N;
    int arr[];
    int size[];
    int rank[];
    QuickUnion(int N){
        this.N=N;
        arr=new int[N];
        size=new int[N];
        rank=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=i;
            size[i]=1;
            rank[i]=0;
        }
    }
     int findUltimateParent(int i){
        while(true){
            if(arr[i]==i)
            return i;
            else{
                i=arr[i];
            }
        }
    }
    void join(int x, int y) {//with path compression
    int rootX = findUltimateParent(x);
    int rootY = findUltimateParent(y);

    if (rootX == rootY) return; // already in same set

    arr[rootY] = rootX; // connect root of y to root of x
}

    void unionBysize(int a, int b) {
    int roota = findUltimateParent(a);
    int rootb = findUltimateParent(b);

    if (roota == rootb) return;

    if (size[roota] < size[rootb]) {
        join(rootb, roota);
        size[rootb] += size[roota];
    } else {
        join(roota, rootb);
        size[roota] += size[rootb];
    }
}
void unionByRank(int a, int b) {
    int roota = findUltimateParent(a);
    int rootb = findUltimateParent(b);

    if (roota == rootb) return;

    if (rank[roota] < rank[rootb]) {
        join(rootb, roota);
    } else if (rank[roota] > rank[rootb]) {
        join(roota, rootb);
    } else {
        join(roota, rootb);
        rank[roota] += 1;
    }
}


     boolean isSameSet(int x,int y){
        if(findUltimateParent(x)==findUltimateParent(y))
        return true;
        return false;
    }

}