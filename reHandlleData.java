

import static java.lang.System.out;

import java.util.Scanner;

public class reHandlleData extends Function{
	public static void updateDate() {
		while(true) {
			int XXX;
			out.println("接下來輸入你想要修改的資料工作編號，輸入0離開");
			String select = input.nextLine();
			XXX=judgeUpdate(select);

			if(select.equals("0")) {
				  while(true) {
					   out.println("確認離開? Y/N");
				     String ss = input.nextLine();
				     if(ss.equals("Y")) {
						   return;
				     }else if(ss.equals("N")) {
						   break;
				     }else {
				   continue;
				   }
			    }
				   continue;
			   //判斷資料正確否
		     }else if(XXX>=0){
		    	  DataStruct re =  DataHere.get(XXX);
				  while(true) {
					    out.println("請選擇想要修改或更新的功能，輸入0隨時可以重新選擇");
					    out.print("(1 使用工作名子/");
						out.print("(2 使用開始時間/");
						out.print("(3 使用結束時間/");
						out.print("(4 使用完成百分比/");
						out.println("(5 使用工作狀態/");
						out.print("(6 使用工作編號/");
						out.print("(7 使用工作分類/");
						out.print("(8 使用工作內容/");
						out.print("(9 重新輸入編號/");
						out.print("(10 返回選單/");
						String SelectX = input.nextLine();
						if(SelectX.equals("1")) {
							out.print("輸入修改的工作名子");
							select = input.nextLine();
							if(select.equals("0")) {
								   continue;
							   //判斷資料正確否
						    }else {
						    	re.workName = select;
						    }
						}else if(SelectX.equals("2")) {
							out.print("輸入修改的開始時間,EX.2017/06/06");
							select = input.nextLine();
							if(select.equals("0")) {
								   continue;
							   //判斷資料正確否
						    }else {
						       Scanner reDate = new Scanner(select).useDelimiter("/");
							   int yy = reDate.nextInt();
							   int mm = reDate.nextInt();
							   int dd = reDate.nextInt();
							   DateX startDate1 = new DateX(mm,dd,yy);
							   if(startDate1.dateOK(mm,dd,yy)) {
							      re.startDate = startDate1;
							   }else {
								    out.println("時間格式錯誤，請確認後輸出");
									continue;
							   }
								 reDate.close();

						    }
						}else if(SelectX.equals("3")) {
							out.print(" 輸入修改的結束時間,EX.2018/06/06");
							select = input.nextLine();
							if(select.equals("0")) {
								   continue;
							   //判斷資料正確否
						    }else {
						    	Scanner reDate = new Scanner(select).useDelimiter("/");
								   int yy = reDate.nextInt();
								   int mm = reDate.nextInt();
								   int dd = reDate.nextInt();
								   DateX endDate1 = new DateX(mm,dd,yy);
								   if(endDate1.dateOK(mm,dd,yy)) {
								      re.endDate = endDate1;
								   }else {
									    out.println("時間格式錯誤，請確認後輸出");
										continue;
								   }
								    reDate.close();
						    }
						}else if(SelectX.equals("4")) {
							out.print(" 輸入修改的完成百分比,EX 99%");
							select = input.nextLine();
							if(select.equals("0")) {
								   continue;
							   //判斷資料正確否
						    }else {
						    	if(select.charAt(select.length()-1)=='%') {
									   Scanner rePercent = new Scanner(select).useDelimiter("%");
									   int ss = rePercent.nextInt();
									   if(0<=ss&&ss<=100) {
										     re.percent = select;
									   }else {
										   out.println("請輸入0~100的完成度");
										   continue;
									   }
								   }else {
									   out.println("請輸入正確的值");
									   continue;
								   }
						    }
						}else if(SelectX.equals("5")) {
							out.print(" 輸入修改後的工作狀態，EX 完成、執行中、未開始");
							select = input.nextLine();
							if(select.equals("0")) {
								   continue;
							   //判斷資料正確否
						    }else {
						    	if(select.equals("完成")||select.equals("執行中")||select.equals("未開始")){
						    		re.status = select;
									   break;
								}else {
									out.println("請輸入正確的值");
								}
						    }
						}else if(SelectX.equals("6")) {
							out.print(" 輸入修改後工作編號，數字都可以");
							select = input.nextLine();
							if(select.equals("0")) {
								   continue;
							   //判斷資料正確否
						    }else {
						    	if(judgeNumber(select, select.length())==0) {
									   continue;
								   }else {
									   re.Numbering = select;
								   }
						    }
						}else if(SelectX.equals("7")) {
							out.print(" 輸入修改後的分類");
							select = input.nextLine();
							if(select.equals("0")) {
								   continue;
							   //判斷資料正確否
						    }else {
						    	  out.println("接下來輸入工作分類: ");
								   out.println("(1 工作/(2 考試/(3 私人/(4 活動/(5 其他/(6 自訂");
								    select = input.nextLine();
								   if(select.equals("0")) {
									   continue;
								   }else if(select.equals("1")) {
									   re.classX  = "工作";
									   break;
								   }else if(select.equals("2")) {
									   re.classX  = "考試";
									   break;
								   }else if(select.equals("3")) {
									   re.classX  = "私人";
									   break;
								   }else if(select.equals("4")) {
									   re.classX  = "活動";
									   break;
								   }else if(select.equals("5")) {
									   re.classX  = "其他";
									   break;
								   }else {
									   out.println("接下來輸入自訂分類: ");
									   String XX  = input.nextLine();
									   if(XX.equals("0")) {
											continue;
										   //判斷資料正確否
									    }else {
											   re.classX=XX;
										}
								   }

						    }
						}else if(SelectX.equals("8")) {
							out.print(" 輸入修改後工作內容");
							select = input.nextLine();
							if(select.equals("0")) {
								   continue;
							   //判斷資料正確否
						    }else {
						    	re.work = select;
						    }
						}else if(SelectX.equals("9")) {
							DataHere.set(XXX, re);
							break;
						}else if(SelectX.equals("10")) {
							DataHere.set(XXX, re);
							return;
						}

				  }

		 }else{
				   out.println("請輸入正確的值");
		 }
	  }

    }

