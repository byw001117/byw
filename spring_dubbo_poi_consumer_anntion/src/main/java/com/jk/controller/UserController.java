package com.jk.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.UserBean;
import com.jk.service.UserService;
import com.jk.util.ExportExcel;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {
    @Reference(version = "1.0")

    private UserService userService;

    @RequestMapping("toShow")
    public  String toShow(){
        return "show";
    }

    @RequestMapping("queryUser")
    @ResponseBody
    public List<UserBean> queryUser()  {
        List<UserBean> list=new ArrayList<>();
        try {
            list = userService.queryUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @RequestMapping("export")
    public void export(HttpServletResponse response){
        List<UserBean> list= new ArrayList<UserBean>();
        try {
            list = userService.queryUser();

            //定义表格的标题
            String title ="1905全体成员信息";
            //定义列名
            String[] rowName={"id","名称","性别","时间"};
            //定义工具类要的数据
            List<Object[]>  dataList = new ArrayList<Object[]>();

            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");


            //循环数据把数据存放到 List<Object[]>
            for (UserBean user:list) {
                Object[] obj=new Object[rowName.length];
                obj[0]=user.getUserid();
                obj[1]= user.getUsername();
                if(user.getUsersex()==1){
                    obj[2]="男" ;
                }else{
                    obj[2]="女" ;
                }
                obj[3]=sdf.format(user.getUsertime());



                dataList.add(obj);
            }
            ExportExcel exportExcel=new ExportExcel(title,rowName,dataList,response);
            exportExcel.export();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @RequestMapping("importExcel")
    public String importExcel(MultipartFile file, HttpServletResponse response){
        //上传文件的名称
        String fileName = file.getOriginalFilename();
        //生成新的文件名称
        String filePath = "./src/main/resources/templates/fileupload/";

        //创建list集合接收传递的参数
        List<UserBean> list= new ArrayList<UserBean>();

        //上传文件
        try {
            uploadFile(file.getBytes(), filePath, fileName);

            SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
            //通过文件创建流
            FileInputStream fileInputStream = new FileInputStream(filePath+fileName);
            //创建操作excel的对象   因为xls的文件需要HSSFWorkbook  xlsx需要的XSSFWorkbook 因此直接使用workBook对象就行了
            Workbook workbook= WorkbookFactory.create(fileInputStream) ;
            //通过workbook获得sheet页  sheet有可能有多个
            for(int i=0;i<workbook.getNumberOfSheets();i++){
                //创建sheet对象
                Sheet sheetAt = workbook.getSheetAt(i);
                //根绝sheet创建行  row
                for(int j=3;j<sheetAt.getPhysicalNumberOfRows();j++){
                    //创建row对象
                    Row row = sheetAt.getRow(j);

                    //创建对象接收从文件读取的内容
                    UserBean user=new UserBean();
                    if( !"".equals(row.getCell(1)) && row.getCell(1)!=null){
                        user.setUsername(row.getCell(1).toString());
                    }
                    if( !"".equals(row.getCell(2)) && row.getCell(2)!=null){
                        if(row.getCell(2).toString().equals("男")){
                            user.setUsersex(1);
                        }else {
                            user.setUsersex(2);
                        }
                    }

                    if( !"".equals(row.getCell(3)) && row.getCell(3)!=null){
                        user.setUsertime(sdf.parse(row.getCell(3).toString()));
                    }


                    list.add(user);
                }

            }
            userService.addUser(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "show";
    }



    //上传文件的方法
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }


}
