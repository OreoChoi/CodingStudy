package JunHo.done;

/**
 * jhChoi - 201201
 * 프로그래머스 - 방금 그 곡
 */
public class Pro_Song {
    public static void main(String[] args) {
        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String m1 = "CC#BCC#BCC#BCC#B";
        String[] musicinfos1 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        String m2 = "ABC";
        String[] musicinfos2 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABC"};
        String m3 = "A#";
        String[] musicinfos3 = {"13:00,13:02,HAPPY,B#A#"};
        String m4 = "CDEFGAC";
        String[] musicinfos4 = {"12:00,12:06,HELLO,CDEFGA"};
        String m5 = "CCF";
        String[] musicinfos5 = {"03:00,03:10,FOO,CCF#CCF", "04:00,04:08,BAR,ABC"};
        String m6 = "CDCDF";
        String[] musicinfos6 = {"00:00,00:10,HI,CDCDCDF"};
        //System.out.println(solution(m, musicinfos));
        //System.out.println(solution(m1, musicinfos1));
        //System.out.println(solution(m2, musicinfos2));
        //System.out.println(solution(m3, musicinfos3));
        //System.out.println(solution(m4, musicinfos4));
        System.out.println(solution(m5, musicinfos5));
        //System.out.println(solution(m6, musicinfos6));
    }

    static Music result = null;

    public static String solution(String m, String[] musicinfos) {
        for (String musicInfo : musicinfos) {
            new Music(musicInfo, m);
        }

        if (result == null) return "(None)";
        else return result.songName;
    }

    static class Music {
        int playTime;
        String songName;
        String melody;

        public Music(String musicInfo, String m) {
            String[] info = musicInfo.split(",");
            calculationPlayTime(info[0], info[1]);
            songName = info[2];
            melody = info[3];

            checkMatchingSong(m);
        }

        /**
         * 재생 시간을 계산합니다.
         */
        private void calculationPlayTime(String startTime, String endTime) {
            String[] startSplit = startTime.split(":");
            String[] endSplit = endTime.split(":");
            int startTimeInSec = Integer.parseInt(startSplit[0]) * 60 + Integer.parseInt(startSplit[1]);
            int endTimeInSec = Integer.parseInt(endSplit[0]) * 60 + Integer.parseInt(endSplit[1]);
            playTime = endTimeInSec - startTimeInSec;
        }

        /**
         * 멜로디가 일치하는 체크합니다.
         */
        private void checkMatchingSong(String m) {
            String melody = parseSoundList(refactoringMelody());
            String memoMelody = parseSoundList(m);

            if (melody.contains(memoMelody)) { //멜로디가 일치하는 경우
                if (result == null) {        //아직 정답이 없는 경우
                    result = this;
                } else if (result.playTime < playTime) {   //재생시간 비교
                    result = this;
                }
            }
        }

        /**
         * 원하는 길이만큼 멜로디를 자릅니다.
         */
        private String cutMelody(int cutCount) {
            String result = "";
            int stopCount = 0;
            for (int i = 0; i < melody.length(); i++) {
                if (melody.charAt(i) == '#') continue;
                stopCount++;

                if ((stopCount - 1) == cutCount) {
                    result = melody.substring(0, i);
                    break;
                }
            }

            return result;
        }

        /**
         * 기억하는 멜로디 길이에 맞게
         * 노래의 멜로디를 반복 시킨 문자열을 반환합니다.
         */
        private String refactoringMelody() {
            String refacMelody;
            int melodyLength = 0;
            for (int i = 0; i < melody.length(); i++) {
                if (melody.charAt(i) == '#') continue;
                melodyLength++;
            }

            if (playTime == melodyLength) {
                refacMelody = melody;
            } else if (playTime < melodyLength) {
                refacMelody = cutMelody(playTime);
            } else {
                StringBuilder result = new StringBuilder(melody.repeat(playTime / melodyLength));
                int addCount = playTime % melodyLength;
                if (addCount > 0) result.append(cutMelody(addCount));
                refacMelody = result.toString();
            }

            return refacMelody;
        }

        private String parseSoundList(String sounds) {
            return sounds.replace("C#","c")
                    .replace("D#","d")
                    .replace("F#","f")
                    .replace("G#","g")
                    .replace("A#","a");
        }
    }
}
