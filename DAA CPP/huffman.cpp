#include<iostream>
#include<vector>
#include<string>
#include<queue>
using namespace std;
struct Node{
    char ch;
    int freq;
    Node *left,*right;
    Node(char c,int f){
        ch=c;
        freq=f;
        left=right=nullptr;
    }
};
struct Compare{
    bool operator()(Node* a,Node* b){
        return a->freq > b->freq;
    }
};

void printcodes(Node* root , string code){
    if(!root) return;
    if(!root->left && !root->right){
        cout<<root->ch<<" : "<<code<<endl;
    }
    printcodes(root->left,code+"0");
    printcodes(root->right,code+"1");
}
void huffmanencoding(vector<char> &chars,vector<int> &freq){
    priority_queue<Node*,vector<Node*>,Compare> pq;
    for(int i=0;i<chars.size();i++){
        pq.push(new Node(chars[i],freq[i]));
    }
    while(pq.size()>1){
        Node* left=pq.top();
        pq.pop();
        Node* right=pq.top();
        pq.pop();
        Node* newnode=new Node('-',left->freq+right->freq);
        newnode->left=left;
        newnode->right=right;
        pq.push(newnode);
    }
    Node* root=pq.top();
    cout<<"Huffman Codes:"<<endl;
    printcodes(root,"");
}
int main(){
    int n;
    cout<<"Enter number of characters in the message:";
    cin>>n;
    vector<char> chars1(n);
    vector<int> freq1(n);
    for(int i=0;i<n;i++){
        cin>>chars1[i];
    }
    cout<<"Enter values of corresponding freq:/n";
    for(int i=0;i<n;i++){
        cin>>freq1[i];
    }
    huffmanencoding(chars1,freq1);
    return 0;
}