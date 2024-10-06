.DEFAULT_GOAL := build-run

#ifeq ($(OS),Windows_NT)
#    CLEAR_CMD = cls
#else
#    CLEAR_CMD = clear
#endif

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

build-run: clean build installDist lint test report run-dist

b-h:
	./build/install/app/bin/app -h
b-s:
	./build/install/app/bin/app differentFile1.json differentFile2.json
b-p:
	./build/install/app/bin/app -f plain differentFile1.json differentFile2.json
b-j:
	./build/install/app/bin/app -f json differentFile1.json differentFile2.json

.PHONY: build
