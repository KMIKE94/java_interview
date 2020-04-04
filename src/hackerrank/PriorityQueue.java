package hackerrank;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Create the Student and Priorities classes here.
 */
class Priorities {
    Queue<Student> students = new java.util.PriorityQueue<Student>();

    public List<Student> getStudents(List<String> events) {
        for(String event: events) {
            if(event.contains("ENTER")) {
                String[] vars = event.split(" ");
                // 0-3 ENTER name cgpa id
                Student st = new Student(Integer.valueOf(vars[3]), vars[1], Double.valueOf(vars[2]));
                students.add(st);
            } else if (event.contains("SERVED")) {
                // remove the top of the list
                students.poll();
            }

            for(Student elem:students) {
                System.out.println(elem.getName() + " " + elem.getCgpa() + " " + elem.getId());
            }
        }

        return students.stream().collect(Collectors.toList());
    }

}

class Student implements Comparable<Student>{
    private String name;
    private int id;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId(){
        return id;
    }

    public double getCgpa() {
        return cgpa;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student o) {
        if(this.cgpa > o.cgpa) {
            return 1;
        } else if(this.cgpa == o.cgpa) {
            int nameResult = this.name.compareToIgnoreCase(o.name);
            if(nameResult==0) {
                if(this.id > o.id) {
                    return 1;
                } else {
                    return -1;
                }
            }
            return nameResult;
        }
        return -1;
    }
}


public class PriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
