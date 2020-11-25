package JunHo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * jhChoi - 201124
 * 카카오프렌즈 컬러링북
 * <p>
 * 참고 알고리즘 : 인접리스트, BFS, 플러드 필
 */
public class Pro_ColoringBook {

    public static class ListGraph {
        private ArrayList<ArrayList<Integer>> listGraph;
        int initSize = 0;

        public ListGraph(int initSize) {
            this.initSize = initSize;
            listGraph = new ArrayList<>();

            for (int i = 0; i < initSize + 1; i++) {
                listGraph.add(new ArrayList<>());
            }
        }

        public int getSize() {
            return initSize;
        }

        public ArrayList<Integer> getNode(int i) {
            return listGraph.get(i);
        }

        public void put(int x, int y) {
            ArrayList<Integer> xList = listGraph.get(x);
            ArrayList<Integer> yList = listGraph.get(y);

            if (!xList.contains(y)) {
                listGraph.get(x).add(y);
            }
            if (!yList.contains(x)) {
                listGraph.get(y).add(x);
            }
        }
    }

    static ListGraph graph;

    //고유한 키를 생성합니다.
    static int createPk(int width, int x, int y) {
        return width * x + y;
    }

    public static int[] solution(int height, int width, int[][] picture) {
        List<boolean[]> visited = new ArrayList<>();
        graph = new ListGraph(height * width);

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                int curPx = picture[i][j];   //현재 픽셀

                if (curPx == 0) continue;   //0은 무 영역 이니 스킵

                int cIdx = createPk(width, i, j);
                int lPx = j - 1;
                int rPx = j + 1;
                int tPx = i - 1;
                int dPx = i + 1;

                graph.put(cIdx, cIdx);
                if (lPx >= 0 && picture[i][lPx] == curPx)
                    graph.put(cIdx, createPk(width, i, lPx));
                if (rPx < picture[i].length && picture[i][rPx] == curPx)
                    graph.put(cIdx, createPk(width, i, rPx));
                if (tPx >= 0 && picture[tPx][j] == curPx)
                    graph.put(cIdx, createPk(width, tPx, j));
                if (dPx < picture.length && picture[dPx][j] == curPx)
                    graph.put(cIdx, createPk(width, dPx, j));
            }
        }

        List<Integer> areaCount = new ArrayList<>();
        for (int i = 0; i < graph.getSize(); i++) {
            ArrayList<Integer> node = graph.getNode(i);

            if (node.size() == 0) continue;

            boolean[] visit;
            boolean agoVisit = false;
            if (visited.size() == 0) {
                visit = new boolean[height * width];
            } else {
                int nDex = node.get(0);
                for (boolean[] checkList : visited) {
                    if (checkList[nDex]) {
                        agoVisit = true;
                        break;
                    }
                }

                if (agoVisit) continue;
                else visit = new boolean[height * width];
            }

            areaCount.add(bfsList(i, visit));
            visited.add(visit);
        }

        int max = 0;
        for (int n : areaCount) {
            max = Math.max(max, n);
        }
        return new int[]{visited.size(), max};
    }

    public static int bfsList(int startIndex, boolean[] visited) {
        int apartCount = 1;
        Queue<Integer> queue = new LinkedList<>();
        visited[startIndex] = true;
        queue.add(startIndex);

        while (queue.size() != 0) {
            startIndex = queue.poll();

            for (int k : graph.getNode(startIndex)) {
                if (!visited[k]) {
                    apartCount++;
                    visited[k] = true;
                    queue.add(k);
                }
            }
        }

        return apartCount;
    }
}
