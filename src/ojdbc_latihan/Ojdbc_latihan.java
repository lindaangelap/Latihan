/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ojdbc_latihan;

import dao.JobGradeDAO;
import java.util.List;
import model.JobGrade;

/**
 *
 * @author hp
 */
public class Ojdbc_latihan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(new connection().getKoneksi());
//        System.out.println(new JobGradeDAO().getAllData().size());
//        List<JobGrade> datas = new JobGradeDAO().getAllData();
//        datas = new JobGradeDAO().search("1000");
//        for (int i = 0; i < datas.size(); i++) {
//            System.out.println(datas.get(i).getGradelevel()+", Gaji Tertinggi: "+datas.get(i).getHighestSalary());
//        }
//        for (JobGrade data : datas) {
//            
//        }
//        datas.forEach(x->System.out.println(x.getGradelevel()+" Gaji Tertinggi : "+x.getHighestSalary()+" Gaji Terendah : "+x.getLowestSalary()));
        List<JobGrade> datas = new JobGradeDAO().search("lowest_level_sal", "1000");
        datas.forEach(x -> System.out.println(x.getGradelevel() + " Gaji Tertinggi : " + x.getHighestSalary() + " Gaji Terendah : " + x.getLowestSalary()));

//        System.out.println("menampilkan lowestsalary di A");
//        JobGrade jg = new JobGradeDAO().getByGradeLevel("A");
//        System.out.println(jg.getLowestSalary());
//
//        System.out.println("Insert Data");
//        JobGrade masuk = new JobGrade();
//        masuk.setGradelevel("G");
//        masuk.setLowestSalary(2000);
//        masuk.setHighestSalary(45000);
//        System.out.println(new JobGradeDAO().insert(masuk));
//        
//        System.out.println("Update Data");
//        JobGrade ubah = new JobGrade("C",1000,44000);
//        System.out.println(new JobGradeDAO().update(ubah));
        
        System.out.println("Delete Data");
        JobGrade hapus = new JobGrade();
        System.out.println(new JobGradeDAO().delete("G"));
    }

}
