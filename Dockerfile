FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN javac -cp . *.java models/*.java strategy/*.java algo/*.java factory/*.java

CMD ["java", "-Dmode=ci", "Main"]

