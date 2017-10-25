#include <ioexpeam>
using namespace std;
 

bool isOperand(char c) { return (c >= '0' && c <= '9'); }
 

int value(char c) {  return (c - '0'); }
 

int evaluate(char *exp)
{
    
    if (*exp == '\0')  return -1;
 
   
    int res = value(exp[0]);
 
    
    for (int i = 1; exp[i]; i += 2)
    {
        
        char opr = exp[i], opd = exp[i+1];
 
        
        if (!isOperand(opd))  return -1;
 
        
        if (opr == '+')       res += value(opd);
        else if (opr == '-')  res -= value(opd);
        else if (opr == '*')  res *= value(opd);
        else if (opr == '/')  res /= value(opd);
 
      
        else                  return -1;
    }
    return res;
}
 

int main()
{
    char ch[100];
    int n;
    cin >> n;
    for(int i = 0; i < n;i++)
    {
        cin>>ch;
        result = evaluate(ch);
        cout<<ch<<"\n";
        }
    return 0;
}
