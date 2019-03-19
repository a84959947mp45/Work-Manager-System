

import java.text.*;
import java.util.*;
import static java.lang.System.out;


public class view  extends Function{
		private static List<DataStruct> reData = new ArrayList<DataStruct>();
		public static int controlls=1;
		//看全部
		public static  void ViewAll() {
			int pageMAX = (DataHere.size()-1)/10;
			int page = 0;
		     Calender_yy_mm C_yy_mm ;


			while(true) {
				out.printf("%d頁/%d頁%n",page+1,pageMAX+1);
				out.println("");
				try {
					for(int i=0;i<10;i++) {
							String nouse = DataHere.get(page*10+i).workName;


							out.printf("第%d筆資料%n",page*10+i+1);
							out.println("工作名稱:");
							out.println(DataHere.get(page*10+i).workName);
							out.println("開始時間:");
							C_yy_mm = new Calender_yy_mm(DataHere.get(page*10+i).startDate.getYear()
									,DataHere.get(page*10+i).startDate.getMonth(),DataHere.get(page*10+i).startDate.getDay());
						    C_yy_mm.printCalender_yy_mm();
						    out.println("結束時間:");
							C_yy_mm = new Calender_yy_mm(DataHere.get(page*10+i).endDate.getYear()
									,DataHere.get(page*10+i).endDate.getMonth(),DataHere.get(page*10+i).endDate.getDay());
						    C_yy_mm.printCalender_yy_mm();
						    out.println("工作百分比:");
							out.println(DataHere.get(page*10+i).percent);
							String re= DataHere.get(page*10+i).percent;
							Scanner Ninput = new Scanner(re).useDelimiter("%");
							int sizeX = Ninput.nextInt()/10;
							Ninput.close();

							out.print("|");
							for(int j=0;j<sizeX;j++) {
								out.print("*");
							}
							for(int j=0;j<10-sizeX;j++) {
								out.print(" ");
							}
							out.println("|");
							out.println("完成狀態:");
							out.println(DataHere.get(page*10+i).status);
							out.println("工作編號:");
							out.println(DataHere.get(page*10+i).Numbering);
							out.println("分類:");
							out.println(DataHere.get(page*10+i).classX);
							out.println("工作內容:");
							out.println(DataHere.get(page*10+i).work);
							out.println();

					}
				}
				catch(IndexOutOfBoundsException e){

				}
				out.println("(1 上一頁 (2 下一頁 (3 選擇排序種類 (4 返回 (5 退出程式");
				String select = input.nextLine();
				if(select.equals("1")) {
					if(page==0) {
						out.println("已經是最上一頁了");
						continue;
					}
					page--;
				}else if(select.equals("2")) {
					if(page==pageMAX) {
							out.println("已經是最後一頁了");
							continue;
						}
						page++;
				}else if(select.equals("3")) {
						view.SortWhat();
						page = 0;
						continue;
				}else if(select.equals("4")) {

					return;
				}else if(select.equals("5")) {
				    data.outputFile();
					System.exit(1);
				}else {
					 continue;
				}
			}
		}
		//看分類
		public static void ViewClass(String classSelect,String SelectName) {
			reData.clear();
			if(classSelect.equals("workName")) {
				for(int i =0 ; i<DataHere.size();i++) {
					if(DataHere.get(i).workName.equals(SelectName)) {
						reData.add(DataHere.get(i));
					}
				}
			}else if(classSelect.equals("startDate")) {
				for(int i =0 ; i<DataHere.size();i++) {
					if(DataHere.get(i).startDate.toString().equals(SelectName)) {
						reData.add(DataHere.get(i));
					}
				}
			}else if(classSelect.equals("endDate")) {
				for(int i =0 ; i<DataHere.size();i++) {
					if(DataHere.get(i).endDate.toString().equals(SelectName)) {
						reData.add(DataHere.get(i));
					}
				}
			}else if(classSelect.equals("percent")) {
				for(int i =0 ; i<DataHere.size();i++) {
					if(DataHere.get(i).percent.equals(SelectName)) {
						reData.add(DataHere.get(i));
					}
				}
			}else if(classSelect.equals("status")) {
				for(int i =0 ; i<DataHere.size();i++) {
					if(DataHere.get(i).status.equals(SelectName)) {
						reData.add(DataHere.get(i));
					}
				}
			}else if(classSelect.equals("Numbering")) {
				for(int i =0 ; i<DataHere.size();i++) {
					if(DataHere.get(i).Numbering.equals(SelectName)) {
						reData.add(DataHere.get(i));
					}
				}
			}else if(classSelect.equals("classX")) {
				for(int i =0 ; i<DataHere.size();i++) {
					if(DataHere.get(i).classX.equals(SelectName)) {
						reData.add(DataHere.get(i));
					}
				}
			}else if(classSelect.equals("work")) {
				for(int i =0 ; i<DataHere.size();i++) {
					if(DataHere.get(i).work.equals(SelectName)) {
						reData.add(DataHere.get(i));
					}
				}
			}else {
				out.println("查無資料");
				return;
			}


			int pageMAX = (reData.size()-1)/10;
			int page = 0;
			Scanner XINPUT ;
		    Calender_yy_mm C_yy_mm ;


			while(true) {
				out.printf("%d頁/%d頁%n",page+1,pageMAX+1);
				out.println("");
				try {
					for(int i=0;i<10;i++) {
							String nouse=reData.get(page*10+i).workName;


							out.printf("第%d筆資料%n",page*10+i+1);
							out.println("工作名稱:");
							out.println(reData.get(page*10+i).workName);
							out.println("開始時間:");
							C_yy_mm = new Calender_yy_mm(reData.get(page*10+i).startDate.getYear()
									,reData.get(page*10+i).startDate.getMonth(),reData.get(page*10+i).startDate.getDay());
						    C_yy_mm.printCalender_yy_mm();
						    out.println("結束時間:");
							C_yy_mm = new Calender_yy_mm(reData.get(page*10+i).endDate.getYear()
									,reData.get(page*10+i).endDate.getMonth(),reData.get(page*10+i).endDate.getDay());
						    C_yy_mm.printCalender_yy_mm();
						    out.println("工作百分比:");
							out.println(reData.get(page*10+i).percent);
							String re= reData.get(page*10+i).percent;
							XINPUT = new Scanner(re).useDelimiter("%");
							int sizeX = XINPUT.nextInt()/10;
							XINPUT.close();
							out.print("|");
							for(int j=0;j<sizeX;j++) {
								out.print("*");
							}
							for(int j=0;j<10-sizeX;j++) {
								out.print(" ");
							}
							out.println("|");
							out.println("完成狀態:");
							out.println(reData.get(page*10+i).status);
							out.println("工作編號:");
							out.println(reData.get(page*10+i).Numbering);
							out.println("分類:");
							out.println(reData.get(page*10+i).classX);
							out.println("工作內容:");
							out.println(reData.get(page*10+i).work);
							out.println();

					}
				}
				catch(IndexOutOfBoundsException e){

				}
				out.println("(1 上一頁 (2 下一頁 (3 選擇排序種類 (4 返回 (5 退出程式");
				String select = input.nextLine();
				out.println(select);
				if(select.equals("1")) {
					if(page==0) {
						out.println("已經是最上一頁了");
						continue;
					}
					page--;
				}else if(select.equals("2")) {
					if(page==pageMAX) {
							out.println("已經是最後一頁了");
							continue;
						}
						page++;
				}else if(select.equals("3")) {
						view.SortWhat(classSelect);
						page = 0;
						continue;
				}else if(select.equals("4")) {

					return;
				}else if(select.equals("5")) {
				    data.outputFile();
					System.exit(1);
				}else {
					 continue;
				}

			}
		}
		//看選擇
		void search(String select) {

		}
		public static void SortWhat() {
			out.println("如果你想要依種類排序，請選擇種類");
			out.print("(1 工作名子/");
			out.print("(2 開始時間/");
			out.print("(3 結束時間/");
			out.print("(4 完成百分比/");
			out.println("(5 工作狀態/");
			out.print("(6 工作編號/");
			out.print("(7 工作分類/");
			out.print("(8 工作內容/");
			out.print("(9 返回選單/");
			out.print("(10 退出程式");
			String select = input.next();
			while(true) {
				if(select.equals("1")) {
					Collections.sort(DataHere, new Comparator<DataStruct>(){

						public int compare(DataStruct r1, DataStruct r2) {
							String name1=  r1.workName;
			                String name2=  r2.workName;
			                Collator instance = Collator.getInstance(Locale.TAIWAN);
			                return controlls*instance.compare(name1, name2);
					    }
					});
					return;
				}else if(select.equals("2")) {
					Collections.sort(DataHere, new Comparator<DataStruct>() {

						public int compare(DataStruct r1, DataStruct r2) {
							DateX time1=  r1.startDate;
			                DateX time2=  r2.startDate;

			                return controlls*time1.precedes(time2);
						}
					});

					return;

				}else if(select.equals("3")) {
					Collections.sort(DataHere, new Comparator<DataStruct>(){
						public int compare(DataStruct r1, DataStruct r2) {
							DateX time1=  r1.endDate;
			                DateX time2=  r2.endDate;
			                return controlls*time1.precedes(time2);
					    }
					} );
					return;
				}else if(select.equals("4")) {
					Collections.sort(DataHere, new Comparator<DataStruct>(){

						public int compare(DataStruct r1, DataStruct r2) {
							String percent1=  r1.percent;
			                String percent2=  r2.percent;
			                return controlls*percent1.compareTo(percent2);
					    }
					});
					return;
				}else if(select.equals("5")) {
					Collections.sort(DataHere, new Comparator<DataStruct>(){

						public int compare(DataStruct r1, DataStruct r2) {
							String name1=  r1.status;
			                String name2=  r2.status;
			                Collator instance = Collator.getInstance(Locale.TAIWAN);
			                return controlls*instance.compare(name1, name2);
					    }
					});
					return;
				}else if(select.equals("6")) {
					Collections.sort(DataHere, new Comparator<DataStruct>(){

						public int compare(DataStruct r1, DataStruct r2) {
							String percent1=  r1.Numbering;
			                String percent2=  r2.Numbering;
			                return controlls*percent1.compareTo(percent2);
					    }
					});
					return;
				}else if(select.equals("7")) {
						Collections.sort(DataHere, new Comparator<DataStruct>(){

							public int compare(DataStruct r1, DataStruct r2) {
								String percent1=  r1.Numbering;
				                String percent2=  r2.Numbering;
				                return controlls*percent1.compareTo(percent2);
						    }
					});
					return;
				}else if(select.equals("8")) {
					Collections.sort(DataHere, new Comparator<DataStruct>(){

						public int compare(DataStruct r1, DataStruct r2) {
							String name1=  r1.work;
			                String name2=  r2.work;
			                Collator instance = Collator.getInstance(Locale.TAIWAN);
			                return controlls*instance.compare(name1, name2);
					    }
					});
					return;
				}else if(select.equals("9")) {
					return;
				}else if(select.equals("10")) {
				    data.outputFile();
					System.exit(1);
				}else {
					 continue;
				}

			}
		}
		//分類排序
		public static void SortWhat(String X) {
			Scanner XINPUT  =  new Scanner(System.in);
			out.println("請選擇排序種類");
			out.print("(1 工作名子/");
			out.print("(2 開始時間/");
			out.print("(3 結束時間/");
			out.print("(4 完成百分比/");
			out.println("(5 工作狀態/");
			out.print("(6 工作編號/");
			out.print("(7 工作內容/");
			out.print("(8 返回選單/");
			out.print("(9 退出程式");
			String select = XINPUT.next();
			while(true) {
				if(select.equals("1")) {
					Collections.sort(reData, new Comparator<DataStruct>(){

						public int compare(DataStruct r1, DataStruct r2) {
							String name1=  r1.workName;
			                String name2=  r2.workName;
			                Collator instance = Collator.getInstance(Locale.TAIWAN);
			                return controlls*instance.compare(name1, name2);
					    }
					});
					return;
				}else if(select.equals("2")) {
					Collections.sort(reData, new Comparator<DataStruct>() {

						public int compare(DataStruct r1, DataStruct r2) {
							DateX time1=  r1.startDate;
			                DateX time2=  r2.startDate;

			                return controlls*time1.precedes(time2);
						}
					});

					return;

				}else if(select.equals("3")) {
					Collections.sort(reData, new Comparator<DataStruct>(){
						public int compare(DataStruct r1, DataStruct r2) {
							DateX time1=  r1.endDate;
			                DateX time2=  r2.endDate;
			                return controlls*time1.precedes(time2);
					    }
					} );
					return;
				}else if(select.equals("4")) {
					Collections.sort(reData, new Comparator<DataStruct>(){

						public int compare(DataStruct r1, DataStruct r2) {
							String percent1=  r1.percent;
			                String percent2=  r2.percent;
			                return controlls*percent1.compareTo(percent2);
					    }
					});
					return;
				}else if(select.equals("5")) {
					Collections.sort(reData, new Comparator<DataStruct>(){

						public int compare(DataStruct r1, DataStruct r2) {
							String name1=  r1.status;
			                String name2=  r2.status;
			                Collator instance = Collator.getInstance(Locale.TAIWAN);
			                return controlls*instance.compare(name1, name2);
					    }
					});
					return;
				}else if(select.equals("6")) {
					Collections.sort(reData, new Comparator<DataStruct>(){

						public int compare(DataStruct r1, DataStruct r2) {
							String percent1=  r1.percent;
			                String percent2=  r2.percent;
			                return controlls*percent1.compareTo(percent2);
					    }
					});
					return;
				}else if(select.equals("7")) {
					Collections.sort(reData, new Comparator<DataStruct>(){

						public int compare(DataStruct r1, DataStruct r2) {
							String name1=  r1.work;
			                String name2=  r2.work;
			                Collator instance = Collator.getInstance(Locale.TAIWAN);
			                return controlls*instance.compare(name1, name2);
					    }
					});
					return;
				}else if(select.equals("8")) {
					return;
				}else if(select.equals("9")) {
					data.outputFile();
					System.exit(1);
				}else {
					 continue;
				}
				XINPUT.close();
			}
		}




}
