# study

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        /**
         * 데일리 반복 연습
         */
        for (int i = 0; i < 10; i++){
            System.out.println(i);
        }
//       2) 향상된 for 문
         List<String> lists = new ArrayList<>();

        lists.add("1");
        lists.add("2");

        for(String list : lists){
            System.out.println(list);
        }

       int[] numbers = {1, 2, 3, 4, 5};

       for(int number : numbers){
           System.out.println(number);
       }


////        3) while 기본
//        int i = 0;
//        while (i < 5) {
//            System.out.println(i);
//            i++;
//        }


////        4) switch
//        int type = 3;
//
//        switch (type) {
//            case 1:
//                System.out.println("A");
//                break;
//            case 3:
//                System.out.println("B");
//                break;
//            default:
//                System.out.println("dd");
//        }


////✅ (B) 컬렉션(List/Map) 필수 패턴
////        5) List 추가/삭제
//
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.remove("a");
//       6) Map put/get/loop
//
//        Map<String, Integer> map = new HashMap<>();
//        map.put("kim", 10);
//        map.put("lee", 20);
//        map.put("park", 30);
//
//        for (Map.Entry<String, Integer> e : map.entrySet()) {
//            System.out.println(e.getKey() + ": " + e.getValue());
//        }
//        map.forEach((k, v) -> System.out.println(k + ":" + v));


////        7) computeIfAbsent (실무에서 정말 자주 씀)
//
//        map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
////✅ (C) Optional 실무 패턴
////        8) map + orElse
//
//        String name = Optional.ofNullable(user)
//                .map(User::getName)
//                .orElse("UNKNOWN");
////        9) orElseThrow
////
////        User u = repository.findById(id)
////                .orElseThrow(() -> new IllegalArgumentException("Not found"));
//✅ (D) Stream 실무 패턴
//        10) forEach문 예제
//        list.stream()
//                .forEach(System.out::println);
//        10) filter + map + toList
//        rust
//        코드 복사
//        List<String> res = list.stream()
//                .filter(s -> s.startsWith("a"))
//                .map(String::toUpperCase)
//                .toList();

//        11) sorted + reversed

//        python
//        코드 복사
//        List<User> sorted = users.stream()
//                .sorted(Comparator.comparing(User::getAge).reversed())
//                .toList();
//        12) groupBy + counting
//        vbnet
//        코드 복사
//        Map<String, Long> count = list.stream()
//                .collect(Collectors.groupingBy(Item::getType, Collectors.counting()));
//        13) flatMap
//                rust
//        코드 복사
//        List<String> tags = posts.stream()
//                .flatMap(p -> p.getTags().stream())
//                .toList();
//✅ (E) Exception 실무 패턴
//        14) 기본 try-catch
//        php
//        코드 복사
//        try {
//            run();
//        } catch (Exception e) {
//            throw new RuntimeException("실행 실패", e);
//        }
//        15) try-with-resources
//        java
//        코드 복사
//        try (FileWriter w = new FileWriter("a.txt")) {
//            w.write("hello");
//        }
//        2️⃣ SQL 기본기 루틴 (7분)
//        아래는 실무 개발자라면 타이핑이 자동으로 나와야 하는 문장 패턴이다.
//
//✅ (A) 기본 SELECT 패턴
//        1) 기본 SELECT
//        pgsql
//        코드 복사
//        SELECT id, name, created_at
//        FROM user
//        WHERE status = 'ACTIVE'
//        ORDER BY created_at DESC;
//        2) LIKE
//                pgsql
//        코드 복사
//        WHERE name LIKE '%coffee%';
//✅ (B) JOIN 핵심 패턴
//        3) INNER JOIN
//        pgsql
//        코드 복사
//        SELECT u.id, o.amount
//        FROM user u
//        JOIN orders o ON u.id = o.user_id;
//        4) LEFT JOIN (히스토리 붙일 때 자주 씀)
//        sql
//        코드 복사
//        SELECT c.id, h.use_date
//        FROM coupon c
//        LEFT JOIN coupon_hist h
//        ON c.id = h.coupon_id;
//✅ (C) GROUP BY / HAVING
//        5) count
//                pgsql
//        코드 복사
//        SELECT type, COUNT(*)
//        FROM coupon
//        GROUP BY type;
//        6) having 조건
//        sql
//        코드 복사
//        HAVING COUNT(*) >= 3;
//✅ (D) Window 함수 (실무 핵심)
//        7) ROW_NUMBER()
//        pgsql
//        코드 복사
//        ROW_NUMBER() OVER (PARTITION BY user_id ORDER BY created_at DESC)
//        8) RANK()
//        pgsql
//        코드 복사
//        RANK() OVER (ORDER BY score DESC)
//        9) DENSE_RANK()
//        pgsql
//        코드 복사
//        DENSE_RANK() OVER (ORDER BY score DESC)
//        10) LAG()
//“이전 값 가져오기”
//
//        pgsql
//        코드 복사
//        LAG(amount) OVER (ORDER BY created_at)
//        11) LEAD()
//“다음 값 가져오기”
//
//        pgsql
//        코드 복사
//        LEAD(amount) OVER (ORDER BY created_at)
//        12) SUM() OVER
//“누적합”
//
//        pgsql
//        코드 복사
//        SUM(amount) OVER (ORDER BY created_at)
//        13) AVG() OVER
//                pgsql
//        코드 복사
//        AVG(price) OVER (PARTITION BY category)
//✅ (E) SUBQUERY
//        14) IN
//                sql
//        코드 복사
//        WHERE id IN (SELECT user_id FROM coupon WHERE status = 'USED')
//        15) EXISTS
//                sql
//        코드 복사
//        WHERE EXISTS (SELECT 1 FROM orders o WHERE o.user_id = u.id)
//✅ (F) 날짜/페이징
//        16) 최근 n일
//        sql
//        코드 복사
//        WHERE created_at >= DATE_SUB(NOW(), INTERVAL 7 DAY)
//        17) LIMIT + OFFSET
//        pgsql
//        코드 복사
//        LIMIT 20 OFFSET 40



