package hashing;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class EmployeesUnderManager {

    private static Map<String, Integer> results = new HashMap<String,Integer>();

    private static void employeesUnderEachManager(Map<String, String> emp) {

        Map<String, ArrayList<String>> reverseMap = new HashMap<String, ArrayList<String>>();
        for (Map.Entry<String, String> entry : emp.entrySet()) {
            String employee = entry.getKey();
            String manager = entry.getValue();
            if (reverseMap.containsKey(manager)) {
                if (!manager.equals(employee)) {
                    ArrayList<String> employees = reverseMap.get(manager);
                    employees.add(employee);
                }
            } else {
                ArrayList<String> employees = new ArrayList<String>();
                employees.add(employee);
                reverseMap.put(manager, employees);
            }
        }

        for (Map.Entry<String, ArrayList<String>> entry : reverseMap.entrySet()) {
            String manager = entry.getKey();
            results.put(manager, populateResultUtil(manager, reverseMap));
        }
    }

    private static int populateResultUtil(String mngr,
                               Map<String, ArrayList<String>> mngrEmpMap)
    {
        int count = 0;
 
        // means employee is not a manager of any other employee
        if (!mngrEmpMap.containsKey(mngr))
        {
            results.put(mngr, 0);
            return 0;
        }
 
        // this employee count has already been done by this
        // method, so avoid re-computation
        else if (results.containsKey(mngr))
            count = results.get(mngr);
 
        else
        {
            ArrayList<String> directReportEmpList = mngrEmpMap.get(mngr);
            count = directReportEmpList.size();
            for (String directReportEmp: directReportEmpList)
               count +=  populateResultUtil(directReportEmp, mngrEmpMap);
 
            results.put(mngr, count);
        }
        return count;
    }

    public static void main(String[] args) {
        Map<String, String> dataSet = new HashMap<String, String>();
        dataSet.put("A", "C");
        dataSet.put("B", "C");
        dataSet.put("C", "F");
        dataSet.put("D", "E");
        dataSet.put("E", "F");
        dataSet.put("F", "F");

        employeesUnderEachManager(dataSet);

        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            System.out.println(entry.getKey() + "  ->  " + entry.getValue());
        }
    }
}
