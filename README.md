About this repository
==================
This repository contains all the code samples that are shown in the videos of my REST Assured course that is part of [Test Automation University](https://testautomationu.applitools.com/).

What do I need to run these samples?
---
A Java 8 JDK and Maven. That's it.

What API is used for the samples?
---
The code samples invoke the [Zippopotam.us API](http://api.zippopotam.us).

In those cases where the actual API could not be used (it doesn't support HTTP operations other than GET, plus it doesn't have an option to return XML response bodies), calls have been mocked using [WireMock](http://wiremock.org). 

Running the mock server
---
In order to get a response from the WireMock mock server, you'll need to start it before you run your tests. You can do so by running this command from the `src/test/resources` folder:
```
java -jar wiremock-standalone-2.21.0.jar --port 9876
```
In the (unlikely) event that you've already got a process running on port 9876, you can run the mock server on any available port. Please make sure to change the references to the port in the test classes as well, or your tests will likely never pass...

Comments? Saying thanks?
---
Feel free to file an issue here or send me an email at bas@ontestautomation.com.