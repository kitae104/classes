package inhatc.cse.java.chap12.assignment.storage;

import inhatc.cse.java.chap12.assignment.item.LibraryItem;
import java.util.ArrayList;

// TODO: T가 LibraryItem의 하위 타입만 허용하도록 제네릭 선언을 완성하세요
//       힌트: GenericPrinter<T extends Material> 구조를 참고 (ex2_extends)
public class Storage<T> {

    // TODO: ArrayList<T> 필드를 선언하세요

    public Storage() {
        // TODO: ArrayList 초기화
    }

    // 자료 추가
    public void addItem(T item) {
        // TODO
    }

    // ID로 자료 제거, 성공 시 true 반환
    public boolean removeItem(String itemId) {
        // TODO: for 반복문으로 itemId가 일치하는 자료를 제거 후 true 반환
        //       힌트: MemberArrayList.removeMember() 구조 참고
        return false;
    }

    // ID로 자료 검색, 없으면 null 반환
    public T findItem(String itemId) {
        // TODO
        return null;
    }

    // 전체 자료 출력 (displayInfo() 호출)
    public void showAll() {
        // TODO: T extends LibraryItem이므로 displayInfo()를 직접 호출할 수 있습니다
    }

    // 저장된 자료 수 반환
    public int getCount() {
        // TODO
        return 0;
    }

    // 내부 리스트 반환 (LibraryManager의 제네릭 메서드에서 사용)
    public ArrayList<T> getItems() {
        // TODO
        return null;
    }
}
