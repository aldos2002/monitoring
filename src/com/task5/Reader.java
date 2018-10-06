package com.task5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by admin
 * on 06.10.2018.
 */
public class Reader {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        Scanner scan;
        try {
            scan = new Scanner(new File("txt_dump.txt"));
            while (scan.hasNextLine()) {
                strings.add(scan.nextLine().substring(0, 3));
            }
            Thread.sleep(300000);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
