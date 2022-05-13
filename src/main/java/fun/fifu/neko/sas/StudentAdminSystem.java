package fun.fifu.neko.sas;

import fun.fifu.neko.sas.pojo.Student;

import java.util.Scanner;

public class StudentAdminSystem {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("====== 欢迎使用学生管理系统 ======");
        try {
            while (true) {
                System.out.print("1.添加学生  2.查询学生  3.删除学生  4.修改学生  请选择操作（序号）：");
                switch (scanner.next()) {
                    case "1" -> addStudent();
                    case "2" -> searchStudent();
                    case "3" -> deleteStudent();
                    case "4" -> changeStudent();
                    default -> System.out.println("非法操作");
                }
            }
        } catch (Throwable ignored) {
        }
    }

    private static void changeStudent() {
        System.out.print("请输入要修改信息的学生的学号：");
        Long id = scanner.nextLong();
        DataManger.metaData.getItems().stream().filter(p -> p.getId().equals(id)).forEach(student -> {
            System.out.println("正在操作条目：");
            System.out.println(student);
            System.out.print("1.修改学号    2.修改姓名  3.修改身份证号     4.修改手机号     5.修改班级      6.暂不修改     请选择操作（序号）：");
            switch (scanner.next()) {
                case "1" -> {
                    System.out.println("请输入新学号：");
                    student.setId(scanner.nextLong());
                }
                case "2" -> {
                    System.out.println("请输入新姓名：");
                    student.setName(scanner.next());
                }
                case "3" -> {
                    System.out.println("请输入新身份证号：");
                    if (!student.setIdCard(scanner.next()))
                        System.out.println("输入的身份证号不合法，修改失败");
                }
                case "4" -> {
                    System.out.println("请输入新手机号：");
                    student.setPhoneNumber(scanner.nextLong());
                }
                case "5" -> {
                    System.out.println("请输入新班级：");
                    student.setClassName(scanner.next());
                }
                default -> System.out.println("输入有误");
            }
            DataManger.saveData();
            System.out.println("操作完毕");
        });
    }

    private static void deleteStudent() {
        System.out.print("请输入要删除的学生的学号：");
        DataManger.removeDataById(scanner.nextLong());
        System.out.println("操作完毕");
    }

    private static void searchStudent() {
        System.out.print("1.按学号搜索     2.按姓名搜索     3.按身份证搜索    4.按手机号搜索    5.按班级搜索  6.所有信息   请选择操作（序号）：");
        switch (scanner.next()) {
            case "1" -> searchStudentById();
            case "2" -> searchStudentByName();
            case "3" -> searchStudentByIdCard();
            case "4" -> searchStudentByPhoneNumber();
            case "5" -> searchStudentByClassName();
            case "6" -> searchStudentAll();
            default -> System.out.println("选择有误");
        }
    }

    private static void searchStudentAll() {
        System.out.println("所有信息：");
        DataManger.metaData.getItems().forEach(System.out::println);
    }

    private static void searchStudentByPhoneNumber() {
        System.out.print("请输入学生的手机号：");
        Long id = scanner.nextLong();
        DataManger.metaData.getItems().stream().filter(p -> p.getPhoneNumber().equals(id)).forEach(System.out::println);
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
        if (DataManger.metaData.getItems().stream().anyMatch(s -> s.getId().equals(student.getId()))) {
            System.out.println("学号重复，添加失败");
            return;
        }
        System.out.println("请输入学生的姓名：");
        student.setName(scanner.next());
        System.out.println("请输入学生的身份证号：");
        if (!student.setIdCard(scanner.next())) {
            System.out.println("输入的身份证号不合法，添加失败");
            return;
        }
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
