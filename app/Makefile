.DEFAULT_GOAL := build-run

setup:
	./gradlew wrapper --gradle-version 8.5
clean:
	./gradlew clean
build:
	./gradlew clean build
install:
	./gradlew clean install
installDist:
	./gradlew installDist
run-dist:
	./build/install/app/bin/app
test:
	./gradlew test
report:
	./gradlew jacocoTestReport
lint:
	./gradlew checkstyleMain
check-deps:
	./gradlew dependencyUpdates -Drevision=release
run-test:
	./build/install/app/bin/app /Users/s.roman3455/Documents/IT/Education/Hexlet/Java_developer/Projects/java-project-71/app/src/main/resources/file1.json /Users/s.roman3455/Documents/IT/Education/Hexlet/Java_developer/Projects/java-project-71/app/src/main/resources/file2.json
build-run: build installDist test report lint run-test

.PHONY: build
