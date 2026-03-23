# Chapter 12 Java Collection 과제

> 각 문제는 **제네릭(Generics)과 2개 이상의 컬렉션 자료구조**를 함께 사용해야 합니다.

---

## 문제 1. 도서관 관리 시스템

### 요구사항

도서관에서 책을 관리하는 프로그램을 작성하시오.

**사용해야 할 자료구조**
- `ArrayList<Book>` — 도서 목록 저장
- `HashMap<String, ArrayList<Book>>` — 카테고리별 도서 분류

**클래스 설계**

```
Book
  - String title
  - String author
  - String category   // "소설", "과학", "역사" 등
  - int year

// 제네릭 컨테이너 클래스
Container<T>
  - T item
  - String label
  - T getItem()
  - String getLabel()
```

**구현 기능**

1. `Book` 객체를 `ArrayList<Book>`에 최소 6권 이상 추가한다.
2. 카테고리를 키로 사용하는 `HashMap<String, ArrayList<Book>>`에 분류한다.
3. `Container<Book>`을 사용하여 "이달의 추천 도서"를 하나 저장하고 출력한다.
4. 특정 카테고리("과학")의 도서 목록을 출력한다.
5. 전체 카테고리 목록(키 집합)을 출력한다.

**출력 예시**

```
=== 전체 등록 도서 ===
[소설] 채식주의자 (한강, 2007)
[과학] 코스모스 (칼 세이건, 1980)
[과학] 파인만의 물리학 강의 (리처드 파인만, 1963)
[역사] 총균쇠 (재레드 다이아몬드, 1997)
[소설] 1984 (조지 오웰, 1949)
[역사] 사피엔스 (유발 하라리, 2011)

=== 이달의 추천 도서 ===
[추천] 코스모스 (칼 세이건, 1980)

=== 카테고리: 과학 ===
코스모스 (칼 세이건, 1980)
파인만의 물리학 강의 (리처드 파인만, 1963)

=== 등록된 카테고리 ===
[소설, 과학, 역사]
```

---

## 문제 2. 학생 성적 분석기

### 요구사항

여러 학생의 성적을 입력받아 통계를 분석하는 프로그램을 작성하시오.

**사용해야 할 자료구조**
- `ArrayList<Student>` — 학생 목록 저장
- `TreeMap<Integer, String>` — 점수 오름차순으로 학생 정렬
- `HashSet<String>` — 중복 없이 수강 과목 목록 관리

**클래스 설계**

```
// 제네릭 통계 클래스
Statistics<T extends Number>
  - List<T> data
  - void add(T value)
  - double getAverage()
  - T getMax()
  - T getMin()

Student
  - String name
  - int score
  - String subject   // 수강 과목
```

**구현 기능**

1. `Student` 객체를 최소 7명 이상 생성하여 `ArrayList<Student>`에 추가한다.
2. `Statistics<Integer>`를 사용하여 전체 점수의 평균, 최고점, 최저점을 계산한다.
3. `TreeMap<Integer, String>`에 `(점수, 이름)` 으로 저장하여 점수 순 정렬 결과를 출력한다.
4. `HashSet<String>`으로 중복 없는 수강 과목 목록을 출력한다.
5. 평균 점수 이상인 학생 목록을 출력한다.

**출력 예시**

```
=== 학생 목록 ===
이름: 김민준, 과목: 자바프로그래밍, 점수: 88
이름: 박서연, 과목: 자료구조, 점수: 75
이름: 최지호, 과목: 자바프로그래밍, 점수: 92
이름: 정하은, 과목: 알고리즘, 점수: 63
이름: 이준서, 과목: 자료구조, 점수: 81
이름: 윤채원, 과목: 알고리즘, 점수: 97
이름: 강도윤, 과목: 자바프로그래밍, 점수: 70

=== 성적 통계 ===
평균: 80.86  최고: 97  최저: 63

=== 점수 오름차순 정렬 ===
63점 - 정하은
70점 - 강도윤
75점 - 박서연
81점 - 이준서
88점 - 김민준
92점 - 최지호
97점 - 윤채원

=== 수강 과목 목록 (중복 제거) ===
[알고리즘, 자료구조, 자바프로그래밍]

=== 평균 이상 학생 ===
김민준 (88), 최지호 (92), 이준서 (81), 윤채원 (97)
```

---

## 문제 3. 단어 빈도 분석기

### 요구사항

문장들의 목록을 입력받아 각 단어의 등장 횟수를 집계하고 분석하는 프로그램을 작성하시오.

**사용해야 할 자료구조**
- `ArrayList<String>` — 입력 문장 목록 저장
- `HashMap<String, Integer>` — 단어별 등장 횟수 저장
- `TreeSet<String>` — 알파벳 순으로 정렬된 고유 단어 집합

**클래스 설계**

```
// 제네릭 페어 클래스
Pair<K, V>
  - K key
  - V value
  - K getKey()
  - V getValue()
  - toString()  →  "key=value" 형태로 출력
```

**구현 기능**

1. 영어 문장 5개 이상을 `ArrayList<String>`에 저장한다.
2. 각 문장을 공백으로 분리하여 소문자로 변환 후 `HashMap<String, Integer>`에 단어 빈도를 집계한다.
   - 구두점(`.`, `,`, `!`, `?`)은 제거한다.
3. `TreeSet<String>`에 모든 고유 단어를 저장하여 알파벳 순으로 출력한다.
4. `Pair<String, Integer>`를 사용하여 가장 많이 등장한 단어를 저장하고 출력한다.
5. 등장 횟수가 2회 이상인 단어만 출력한다.

**출력 예시**

```
=== 입력 문장 목록 ===
1: Java is a powerful language
2: Java is widely used in enterprise
3: I love Java programming
4: Programming in Java is fun
5: Java language is object oriented

=== 알파벳 순 고유 단어 목록 (TreeSet) ===
[a, enterprise, fun, i, in, is, java, language, love, object, oriented, powerful, programming, used, widely]

=== 단어 빈도 (HashMap) ===
java=5, is=4, in=2, language=2, programming=2, a=1, ...

=== 가장 많이 등장한 단어 (Pair) ===
java = 5회

=== 2회 이상 등장한 단어 ===
java: 5회
is: 4회
in: 2회
language: 2회
programming: 2회
```

---

---

