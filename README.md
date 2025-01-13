# 프로젝트 진행 과정


### 📂 **1. 개인 서버 구축**
- 프로젝트 배포를 위한 서버 환경 준비 및 구성


### 🐳 **2. Docker 설치 및 프로젝트 배포 테스트**
- 서버 내 Docker 설치 완료  
- 프로젝트 컨테이너화 및 초기 배포 테스트


### 🌐 **3. 외부 접속 확인**
- 외부 네트워크에서 배포된 프로젝트 정상 접속 확인  


### 🔑 **4. [Easy Deploy] 로그인 / 로그아웃 기능 구현**
- 사용자 인증을 위한 `Users` 테이블 생성  
- 로그인 및 로그아웃 기능 개발 완료

- Users 테이블 구조
  
| **컬럼명**            | **데이터 타입** | **설명**               |
|-----------------------|----------------|------------------------|
| `user_name`           | VARCHAR        | 사용자 이름            |
| `user_id`             | VARCHAR        | 사용자 ID (고유값)     |
| `user_pw`             | VARCHAR        | 사용자 비밀번호        |
| `user_dockerfile`     | FILE           | Dockerfile 업로드      |
| `user_docker_compose` | FILE           | Docker Compose 파일    |
| `project_name`        | VARCHAR        | 프로젝트 이름          |
| `project_description` | TEXT           | 프로젝트 설명          |
| `project_upload_date` | DATETIME       | 프로젝트 업로드 날짜   |
| `project_tag`         | VARCHAR        | 프로젝트 태그          |
| `project_download_count` | INT        | 프로젝트 다운로드 수   |
| `project_storage`     | VARCHAR        | 프로젝트 저장 경로     |

### **테이블 예시**
```sql
CREATE TABLE Users (
    user_name VARCHAR(50) NOT NULL,
    user_id VARCHAR(50) PRIMARY KEY,
    user_pw VARCHAR(255) NOT NULL,
    user_dockerfile BLOB,
    user_docker_compose BLOB,
    project_name VARCHAR(100) NOT NULL,
    project_description TEXT,
    project_upload_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    project_tag VARCHAR(255),
    project_download_count INT DEFAULT 0,
    project_storage VARCHAR(255)
);



### 📁 **5. [Easy Deploy] 파일더 업로드 구현**
- 사용자가 프로젝트 폴더 내 dockerfile과 docker compose 파일을 업로드 가능하도록 구현  
- 업로드된 프로젝트는 `Users` 테이블에 등록된 파일 컬럼과 연동


### ⚙️ **6. [Easy Deploy] Docker 위에서 프로젝트 빌드 및 실행**
- 업로드된 프로젝트를 Docker 컨테이너 위에서 자동 빌드 및 실행 처리


### ✅ **7. 외부 접속 확인**
- 업로드 및 배포 완료된 프로젝트의 외부 접속 테스트 성공


### 🎨 **8. 웹 사이트 마무리**
- 웹 사이트의 디자인, 사용자 경험(UX) 최적화 및 세부 사항 조정  
- 전체 프로젝트를 점검하고 배포 준비 완료  
