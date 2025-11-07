#include<iostream>
#include<vector>
using namespace std;
int knapsackdp(int n,int W,vector<int> &val,vector<int> &wt){
    vector<vector<int>> dp(n+1,vector<int>(W+1,0));
    for(int i=1;i<=n;i++){
        for(int w=1;w<=W;w++){
            if(wt[i-1]<=w){
                dp[i][w]=max(dp[i-1][w],val[i-1]+dp[i-1][w-wt[i-1]]);
            }else{
                dp[i][w]=dp[i-1][w];
            }
        }
    }
    return dp[n][W];
}
int main(){
    int n,W;
    cout<<"Enter number of items:\n";
    cin>>n;
    vector<int> val(n);
    vector<int> wt(n);
    cout<<"Enter values and corresponding weights:\n";
    for(int i=0;i<n;i++){
        cin>>val[i]>>wt[i];
    }
    cout<<"Enter capacity of knapsack:\n";
    cin>>W;
    cout<<"Maxvalue:"<<knapsackdp(n,W,val,wt);
}