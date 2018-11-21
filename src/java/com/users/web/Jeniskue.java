package com.users.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Hakushuu
 */
@ManagedBean
@RequestScoped
public class Jeniskue {

    /**
     * Creates a new instance of Jenis Kue
     */
    
    private String KODE;
    public void setKODE(String KODE) {
        this.KODE = KODE;
    }
    public String getKODE() {
        return KODE;
    }

    private String NAMA;
    public void setNAMA(String NAMA) {
        this.NAMA = NAMA;
    }
    public String getNAMA() {
        return NAMA;
    }
    
    private String EXPIRED;
    public void setEXPIRED(String EXPIRED) {
        this.EXPIRED = EXPIRED;
    }
    public String getEXPIRED() {
        return EXPIRED;
    }
   
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap(); 

public String Edit_Jeniskue(){
     FacesContext fc = FacesContext.getCurrentInstance();
     Map<String,String > params = fc.getExternalContext().getRequestParameterMap();
     String Field_KODE = params.get("action");
     try {
          Koneksi obj_koneksi = new Koneksi();
          Connection connection = obj_koneksi.get_connection();
          Statement st = connection.createStatement();
          ResultSet rs = st.executeQuery("select * from jenis_kue where kode_jenis_kue="+Field_KODE);
          Jeniskue obj_Jeniskue = new Jeniskue();
          rs.next();
          obj_Jeniskue.setKODE(rs.getString("kode_jenis_kue"));
          obj_Jeniskue.setNAMA(rs.getString("nama_jenis_kue"));
          obj_Jeniskue.setEXPIRED(rs.getString("jangka_expired"));
          sessionMap.put("EditJeniskue", obj_Jeniskue);  
      } catch (Exception e) {
            System.out.println(e);
      }
     return "/Edit1.xhtml?faces-redirect=true";   
}

public String Delete_Jeniskue(){
      FacesContext fc = FacesContext.getCurrentInstance();
      Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
      String Field_KODE = params.get("action");
      try {
         Koneksi obj_koneksi = new Koneksi();
         Connection connection = obj_koneksi.get_connection();
         PreparedStatement ps = connection.prepareStatement("delete from jenis_kue where kode_jenis_kue=?");
         ps.setString(1, Field_KODE);
         System.out.println(ps);
         ps.executeUpdate();
        } catch (Exception e) {
         System.out.println(e);
        }
       return "/index.xhtml?faces-redirect=true";   
}

public String Update_Jeniskue(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
	String Update_KODE= params.get("Update_KODE");
        try {
            Koneksi obj_koneksi = new Koneksi();
            Connection connection = obj_koneksi.get_connection();
            PreparedStatement ps = connection.prepareStatement("update jenis_kue set kode_jenis_kue=?, nama_jenis_kue=?, jangka_expired=? where kode_jenis_kue=?");
            ps.setString(1, KODE);
            ps.setString(2, NAMA);
            ps.setString(3, EXPIRED);
            ps.setString(4, Update_KODE);
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
       return "/index.xhtml?faces-redirect=true";   
}
    
    public ArrayList getGet_all_jeniskue() throws Exception{
        ArrayList list_of_jeniskue=new ArrayList();
             Connection connection=null;
        try {
            Koneksi obj_koneksi = new Koneksi();
            connection = obj_koneksi.get_connection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("Select * from jenis_kue");
            while(rs.next()){
                Jeniskue obj_Jeniskue = new Jeniskue();
                obj_Jeniskue.setKODE(rs.getString("kode_jenis_kue"));
                obj_Jeniskue.setNAMA(rs.getString("nama_jenis_kue"));
                obj_Jeniskue.setEXPIRED(rs.getString("jangka_expired"));
                list_of_jeniskue.add(obj_Jeniskue);
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            if(connection!=null){
                connection.close();
            }
        }
        return list_of_jeniskue;
}
    
public String Tambah_Jeniskue(){
        try {
            Connection connection=null;
            Koneksi obj_koneksi = new Koneksi();
            connection = obj_koneksi.get_connection();
            PreparedStatement ps=connection.prepareStatement("insert into jenis_kue (kode_jenis_kue, nama_jenis_kue, jangka_expired) value('"+KODE+"','"+NAMA+"','"+EXPIRED+"')");
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return "/index.xhtml?faces-redirect=true";
    }
}