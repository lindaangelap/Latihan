/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.JobGradeDAO;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.JobGrade;

/**
 *
 * @author hp
 */
public class JobGradeController implements ControllerInterface{

    public JobGradeDAO jgdao;
    
    public JobGradeController(){        
        this.jgdao = new JobGradeDAO();
    }
    @Override
    public boolean insert(Object obj) {
        JobGrade jg = (JobGrade) obj;
        return jgdao.insert(jg);
    }
    
    public boolean insert(String gradeLevel, int lowSal, int higSal) {
        JobGrade grade = new JobGrade(gradeLevel, lowSal, higSal);
        return jgdao.insert(grade);
    }

    @Override
    public boolean delete(String id) {       
        return jgdao.delete(id);
    }

    @Override
    public boolean update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean update(String gradeLevel, int lowSal, int higSal) {
        JobGrade grade = new JobGrade(gradeLevel, lowSal, higSal);
        return jgdao.update(grade);
    }
    

    @Override
    public List<Object> search(String kategori, String cari) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getBy(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
//    public void bindingTable(JTable table) {
//        String header[] = {"Grade Level", "Lowest Salary", "Highest Salary"};
//        List<JobGrade> datas = new JobGradeDAO().getAllData();
//        Object[][] data = new Object[datas.size()][3];
//        for (int i = 0; i < datas.size(); i++) {
//            data[i][0] = datas.get(i).getGradelevel();
//            data[i][1] = datas.get(i).getLowestSalary();
//            data[i][2] = datas.get(i).getHighestSalary();
//        }
//        DefaultTableModel model = new DefaultTableModel(data, header);
//        table.setModel(model);
//    }
//    
   

//  atau juga bisa seperti di bawah karena header harusnya di view jadi di pindah ke view
//  karna tidak hanya getalldata jadi di jadikan parameter

    
    public void bindingAll(JTable table, String[] header)
    {
        bindingTable(table, header, jgdao.getAllData());
    }
    
    public void bindingSearch(JTable table, String[] header, String category, String cari){
        bindingTable(table, header, jgdao.search(category, cari));        
    }
    

    public void bindingTable(JTable table, String[] header, List<JobGrade> datas) {       
        DefaultTableModel model = new DefaultTableModel(header,0);
        for (JobGrade data : datas) {
            Object[] data1 = {
                data.getGradelevel(),
                data.getLowestSalary(),
                data.getHighestSalary()
            };
            model.addRow(data1);
        }
        table.setModel(model);
    }

    
}
