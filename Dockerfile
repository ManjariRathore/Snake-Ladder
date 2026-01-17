FROM eclipse-temurin:17-jre

WORKDIR /app

COPY *.class ./
COPY models ./models
COPY strategy ./strategy
COPY algo ./algo
COPY factory ./factory

CMD ["java", "Main"]
