import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int age;
    private int score;

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return score;
    }
}

public class Test6 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 14, 88),
                new Student("Bob", 23, 82),
                new Student("Charlie", 17, 95),
                new Student("David", 21, 73)
        );

        Map<Integer, Double> averageScoreByAgeGroup = students.stream()
                .collect(Collectors.groupingBy(student -> (student.getAge() / 10) * 10,
                        Collectors.averagingDouble(Student::getScore)));

        averageScoreByAgeGroup.forEach((ageGroup, averageScore) ->
                System.out.println(ageGroup + "s: " + averageScore));

    }
}
