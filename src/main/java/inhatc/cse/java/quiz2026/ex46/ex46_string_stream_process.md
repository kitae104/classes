# 2026년도 46번 - Stream 문자열 스트림 처리

문자열 문장을 단어로 분리하여 단어 길이별로 그룹화하고, 각 그룹에서 길이 기준 정렬하세요.

## 데이터
```
"The quick brown fox jumps over the lazy dog"
```

## 요구사항
- `split()`으로 단어 분리
- `Arrays.stream()` 또는 `flatMap()` 사용
- `groupingBy(String::length)` 로 길이별 그룹화
- 각 그룹 내 단어 알파벳순 정렬
- 결과 출력

## 난이도: 상


