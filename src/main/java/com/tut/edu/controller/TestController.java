package com.tut.edu.controller;

import com.tut.edu.Service.IUserService;
import com.tut.edu.UserModel.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.List;

@RestController
public class TestController {
    @Autowired
    private IUserService iUserService;

    @RequestMapping("/TestCode")
    public List<UserModel> Test() {
        return iUserService.SelectAll();
    }

    @RequestMapping(value = "/TestRun", method = RequestMethod.POST)
    public String TestRun(@RequestBody String codeString) {

        File file = new File("d:/test.py");
        try {
            System.out.println(file.createNewFile());
            if (file.exists()) {
                FileWriter filewriter = new FileWriter("d:/test.py", false);
                filewriter.write(codeString);
                filewriter.close();
                Process proc = Runtime.getRuntime().exec("py D:\\test.py");// 执行py文件
                proc.waitFor();
                // 定义Python脚本的返回值
                String result = null;
                // 获取CMD的返回流
                BufferedInputStream in = new BufferedInputStream(proc.getInputStream());
                // 字符流转换字节流
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String lineStr;
                while ((lineStr = br.readLine()) != null) {
                    result = lineStr;
                }
                // 关闭输入流
                br.close();
                in.close();
                return result;
            }
            return null;
        } catch (Exception ex) {

        }
        return null;
    }
}
