package JunHo;

/**
 * jhChoi - 201115
 * 더 맵게
 * */
public class MoreHot {
    static final int ROOT = 1;
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int[] scoville1 = {1, 1, 1};
        int[] scoville2 = {3, 5, 6, 9, 10, 12};
        System.out.println(solution(scoville2, 7));
    }

    public static int solution(int[] scoville, int K) {
        Heap heap = new Heap(scoville);
        int mixCount = 0;

        while (heap.index > 2) {
            int min = heap.pop();
            int nextMin = heap.pop();

            if (min >= K) {
                break;
            }

            heap.add(min + (nextMin * 2), heap.index);
            mixCount++;
        }

        if (heap.index == 2) {
            mixCount = heap.pop() < K ? -1 : mixCount;
        }

        return mixCount;
    }

    static class Heap {
        int[] tree;
        int index = 1;

        public Heap(int[] tree) {
            this.tree = new int[tree.length + 1];
            this.tree[0] = 0;

            for (int i = 1; i < this.tree.length; i++) {
                add(tree[i - 1], index);
            }
        }

        public int pop() {
            if (tree[ROOT] == -1) {   //더이상 요소가 존재 하지 않는 경우
                return -1;
            }

            --index;
            int root = tree[ROOT];
            int lastNode = tree[index];
            tree[index] = -1;

            if (tree[ROOT] == -1) {
                return root;
            }

            tree[ROOT] = lastNode;
            int curIndex = ROOT;
            while (true) {
                int lCIndex = curIndex * 2;
                int rCIndex = lCIndex + 1;
                int minIndex;

                if (index > lCIndex) {
                    if (index > rCIndex) {
                        minIndex = tree[lCIndex] >= tree[rCIndex] ? rCIndex : lCIndex;
                    } else {
                        minIndex = lCIndex;
                    }
                } else {
                    break;
                }

                int minChild = tree[minIndex];
                int current = tree[curIndex];

                if (minChild > current) {
                    break;
                } else {
                    swap(minIndex, curIndex);
                    curIndex = minIndex;
                }
            }

            return root;
        }

        public void add(int value, int addIndex) {
            tree[addIndex] = value;
            index++;

            if (addIndex == ROOT) {   //루트 노드만 존재 하는 경우
                return;
            }

            while ((addIndex / 2) > 0) {
                if (tree[addIndex] > tree[addIndex / 2]) {
                    break;
                }else{
                    swap(addIndex, addIndex / 2);
                    addIndex = addIndex / 2;
                }
            }
        }

        private void swap(int curIndex, int parentIndex) {
            int parentTemp = tree[parentIndex];
            tree[parentIndex] = tree[curIndex];
            tree[curIndex] = parentTemp;
        }
    }
}