	public static void addNewDate() {
		while(true) {
		   out.println("接下來輸入你想要更新的資料，");
		   out.println("工作名稱/開始時間/結束時間/完成度/工作狀態/工作編號/工作分類/工作內容");
		   out.println("輸入0可以離開輸入");
		   DataStruct re = new DataStruct();
		   //輸入工作名稱
		   while(true) {
			   out.println("接下來輸入工作名稱:");
			   re.workName  = input.nextLine();
			   //跳出離開確認
			   if(re.workName.equals("0")) {
				   while(true) {
					   out.println("確認離開? Y/N");
					   String ss = input.nextLine();
					   if(ss.equals("Y")) {
						   return;
					   }else if(ss.equals("N")) {
						   break;
					   }else {
						   continue;
					   }
				   }
				   continue;
			   //判斷資料正確否
			   }else {
				   break;
			   }
		   }
		   //輸入開始時間
		   while(true) {
			   out.println("接下來輸入開始時間 ex.2017/06/01:");
			   String XX = input.nextLine();
			   if(XX.equals("0")) {
				   while(true) {
					   out.println("確認離開? Y/N");
					   String ss = input.nextLine();
					   if(ss.equals("Y")) {
						   return;
					   }else if(ss.equals("N")) {
						   break;
					   }else {
						   continue;
					   }
				   }
				   continue;
			   //判斷資料正確否
			   }else {
				   Scanner reDate = new Scanner(XX).useDelimiter("/");
				   int yy = reDate.nextInt();
				   int mm = reDate.nextInt();
				   int dd = reDate.nextInt();
				   DateX startDate  = new DateX(mm,dd,yy);
				   if(startDate.dateOK(mm,dd,yy)) {
					    re.startDate = startDate;
					}else {
						continue;
					}
				   reDate.close();
				   break;
			   }
		   }
		   //輸入結束時間
		   while(true) {
			   out.println("接下來輸入結束時間 ex.2017/06/01:");
			   String XX = input.nextLine();
			   if(XX.equals("0")) {
				   while(true) {
					   out.println("確認離開? Y/N");
					   String ss = input.nextLine();
					   if(ss.equals("Y")) {
						   return;
					   }else if(ss.equals("N")) {
						   break;
					   }else {
						   continue;
					   }
				   }
				   continue;
			   //判斷資料正確否
			   }else {
				   Scanner reDate = new Scanner(XX).useDelimiter("/");
				   int yy = reDate.nextInt();
				   int mm = reDate.nextInt();
				   int dd = reDate.nextInt();
				   DateX endDate1 = new DateX(mm,dd,yy);
				   if(endDate1.dateOK(mm,dd,yy)) {
					    re.endDate = endDate1;
					}else {
						continue;
					}
				   reDate.close();
				   break;
			   }
		   }
		   //輸入完成度
		   while(true) {
			   out.println("接下來輸入完成度: ex.87%");
			   re.percent  = input.nextLine();
			   //跳出離開確認
			   if(re.percent.equals("0")) {
				   while(true) {
					   out.println("確認離開? Y/N");
					   String ss = input.nextLine();
					   if(ss.equals("Y")) {
						   return;
					   }else if(ss.equals("N")) {
						   break;
					   }else {
						   continue;
					   }
				   }
				   continue;
			   //判斷資料正確否
			   }else {
				   if(re.percent.charAt(re.percent.length()-1)=='%') {
					   Scanner rePercent = new Scanner(re.percent).useDelimiter("%");
					   int ss = rePercent.nextInt();
					   if(0<=ss&&ss<=100) {
						     break;
					   }else {
						   out.println("請輸入0~100的完成度");
						   continue;
					   }
				   }else {
					   out.println("請輸入正確的值");
					   continue;
				   }
			   }
		   }
		   //判斷狀態
		   while(true) {
			   out.println("接下來輸入工作完成度: ex.完成，執行中，未開始");
			   re.status  = input.nextLine();
			   //跳出離開確認
			   if(re.status.equals("0")) {
				   while(true) {
					   out.println("確認離開? Y/N");
					   String ss = input.nextLine();
					   if(ss.equals("Y")) {
						   return;
					   }else if(ss.equals("N")) {
						   break;
					   }else {
						   continue;
					   }
				   }
				   continue;
			   //判斷資料正確否
			   }else if(re.status.equals("完成")||re.status.equals("執行中")||re.status.equals("未開始")){
				   break;
			   }else {
				   continue;
			   }
		   }
		   //工作編號
		   while(true) {
			   out.println("接下來輸入工作編號: 數字都可以");
			   re.Numbering  = input.nextLine();
			   //跳出離開確認
			   if(re.Numbering.equals("0")) {
				   while(true) {
					   out.println("確認離開? Y/N");
					   String ss = input.nextLine();
					   if(ss.equals("Y")) {
						   return;
					   }else if(ss.equals("N")) {
						   break;
					   }else {
						   continue;
					   }
				   }
				   continue;
			   //判斷資料正確否
			   }else {

				   if(judgeNumber(re.Numbering, re.Numbering.length())==0) {
					   continue;
				   }else {
					   break;
				   }
			   }
		   }
		 //工作分類
		   while(true) {
			   out.println("接下來輸入工作分類: ");
			   out.println("(1 工作/(2 考試/(3 私人/(4 活動/(5 其他/(6 自訂");
			   String select = input.nextLine();
			   if(select.equals("0")) {
				   while(true) {
					   out.println("確認離開? Y/N");
					   String ss = input.nextLine();
					   if(ss.equals("Y")) {
						   return;
					   }else if(ss.equals("N")) {
						   break;
					   }else {
						   continue;
					   }
				   }
				   continue;
			   }else if(select.equals("1")) {
				   re.classX  = "工作";
				   break;
			   }else if(select.equals("2")) {
				   re.classX  = "考試";
				   break;
			   }else if(select.equals("3")) {
				   re.classX  = "私人";
				   break;
			   }else if(select.equals("4")) {
				   re.classX  = "活動";
				   break;
			   }else if(select.equals("5")) {
				   re.classX  = "其他";
				   break;
			   }else {
				   out.println("接下來輸入自訂分類: ");
				   re.classX  = input.nextLine();
			   }
				   //跳出離開確認
			   if(re.classX.equals("0")) {
				  while(true) {
			    	  out.println("確認離開? Y/N");
				      String ss = input.nextLine();
					   if(ss.equals("Y")) {
						   return;
					   }else if(ss.equals("N")) {
						   break;
						}else {
				    	   continue;
					   }
		  	      }
					continue;
				   //判斷資料正確否
			    }else {
					   break;
				}

		   }
		   //工作內容
		   while(true) {
			   out.println("接下來輸入工作內容:");
			   re.work  = input.nextLine();
			   //跳出離開確認
			   if(re.work.equals("0")) {
				   while(true) {
					   out.println("確認離開? Y/N");
					   String ss = input.nextLine();
					   if(ss.equals("Y")) {
						   return;
					   }else if(ss.equals("N")) {
						   break;
					   }else {
						   continue;
					   }
				   }
				   continue;
			   //判斷資料正確否
			   }else {
				   break;
			   }
		   }
		   DataHere.add(re);
		   break;
		}
	}
	private static  int judgeUpdate(String number) {
		for(int i =0 ;i<DataHere.size();i++) {
			 if(DataHere.get(i).Numbering.equals(number)) {
				 return i;
			 }
		}
		return 0;
	}

	private static int judgeNumber(String a , int b) {
		for(int i =0;i<b;i++) {
			   if(!('0'<=a.charAt(i)&&a.charAt(i)<='9')){
				   out.println("你輸入的不是數字，請確認後再輸入");
				   return 0;
			   }
		}
		for(int i =0 ; i<DataHere.size();i++) {
			if(DataHere.get(i).Numbering.equals(a)) {
				out.println("不能有重複的工作編號喔，請重新輸入");
				return 0;
			}
		}
		return 1;
	}
}
