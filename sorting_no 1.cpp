#include <iostream>
using namespace std;

int main()
{
	int number[7],temp,count;
	for(int i = 0; i <7; i++){
		cin >> number[i];
	}
	
	for(int i = 0; i <7; i++){
		for(int j = 0; j<6; j++){	
			if(number[j]>number[j+1])
			{
				temp=number[j];
				number[j]=number[j+1];
				number[j+1]=temp;
				count++;
				cout<<count<<". "<< "[" << number[j] << ","<< temp <<"] -> ";
				for(int k=0;k<7;k++){
					cout<<number[k]<<" ";
				}
				cout<<endl;
			}
		}
	}

	cout << "jumlah swap :"<<count<<endl;
}
