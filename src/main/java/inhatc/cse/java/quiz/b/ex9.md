# B반 Ex9 - Optional 파싱

`parsePositiveInt(String input)` 메서드를 작성하세요.

## 요구사항
1. 양의 정수면 `Optional.of(value)`
2. 0 이하, 숫자 아님, null이면 `Optional.empty()`
3. 테스트 입력: `["10", "0", "-3", "abc", null, " 7 "]`
