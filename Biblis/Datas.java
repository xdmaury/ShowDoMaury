/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Biblis;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author junior
 */
public class Datas {
     public String data(){
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    } public String diames(){
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM");
        Date date = new Date();
        return dateFormat.format(date);
    }
    public String hora(){
        
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    public String horaeminuto(){
        
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        return dateFormat.format(date);
    }    

    public String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    
     
    
    public String formata10(){
        
        String v[]=getDateTime().split(" ");
        v[1]=v[1].split(":")[0]+":"+v[1].split(":")[1].charAt(0)+"0:00";
        return v[0]+" "+v[1];
    }
    
     public String getDataHoraM() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
       return dateFormat.format(date).substring(0,dateFormat.format(date).length()-1)+"0";

       // return dateFormat.format(date);
    } 
     
     
   
    public String getDataHoraMD() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String v[]=dateFormat.format(date).split("-");
       return v[0]+"-"+
           (( Integer.parseInt(v[1])<10)?"0":"") +(( Integer.parseInt(v[1])!=1)?(Integer.parseInt(v[1])-2):Integer.parseInt(v[1]))
               +"-"+v[2];

       // return dateFormat.format(date);
    }  
       public String getDateTimeMysql(Date dt) {
          if(dt==null){
              
              dt=new Date();
          }
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
       
        return dateFormat.format(dt);
    }
            
            
      
    /** Calcula o número de dias entre duas datas. */
    public  long calcular (String dt, Date dtFinal) throws ParseException {
  
         Calendar start = Calendar.getInstance();
       start.set(Integer.parseInt(dt.split("-")[0]),
               Integer.parseInt( dt.split("-")[1]),Integer.parseInt( dt.split("-")[2]));
         
 
Calendar end = Calendar.getInstance();
String dtf= new SimpleDateFormat ("YYYY-MM-dd").format(dtFinal);
end.set(Integer.parseInt(dtf.split("-")[0]),
               Integer.parseInt( dtf.split("-")[1]),Integer.parseInt( dtf.split("-")[2]));
Date startDate = start.getTime();
Date endDate = end.getTime();
long startTime = startDate.getTime();
long endTime = endDate.getTime();
long diffTime = endTime - startTime;
long diffDays = diffTime / (1000 * 60 * 60 * 24);
DateFormat dateFormat = DateFormat.getDateInstance();
System.out.println("The difference between "+
  dateFormat.format(startDate)+" and "+
  dateFormat.format(endDate)+" is "+
  diffDays+" days.");
return diffDays;
    }
            
                      public Date getDateMysqlD(String dt) {
       Calendar start = Calendar.getInstance();
       start.set(Integer.parseInt(dt.split("-")[2]),
               Integer.parseInt( dt.split("-")[1]),Integer.parseInt( dt.split("-")[0]));
       
       
         
           
             return start.getTime();
          
    }   
                    public String getDateMysql(Date dt) {
          if(dt==null){
              
              dt=new Date();
          }
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
       
        return dateFormat.format(dt);
    }
          public int pegarMes(Date dt) {
          if(dt==null){
              
              dt=new Date();
          }
        DateFormat dateFormat = new SimpleDateFormat("MM");
       
        return Integer.parseInt(dateFormat.format(dt))-1;
    }
          
                  public int pegarAno(Date dt) {
          if(dt==null){
              
              dt=new Date();
          }
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
                
        return Integer.parseInt(dateFormat.format(dt))-1;
    }
                     public String getDateTimeF() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
