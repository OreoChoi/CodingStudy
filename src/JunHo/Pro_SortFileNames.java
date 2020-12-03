package JunHo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * jhChoi - 201201
 * 프로그래머스 - 파일명 정렬
 */
public class Pro_SortFileNames {
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png",
                "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] sortedFile = solution(files);
    }

    public static String[] solution(String[] strFiles) {
        List<File> fileList = new ArrayList<>();
        for (String file : strFiles) {
            fileList.add(new File(file));
        }
        Collections.sort(fileList);
        String[] result = new String[fileList.size()];
        for (int i = 0; i < fileList.size(); i++) {
            result[i] = fileList.get(i).fileName;
        }
        return result;
    }

    static class File implements Comparable<File> {
        String HEAD;
        int NUMBER;
        String fileName;

        public File(String fileName) {
            this.fileName = fileName;
            char[] array = fileName.toCharArray();
            StringBuilder hBuilder = new StringBuilder();
            StringBuilder nBuilder = new StringBuilder();

            for (char word : array) {
                if (word >= '0' && word <= '9') {
                    nBuilder.append(word);
                } else if (nBuilder.length() == 0) {
                    hBuilder.append(word);
                } else {
                    break;
                }
            }
            HEAD = hBuilder.toString().toLowerCase();
            NUMBER = Integer.parseInt(nBuilder.toString());
        }

        @Override
        public int compareTo(File o) {
            int compare = HEAD.compareTo(o.HEAD);
            if (compare != 0) {
                return compare;
            }
            compare = Integer.compare(NUMBER, o.NUMBER);
            return compare;
        }
    }
}
