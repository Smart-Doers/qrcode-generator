##QRCode- Generator

[![Build Status](https://travis-ci.org/Smart-Doers/qrcode-generator.svg?branch=master)](https://travis-ci.org/Smart-Doers/qrcode-generator)


###To run the functional test cases, please run below command
./gradlew clean cucumber

###To create Docker image, please run below command
./gradlew clean buildDocker

###To run the docker image, please run below command
docker run -p 8080:8080 IMAGE_ID

###We are using Junit-5, Please upgrade intellij to 2016.3.3+ version.