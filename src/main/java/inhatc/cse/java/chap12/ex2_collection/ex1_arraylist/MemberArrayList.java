package inhatc.cse.java.chap12.ex2_collection.ex1_arraylist;

import inhatc.cse.java.chap12.ex2_collection.Member;

import java.util.ArrayList;

public class MemberArrayList {
    
    private ArrayList<Member> arrayList;

    public MemberArrayList() {
        this.arrayList = new ArrayList<Member>();
    }

    public void addMember(Member member) {
        arrayList.add(member);
    }

    public boolean removeMember(int memberId) {
        
        for (int i = 0; i < arrayList.size(); i++) {
            Member member = arrayList.get(i);
            if (member.getMemberId() == memberId) {
                arrayList.remove(i);
                return true;
            }
        }

        // Iterator<Member> iter = arrayList.iterator();
        // while (iter.hasNext()) {
        //     Member member = iter.next();
        //     if (member.getMemberId() == memberId) {
        //         arrayList.remove(member);
        //         return true;
        //     }
        // }

        System.out.println(memberId + "가 존재하지 않습니다.");
        return false;
    }

    public void showAllMembers() {
        for (Member member : arrayList) {
            System.out.println(member);
        }
        System.out.println();
    }
}