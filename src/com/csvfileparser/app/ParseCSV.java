package com.csvfileparser.app;

import java.io.*;
import java.sql.Timestamp;
import java.util.*;
import java.util.List;

import com.csvfileparser.db.*;
import org.apache.commons.csv.*;
import org.json.JSONObject;

public class ParseCSV {

    File file;

    public ParseCSV() {

    }

    ParseCSV(File file) {
        this.file = file;
    }

    public void execute(InputStream in) throws Exception {
        InputStreamReader reader = null;
        CSVParser csvParser = null;
        try {
            reader = new InputStreamReader(in);
            csvParser = new CSVParser(reader,
                    CSVFormat.EXCEL.withHeader("object_id","object_type","timestamp","object_changes").withSkipHeaderRecord(true));
            parse(csvParser);
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (csvParser != null) {
                csvParser.close();
            }
        }
    }

    public void execute() throws Exception {
        FileReader fileReader = null;
        CSVParser csvParser = null;
        try {
            fileReader = new FileReader(this.file);
            csvParser = new CSVParser(fileReader,
                    CSVFormat.EXCEL.withHeader("object_id","object_type","timestamp","object_changes").withSkipHeaderRecord(true));
            parse(csvParser);
        } catch (FileNotFoundException ex) {
            throw ex;
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
            if (csvParser != null) {
                csvParser.close();
            }
        }
    }

    private void parse(CSVParser csvParser) throws Exception {
        List<CSVRecord> records = csvParser.getRecords();
        Map<Long, List> hm = new HashMap<>();
        boolean first = true;
        for (CSVRecord record : records) {
            if (first) {
                continue;
            }
            createDBObj(record, hm);
        }
        print(hm);
    }

    private void print(Map<Long, List> hm) {
        for (Map.Entry<Long, List> entry : hm.entrySet()) {
            Events events = (Events) entry.getValue().get(0);
            System.out.println(events.getObjectId());
            System.out.println(Entities.get(events.getObjectType()));

            EventContent eventContent = (EventContent) entry.getValue().get(1);
            System.out.println(eventContent.getTimestamp());
            System.out.println(eventContent.getJsonObject());
        }
    }

    private void createDBObj(CSVRecord record, Map<Long, List> hm) throws Exception {
        List list = new ArrayList();
        System.out.println(record);
        Long id= Long.parseLong(record.get(HEADERS.OBJECT_ID.disp()));
        Timestamp timestamp = new Timestamp(Long.parseLong(record.get(HEADERS.TIMESTAMP.disp()))*1000);
        JSONObject jsonObj = new JSONObject(record.get(HEADERS.OBJECT_CHANGES.disp()));
        Events events = new Events().setObjectId(id)
                .setObjectType(Entities.valueOf(record.get(HEADERS.OBJECT_TYPE.disp()).toUpperCase()).getValue());
        EventContent content = new EventContent().setTimestamp(timestamp).setJsonObject(jsonObj);
        list.add(events);
        list.add(content);
        hm.put(events.getObjectId(), list);
    }

    public static void main(String[] args) throws Exception {
        ParseCSV parseCSV = new ParseCSV(new File("input.csv"));
        parseCSV.execute();
    }
}

enum HEADERS {
    OBJECT_ID, OBJECT_TYPE, TIMESTAMP, OBJECT_CHANGES;

    public String disp() {
        return this.name().toLowerCase();
    }
}