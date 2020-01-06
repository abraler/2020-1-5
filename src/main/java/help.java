import java.util.Scanner;

public class help {
    public static void main(String[] args) {
        StringBuilder sql=new StringBuilder();
        String name="wx";
        Scanner in=new Scanner(System.in);
        sql.append("update connector ");
        System.out.print("->地址");
        String address=in.next();
        System.out.print("->电话");
        String phone=in.next();
        System.out.print("->邮政编码");
        int PostalCode=in.nextInt();
        System.out.print("->Email");
        String Email=in.next();
        System.out.print("家庭电话");
        String hometelephone=in.next();

        sql.append("set address='");
        sql.append(address+"'");


        sql.append(",phone='");
        sql.append(phone+"'");

        sql.append(",PostalCode=");
        sql.append(phone);

        sql.append(",Email='");
        sql.append(Email+"'");

        sql.append(",hometelephone='");
        sql.append(hometelephone+"'");

        sql.append("where name="+"'");
        sql.append(name+"'");
        System.out.println(sql);
    }
}