//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }
//        2) 향상된 for
//        scss
//        코드 복사
//        for (String s : list) {
//            System.out.println(s);
//        }
//        3) while
//        cpp
//        코드 복사
//        int i = 0;
//        while (i < 5) {
//            i++;
//        }
//        4) switch 문
//                csharp
//        코드 복사
//        switch (status) {
//            case "A":
//                System.out.println("Active");
//                break;
//            case "U":
//                System.out.println("Used");
//                break;
//            default:
//                System.out.println("Unknown");
//        }
//        5) continue / break
//                kotlin
//        코드 복사
//        for (int i = 1; i <= 10; i++) {
//            if (i == 5) continue;
//            if (i == 8) break;
//            System.out.println(i);
//        }
//🔥 B. List / Map / Collection 패턴 (7개)
//        6) removeIf (요청한 내용)
//        less
//        코드 복사
//        list.removeIf(s -> s.startsWith("A"));
//        실무에서 “조건에 맞는 요소 삭제”는 100% 이걸로 한다.
//
//        7) computeIfAbsent
//                arduino
//        코드 복사
//        map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
//        8) toMap
//                rust
//        코드 복사
//        Map<Long, String> map = users.stream()
//                .collect(Collectors.toMap(User::getId, User::getName));
//        9) list 정렬
//        less
//        코드 복사
//        list.sort(Comparator.naturalOrder());
//        10) list 뒤집기
//        lua
//        코드 복사
//        Collections.reverse(list);
//        11) list → set
//                vbnet
//        코드 복사
//        Set<String> set = new HashSet<>(list);
//        12) set → list
//                arduino
//        코드 복사
//        List<String> newList = new ArrayList<>(set);
//🔥 C. Stream (핵심 5개)
//        13) filter + map
//        rust
//        코드 복사
//        var result = list.stream()
//                .filter(s -> s.length() > 2)
//                .map(String::toUpperCase)
//                .toList();
//        14) groupBy + counting
//        arduino
//        코드 복사
//        var map = list.stream()
//                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
//        15) flatMap
//                csharp
//        코드 복사
//        var flat = list.stream()
//                .flatMap(l -> l.stream())
//                .toList();
//        16) sorted + comparator
//        python
//        코드 복사
//        var sorted = list.stream()
//                .sorted(Comparator.comparing(String::length).reversed())
//                .toList();
//        17) findFirst
//                csharp
//        코드 복사
//        var item = list.stream()
//                .filter(s -> s.contains("A"))
//                .findFirst()
//                .orElse(null);
//🔥 D. Optional 패턴 (3개)
//        18)
//        vbnet
//        코드 복사
//        String name = Optional.ofNullable(user)
//                .map(User::getName)
//                .orElse("UNKNOWN");
//        19)
//        sql
//        코드 복사
//        User user = repo.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Not found"));
//        20)
//        scss
//        코드 복사
//        Optional.ofNullable(value).ifPresent(System.out::println);
//🟧 2. SQL 데일리 루틴 — 실무 자주 쓰는 핵심 20개
//🔥 A. SELECT + WHERE + ORDER (4개)
//        1)
//        pgsql
//        코드 복사
//        SELECT id, name
//        FROM user
//        WHERE status = 'A'
//        ORDER BY created_at DESC;
//        2)
//        pgsql
//        코드 복사
//        SELECT *
//                FROM product
//        WHERE name LIKE '%coffee%';
//        3)
//        sql
//        코드 복사
//        SELECT *
//                FROM table
//        WHERE updated_at >= DATE_SUB(NOW(), INTERVAL 7 DAY);
//        4)
//        pgsql
//        코드 복사
//        SELECT *
//                FROM table
//        LIMIT 20 OFFSET 40;
//🔥 B. JOIN (3개)
//        5)
//        pgsql
//        코드 복사
//        SELECT u.id, o.amount
//        FROM user u
//        JOIN orders o ON u.id = o.user_id;
//        6)
//        sql
//        코드 복사
//        SELECT c.id, h.use_date
//        FROM coupon c
//        LEFT JOIN coupon_hist h
//        ON c.id = h.coupon_id
//        AND h.rn = 1;
//        7)
//        pgsql
//        코드 복사
//        SELECT u.id, p.point
//        FROM user u
//        LEFT JOIN point p ON u.id = p.user_id;
//🔥 C. GROUP BY (3개)
//        8)
//        pgsql
//        코드 복사
//        SELECT type, COUNT(*)
//        FROM coupon
//        GROUP BY type;
//        9)
//        pgsql
//        코드 복사
//        SELECT user_id, SUM(amount)
//                FROM payment
//        GROUP BY user_id;
//        10)
//        pgsql
//        코드 복사
//        SELECT coupon_type, COUNT(*)
//        FROM coupon
//        GROUP BY coupon_type
//        HAVING COUNT(*) >= 3;
//🔥 D. Window 함수 — 확장 버전 (6개)
//        11) ROW_NUMBER
//                pgsql
//        코드 복사
//        ROW_NUMBER() OVER (PARTITION BY user_id ORDER BY created_at DESC)
//        12) RANK
//                pgsql
//        코드 복사
//        RANK() OVER (ORDER BY total_score DESC)
//        13) DENSE_RANK
//                pgsql
//        코드 복사
//        DENSE_RANK() OVER (ORDER BY sales DESC)
//        14) LAG
//                pgsql
//        코드 복사
//        LAG(amount, 1, 0) OVER (ORDER BY id) AS prev_amount
//        15) LEAD
//                pgsql
//        코드 복사
//        LEAD(amount, 1, 0) OVER (ORDER BY id) AS next_amount
//        16) SUM OVER (누적합)
//                pgsql
//        코드 복사
//        SUM(amount) OVER (ORDER BY created_at) AS cumulative_amount
//🔥 E. SUBQUERY (2개)
//        17)
//        sql
//        코드 복사
//        SELECT *
//                FROM user
//        WHERE id IN (SELECT user_id FROM orders WHERE amount > 10000);
//        18)
//        sql
//        코드 복사
//        SELECT *
//                FROM user u
//        WHERE EXISTS (SELECT 1 FROM coupon c WHERE c.user_id = u.id);
//🔥 F. 날짜 (2개)
//        19)
//        sql
//        코드 복사
//        WHERE created_at BETWEEN :start AND :end
//        20)
//        sql
//        코드 복사
//        WHERE created_at >= DATE_SUB(NOW(), INTERVAL 3 MONTH)
//🟩 3. 핵심 데일리 루틴 요약 (10~15분)
//🔥 Java (5~7분)
//        for (기본/향상된)
//
//            switch
//
//        removeIf
//
//        List → Map / Map → List
//
//        sort / reverse
//
//        stream: filter + map + sorted
//
//        groupBy + counting
//
//        flatMap
//
//        Optional 패턴 3종
//
//🔥 SQL (5~7분)
//        기본 SELECT 패턴
//
//        INNER JOIN + LEFT JOIN
//
//        GROUP BY + HAVING
//
//        날짜 INTERVAL
//
//        SUBQUERY (IN, EXISTS)
//
//        WINDOW 함수 6종
//
//                ROW_NUMBER
//
//        RANK
//
//                DENSE_RANK
//
//        LAG
//
//                LEAD
//
//        SUM OVER
//
//🟨 4. removeIf 타이핑 연습 세트만 따로 (추가)
//        실무에서 removeIf를 가장 많이 쓰는 패턴 3개.
//
//        1) 문자열 조건
//        less
//        코드 복사
//        list.removeIf(s -> s.startsWith("A"));
//        2) 객체 조건
//        less
//        코드 복사
//        users.removeIf(u -> u.getAge() < 18);
//        3) 널값 제거
//        css
//        코드 복사
//        list.removeIf(Objects::isNull);


