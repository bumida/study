## Item 02: 생성자에 매개변수가 많다면 빌더를 고려하라

### 핵심 아이디어
- 생성자나 정적 팩터리에 인자가 많아지면 가독성이 떨어짐 → **빌더 패턴(Builder Pattern)**을 사용하라.

### 문제점
- **점층적 생성자 패턴 (Telescoping Constructor Pattern)**  
  ```java
  new NutritionFacts(240, 8, 100, 0.0, 35, 27);
  ```
  → 인자 수가 많으면 가독성, 유지보수성 최악.

- **자바빈즈 패턴 (JavaBeans Pattern)**  
  ```java
  NutritionFacts nf = new NutritionFacts();
  nf.setServingSize(240);
  nf.setServings(8);
  ```
  → 객체가 완전한 상태로 사용되기 전에 불변식 깨질 위험 있음.

### 해결책: 빌더 패턴
```java
NutritionFacts nf = new NutritionFacts.Builder(240, 8)
    .calories(100)
    .sodium(35)
    .carbohydrate(27)
    .build();
```

### 장점
- 파라미터가 많아도 **가독성** 좋음
- **불변 객체(immutable)** 생성 가능
- 필요한 매개변수만 선택적으로 설정 가능

### 단점
- 코드가 다소 장황해짐 (Builder 클래스 필요)
- 성능상 작은 오버헤드 존재