package fun.fifu.neko.sas;

import fun.fifu.neko.sas.pojo.Student;

import java.util.Scanner;

public class StudentAdminSystem {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("====== 欢迎使用学生管理系统 ======");
        while (true) {
            System.out.print("1.添加学生  2.查询学生  3.删除学生  4.修改学生  请选择操作（序号）：");
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
        System.out.print("请输入要删除的学生的学号：");
        DataManger.removeDataById(scanner.nextLong());
        System.out.println("操作完毕");
    }

    private static void searchStudent() {
        System.out.print("1.按学号搜索     2.按姓名搜索     3.按身份证搜索    4.按手机号搜索    5.按班级搜索  6.所有信息   请选择操作（序号）：");
        switch (scanner.next()) {
            case "1":
                searchStudentById();
                break;
            case "2":
                searchStudentByName();
                break;
            case "3":
                searchStudentByIdCard();
                break;
            case "4":
                searchStudentByClassName();
                break;
            case "6":
                System.out.println("所有信息：");
                DataManger.metaData.getItems().forEach(System.out::println);
                break;
            default:
                System.out.println("选择有误");
        }
    }

    private static void searchStudentByClassName() {
        System.out.print("请输入学生班级：");
        String className = scanner.next();
        DataManger.metaData.getItems().stream().filter(p -> p.getClassName().equals(className)).forEach(System.out::println);
    }

    private static void searchStudentByIdCard() {
        System.out.print("请输入学生身份证：");
        String idCard = scanner.next();
        DataManger.metaData.getItems().stream().filter(p -> p.getIdCard().equals(idCard)).forEach(System.out::println);
    }

    private static void searchStudentByName() {
        System.out.print("请输入学生姓名：");
        String name = scanner.next();
        DataManger.metaData.getItems().stream().filter(p -> p.getName().equals(name)).forEach(System.out::println);
    }

    private static void searchStudentById() {
        System.out.print("请输入学生学号：");
        Long id = scanner.nextLong();
        DataManger.metaData.getItems().stream().filter(p -> p.getId().equals(id)).forEach(System.out::println);
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
        if (DataManger.addData(student)) {
            System.out.println("录入成功");
        } else {
            System.out.println("学号重复，录入失败");
        }
    }
}