//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }
//        2) 역순
//                pgsql
//        코드 복사
//        for (int i = 10; i >= 0; i--) {
//            System.out.println(i);
//        }
//        3) 이중 for (구구단)
//            pgsql
//        코드 복사
//        for (int i = 2; i <= 9; i++) {
//            for (int j = 1; j <= 9; j++) {
//                System.out.println(i + " x " + j + " = " + i*j);
//            }
//        }
//✅ B. switch 문 연습 (자바17 패턴 포함)
//        1) 기본 switch
//        csharp
//        코드 복사
//        switch (grade) {
//            case "A": System.out.println("Excellent"); break;
//            case "B": System.out.println("Good"); break;
//            default: System.out.println("Try again");
//        }
//        2) switch → 결과 반환
//        arduino
//        코드 복사
//        String result = switch (status) {
//            case "Y" -> "ACTIVE";
//            case "N" -> "INACTIVE";
//            default -> "UNKNOWN";
//        };
//✅ C. removeIf (실무에서 진짜 많이 씀)
//        removeIf 기본
//        mathematica
//        코드 복사
//        List<String> list = new ArrayList<>(List.of("a", "bb", "ccc"));
//
//        list.removeIf(s -> s.length() == 1);
//        실무 스타일
//        less
//        코드 복사
//        users.removeIf(u -> u.getStatus().equals("DELETED"));
//✅ D. Lambda 기본 패턴 (매일 타이핑)
//        1) Runnable
//                pgsql
//        코드 복사
//        Runnable r = () -> System.out.println("hello");
//        2) Comparator
//                css
//        코드 복사
//        list.sort((a, b) -> a.length() - b.length());
//        3) 람다 + map
//        mathematica
//        코드 복사
//        List<Integer> lengths = list.stream()
//                .map(s -> s.length())
//                .toList();
//        4) 람다 + filter
//        rust
//        코드 복사
//        List<String> filtered = list.stream()
//                .filter(s -> s.startsWith("a"))
//                .toList();
//        5) Function 정의
//        vbnet
//        코드 복사
//        Function<String, Integer> func = s -> s.length();
//✅ E. 자바 실무패턴 (Stream 외 필수 패턴)
//        1) computeIfAbsent
//                arduino
//        코드 복사
//        map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
//        2) Optional 기본 + orElse
//        vbnet
//        코드 복사
//        String name = Optional.ofNullable(user)
//                .map(User::getName)
//                .orElse("UNKNOWN");
//        3) Optional + orElseThrow
//        sql
//        코드 복사
//        User user = repository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Not found"));
//        4) List → Map
//                rust
//        코드 복사
//        Map<Long, String> map = users.stream()
//                .collect(Collectors.toMap(User::getId, User::getName));
//        5) List 필터링 (removeIf 없이)
//        sql
//        코드 복사
//        List<User> filtered = users.stream()
//                .filter(u -> u.getAge() >= 20)
//                .toList();
//🟧 2. SQL 기본기 데일리 루틴
//✅ A. 기본 SELECT / WHERE
//                pgsql
//        코드 복사
//        SELECT id, name
//        FROM user
//        WHERE status = 'ACTIVE'
//        ORDER BY created_at DESC;
//✅ B. JOIN 패턴 (매일 무조건)
//        INNER JOIN
//        pgsql
//        코드 복사
//        SELECT u.id, o.amount
//        FROM user u
//        JOIN orders o ON u.id = o.user_id;
//        LEFT JOIN
//        sql
//        코드 복사
//        SELECT c.id, h.use_date
//        FROM coupon c
//        LEFT JOIN coupon_hist h
//        ON c.id = h.coupon_id;
//✅ C. GROUP BY / HAVING
//                pgsql
//        코드 복사
//        SELECT user_id, COUNT(*)
//        FROM orders
//        GROUP BY user_id
//        HAVING COUNT(*) >= 3;
//✅ D. 서브쿼리 패턴
//        IN
//                sql
//        코드 복사
//        SELECT *
//                FROM user
//        WHERE id IN (
//                SELECT user_id
//                FROM orders
//                WHERE amount > 10000
//        );
//        EXISTS
//                sql
//        코드 복사
//        SELECT u.*
//        FROM user u
//        WHERE EXISTS (
//                SELECT 1
//        FROM orders o
//        WHERE o.user_id = u.id
//);
//🟥 E. Window 함수 (핵심만 정리)
//        1) row_number()
//        pgsql
//        코드 복사
//        ROW_NUMBER() OVER(PARTITION BY coupon_id ORDER BY hist_id DESC)
//        2) rank()
//        pgsql
//        코드 복사
//        RANK() OVER(ORDER BY score DESC)
//        3) dense_rank()
//        pgsql
//        코드 복사
//        DENSE_RANK() OVER(ORDER BY score DESC)
//        4) sum() over window
//        pgsql
//        코드 복사
//        SUM(amount) OVER(PARTITION BY user_id ORDER BY created_at)
//        5) average over window
//                pgsql
//        코드 복사
//        AVG(score) OVER(PARTITION BY class)
//        6) moving average (frame)
//                pgsql
//        코드 복사
//        AVG(amount) OVER (
//                ORDER BY created_at
//                ROWS BETWEEN 2 PRECEDING AND CURRENT ROW
//        )
//        7) cumulative sum
//        pgsql
//        코드 복사
//        SUM(amount) OVER (ORDER BY created_at)
//🟩 F. 실무 날짜 처리
//                sql
//        코드 복사
//        WHERE created_at >= DATE_SUB(NOW(), INTERVAL 7 DAY)
//🟦 G. 정렬 + 페이징
//        pgsql
//        코드 복사
//        SELECT *
//                FROM coupon
//        ORDER BY updated_at DESC
//        LIMIT 20 OFFSET 40;
//🟪 3. 실무 감각 데일리 챌린지(5문제)
//        매일 아래 5개 중 아무거나 보고 바로 닫고 → 타이핑하기.
//
//🧩 1) List에서 특정 조건 removeIf
//        less
//        코드 복사
//        list.removeIf(s -> s.contains("test"));
//🧩 2) Map에 List append하기
//                arduino
//        코드 복사
//        map.computeIfAbsent(id, k -> new ArrayList<>()).add(value);
//🧩 3) stream groupBy counting
//                vbnet
//        코드 복사
//        Map<String, Long> m = list.stream()
//                .collect(Collectors.groupingBy(Item::getType, Collectors.counting()));
//🧩 4) 최신 히스토리 뽑는 window쿼리
//        pgsql
//        코드 복사
//        ROW_NUMBER() OVER(PARTITION BY coupon_id ORDER BY hist_id DESC) AS rn
//🧩 5) LEFT JOIN + 최신 이력만
//                pgsql
//        코드 복사
//        SELECT *
//                FROM coupon c
//        LEFT JOIN (
//                SELECT *, ROW_NUMBER() OVER(PARTITION BY coupon_id ORDER BY hist_id DESC) AS rn
//        FROM coupon_hist
//) h ON c.id = h.coupon_id AND h.rn = 1;


