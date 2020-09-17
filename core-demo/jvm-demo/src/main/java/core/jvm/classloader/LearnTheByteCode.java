package core.jvm.classloader;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author kris
 * @since 2020-08-29
 */
public class LearnTheByteCode {

    private volatile static String code;


    public static void main(String[] args) {

        String a = "aaa";
        System.out.println(code);

        code = a;

        String s1 = new StringBuilder().append("aaa").toString();
        String s2 = new StringBuilder().append("bb").append("_").append("cc").toString();
        String s3 = new StringBuilder().append("bb").append("_").append("cc").toString();

        System.out.println(code.hashCode());
        System.out.println(s1.hashCode());

        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());



    }
}
