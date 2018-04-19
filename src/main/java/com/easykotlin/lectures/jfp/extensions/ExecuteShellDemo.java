package com.easykotlin.lectures.jfp.extensions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.lang.System.out;

public class ExecuteShellDemo {
    public static void main(String[] args) throws IOException {
        ExecuteShellDemo demo = new ExecuteShellDemo();
        String result = demo.execute("tree");
        out.println(result);
    }

    String execute(String cmd) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process p = runtime.exec(cmd);
        InputStream inputStream = p.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder result = new StringBuilder();
        String line = "";
        while (line != null) {
            line = bufferedReader.readLine();
            result.append(line).append("\n");
        }
        return result.toString();
    }
}
