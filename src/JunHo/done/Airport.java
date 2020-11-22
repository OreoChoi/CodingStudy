package JunHo.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * jhChoi - 201120
 *
 * 공항
 * */
public class Airport {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        UnionFind find = new UnionFind(G);
        int airplaneCount = 0;

        for (int i = 0; i < P; i++) {
            int A = Integer.parseInt(br.readLine());
            A = find.find(A);

            if (A == 0) break;
            find.union(A - 1, A);
            airplaneCount++;
        }

        System.out.println(airplaneCount);
    }

    public static class UnionFind {
        int[] parent;

        UnionFind(int size) { //초기화
            parent = new int[size + 1];

            for (int i = 1; i < size + 1; i++) {
                parent[i] = i;
            }
        }

        int find(int x) { //Pass compression(경로 압축) 적용
            if (parent[x] == x) return x;
            else return parent[x] = find(parent[x]);
        }

        void union(int x, int y) {
            x = find(x);
            y = find(y);

            if (x == y) return;  //같은 부모에 속한경우 합침 연산을 하지 않습니다.
            parent[y] = x;
        }
    }
}
