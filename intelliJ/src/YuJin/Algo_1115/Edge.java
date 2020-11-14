package YuJin;

class Edge implements Comparable<Edge> {
    int v1, v2;
    int cost;

    public Edge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.cost < o.cost) return -1;
        else if (this.cost == o.cost) return 0;
        else return 1;
    }
}
