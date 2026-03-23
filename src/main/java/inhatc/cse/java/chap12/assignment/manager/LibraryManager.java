package inhatc.cse.java.chap12.assignment.manager;

import inhatc.cse.java.chap12.assignment.item.LibraryItem;
import inhatc.cse.java.chap12.assignment.storage.Storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LibraryManager {

    // 문제 3-①: source의 모든 자료를 destination으로 이동 (source는 비워짐)
    // 힌트: makeRectangle2의 <T, V> 선언 구조 참고 (ex3/GenericMethod.java)
    public static <T extends LibraryItem>
    void transferItems(Storage<T> source, Storage<T> destination) {
        // TODO
    }

    // 문제 3-②: 가장 마지막에 추가된 자료 반환, 비어있으면 null 반환
    public static <T extends LibraryItem>
    T findMostRecent(Storage<T> storage) {
        // TODO
        return null;
    }

    // 문제 3-③: 제목에 keyword가 포함된 자료 수 반환
    public static <T extends LibraryItem>
    int countItems(Storage<T> storage, String keyword) {
        // TODO: getTitle()에 keyword가 포함(contains)된 자료 수를 반환
        return 0;
    }

    // 문제 4: 제목 첫 글자를 key로, 해당 자료 목록을 value로 하는 HashMap 반환
    public static <T extends LibraryItem>
    HashMap<String, List<T>> groupByFirstChar(Storage<T> storage) {
        // TODO: 각 자료의 getTitle().substring(0, 1)을 키로 분류
        //       힌트: map.computeIfAbsent(key, k -> new ArrayList<>()).add(item)
        return null;
    }
}
