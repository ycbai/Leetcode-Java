package com.inuker.solution;

import java.util.Stack;

/**
 * Created by dingjikerbo on 2016/12/11.
 */

public class DecodeString {

    // 耗时3ms，思路很直观，且不容易错，面试推荐写法
    public String decodeString2(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c != ']') {
                sb.append(c);
            } else {
                String t = popString(sb);
                for (int i = popCount(sb); i > 0; i--) {
                    sb.append(t);
                }
            }
        }

        return sb.toString();
    }

    private String popString(StringBuilder sb) {
        StringBuilder ss = new StringBuilder();

        int i = sb.length() - 1;
        for ( ; sb.charAt(i) != '['; i--) {
            ss.append(sb.charAt(i));
        }
        sb.setLength(i);

        return ss.reverse().toString();
    }

    private int popCount(StringBuilder sb) {
        int i = sb.length() - 1, cnt = 0, t = 1;
        for ( ; i >= 0 && Character.isDigit(sb.charAt(i)); i--, t *= 10) {
            cnt += t * (sb.charAt(i) - '0');
        }
        sb.setLength(i + 1);
        return cnt;
    }
}
