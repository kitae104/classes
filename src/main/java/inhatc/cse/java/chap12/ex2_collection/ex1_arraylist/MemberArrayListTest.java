package inhatc.cse.java.chap12.ex2_collection.ex1_arraylist;

import inhatc.cse.java.chap12.ex2_collection.Member;

public class MemberArrayListTest {
    public static void main(String[] args) {
        
        MemberArrayList memberArrayList = new MemberArrayList();
		
		Member memberLee = new Member(1001, "이지원");
		Member memberSon = new Member(1002, "손민국");
		Member memberPark = new Member(1003,"박서훤");
		Member memberHong = new Member(1004, "홍길동");

        memberArrayList.addMember(memberLee);
		memberArrayList.addMember(memberSon);
		memberArrayList.addMember(memberPark);
		memberArrayList.addMember(memberHong);

        memberArrayList.showAllMembers();

        memberArrayList.removeMember(memberHong.getMemberId());
        memberArrayList.showAllMembers();
    }
}
