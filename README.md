# walkie-paw

반려동물은 단순한 가족 구성원 이상의 의미를 지닙니다. 그러나 바쁜 생활 패턴으로 인해 반려견 산책은 종종 소홀히 되기 쉽습니다. WalkiePaw는 반려견 산책 전문 서비스를 제공하여 이 문제를 해결하고자 합니다.

WalkiePaw를 통해 견주들은 신뢰할 수 있는 산책인을 쉽게 찾을 수 있습니다. 위치기반 매칭 시스템을 활용하여 가까운 곳에서 활동 중인 산책인 검색을 검색할 수도 있습니다. 채팅을 통해 산책인과 직접 대화하며 자세한 사항을 조율해 보세요.

또한 산책인 프로필과 평가 시스템을 갖추고 있어, 견주들이 안심하고 산책인을 선택할 수 있습니다. 산책 후에는 간편한 결제 프로세스를 거치면 됩니다.

WalkiePaw를 통해 반려견 산책은 더 이상 부담이 되지 않을 것입니다. 반려견과 가족 모두가 행복해질 수 있는 기회를 만들어보세요!

### 프로젝트 개요: WalkiePaw

#### 프로젝트 설명
WalkiePaw는 반려동물 산책 서비스를 제공하는 웹 애플리케이션입니다. 반려동물 주인과 전문 산책사를 연결하여 일정 관리, 추적, 결제 서비스를 제공합니다.

#### 주요 기능
1. **사용자 등록 및 인증:**
   - 반려동물 주인 및 산책사 계정 생성 및 관리
   - 안전한 인증 시스템

2. **프로필 관리:**
   - 사용자 프로필 및 반려동물 정보 관리
   - 산책사 서비스, 가능 시간, 요금 목록

3. **예약 시스템:**
   - 반려동물 산책 예약
   - 일정 관리 통합

4. **추적 및 알림:**
   - 실시간 산책 추적
   - 반려동물 주인과 산책사에게 알림 제공

5. **결제 시스템:**
   - 안전한 결제 게이트웨이
   - 거래 내역 및 인보이스

6. **리뷰 및 평가:**
   - 산책사에 대한 리뷰 및 평가 제공
   - 서비스 품질 유지 피드백 시스템

#### 기술 스택
- **백엔드:** Spring Boot
- **ORM:** JPA (Java Persistence API)
- **프론트엔드:** [Figma 디자인에 따라 React.js 또는 Angular]
- **데이터베이스:** [MySQL, PostgreSQL, H2 중 하나]

### 데이터베이스 스키마 (ERD 기반)

#### 엔티티 및 관계
1. **User (사용자)**
   - `id` (PK)
   - `username`
   - `password`
   - `email`
   - `role` (반려동물 주인, 산책사)
   - `created_at`
   - `updated_at`

2. **Profile (프로필)**
   - `id` (PK)
   - `user_id` (FK)
   - `first_name`
   - `last_name`
   - `phone_number`
   - `address`
   - `bio`
   - `created_at`
   - `updated_at`

3. **Pet (반려동물)**
   - `id` (PK)
   - `owner_id` (FK, User 참조)
   - `name`
   - `breed`
   - `age`
   - `created_at`
   - `updated_at`

4. **Walk (산책)**
   - `id` (PK)
   - `pet_id` (FK)
   - `walker_id` (FK, User 참조)
   - `scheduled_time`
   - `duration`
   - `status` (예정, 진행 중, 완료)
   - `created_at`
   - `updated_at`

5. **Payment (결제)**
   - `id` (PK)
   - `walk_id` (FK)
   - `amount`
   - `status` (대기 중, 완료, 실패)
   - `created_at`
   - `updated_at`

6. **Review (리뷰)**
   - `id` (PK)
   - `walk_id` (FK)
   - `rating`
   - `comment`
   - `created_at`
   - `updated_at`

### 구현 계획
1. **Spring Boot 프로젝트 설정**
   - 필요한 종속성으로 Spring Boot 프로젝트 초기화
   - 데이터베이스 연결 구성

2. **JPA 엔티티 생성**
   - 데이터베이스 스키마에 해당하는 JPA 엔티티 정의
   - JPA 어노테이션을 사용해 엔티티 간 관계 설정

3. **레포지토리 레이어 개발**
   - 엔티티에 대한 CRUD 작업을 위한 레포지토리 생성

4. **서비스 레이어 구현**
   - 비즈니스 로직을 위한 서비스 개발
   - 트랜잭션 무결성 보장 및 예외 처리

5. **REST 컨트롤러 빌드**
   - 프론트엔드 상호작용을 위한 엔드포인트 공개
   - 인증 및 권한 부여 구현

6. **프론트엔드 통합**
   - 프론트엔드와 백엔드 서비스 연결
   - WebSockets 등을 사용한 실시간 업데이트 및 알림 보장

7. **테스트 및 배포**
   - 단위 및 통합 테스트 작성
   - 클라우드 제공자 또는 온프레미스 서버에 애플리케이션 배포

이 프로젝트 개요는 WalkiePaw 애플리케이션의 주요 측면을 다루며, 상세한 Figma 디자인 및 ERD 세부 사항에 따라 조정이 필요할 수 있습니다.
