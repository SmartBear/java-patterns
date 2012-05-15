package com.smartbear.gotchas.regex;

import java.util.regex.Pattern;

/**
 * Total rip of Joshua Blochs and Bob Lees presentation.
 *
 */
public class RegexCrash {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("(aa|aab?)+");
        int count = 0;
        for (String s = ""; s.length() < 200; s += "a")
            if (p.matcher(s).matches())
                count++;
        System.out.println(count);
    }
}
