package service;

import helper.CSVHelper;
import model.InputLineCsv;
import model.SummaryLineCsv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import repository.CsvRepository;

import java.io.IOException;
import java.util.List;

@Service
public class CSVService {


    @Autowired
    CsvRepository repository;
    public void save(MultipartFile file){
        try{
            List<InputLineCsv> tableInput = CSVHelper.csvToObject(file.getInputStream());
            repository.save(tableInput);
        }catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }


    }

    public List<InputLineCsv> getInputCSVs() {
        return repository.findAll();
    }

    public void createSummary(List<InputLineCsv> tableInput){
        try {
            List<SummaryLineCsv> tableSummary = CSVHelper.createSummary(tableInput);
            repository.save(tableSummary);
        }catch (Exception e) {
            throw new RuntimeException("fail to create Summary because of error" + e.getMessage());
        }
    };

    public List<SummaryLineCsv> getSummary(){
        List<SummaryLineCsv> tableSummary = repository.findAll();
        return tableSummary;
    }






}
