package helper;

import model.InputLineCsv;
import model.SummaryLineCsv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;


public class CSVHelper {

    public static int amountOfEmployees = 0;
    static Set<String> departmentsSet = new HashSet<String>();
    static ArrayList salaries = new ArrayList();

    public static String TYPE = "text/csv";
    static String[] HEADERs = { "ID","Name","DOB","Department","Salary" };

    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<InputLineCsv> csvToObject(InputStream is) {

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(
                     fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
                List<InputLineCsv> table = new ArrayList<InputLineCsv>();
                Iterable<CSVRecord> csvRecords = csvParser.getRecords();
                for (CSVRecord csvRecord : csvRecords) {
                InputLineCsv inputLineCsv = new InputLineCsv(
                        csvRecord.get("id"),
                        csvRecord.get("name"),
                        csvRecord.get("DOB"),
                        csvRecord.get("Department"),
                        csvRecord.get("salary")

                );
                System.out.println(table);
                table.add(inputLineCsv);
            }

            return table;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
        }

    public static List<SummaryLineCsv> createSummary(List<InputLineCsv> tableInput) {


        getDepartaments(tableInput);
        getSalaries(tableInput);
        generateOutput(tableInput);
        return null;
    }

    public static Set getDepartaments(List<InputLineCsv> table){


        for (int i =0; i < table.size(); i++){
            String[] values  = table.get(i).toString().split(",");
            departmentsSet.add(values[3]);
        }

        return departmentsSet;
    }

    public static ArrayList getSalaries(List<InputLineCsv> table){
        for (int i =1; i < table.size(); i++){
            String[] values  = table.get(i).toString().split(",");
            salaries.add(parseInt(values[4]));
        }

        sumAllSalaries(salaries);
        getSamllestSalary(salaries);
        getBiggestSalary(salaries);
        return salaries;

    }

    public static String getSamllestSalary(ArrayList salaries){
        Collections.sort(salaries);
        String smallestSalarie = salaries.get(0).toString();
        System.out.println(smallestSalarie);

        return smallestSalarie;
    }

    public static String getBiggestSalary(ArrayList salaries){
        Collections.sort(salaries,Collections.reverseOrder());
        String biggetSalarie = salaries.get(1).toString();
        System.out.println(biggetSalarie);
        return biggetSalarie;
    }

    public static int sumAllSalaries(ArrayList salaries){
        int sum =0;
        for (int i=0; i<= salaries.size()-1; i++){
            sum += parseInt(salaries.get(i).toString());
        }
        System.out.println("Soma " + sum);
        return sum;

    }

    public static int avgSalarie(ArrayList salaries){
        int sum = sumAllSalaries(salaries);
        return 0;
    }

    public static void generateOutput(List<InputLineCsv> table){
        ArrayList outputTable = new ArrayList<>();

        String[] headers = new String[7];
        headers[0] ="department";
        headers[1] ="Employees";
        headers[2] ="MinSalary";
        headers[3] ="AvgSalary";
        headers[4] ="MaxSalary";
        headers[5] ="TotalSalary";
        headers[6] = "";

        outputTable.set(0,headers );

        for (int i = 0; i <= table.size(); i++) {


        }
    }
}



