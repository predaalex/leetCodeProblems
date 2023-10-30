package main.java;

import java.util.ArrayList;
import java.util.List;

public class AMIQinterview {
    public static void main(String[] args) {
        String input =
                "Etiam\\#vitae##bibendum\n" +
                "tellus##Interdum#et\n" +
                "malesuada#fames\\#ac###ante\n" +
                "ipsum#######primis#in\n";


        String[] row = input.split("\n");


        //building row matrix
        List<List<String>> matrix = new ArrayList<>();
        for(String line : row){
            List<String> eachLine = new ArrayList<>();
//            String[] columns = line.split("#");

            List<String> cols = new ArrayList<>();

            // split corect
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < line.length(); i++){
                if(line.charAt(i) == '\\' && line.charAt(i + 1) == '#') {
                    line = line.replace("\\#", "#");
                    str.append("#");
                    continue;
                }
                if(line.charAt(i) == '#'){
                    cols.add(str.toString());
                    str = new StringBuilder();
                    continue;
                }
                str.append(line.charAt(i));
            }
            cols.add(str.toString());

            //

            int end = line.length() - 1;
            while(line.charAt(end) == '#') {
                cols.add("");
                end--;
            }
            for(int i = 0; i < cols.size(); i++) {

                if(cols.get(i).contains("\\") && i < cols.size() - 1) {
                    eachLine.add((cols.get(i) + cols.get(i + 1)).replace("\\",""));
                    i++;
                } else {
                    eachLine.add(cols.get(i));
                }
            }
            matrix.add(eachLine);
        }
        int longestRow = 0;
        for (List<String> strings : matrix)
            if (longestRow < strings.size())
                longestRow = strings.size();

        List<Integer> maxLenPerCol = new ArrayList<>();

        for(int i = 0; i < longestRow; i++){
            int len = 0;
            for (List<String> strings : matrix) {
                if (strings.size() <= i)
                    continue;
                if (strings.get(i).length() > len)
                    len = strings.get(i).length();
            }
            maxLenPerCol.add(len);
        }

        StringBuilder result = new StringBuilder();
        StringBuilder rowSplitter = new StringBuilder("+");
        for(int i : maxLenPerCol){
            for(int j = 0; j < i; j++)
                rowSplitter.append("-");
            rowSplitter.append("+");

        }
        rowSplitter.append("\n");
        result.append(rowSplitter);

        for (List<String> strings : matrix) {
            StringBuilder resultRow = new StringBuilder("|");
            for (int j = 0; j < longestRow; j++) {
                int sizeOfCol = maxLenPerCol.get(j);
                if (strings.size() > j) {
                    String col = strings.get(j);
                    StringBuilder colBuilder = new StringBuilder(col);
                    while (colBuilder.length() < sizeOfCol)
                        colBuilder.append(" ");
                    colBuilder.append("|");
                    resultRow.append(colBuilder);
                } else {
                    StringBuilder colBuilder = new StringBuilder();
                    while (colBuilder.length() < sizeOfCol)
                        colBuilder.append(" ");
                    colBuilder.append("|");
                    resultRow.append(colBuilder);
                }
            }
            resultRow.append("\n");
            result.append(resultRow);
            result.append(rowSplitter);
        }


        System.out.println(result);
    }
}
