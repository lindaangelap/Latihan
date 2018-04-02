/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.JobGrade;
import ojdbc_latihan.connection;

/**
 *
 * @author hp
 */
public class JobGradeDAO {

    private Connection kon;

    public JobGradeDAO() {
        this.kon = new connection().getKoneksi();
    }

    /**
     *
     * fungsi untuk melihat semua data JobGrades
     *
     * @return List semua data JobGrade
     */
    public List<JobGrade> getAllData() {
//        List<JobGrade> datas = new ArrayList<>();
//
//        try {
//            PreparedStatement pst = con.prepareStatement("SELECT * FROM HR.job_grades");
//            ResultSet rs = pst.executeQuery();
//            while (rs.next()) {
//                JobGrade jd = new JobGrade(rs.getString("grade_level"),rs.getInt("lowest_level_sal"),rs.getInt("highest_sal"));
////                bisa yang dipakai bisa yang di comment
////                jd.setGradelevel(rs.getString("grade_level"));
////                jd.setLowestSalary(rs.getInt("lowest_level_sal"));
////                jd.setHighestSalary(rs.getInt("highest_sal"));
//                datas.add(jd);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(JobGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }

        return getData("");

    }

    public JobGrade getByGradeLevel(String gradeLevel) {

        return getData("WHERE grade_level='" + gradeLevel + "'").get(0);

    }

    /**
     *
     * fungsi untuk mencari semua data JobGrades
     *
     * @return List semua data JobGrade
     */
    public List<JobGrade> search(String category, String cari) {
//        List<JobGrade> datas = new ArrayList<>();
//
//        try {
//            PreparedStatement pst = con.prepareStatement("SELECT * FROM HR.job_grades where grade_level Like '%"+cari+"%'"
//                    + "OR lowest_level_sal Like '%"+cari+"%'"
//                            + "OR highest_sal LIKE '&"+cari+"%'");
//            ResultSet rs = pst.executeQuery();
//            while (rs.next()) {
//                JobGrade jd = new JobGrade(rs.getString("grade_level"),rs.getInt("lowest_level_sal"),rs.getInt("highest_sal"));
//                datas.add(jd);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(JobGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return datas;
        return getData("Where " + category + " Like '%" + cari + "%'");

    }

    private List<JobGrade> getData(String query) {
        List<JobGrade> datas = new ArrayList<>();

        try {
            PreparedStatement pst = kon.prepareStatement("SELECT * FROM job_grades " + query);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                JobGrade jd = new JobGrade(rs.getString("grade_level"), rs.getInt("lowest_level_sal"), rs.getInt("highest_sal"));
                datas.add(jd);
            }

        } catch (SQLException ex) {
            Logger.getLogger(JobGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return datas;
    }

    public boolean insert(JobGrade jobGrade) {
        try {
            PreparedStatement pst = kon.prepareStatement("INSERT INTO JOB_GRADES VALUES (?,?,?)");
            pst.setString(1, jobGrade.getGradelevel());
            pst.setInt(2, jobGrade.getLowestSalary());
            pst.setInt(3, jobGrade.getHighestSalary());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JobGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean update(JobGrade jobGrade) {
        try {
            PreparedStatement pst = kon.prepareStatement("UPDATE JOB_GRADES SET lowest_level_sal=?,"
                    + " highest_sal =? WHERE grade_level=?");
            pst.setInt(1, jobGrade.getLowestSalary());
            pst.setInt(2, jobGrade.getHighestSalary());
            pst.setString(3, jobGrade.getGradelevel());
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JobGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean delete(String gradeLevel) {
        try {
            PreparedStatement pst = kon.prepareStatement("DELETE JOB_GRADES WHERE grade_level=?");
            pst.setString(1, gradeLevel);
            pst.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(JobGradeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
