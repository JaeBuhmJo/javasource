package register;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberUi {

	public static void main(String[] args) {

		boolean isStop = false;
		Scanner sc = new Scanner(System.in);

		MemberConsoleUtil util = new MemberConsoleUtil();
		ArrayList<Member> list = new ArrayList<>(); // 회원 정보 추가

		// 선언
		Member member = null;

		do {
			System.out.println("========회원관리 프로그램=========");
			System.out.println("1.회원등록");
			System.out.println("2.회원 목록 보기");
			System.out.println("3.회원 정보 수정");
			System.out.println("4.회원 정보 삭제");
			System.out.println("5.프로그램 종료");
			System.out.println("==============================");

			System.out.print("메뉴 번호 >> ");
			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1:
				member = util.getNewmember(sc);
				list.add(member);
				util.printAddSuccessMessage(member);
				break;
			case 2:
				util.printMemberList(list);
				break;
			case 3:
				member = util.updateMember(sc,list);
				if(member!=null) {
					util.printUpdateSuccessMessage(member);
				}else {
					util.printUpdateFailMessage();
				}
				break;
			case 4:
				member = util.removeMember(sc,list);
				if(member!=null) {
					util.printRemoveSuccessMessage(member);
				}else {
					util.printRemoveFailMessage();
				}
				
				break;
			case 5:
				isStop = true;
				break;
			default:

				break;
			}

		} while (!isStop);

	}

}
