package educationCenter;

import java.util.Arrays;
import java.util.Scanner;

public class EducationCenter {
    static StudentStorage studentStorage = new StudentStorage();
    static LessonStorage lessonStorage = new LessonStorage();
    static Scanner scanner = new Scanner(System.in);
    private static final int EXIT = 0;
    private static final int ADD_STUDENT = 1;
    private static final int ADD_LESSON = 2;
    private static final int PRINT_STUDENTS = 3;
    private static final int PRINT_LESSONS = 4;
    private static final int CHANGE_STUDENT_LESSON = 5;
    private static final int PRINT_STUDENTS_BY_LESSON_NAME = 6;


    public static void main(String[] args) {
        boolean isrun = true;
        while (isrun) {
            printCommand();
            String commandStr = scanner.nextLine();
            int command = Integer.parseInt(commandStr);
            switch (command) {
                case EXIT:
                    isrun = false;
                    System.out.println("Հաջողություն");
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case ADD_LESSON:
                    addLesson();
                    break;
                case PRINT_STUDENTS:
                    printStudents();
                    break;
                case PRINT_LESSONS:
                    printLessons();
                    break;
                case CHANGE_STUDENT_LESSON:
                    changeStudentLesson();
                    break;
                case PRINT_STUDENTS_BY_LESSON_NAME:
                    printStudentByLessonName();
                    break;
                default:
                    System.out.println("Սխալ հրաման");
            }
        }
    }

    private static void printStudentByLessonName() {
        System.out.println("Ներմուծեք առարկայի անունը, ուսանողներին տեսնելու համար");
        String byLessonNameStr = scanner.nextLine();
        System.out.println(Arrays.toString(studentStorage.printStudentByLessonName(byLessonNameStr)));

    }

    private static void changeStudentLesson() {
        System.out.println("ուսանողների ցանկը");
        printStudents();
        System.out.println("ընտրեք այն ուսանողի անունը որի առարկան ուզում եք փոխել");
        String studentName = scanner.nextLine();
        System.out.println("դուք ուզում եք փոխել այս ուսանողի առարկան " + studentStorage.getByName(studentName));
        System.out.println("ընտրեք առարկաների անունները");
        lessonStorage.printLessonName();
        String lessonsNameStr = scanner.nextLine();
        String[] lessonsName = lessonsNameStr.split(",");
        Lesson[] lessons = new Lesson[lessonsName.length];
        for (int i = 0; i < lessonsName.length; i++) {
            lessons[i] = lessonStorage.getByName(lessonsName[i]);
        }
        Student student = studentStorage.getByName(studentName);
        student.setLesson(lessons);


    }

    private static void printLessons() {
        lessonStorage.print();
    }

    private static void printStudents() {
        studentStorage.print();
    }

    private static void addLesson() {
        System.out.println("Ներմուծեք առարկաների տվյալները (name,duration,price,lecturerName)");
        String lessonDataStr = scanner.nextLine();
        String[] lessonData = lessonDataStr.split(",");
        Lesson lesson = new Lesson();
        lesson.setName(lessonData[0]);
        lesson.setDuration(Integer.parseInt(lessonData[1]));
        lesson.setPrice(Double.parseDouble(lessonData[2]));
        lesson.setLecturerName(lessonData[3]);
        lessonStorage.add(lesson);


    }

    private static void addStudent() {
        System.out.println("Ընտրեք առարկաների անունները");
        lessonStorage.print();
        String lessonNameStr = scanner.nextLine();
        String[] lessonName = lessonNameStr.split(",");
        Lesson[] lessonByName = new Lesson[lessonName.length];
        for (int i = 0; i < lessonName.length; i++) {
            lessonByName[i] = lessonStorage.getByName(lessonName[i]);
        }
        System.out.println("Գրեք ուսանողի տվյալները (name,surname,phone,email)");
        String studentDataStr = scanner.nextLine();
        String[] studentData = studentDataStr.split(",");
        Student student = new Student();
        student.setName(studentData[0]);
        student.setSurname(studentData[1]);
        student.setPhone(studentData[2]);
        student.setEmail(studentData[3]);
        student.setLesson(lessonByName);
        studentStorage.add(student);


    }


    private static void printCommand() {
        System.out.println("Ներմուծել " + EXIT + " դուրս գալու համար");
        System.out.println("Ներմուծել " + ADD_STUDENT + " ուսանող ավելացնելու համար");
        System.out.println("Ներմուծել " + ADD_LESSON + " առարկա ավելացնելու համար ");
        System.out.println("Ներմուծել " + PRINT_STUDENTS + " ուսանողներին տեսնելու համար");
        System.out.println("Ներմուծել " + PRINT_LESSONS + " առարկաները տեսնելու համար");
        System.out.println("Ներմուծել " + CHANGE_STUDENT_LESSON + " ուսանողի առարկան փոխելու համար");
        System.out.println("Ներմուծել " + PRINT_STUDENTS_BY_LESSON_NAME + " ուսանողնորին առարկայի անունով գտնելու համար");

    }
}

