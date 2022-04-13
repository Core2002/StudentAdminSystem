package fun.fifu.neko.sas.pojo;

import cn.hutool.core.util.IdcardUtil;
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

    public boolean setIdCard(String idCard) {
        if (IdcardUtil.isValidCard(idCard)) {
            this.idCard = idCard;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("学号：").append(id).append('\t');
        stringBuilder.append("姓名：").append(name).append('\t');
        stringBuilder.append("性别：").append(IdcardUtil.getGenderByIdCard(idCard) == 0 ? '女' : '男').append('\t');
        stringBuilder.append("籍贯：").append(IdcardUtil.getProvinceByIdCard(idCard)).append('\t');
        stringBuilder.append("年龄：").append(IdcardUtil.getAgeByIdCard(idCard)).append('\t');
        stringBuilder.append("班级：").append(className).append('\t');
        stringBuilder.append("生日：").append(IdcardUtil.getBirth(idCard)).append('\t');
        stringBuilder.append("手机号：").append(phoneNumber).append('\t');
        return stringBuilder.toString();
    }
}
