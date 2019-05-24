package com.cegeka.bicycleStore.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class BicycleController {

    File database;
    String lastLine = null;
    private static String ID_REGEX;

    static {
        ID_REGEX = "^\\d+";
    }

    public BicycleController() {
        database = new File("database.txt");
        try {
            database.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping(value = "/bicycle/name/{brandName}/model/{modelName}")
    public String insertBicycle(@PathVariable String brandName, @PathVariable String modelName) {
        int id = getLastId(brandName + "|" + modelName);

        if(id == -1) {
            return "500";
        } else if(id == 0)
            return "200 Ok";

        if(!insertBicyleToFile(String.valueOf(id) + "|" + brandName + "|" + modelName))
            return "500";

        return "201 Created";
    }

    @GetMapping(value = "/bicycle/id/{id}")
    public String getBicycleById(@PathVariable int id) {
        String result = extractBicycleById(id);
        if(result == null)
            return "204";
        return result;
    }

    @GetMapping(value = "/bicycle/name/{brandName}")
    public String getBicycleByBrandName(@PathVariable String brandName) {
        List<String> result = extractBicycleByString(brandName);
        if(result == null)
            return "204";
        return result.toString();
    }

    @GetMapping(value = "/bicycles")
    public String getBicycles() {
        List<String> result = extractAllData();
        if(result == null)
            return "204";
        return result.toString();
    }

    private String extractBicycleById(int id) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.database));
            String line = br.readLine();
            if(line == null) {
                return null;
            }

            while(line != null) {
                if(extractId(line) == id)
                    return line;
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<String> extractAllData() {
        List<String> result = new ArrayList<>();
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.database));
            line = br.readLine();
            if(line == null) {
                return null;
            }

            while(line != null) {
                result.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    private List<String> extractBicycleByString(String data) {
        List<String> result = new ArrayList<>();
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.database));
            line = br.readLine();
            if(line == null) {
                return null;
            }

            while(line != null) {
                if(line.contains(data))
                    result.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    private int getLastId(String data) {
        if(lastLine != null)
            return extractId(lastLine) + 1;
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.database));
            String line = br.readLine();
            if(line == null) {
                return 1;
            }

            while(line != null) {
                if(line.contains(data))
                    return 0;
                lastLine = line;
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return extractId(lastLine) + 1;
    }

    private int extractId(String line) {
        Pattern pattern = Pattern.compile(BicycleController.ID_REGEX);
        Matcher matcher = pattern.matcher(line);
        if(matcher.find()) {
            return Integer.parseInt(matcher.group(0));
        }
        return -1;
    }

    private boolean insertBicyleToFile(String line) {
        FileWriter fw;
        PrintWriter printWriter = null;
        try {
            fw = new FileWriter(database, true);
            printWriter = new PrintWriter(fw, true);
            printWriter.append(line).append(String.valueOf('\n'));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            assert printWriter != null;
            printWriter.close();
        }
    }
}
