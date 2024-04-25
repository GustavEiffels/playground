public class PolymorphismExam {
    
    class Person{
        void show(){
            System.out.println("Person");
        }
    }

    class Student extends Person{
        void show(){
            System.out.println("Student");
        }
    }

    public static void main(String[] args) {
        PolymorphismExam polymorphismExam = new PolymorphismExam();
        Person student = polymorphismExam.new Student();
        student.show();
    }
}
