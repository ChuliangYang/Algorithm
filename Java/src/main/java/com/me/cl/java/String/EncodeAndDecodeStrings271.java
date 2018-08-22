package com.me.cl.java.String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CL on 8/22/18.
 */
public class EncodeAndDecodeStrings271 {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs == null) return "";
        StringBuilder sb = new StringBuilder("");
        for (String str : strs) {
            sb.append(str.length() + "$");
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList();
        char[] chars = s.toCharArray();
        StringBuilder lengthBuilder = new StringBuilder();
        StringBuilder contentBuilder = new StringBuilder();
        int length = 0;
        boolean isContent = false;
        for (int i = 0; i < chars.length; i++) {
            if (!isContent) {
                if (chars[i] == '$') {
                    length = Integer.parseInt(lengthBuilder.toString());
                    lengthBuilder = new StringBuilder();
                    if (length == 0) {
                        result.add("");
                    } else {
                        isContent = true;
                    }
                } else {
                    lengthBuilder.append(chars[i]);
                }
            } else {
                contentBuilder.append(chars[i]);
                length--;
                if (length == 0) {
                    result.add(contentBuilder.toString());
                    contentBuilder = new StringBuilder();
                    isContent = false;
                }
            }
        }

        return result;
    }
}
