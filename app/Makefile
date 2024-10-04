.DEFAULT_GOAL := build-run

clean:
	./gradlew clean
build:
	./gradlew build
installDist:
	./gradlew installDist
run-dist:
	./build/install/app/bin/app -h
test:
	./gradlew test
report:
	./gradlew jacocoTestReport
lint:
	./gradlew checkstyleMain checkstyleTest
run-test:
	./build/install/app/bin/app differentFile1.json differentFile2.json

build-run: clean build installDist lint test report run-dist
build-test: clean build installDist lint test report run-test

.PHONY: build