//🟦 1. 자바 기본기 실무 타이핑 세트 (새로운 것만)
//✅ 1) Comparator / 정렬 (Stream 제외)
//        기본 Comparator
//        list.sort(Comparator.comparing(User::getAge));
//
//        역순
//        list.sort(Comparator.comparing(User::getAge).reversed());
//
//        복합 정렬
//        list.sort(Comparator
//                .comparing(User::getAge)
//                .thenComparing(User::getName)
//        );
//
//✅ 2) Arrays 관련 실무 패턴
//        배열 정렬
//        int[] arr = {3, 1, 2};
//        Arrays.sort(arr);
//
//        배열 → 문자열
//        String str = Arrays.toString(arr);
//
//        배열 → 리스트
//        List<String> list = Arrays.asList("a", "b", "c");
//
//✅ 3) String 실무 패턴
//        문자열 합치기
//        String result = String.join(",", "A", "B", "C");
//
//        문자열 분리
//        String[] parts = "a,b,c".split(",");
//
//        공백 제거
//        String clean = str.trim();
//
//        숫자인지 확인
//        boolean isNum = str.matches("\\d+");
//
//✅ 4) Random 실무 패턴
//        int r = new Random().nextInt(100);  // 0~99
//
//✅ 5) Collections 기본기
//        리스트 복사
//        List<String> copy = new ArrayList<>(original);
//
//        값 존재 여부
//        if (list.contains("A")) { ... }
//
//        인덱스 접근
//        String item = list.get(0);
//
//✅ 6) removeIf (너가 요청한 새로운 타자연습)
//        list.removeIf(s -> s.length() < 3);
//
//✅ 7) 람다 (Stream 제외)
//        Runnable 람다
//        Runnable r = () -> System.out.println("run!");
//        r.run();
//
//        Comparator 람다
//        list.sort((a, b) -> a.getAge() - b.getAge());
//
//        Function 람다
//        Function<String, Integer> f = s -> s.length();
//        int len = f.apply("hello");
//
//✅ 8) for문 패턴 (Stream 제외)
//        기본 for
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }
//
//        향상된 for
//        for (String s : list) {
//            System.out.println(s);
//        }
//
//        인덱스로 순회
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//
//✅ 9) switch 패턴
//        기본 switch
//        switch (type) {
//            case "A": result = 1; break;
//            case "B": result = 2; break;
//            default: result = 0;
//        }
//
//        switch → 반환하기 (Java 14+)
//        int score = switch (grade) {
//            case "A" -> 100;
//            case "B" -> 80;
//            default -> 60;
//        };
//
//🟧 2. SQL 기본기 실무 타이핑 세트 (새로운 것만)
//✅ 1) CASE WHEN
//        SELECT
//                user_id,
//        CASE WHEN status = 'U' THEN 'USED'
//        WHEN status = 'A' THEN 'ACTIVE'
//        ELSE 'OTHER'
//        END AS status_text
//        FROM coupon;
//
//✅ 2) BETWEEN 사용
//        WHERE created_at BETWEEN '2024-01-01' AND '2024-01-31'
//
//✅ 3) 그 외 기본 함수 패턴
//                LENGTH
//        SELECT LENGTH(name) FROM user;
//
//        UPPER / LOWER
//        SELECT UPPER(name) FROM user;
//
//        CONCAT
//        SELECT CONCAT(first_name, ' ', last_name) FROM user;
//
//✅ 4) SUBSTRING
//        SELECT SUBSTRING(code, 1, 3) FROM product;
//
//✅ 5) COALESCE (널일 때 기본값)
//        SELECT COALESCE(nickname, 'UNKNOWN') FROM user;
//
//✅ 6) DISTINCT
//        SELECT DISTINCT type FROM coupon;
//
//✅ 7) ORDER BY 여러 조건
//        ORDER BY created_at DESC, id ASC
//
//🟥 3. Window 함수 (새로운 것만)
//
//        기존에 준 row_number(), rank() 제외하고 추가.
//
//⭐ 1) DENSE_RANK()
//
//        순위를 건너뛰지 않음.
//
//                SELECT user_id,
//        DENSE_RANK() OVER (ORDER BY score DESC) AS rnk
//        FROM user_score;
//
//⭐ 2) LEAD() / LAG()
//
//        이전/다음 행 값 가져오기.
//
//                SELECT
//                id,
//                created_at,
//        LAG(created_at, 1) OVER (ORDER BY created_at) AS prev_time
//        FROM logs;
//
//⭐ 3) FIRST_VALUE() / LAST_VALUE()
//        SELECT
//                user_id,
//        FIRST_VALUE(amount) OVER (ORDER BY created_at) AS first_pay
//        FROM payment;
//
//⭐ 4) NTILE(n)
//
//        n등분하여 그룹 나누기
//
//                SELECT
//        user_id,
//                NTILE(4) OVER (ORDER BY score DESC) AS quartile
//        FROM ranking;



//        int n = 1260;
//        int cnt = 0;
//        int[] coinTypes = {500, 100, 50, 10};
//
//        for (int i = 0; i < 4; i++) {
//            int coin = coinTypes[i];
//            cnt += n / coin;
//            n %= coin;
//        }
//
//        System.out.println(cnt);
//    }

        //자바 reduce 함수도 알아야함
    }
}
