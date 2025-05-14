//Cannot access Student

 class Student {
    String name;
    int score;
    int grade;

    Student(String name, int score, int grade) {
        this.name = name;
        this.score = score;
        //this.grade = grade ;
        if (grade == 10) {
            this.grade = grade;
        }else {
            System.out.println("Only Grade 10 allowed");
        }
    }

}

