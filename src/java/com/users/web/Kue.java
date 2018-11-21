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
public class Kue {

    /**
     * Creates a new instance of Mahasiswa
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
    
    private String HARGA;
    public void setHARGA(String HARGA) {
        this.HARGA = HARGA;
    }
    public String getHARGA() {
        return HARGA;
    }
    
        private String KODEJENIS;
    public void setKODEJENIS(String KODEJENIS) {
        this.KODEJENIS = KODEJENIS;
    }
    public String getKODEJENIS() {
        return KODEJENIS;
    }
    
        private String STOCK;
    public void setSTOCK(String STOCK) {
        this.STOCK = STOCK;
    }
    public String getSTOCK() {
        return STOCK;
    }
   
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap(); 

public String Edit_Kue(){
     FacesContext fc = FacesContext.getCurrentInstance();
     Map<String,String > params = fc.getExternalContext().getRequestParameterMap();
     String Field_KODE = params.get("action");
     try {
          Koneksi obj_koneksi = new Koneksi();
          Connection connection = obj_koneksi.get_connection();
          Statement st = connection.createStatement();
          ResultSet rs = st.executeQuery("select * from kue where kode_kue="+Field_KODE);
          Kue obj_Kue = new Kue();
          rs.next();
          obj_Kue.setKODE(rs.getString("kode_kue"));
          obj_Kue.setNAMA(rs.getString("nama_kue"));
          obj_Kue.setHARGA(rs.getString("harga_satuan"));
          obj_Kue.setKODEJENIS(rs.getString("kode_jenis_kue"));
          obj_Kue.setSTOCK(rs.getString("stock"));
          sessionMap.put("EditKue", obj_Kue);  
      } catch (Exception e) {
            System.out.println(e);
      }
     return "/Edit.xhtml?faces-redirect=true";   
}

public String Delete_Kue(){
      FacesContext fc = FacesContext.getCurrentInstance();
      Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
      String Field_KODE = params.get("action");
      try {
         Koneksi obj_koneksi = new Koneksi();
         Connection connection = obj_koneksi.get_connection();
         PreparedStatement ps = connection.prepareStatement("delete from kue where kode_kue=?");
         ps.setString(1, Field_KODE);
         System.out.println(ps);
         ps.executeUpdate();
        } catch (Exception e) {
         System.out.println(e);
        }
       return "/index.xhtml?faces-redirect=true";   
}

public String Update_Kue(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
	String Update_KODE= params.get("Update_KODE");
        try {
            Koneksi obj_koneksi = new Koneksi();
            Connection connection = obj_koneksi.get_connection();
            PreparedStatement ps = connection.prepareStatement("update kue set kode_kue=?, nama_kue=?, harga_satuan=?, kode_jenis_kue=?, stock=?  where kode_kue=?");
            ps.setString(1, KODE);
            ps.setString(2, NAMA);
            ps.setString(3, HARGA);
            ps.setString(4, KODEJENIS);
            ps.setString(5, STOCK);
            ps.setString(6, Update_KODE);
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
       return "/index.xhtml?faces-redirect=true";   
}
    
    public ArrayList getGet_all_kue() throws Exception{
        ArrayList list_of_kue=new ArrayList();
             Connection connection=null;
        try {
            Koneksi obj_koneksi = new Koneksi();
            connection = obj_koneksi.get_connection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("Select * from kue");
            while(rs.next()){
                Kue obj_Kue = new Kue();
                obj_Kue.setKODE(rs.getString("kode_kue"));
                obj_Kue.setNAMA(rs.getString("nama_kue"));
                obj_Kue.setHARGA(rs.getString("harga_satuan"));
                obj_Kue.setKODEJENIS(rs.getString("kode_jenis_kue"));
                obj_Kue.setSTOCK(rs.getString("stock"));
                list_of_kue.add(obj_Kue);
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            if(connection!=null){
                connection.close();
            }
        }
        return list_of_kue;
}
    
public String Tambah_Kue(){
        try {
            Connection connection=null;
            Koneksi obj_koneksi = new Koneksi();
            connection = obj_koneksi.get_connection();
            PreparedStatement ps=connection.prepareStatement("insert into kue(kode_kue, nama_kue, harga_satuan, kode_jenis_kue, stock) value('"+KODE+"','"+NAMA+"','"+HARGA+"','"+KODEJENIS+"','"+STOCK+"')");
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return "/index.xhtml?faces-redirect=true";
    }
}