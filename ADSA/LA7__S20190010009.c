#include <stdio.h>

int visit[100], n;
void depth_first_search(int i, int graph[][n])
{
    int j;
    printf("--------\n");
    printf("  %d\n", i);
    visit[i] = 1;

    for (j = 0; j < n; j++)
        if (!visit[j] && graph[i][j] == 1)
        {
            depth_first_search(j, graph);
        }
}

void main()
{
    int i, j, node;
    printf("Enter number of vertices:");
    scanf("%d", &n);
    int graph[n][n];
    printf("\nEnter adjecency matrix of the graph: \n");

    for (i = 0; i < n; i++)
        for (j = 0; j < n; j++)
            scanf("%d", &graph[i][j]);

    for (i = 0; i < n; i++)
        visit[i] = 0;

    printf("enter node to start: \n");
    scanf("%d", &node);

    depth_first_search(node, graph);
}
