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
  

### 📁 **5. [Easy Deploy] 파일 업로드 구현**
- 사용자가 프로젝트 폴더 내 dockerfile과 docker compose 파일을 업로드 가능하도록 구현  
- 업로드된 프로젝트는 `Users` 테이블에 등록된 파일 컬럼과 연동


### ⚙️ **6. [Easy Deploy] Docker 위에서 프로젝트 빌드 및 실행**
- 업로드된 프로젝트를 Docker 컨테이너 위에서 자동 빌드 및 실행 처리


### ✅ **7. 외부 접속 확인**
- 업로드 및 배포 완료된 프로젝트의 외부 접속 테스트 성공


### 🎨 **8. 웹 사이트 마무리**
- 웹 사이트의 디자인, 사용자 경험(UX) 최적화 및 세부 사항 조정  
- 전체 프로젝트를 점검하고 배포 준비 완료  

---

### Users 테이블 구조
  
| **컬럼명**            | **데이터 타입** | **설명**               |
|-----------------------|----------------|------------------------|
| `username`            | VARCHAR        | 사용자 이름             |
| `userid`              | VARCHAR        | 사용자 ID (고유값)      |
| `passwored`           | VARCHAR        | 사용자 비밀번호         |
| `useremail`           | VARCHAR        | 사용자 이메일           |

---

### Projects 테이블 구조
  
| **컬럼명**            | **데이터 타입** | **설명**               |
|-----------------------|----------------|------------------------|
|`projectid`         | VARCHAR        | 프로젝트 제목            
|`projectname`         | VARCHAR        | 프로젝트 제목            |
| `projectdescription` | TEXT           | 프로젝트 설명           |
| `projectuploaddate` | DATETIME       | 프로젝트 업로드 날짜    |
| `projecttag`         | VARCHAR        | 프로젝트 태그           |
| `projectdownloadcount` | INT         | 프로젝트 다운로드 수     |
| `projectviewcount`     | INT         | 프로젝트 조회수          |
| `projectversion`     | VARCHAR        | 프로젝트 버전      |
| `userid`     | VARCHAR        | 유저 ID      |
| `status`     | bool        | 프로젝트 상태     |
| `projectupdatedate`     | timestamp        | 프로젝트 업데이트 날짜      |
| `dfilename`     | VARCHAR        | Dockerfile 이름       |
| `bfilename`  | VARCHAR           | jar, war 파일 이름    |

---

### file_info 테이블 구조

| **컬럼명**            | **데이터 타입** | **설명**               |
|-----------------------|----------------|------------------------|
| `userid`              | VARCHAR        | 사용자 ID (고유값)      |
| `dockerfile`     | bytea        | Dockerfile      |
| `dfilename`     | VARCHAR        | Dockerfile 이름       |
| `buildfile`     | bytea        | buildfile        |
| `bfilename`  | VARCHAR           | jar, war 파일 이름    |
| `projectname`  | VARCHAR           | 프로젝트 제목    |
