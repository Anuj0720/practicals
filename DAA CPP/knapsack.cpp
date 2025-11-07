#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;
struct item{
    int value;
    int weight;
};
bool compare(item a,item b){
    double r1=(double)a.value/a.weight;
    double r2=(double)b.value/b.weight;
    return r1> r2;
}
double fractionalknapsack(int n,int w,vector<item> &items){
    sort(items.begin(),items.end(),compare);
    double total_value=0.0;
    for(int i=0;i<n;i++){
        
        if(items[i].weight<=w){
            w-=items[i].weight;
            total_value+=items[i].value;
        }else{
            total_value+=items[i].value*((double)w/items[i].weight);
            break;
        }
    }
    return total_value;
}
int main(){
    int n,w;
    cout<< "Enter number of items:\n";
    cin>>n;
    vector<item> items(n);
    cout<<"Enter values and corresponding weight:\n";
    for(int i=0;i<n;i++){
        cin>>items[i].value>>items[i].weight;
    }
    cout<<"capacity of knapsack:\n";
    cin>>w;
    cout<<"maxvalue:"<<fractionalknapsack(n,w,items);
    return 0;
}