# 베이스 이미지 + 이미지 별칭
# FROM amazoncorretto:11 AS builder 
# 사용자 추가
#RUN useradd sipark
#USER sipark
# gradlew 복사
# COPY gradlew . 
# gradle 복사
# COPY gradle gradle 
# build.gradle 복사
# COPY build.gradle . 
# settings.gradle 복사
# COPY settings.gradle . 
# 웹 어플리케이션 소스 복사
# COPY src src 
# gradlew 실행권한 부여
# RUN chmod +x ./gradlew 
# gradlew를 사용하여 실행 가능한 jar 파일 생성
# RUN ./gradlew bootWar 
# 베이스 이미지
FROM amazoncorretto:11
# builder 이미지에서 build/libs/*.jar 파일을 app.jar로 복사
COPY build/libs/*.jar app.jar 
# ENVIRONMENT라는 이름의 argument를 받을 수 있도록 설정
ARG ENVIRONMENT
# argument로 받은 ENVIRONMENT 값을 SPRING_PROFILES_ACTIVE에 적용
ENV SPRING_PROFILES_ACTIVE=${ENVIRONMENT}
# timezone 적용
ENV TZ Asia/Seoul
# 컨테이너 Port 노출
EXPOSE 7080
# jar 파일 실행
ENTRYPOINT ["java", "-jar", "app.jar"]

