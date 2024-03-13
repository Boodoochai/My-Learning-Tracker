#include<stdio.h>

int x[1002];

int main()

{

int i,n,k,j;

scanf("%d",&n);

for(i=0;i<n;i++)

{

scanf("%d",&x[i]);

}

for(i=0;i<n;)

{

k=0,j=i;

while(x[i]==x[j])

{

k++;

j++;

}

printf("%d %d ",k,x[i]);

i=j;

}

return 0;

}