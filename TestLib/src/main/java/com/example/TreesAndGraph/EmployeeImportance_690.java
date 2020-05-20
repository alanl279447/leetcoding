package com.example.TreesAndGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance_690 {
//    Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
//    Output: 11
//    Explanation:
//    Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3.
//    They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
//    https://leetcode.com/problems/employee-importance/

    public static TreeNode root;
    private static TreeNode ans = null;

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee emp1 = new Employee();
        emp1.id = 1;
        Employee emp2 = new Employee();
        emp2.id = 2;
        Employee emp3 = new Employee();
        emp3.id = 3;

        List<Integer> emp1Sub = new ArrayList<>();
        emp1Sub.add(emp2.id);
        emp1Sub.add(emp2.id);

        emp1.importance =5;
        emp1.subordinates = emp1Sub;

        emp2.importance =3;
        emp2.subordinates = new ArrayList<>();
        emp3.importance =3;
        emp3.subordinates = new ArrayList<>();

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);


        int result = getImportance(employees, 1);
        System.out.println(result);
    }

    static Map<Integer, Employee> emap;
    public static int getImportance(List<Employee> employees, int queryid) {
        emap = new HashMap();
        for (Employee e: employees) emap.put(e.id, e);
        return dfs(queryid);
    }
    public static int dfs(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subid: employee.subordinates)
            ans += dfs(subid);
        return ans;
    }

    static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };

    public static class Node {
        TreeNode node;
        int hd; //horiozntal distance

        public Node(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
