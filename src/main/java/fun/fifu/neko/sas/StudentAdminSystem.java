package fun.fifu.neko.sas;

import fun.fifu.neko.sas.pojo.Student;

import java.util.Scanner;

public class StudentAdminSystem {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("====== 欢迎使用学生管理系统 ======");
        while (true) {
            System.out.println("1.添加学生  2.查询学生  3.删除学生  4.修改学生  请选择操作（序号）：");
            switch (scanner.next()) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    searchStudent();
                    break;
                case "3":
                    deleteStudent();
                    break;
                case "4":
                    changeStudent();
                    break;
                default:
                    System.out.println("非法操作");
            }
        }
    }

    private static void changeStudent() {
    }

    private static void deleteStudent() {
    }

    private static void searchStudent() {

    }

    private static void addStudent() {
        Student student = new Student();
        System.out.println("请输入学生的学号：");
        student.setId(scanner.nextLong());
        System.out.println("请输入学生的姓名：");
        student.setName(scanner.next());
        System.out.println("请输入学生的身份证号：");
        student.setIdCard(scanner.next());
        System.out.println("请输入学生的班级：");
        student.setClassName(scanner.next());
        System.out.println("请输入学生的手机号：");
        student.setPhoneNumber(scanner.nextLong());
        System.out.println("请设置学生的密码：");
        student.setPassWord(scanner.next());
        DataManger.addData(student);
    }
}
