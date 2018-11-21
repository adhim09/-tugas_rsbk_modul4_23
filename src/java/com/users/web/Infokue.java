package com.users.web;

import java.sql.Connection;
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
public class Infokue {

    /**
     * Creates a new instance of Mahasiswa
     */
    
    private String NAMAJENISKUE;
    public void setNAMAJENISKUE(String NAMAJENISKUE) {
        this.NAMAJENISKUE = NAMAJENISKUE;
    }
    public String getNAMAJENISKUE() {
        return NAMAJENISKUE;
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
    
        private String EXPIRED;
    public void setEXPIRED(String EXPIRED) {
        this.EXPIRED = EXPIRED;
    }
    public String getEXPIRED() {
        return EXPIRED;
    }
    
        private String STOCK;
    public void setSTOCK(String STOCK) {
        this.STOCK = STOCK;
    }
    public String getSTOCK() {
        return STOCK;
    }
   
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap(); 

    public ArrayList getGet_all_infokue() throws Exception{
        ArrayList list_of_infokue=new ArrayList();
             Connection connection=null;
        try {
            Koneksi obj_koneksi = new Koneksi();
            connection = obj_koneksi.get_connection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("Select * from info_kue");
            while(rs.next()){
                Infokue obj_Infokue = new Infokue();
                obj_Infokue.setNAMAJENISKUE(rs.getString("nama_jenis_kue"));
                obj_Infokue.setNAMA(rs.getString("nama_kue"));
                obj_Infokue.setHARGA(rs.getString("harga_satuan"));
                obj_Infokue.setEXPIRED(rs.getString("jangka_expired"));
                obj_Infokue.setSTOCK(rs.getString("stock"));
                list_of_infokue.add(obj_Infokue);
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            if(connection!=null){
                connection.close();
            }
        }
        return list_of_infokue;
}
}
    
