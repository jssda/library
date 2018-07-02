package cn.jssd.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	/**
     * �����������ڵ��������
     * @author shijing
     * 2015��9��6������5:14:54
     * @param date1
     * @param date2
     * @return
     */
    public static int daysBetween(Date date1,Date date2){     
        Calendar cal = Calendar.getInstance();     
        cal.setTime(date1);     
        long time1 = cal.getTimeInMillis();                  
        cal.setTime(date2);     
        long time2 = cal.getTimeInMillis();          
        long between_days=(time2-time1)/(1000*3600*24);     
             
       return Integer.parseInt(String.valueOf(between_days));            
    }    
    
    /**
     * ����һ�����ж�����
     * @author shijing
     * 2015��9��6������5:15:18
     * @param datetime
     * @return
     */
    public static String getDayByMonth(String datetime){  
        StringBuffer buffer = new StringBuffer();  
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM");   
        Calendar calendar = new GregorianCalendar();   
        try {  
            Date date = sdf.parse(datetime);  
            calendar.setTime(date);   
            int day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);  
            if(day < 10){  
                buffer = buffer.append("0").append(String.valueOf(day));  
            }else{  
                buffer = buffer.append(String.valueOf(day));  
            }  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }   
        return buffer.toString();  
    }  

}
