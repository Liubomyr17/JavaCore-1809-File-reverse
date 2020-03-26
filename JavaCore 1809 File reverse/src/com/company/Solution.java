package com.company;

/*
1809 file reverse
Read from the console 2 file names: file1, file2.
Write to file2 all bytes from file1, but in reverse order.
Close streams.

Requirements:
1. The program should read the file names from the console twice.
2. Use FileInputStream to read from a file, FileOutputStream to write to a file
3. In the second file you need to write all the bytes from the first in the reverse order.
4. The streams FileInputStream and FileOutputStream must be closed.
 */

import java.io.*;
import java.util.Objects;
import java.util.Scanner;



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();
        FileInputStream f1 = new FileInputStream(fileName1);
        FileOutputStream f2 = new FileOutputStream(fileName2);
        while(f1.available() > 0) {
            byte[] buf = new byte[f1.available()];
            byte[] reverseBuf = new byte[buf.length];
            f1.read(buf);
            for (int i=buf.length-1; i>=0; i--)
                reverseBuf[buf.length-i-1]=buf[i];
            f2.write(reverseBuf);
        }
        f1.close();
        f2.close();
        br.close();
    }
}
