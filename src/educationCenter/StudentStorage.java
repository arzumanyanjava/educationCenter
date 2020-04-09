package educationCenter;

public class StudentStorage {

    private Student[] students;
    private int size;


    public StudentStorage(int capasity) {
        students = new Student[capasity];
    }

    public StudentStorage() {
        students = new Student[10];
    }

    public void add(Student student) {
        if (size == students.length) {
            extend();
        }
        students[size++] = student;
    }

    private void extend() {
        Student[] temp = new Student[students.length + 10];
        System.arraycopy(students, 0, temp, 0, students.length);
        students = temp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(students[i]);

        }

    }

    public Student getByName(String name) {
        for (int i = 0; i < size; i++) {
            if (students[i].getName().equals(name)) ;
            return students[i];

        }
        return null;
    }

    public Student[] printStudentByLessonName(String name) {
        Student[] newStudents = new Student[size];
        for (int i = 0; i < size; i++) {
            if (name.equals(students[i].getLesson(name)[i].getName())) {
                System.arraycopy(students,0,newStudents,0,size);
                return newStudents;
            }
        }
        return null;
    }

}
