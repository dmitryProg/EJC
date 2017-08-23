package main.java;

import java.io.*;
import java.util.ArrayList;

/**
 * The CsvFilesGenerator class creates and generates .csv files
 */
class CsvFilesGenerator {
    final static int URL_AND_NAMES_AMOUNT = 11;
    final static int RANDOM_VALUE = 100;
    final static int RANDOM_MULTIPLEXER_FIRST = 901;
    final static int RANDOM_MULTIPLEXER_FOURTH = 1000000001;

    public static void main(String[] args) {
        CsvFilesGenerator gen = new CsvFilesGenerator();
        try {
            FileInputStream names = new FileInputStream(Configs.DIR_STRING + "\\sitesBase.txt");
            DataInputStream in = new DataInputStream(names);

            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String file_name = Configs.DIR_STRING + "\\docs.csv";
            FileWriter offStream = new FileWriter(file_name);

            BufferedWriter out = new BufferedWriter(offStream);
            ArrayList<String> data = new CsvFilesGenerator().inputData(br);

            br.close();
            gen.dataGeneration(out, data);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * The inputData method reads file line by line and adds info to list
     *
     * @param bufferedReader - reader from source .txt file
     * @return ArrayList<String> with names and URL
     */
    private ArrayList<String> inputData(BufferedReader bufferedReader) {
        String strLine;
        ArrayList<String> words = new ArrayList<>();
        try {
            while ((strLine = bufferedReader.readLine()) != null) {
                words.add(strLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    /**
     * The stringGenerator method randomly generates data for .csv files
     *
     * @param inputData - list with names and sites
     * @return randomly generated String
     */
    private String stringGeneration(ArrayList<String> inputData) {
        int randomValueStringBeforeURL = RANDOM_VALUE + (int) (Math.random() * RANDOM_MULTIPLEXER_FIRST);
        int randomValueForNames = (int) (Math.random() * URL_AND_NAMES_AMOUNT);
        int randomValueForSites = URL_AND_NAMES_AMOUNT + (int) (Math.random() * URL_AND_NAMES_AMOUNT);
        int randomValueStringBeforeNames = (int) (Math.random() * RANDOM_MULTIPLEXER_FOURTH);
        String sites = inputData.get(randomValueForSites);
        String names = inputData.get(randomValueForNames);
        return randomValueStringBeforeURL + ";" + sites + ";" + randomValueStringBeforeNames + ";" + names;
    }

    /**
     * The dataGeneration method writes randomized data for .csv generation
     *
     * @param bufferedWriter - output files writer
     * @param nameData       - list with names and sites for stringGenerator method
     */
    private void dataGeneration(BufferedWriter bufferedWriter, ArrayList<String> nameData) {
        try {
            String startLine = "id;url;time;user";
            bufferedWriter.write(startLine + "\n");
            for (int i = 0; i < 10; i++) {
                String string = stringGeneration(nameData);
                bufferedWriter.write(string + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
