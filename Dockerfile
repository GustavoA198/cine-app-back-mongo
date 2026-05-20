# ============================================
# ETAPA 1: BUILD (Compilación)
# ============================================
FROM eclipse-temurin:21-jdk-alpine AS build

WORKDIR /app

COPY pom.xml /app/
COPY mvnw /app/
COPY .mvn /app/.mvn

RUN chmod +x /app/mvnw

# Crear settings.xml con credenciales de GitHub
RUN if [ -n "${GITHUB_TOKEN}" ]; then \
    mkdir -p /root/.m2 && \
    echo '<settings><servers><server><id>github</id><username>${GITHUB_USER}</username><password>${GITHUB_TOKEN}</password></server></servers></settings>' > /root/.m2/settings.xml; \
    fi

# Agregar repositorio de GitHub al pom.xml si hay token
RUN if [ -n "${GITHUB_TOKEN}" ]; then \
    sed -i 's|</project>|<repositories><repository><id>github</id><name>GitHub Packages</name><url>https://maven.pkg.github.com/GustavoA198/*</url></repository></repositories></project>|' pom.xml; \
    fi

RUN ./mvnw dependency:go-offline -B || ./mvnw dependency:resolve -DincludeArtifactIds=parent,rabbitmq-client || true

COPY src /app/src

RUN ./mvnw clean package -DskipTests

# ============================================
# ETAPA 2: RUNTIME (Ejecución)
# ============================================
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENV JAVA_OPTS="-Xmx256m -XX:+UseContainerSupport"

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]