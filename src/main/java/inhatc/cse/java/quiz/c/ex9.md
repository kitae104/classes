# C반 Ex9 - Optional 중첩 처리

`User(name, Address)` 구조에서 사용자 이름으로 우편번호를 조회하세요.

## 데이터
- ("Kim", "11111")
- ("Lee", null)
- ("Park", "33333")

## 요구사항
- 반환 타입: `Optional<String>`
- 없으면 `orElse("NO_ZIP")`
