**Test Description:
**Write a test automation suite which does following.
1. Reads given input file: car_input.txt
2. Extracts vehicle registration numbers based on pattern(s).
3. Each number extracted from input file is fed to any car valuation website for e.g. webuyanycar
(Perform vehicle details search car valuation page with random mileage details)
4. Compare the output returned by car valuation website with given car_output.txt
5. Highlight/fail the test for any mismatches. Showcase your skills so it’s easier to add more
input files in future. Utilise any JVM based language with browser automation tools. Use
design patterns where appropriate.


Repo Contains UI Selenium framework and tests. The base branch for this repo is "master"

**Using Junit to run the vehicleDetailsTest.java** test located under src/test/java
Project does support mutiple input and output file porcessing. Please add more file under sr/main/resource/testdata/{input or output}
Ensure you are using latest version of **JDK (Jave 21 and above)**
Also take a note that Test stops on any assertion failure. Please comment the assertions in Test file to run the full tesst and it will still show the Matching and Not Maching logs on console.
