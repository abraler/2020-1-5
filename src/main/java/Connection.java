import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Connection {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //注册Driver
        Class.forName("com.mysql.jdbc.Driver");
        //通过DriverManager连接数据库
        java.sql.Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Connection?useSSL=false&characterEncoding=utf8",
                "root",
                "wx123456"
        );
        Statement statement = connection.createStatement();
        Scanner in=new Scanner(System.in);
        int flag=0;//选项
        while(flag!=-1){
            menu();
            flag=in.nextInt();
            switch(flag){
                case 1:add(in,statement);break;
                case 2:Show(statement);break;
                case 3:select(in, statement);break;
                case 4:alter(in,statement);break;
                case -1:flag=-1;break;
                default :break;
            }
        }
    }

    //添加
    private static void add(Scanner in,Statement statement) throws SQLException {
        System.out.print("->姓名");
        String name=in.next();
        System.out.print("->地址");
        String address=in.next();
        System.out.print("->电话");
        String phone=in.next();
        System.out.print("->邮政编码");
        String PostalCode=in.next();
        System.out.print("->Email");
        String Email=in.next();
        System.out.print("家庭电话");
        String hometelephone=in.next();
        try {
            StringBuilder sb=new StringBuilder();
            sb.append("INSERT INTO connector VALUES(");
            sb.append("'"+name+"'"+",");
            sb.append("'"+address+"'"+",");
            sb.append("'"+phone+"'"+",");
            sb.append("'"+PostalCode+"'"+",");
            sb.append("'"+Email+"'"+",");
            sb.append("'"+hometelephone+"'"+")");
            sb.append(";");
            System.out.println(sb);
            int  rows= statement.executeUpdate(sb.toString());
            //statement.close();
        }catch ( Exception e){
        }


    }
    //显示
    private static void Show(Statement statement) throws SQLException {
        ResultSet resultSet=statement.executeQuery("select *from connector order by name");
        while(resultSet.next()){
        String name =resultSet.getString(1);
        String address=resultSet.getString(2);
        String phone=resultSet.getString(3);
        String PostalCode=resultSet.getString(4);
        String Email=resultSet.getString(5);
        String hometelephone=resultSet.getString(6);
        System.out.println("name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", PostalCode=" + PostalCode +
                ", Email='" + Email + '\'' +
                ", hometelephone='" + hometelephone + '\'' );
        }

//        statement.close();
//        resultSet.close();
    }
    //查询
    private static void select(Scanner in,Statement statement) throws SQLException {
        System.out.println("->请输入你要查询的姓名");
        String name =in.next();
        StringBuilder sql=new StringBuilder();
        sql.append("select*from connector where name="+"'");
        sql.append(name);
        sql.append("'");
        ResultSet resultSet=statement.executeQuery(sql.toString());
        while(resultSet.next()) {
            String address = resultSet.getString(2);
            String phone = resultSet.getString(3);
            String PostalCode = resultSet.getString(4);
            String Email = resultSet.getString(5);
            String hometelephone = resultSet.getString(6);
            System.out.println("name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    ", phone='" + phone + '\'' +
                    ", PostalCode=" + PostalCode +
                    ", Email='" + Email + '\'' +
                    ", hometelephone='" + hometelephone + '\'');

        }

//        statement.close();
//        resultSet.close();
    }
    //修改
    private static void alter(Scanner in,Statement statement) throws SQLException {
        System.out.println("请输入要修改的姓名");
        String name =in.next();
        StringBuilder sql=new StringBuilder();
        sql.append("update connector ");
        System.out.print("->地址");
        String address=in.next();
        System.out.print("->电话");
        String phone=in.next();
        System.out.print("->邮政编码");
        String PostalCode=in.next();
        System.out.print("->Email");
        String Email=in.next();
        System.out.print("->家庭电话");
        String hometelephone=in.next();

        sql.append("set address='");
        sql.append(address+"'");


        sql.append(",phone='");
        sql.append(phone+"'");

        sql.append(",PostalCode='");
        sql.append(PostalCode+"'");

        sql.append(",Email='");
        sql.append(Email+"'");

        sql.append(",hometelephone='");
        sql.append(hometelephone+"'");

        sql.append("where name="+"'");
        sql.append(name+"'");

        int rows= statement.executeUpdate(sql.toString());
//        statement.close();

    }

    //菜单
    private static void menu(){
        System.out.println("选择菜单");
        System.out.println("1->添加");
        System.out.println("2—>显示");
        System.out.println("3->查询");
        System.out.println("4—>修改");
        System.out.println("-1->退出");
        System.out.println("->请选择");

    }
}