import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<Programmer> programmers = new ArrayList<>();
        programmers.add(new Programmer("Jack", new ArrayList<>(List.of(new Task("task1",20,Status.DONE),
                new Task("task2",10,Status.CANCELED))),"City1"));
        programmers.add(new Programmer("John", new ArrayList<>(List.of(new Task("task2",10,Status.CANCELED),
                new Task("task3",20,Status.PROCESSED))),"City2"));
        programmers.add(new Programmer("Niko", new ArrayList<>(List.of(new Task("task4",20,Status.DONE))),"City3"));

        Status status1 = Status.DONE;
        Status status2 = Status.DONE;

        //1
        System.out.println(getListOfTasks(programmers,status1));
        System.out.println("-".repeat(150));
        //2
        System.out.println(groupByBoolean(programmers,status2));
        System.out.println("-".repeat(150));
        //3
        System.out.println(groupProgrammersByTasks(programmers));


    }
    public static List<Task> getListOfTasks(List<Programmer> programmers, Status status){
        return programmers.stream()
                .flatMap(programmer -> programmer.getTasks().stream())
                .filter(task -> task.getStatus() == status)
                .sorted((d1,d2) -> d2.getDays()- d1.getDays())
                .collect(Collectors.toList());
    }
    public static Map<Boolean,List<Task>> groupByBoolean(List<Programmer> programmers, Status status){
        return programmers.stream()
                .flatMap(programmer -> programmer.getTasks().stream())
                .collect(Collectors.groupingBy(task -> task.getStatus() == status));
    }
    public static Map<Task,List<Programmer>> groupProgrammersByTasks(List<Programmer> programmers){
        return programmers.stream()
                .flatMap(programmer -> programmer.getTasks().stream()
                        .map(task -> Map.entry(task, programmer)))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue , Collectors.toList())));
    }
}