import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date; 
import java.text.SimpleDateFormat;
import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;

public class Calender_yy_mm {

        int ann;int mois,X;
        Calender_yy_mm(int ann,int mois,int day){
        	if(ann==0&&mois==0&&day==0) {
        		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        		Date date = new Date();
        		String strDate = sdFormat.format(date);
        		
        		this.ann= Integer.valueOf(strDate.substring(0,4));
            	this.mois=Integer.valueOf(strDate.substring(5,7));
            	this.X=Integer.valueOf(strDate.substring(8,10));
        		
        	}else {
        	
        	
        	this.ann=ann;
        	this.mois=mois;
        	this.X=day;
        	}
        }//end_建構子
	Color color1=GREEN;
	Color color2=YELLOW;
	Color color3=BLUE;
	Color color4=RED;
	Color color5=CYAN;


        void printCalender_yy_mm(){
//ansi().fg(WHITE).a("日"+" 一"+" 二"+" 三"+" 四"+" 五"+" 六").reset()
	//color1
        System.out.print( ansi().fg(color1).a(Integer.toString(ann)));
  	System.out.print(ansi().fg(color1 ).a(" 年  "));
 	System.out.print(ansi().fg(color1).a(Integer.toString(mois)));
 	System.out.print(ansi().fg(color1).a(" 月  "));
	System.out.print(ansi().fg(color1).a(Integer.toString(X)));
	System.out.println(ansi().fg(color1).a(" 日"));

	//color2
        System.out.print( ansi().fg(color2).a("日"));
	System.out.print(ansi().fg(color2).a(" 一"));
	System.out.print(ansi().fg(color2).a(" 二"));
	System.out.print(ansi().fg(color2).a(" 三"));
	System.out.print(ansi().fg(color2).a(" 四"));
	System.out.print(ansi().fg(color2).a(" 五"));
	System.out.println(ansi().fg(color2).a(" 六").reset() );

	//color3
        System.out.println(ansi().fg(color3).a("---------------------").reset());

        Calendar cal = new GregorianCalendar(ann,mois-1,1);
        int day = cal. getActualMaximum(Calendar.DATE); //取得當月最大天數
        int day_of_week = cal.get(Calendar.DAY_OF_WEEK);//星期幾?
        int day_of_month = cal.get(Calendar.DAY_OF_MONTH);//當月的第一天

        for(int k = 1 ; k < day_of_week ; k++){
          System.out.print("   ");
        } //先把空格空出來


        for(day_of_month = 1 ; day_of_month <= day ; day_of_month++){//此FOR迴圈是要將日期印出來
        	if(day_of_month==X) {
        		if(day_of_month<10){  //若那一天是個位數的印法
		//color4
                    System.out.print(" "+(ansi().fg(color4).a(Integer.toString(X)).reset()+" "));
                    }else{  //十位數的印法
                    System.out.print(ansi().fg(color4).a(Integer.toString(X)).reset()+" ");
                    }
        	}else {
        		if(day_of_month<10){  //若那一天是個位數的印法
        			System.out.print(" ");
			//color5
				System.out.print(ansi().fg(color5).a(Integer.toString(day_of_month)).reset());
				System.out.print(" ");
        		}else{  //十位數的印法
				System.out.print(ansi().fg(color5).a(Integer.toString(day_of_month)).reset());
				System.out.print(" ");
        		} 
        	}//整個IF迴圈是為了要設定格式

           if (cal.get(Calendar.DAY_OF_WEEK) == 7&&day_of_month!=day) {  //每到星期六則跳行
                      System.out.println();
                  }
           cal.add(Calendar.DAY_OF_MONTH, 1);
         }
        System.out.println("");
      } //end_printCalender_yy_mm()
      

}
