
import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;
import static org.fusesource.jansi.Ansi.Color.*;
import static java.lang.System.out;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public  class Controller extends Function{
	private String account;
	private String password;
	//開始
	public void Start() {
		AnsiConsole.systemInstall();
		data.inputFile();
		EnterInformation();
	}
	//輸入帳號
	public void EnterInformation() {
		// TODO Auto-generated method stub

		while(true){
			out.println(ansi().fg(CYAN).a("歡迎來到工作紀錄簿，請輸入你的帳號密碼請輸入正確的，結束請輸入0"));
			out.println("帳號:");
			account = input.nextLine();
			if(account.equals("0")) {
				data.outputFile();
				input.close();
				System.exit(1);
			}
			out.println("密碼:");
			password = input.nextLine();
			if(account.equals("cis")&&password.equals("1234") ) {
				Menu();
				continue;
			}else {
				out.println("帳號密碼錯誤");
				continue;
			}
		}


	}
	//主畫面
	public void Menu() {
		String select;
		while(true) {
			out.println(ansi().fg(YELLOW).a("請選擇想進入的模式").reset());
			out.println(ansi().fg(CYAN).a("(1 使用者模式").reset());
			out.println(ansi().fg(RED).a("(2 管理者模式").reset());
			out.println(ansi().fg(GREEN).a("(3 返回帳號").reset());
			out.println(ansi().fg(MAGENTA).a("(4 退出程式").reset());
			select = input.nextLine();
			//選擇使用者模式
			if(select.equals("1")) {
				USER();
				continue;
			}else if(select.equals("2")) {
				Manager();
				continue;
			}else if(select.equals("3")) {
				EnterInformation();
				continue;
			}else if(select.equals("4")) {
				data.outputFile();
				input.close();
				System.exit(1);
			}else {
				 continue;
			}
		}
	}
	//次畫面
	public void USER() {

		String select="";
		while(true) {
			out.println("請選擇接下來想執行的項目");
			out.println("(1 顯示資料");
			out.println("(2 查詢資料");
			out.println("(3 新增資料");
			out.println("(4 修改、更新資料");
			out.println("(5 刪除資料");
			out.println("(6 返回");
			out.println("(7 退出程式");
			select = input.nextLine();
			//選資料顯示的模式
			if(select.equals("1")) {
				while(true) {
					out.println("請選擇如何顯示資料");
					out.println("(1 全部顯示");
					out.println("(2 依照分類顯示");
					out.println("(3 返回");
					select = input.nextLine();
					//顯示全部
					if(select.equals("1")) {
						view.ViewAll();
						break;
					//顯示分類
					}else if(select.equals("2")) {
						//依甚麼分類
						while(true) {
							out.println("請選擇要顯示甚麼分類?");
							out.println("(1 工作/(2 考試/(3 私人/(4 活動/(5 其他/(6 自訂");
							select = input.nextLine();
							if(select.equals("1")) {
								view.ViewClass("classX","工作");
								break;
							}else if(select.equals("2")) {
								view.ViewClass("classX","考試");
								break;
							}if(select.equals("3")) {
								view.ViewClass("classX","私人");
								break;
							}if(select.equals("4")) {
								view.ViewClass("classX","活動");
								break;
							}if(select.equals("5")) {
								view.ViewClass("classX","其他");
								break;
							}if(select.equals("6")) {
								select = input.nextLine();
								view.ViewClass("classX",select);
								break;
							}else {
								continue;
							}
						 }
						break;
					}else if(select.equals("3")){
						break;
					}else {
						continue;
					}
				}
				continue;
			//查詢資料
			}else if(select.equals("2")) {
				while(true) {
					out.println("請選擇如何選擇資料");
					out.print("(1 使用工作名子/");
					out.print("(2 使用開始時間/");
					out.print("(3 使用結束時間/");
					out.print("(4 使用完成百分比/");
					out.println("(5 使用工作狀態/");
					out.print("(6 使用工作編號/");
					out.print("(7 使用工作分類/");
					out.print("(8 使用工作內容/");
					out.print("(9 返回選單/");
					out.println("(10 退出程式");
					select = input.nextLine();
					//顯示全部
					if(select.equals("1")) {
						out.println("請輸入要搜尋的工作名子");
						select = input.nextLine();
						view.ViewClass("workName",select);
						break;
					}else if(select.equals("2")) {
						out.println("請輸入要搜尋的開始時間: ex,2017/06/06");
						select = input.nextLine();
						Scanner re = new Scanner(select).useDelimiter("/");
						int yy,mm,dd;
						yy = re.nextInt();
						mm = re.nextInt();
						dd = re.nextInt();
						DateX reDate = new DateX(mm,dd,yy);
						//判斷日期是否正確
						if(reDate.dateOK(mm,dd,yy)) {
							view.ViewClass("startDate",reDate.toString());
						}else {
							continue;
						}
						break;
					}else if(select.equals("3")) {
						out.println("請輸入要搜尋的結束時間: ex,2017/06/06");
						select = input.nextLine();
						Scanner re = new Scanner(select).useDelimiter("/");
						int yy,mm,dd;
						yy = re.nextInt();
						mm = re.nextInt();
						dd = re.nextInt();
						DateX reDate = new DateX(mm,dd,yy);
						//判斷日期是否正確
						if(reDate.dateOK(mm,dd,yy)) {
							view.ViewClass("endDate",reDate.toString());
						}else {
							continue;
						}

						break;
					}else if(select.equals("4")) {
						out.println("請輸入要搜尋的完成百分比");
						select = input.nextLine();
						view.ViewClass("percent",select);
						break;
					}else if(select.equals("5")) {
						out.println("請輸入要搜尋的完成狀態");
						select = input.nextLine();
						view.ViewClass("status",select);
						break;
					}else if(select.equals("6")) {
						out.println("請輸入要搜尋的工作編號");
						select = input.nextLine();
						view.ViewClass("Numbering",select);
						break;
					}else if(select.equals("7")) {
						out.println("請輸入要搜尋的工作分類");
						select = input.nextLine();
						view.ViewClass("classX",select);
						break;
					}else if(select.equals("8")) {
						out.println("請輸入要搜尋的工作內容");
						select = input.nextLine();
						view.ViewClass("work",select);
						break;
					}else if(select.equals("9")) {
						break;
					}else if(select.equals("10")) {
							System.exit(1);
					}else {
						out.println("請重新輸入");
						 continue;
					}
				}
				continue;
			//新增資料
			}else if(select.equals("3")) {
				 reHandlleData.addNewDate();
				 continue;
			}else if(select.equals("4")) {
				reHandlleData.updateDate();
				 continue;
			}else if(select.equals("5")) {
				out.println("(1 刪除單筆資料");
				out.println("(2 格式化全部資料");
				out.println("(3 返回");
				 select = input.nextLine();
				 if(select.equals("1")) {
					 	out.println("請輸入想刪除的編號");
					 	select = input.nextLine();
				 }else if(select.equals("2")) {
					 while(true) {
						 out.println("確定要格式化資料? Y/N");
						 select = input.nextLine();
						 if(select.equals("Y")) {
							 DataHere.clear();
							 break;
						 }else if(select.equals("N")) {
							 break;
						 }else {
							 continue;
						 }
					 }
				 }else if(select.equals("3")) {
					 continue;
				 }
			}else if(select.equals("6")) {
				Menu();
				input.close();
				return;
			}else if(select.equals("7")) {
				data.outputFile();
				System.exit(1);
			}else {
				 continue;
			}
		}
	}
	//次要選單
	public void Manager() {
		while(true) {
			out.println("請選擇接下來想執行的項目");
			out.println("(1 排序全部資料，後存入資料");
			out.println("(2 設定使用者排序是由大或小");
			out.println("(3 返回");
			out.println("(4 退出程式");
			String select = input.nextLine();
			//選資料顯示的模式
			if(select.equals("1")) {
					out.println("(1 由大到小");
					out.println("(2 由小到大");
					out.println("(3 返回");
					select = input.nextLine();
					if(select.equals("1")) {
						view.controlls=-1;
						view.SortWhat(select);
						data.outputFile();
						out.println("完成排序");
					}else if(select.equals("2")) {
						view.controlls=1;
						view.SortWhat(select);
						data.outputFile();
					}else if(select.equals("3")) {
						continue;
					}
			}
			else if(select.equals("2")) {
				out.println("(1 由大到小");
				out.println("(2 由小到大");
				out.println("(3 返回");
				select = input.nextLine();
				if(select.equals("1")) {
					view.controlls=-1;
				}else if(select.equals("2")) {
					view.controlls=1;
				}else if(select.equals("3")) {
					continue;
				}
			}else if(select.equals("3")) {
				return;
			}else if(select.equals("4")) {
				System.exit(1);
			}

		}
	}
}
