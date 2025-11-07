#include<iostream>
#include<vector>
using namespace std;
vector<int> fibonacci(int n){
    vector<int> ans;
    if(n==1){
        ans.push_back(0);
        return ans;
    } 
    if(n==2){
        ans.push_back(1);
        return ans;
    }
    ans.push_back(0);
    ans.push_back(1);
    for(int i=2;i<n;i++){
        ans.push_back(ans[i-1]+ans[i-2]);
        
    }
    return ans;
}
int recursive_fibo(int n){
    if(n==1) return 0;
    if(n==2) return 1;
    return recursive_fibo(n-1)+recursive_fibo(n-2);
}


  
int main(){
    int a;
    cout<<"Enter numbers to be print :";
    cin>>a;
    vector<int> v=fibonacci(a);
    cout<<"fibonacci no's(non-recursive):";
    for(int val:v){
        cout<<val<<" ";
    }cout<<endl<<"fibonacci no's(recusive):";
    for(int i=1;i<=a;i++){
         cout<<recursive_fibo(i)<<" ";
    }
   
    return 0;
}