.DEFAULT_GOAL := build-run

setup:
	./gradlew wrapper --gradle-version 8.7
clean:
	./gradlew clean
build:
	./gradlew build
install:
	./gradlew install
installDist:
	./gradlew installDist
run-dist:
	./build/install/app/bin/app -h
test:
	./gradlew test
report:
	./gradlew jacocoTestReport
lint:
	./gradlew checkstyleMain

build-run: clean build installDist test report lint run-dist

.PHONY: build
