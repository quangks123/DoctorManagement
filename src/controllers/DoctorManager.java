
package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import models.Doctor;

public class DoctorManager {
    
    private HashMap<String, Doctor> hashMap;
    private int id;
    
    public int getId() {
        return id;
    }

    public DoctorManager() {
        hashMap = new HashMap<>();
        readFile();
        id = hashMap.size();
    }
    
    private String createID() {
        id++;
        if ((id / 10) == 0) {
            return "D0" + id;
        } 
        
        return "D" + id;
    }
    
    public boolean checkExist(String id) {
        if (hashMap.get(id) == null) {
            return false;
        }
        
        return true;
    }
    
    public void addDoctor(String name, String spec, int avail) {
        String id = createID();
        hashMap.put(id, new Doctor(id, name, spec, avail));
    }
    
    public void displayAll() {
        System.out.println(String.format("%-5s | %-18s | %-15s | %s ", "Code", "Name", "Specialization", "Availability"));
        for (String key: hashMap.keySet()) {
            System.out.println(hashMap.get(key));
        }
    }
    
    public void update(String id, String name, String spec, int avail) {
        if (!name.equals("")) {
            hashMap.get(id).setName(name);
        } 
        
        if (!spec.equals("")) {
            hashMap.get(id).setSpec(spec);
        }
        
        hashMap.get(id).setAvail(avail);
    }
    
    public void delete(String id) {
        hashMap.remove(id);
    }
    
    public void search(String id) {
        System.out.println(String.format("%-5s | %-18s | %-15s | %s ", "Code", "Name", "Specialization", "Availability"));
        System.out.println(hashMap.get(id));
    }
    
    private void readFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data.dat"));
            
            String line = br.readLine();
            
            if (line == null) {
                return;
            }
            
            while (line != null) {                
                String[] data = line.split(",");
                hashMap.put(data[0], new Doctor(data[0], data[1], data[2], Integer.parseInt(data[3])));
                line = br.readLine();
            }
            
            br.close();
        } catch (Exception e) {
        }
    }
}
