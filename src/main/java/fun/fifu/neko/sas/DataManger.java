package fun.fifu.neko.sas;

import cn.hutool.core.io.FileUtil;
import com.google.gson.Gson;
import fun.fifu.neko.sas.pojo.Data;
import fun.fifu.neko.sas.pojo.Student;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DataManger {
    public static Data metaData;
    public static final File datafile = new File("./data.json");
    public static final Gson gson = new Gson();

    static {
        metaData = readData();
    }

    public static Data readData() {
        if (datafile.isFile()) {
            return gson.fromJson(FileUtil.readUtf8String(datafile), Data.class);
        } else {
            datafile.getParentFile().mkdirs();
            FileUtil.writeUtf8String(gson.toJson(new Data()), datafile);
            return readData();
        }
    }

    public static void saveData() {
        FileUtil.writeUtf8String(gson.toJson(metaData), datafile);
    }

    public static boolean addData(Student student) {
        if (metaData.getItems() == null) {
            metaData.setItems(new ArrayList<>());
        }
        if (metaData.getItems().stream().noneMatch(s -> s.getId().equals(student.getId()))) {
            metaData.getItems().add(student);
            saveData();
            return true;
        }
        return false;
    }
}
