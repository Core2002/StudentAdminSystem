package fun.fifu.neko.sas.pojo;

import lombok.Data;

@Data
public class Student {
    // 学号
    Long id;
    // 姓名
    String name;
    // 班级
    String className;
    // 身份证号
    String idCard;
    // 手机号
    Long phoneNumber;
    // 密码
    String passWord;
}
