package educationCenter;

public class LessonStorage {
    private Lesson[] lessons;
    private int size;


    public LessonStorage(int capasity) {
        lessons = new Lesson[capasity];
    }

    public LessonStorage() {
        lessons = new Lesson[10];
    }

    public void add(Lesson lesson) {
        if (size == lessons.length) {
            extend();
        }
        lessons[size++] = lesson;
    }

    private void extend() {
        Lesson[] temp = new Lesson[lessons.length + 10];
        System.arraycopy(lessons, 0, temp, 0, lessons.length);
        lessons = temp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(lessons[i]);

        }
    }

    public Lesson getByName (String name) {
        for (int i = 0; i < size; i++) {
            if (lessons[i].getName().equals(name))
            return lessons[i];

        }return null;
    }

    public void printLessonName(){
        for (int i = 0; i < size; i++) {
            System.out.print(lessons[i].getName() + " ,");

        }
    }
}

