//
// Created by Ha on 16. 1. 3..
//

/*
    page 174
    문자열에서 처음으로 반복되지 않는 문자를 효율적으로 찾아내는 함수를 작성하라.
    예를 들어, "total"에서 처음으로 등장하는 반복되지 않는 문자는 "o"이며,
    "teeter"에서 처음으로 등장하는 반복되지 않는 문자는 "r"이다.
 */

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println(firstNonRepeated("total"));
        System.out.println(firstNonRepeated("teeter"));
        System.out.println(firstNonRepeated("teeterr")); // - 가 나와야함(반복안되는 문자가 없음)
        System.out.println(firstNonRepeated("qwnoqnruiqhaowebifibawybfaweuofiawenfwerh")); // y 가 나와야함

    }

    public static char firstNonRepeated(String str){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int i = 0;

        // str 종주 :
        // 해시맵에서 문자별 카운트
        for(; i < str.length(); i++){
            char c = str.charAt(i);
            if(map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }

        // str 종주 :
        // 각 무자의 해시맵 카운트롤 보고 1인것을 찾음
        // 2이상인 경우 반복된 문자
        // 1인 경우 반복되지 않고 한번만 등장한 문자
        // 0인 경우 나타나지 않은 문자

        for(i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(map.get(c) == 1)
                return c;
        }

        // 반복되지 않는 문자를 찾지 못함
        return '-';
    }
}
