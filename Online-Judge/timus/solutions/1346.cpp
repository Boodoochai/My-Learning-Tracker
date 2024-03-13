#include <iostream>
#include <cstdio>
#include <cstring>

using namespace std;

int work(int m, int n, int *data)
{
    int head = m + 1, count = 0;
    if (n - m <= 1)
        return 1;
    while (head <= n)
    {
        count++;
        while (data[head] == data[head - 1])
            head++;
        if (data[head] > data[head - 1])
        {
            while (head <= n && data[head] >= data[head - 1])
                head++;
            if (head == n)
                return count + 1;
            head++;
            continue;
        }
        else
        {
            while (head <= n && data[head] <= data[head - 1])
                head++;
            if (head == n)
                return count + 1;
            head++;
            continue;
        }
    }
    return count;
}
int main()
{
    int *data = new int[100001];
    int i, m, n;
    while (scanf("%d %d", &m, &n) != EOF)
    {
        for (i = m; i <= n; i++)
            scanf("%d", &data[i]);
        printf("%d\n", work(m, n, data));
    }
    return 0;
}