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
	./gradlew test jacocoTestReport
lint:
	./gradlew checkstyleMain
	./gradlew checkstyleTest

build-run: clean build installDist run-dist lint test report

.PHONY: build
