# Purpose of this Folder

This folder should contain the scaffolded project files to get a student started on their project. This repo will be added to the Classroom for students to use, so please do not have any solutions in this folder.

# Installation
---------------
[<span style="color:red">X</span>] 1. Clone or download this repository.                       

[<span style="color:red">X</span>] 2. Open IntelliJ IDEA.

[<span style="color:red">X</span>] 3. In IDEA, select File -> Open and navigate to the critter directory within this  repository. Select that directory to open.

[<span style="color:red">X</span>] 4. The project should open in IDEA. In the project structure, navigate to src/main/java/com.udacity.jdnd.course3.critter.

[<span style="color:red">X</span>] 5. Within that directory, click on CritterApplication.java and select Run -> Debug CritterApplication.

[<span style="color:red">X</span>] 6. Open a browser and navigate to the url: http://localhost:8082/test -- You should see the message "Critter Starter installed successfully" in your browser.

# Testing

Once you have completed the above installation, you should also be able to run the included unit tests to verify basic functionality as you complete it. To run unit tests:

[<span style="color:red">X</span>] 1. Within your project in IDEA, Navigate to src/test/java/com.udacity.jdnd.course3.critter.

[<span style="color:red">X</span>] 2. Within that directory, click on CritterFunctionalTest.java and select Run -> Run CritterFunctionalTest

A window should open showing you the test executions. All 9 tests should fail and if you click on them they will show java.lang.UnsupportedOperationeException as the cause.

# Tested Conditions

[ ] 1. testCreateCustomer - UserController.saveCustomer returns a saved customer matching the request

[ ] 2. testCreateEmployee - UserController.saveEmployee returns a saved employee matching the request

[ ] 3. testAddPetsToCustomer - PetController.getPetsByOwner returns a saved pet with the same id and name as the one saved with UserController.savePet for a given owner

[ ] 4. testFindPetsByOwner - PetController.getPetsByOwner returns all pets saved for that owner.


[ ] 5. testFindOwnerByPet - UserController.getOwnerByPet returns the saved owner used to create the pet.

[ ] 6. testChangeEmployeeAvailability - UserController.getEmployee returns an employee with the same availability as set for that employee by UserControler.setAvailability

[ ] 7.testFindEmployeesByServiceAndTime - UserController.findEmployeesForService returns all saved employees that have the requested availability and skills and none that do not

[ ] 8. testSchedulePetsForServiceWithEmployee - ScheduleController.createSchedule returns a saved schedule matching the requested activities, pets, employees, and date

[ ] 9. testFindScheduleByEntities - ScheduleController.getScheduleForEmployee returns all saved schedules containing that employee. ScheduleController.getScheduleForPet returns all saved schedules for that pet. ScheduleController.getScheduleForCustomer returns all saved schedules for any pets belonging to that owner.

# Postman 

In addition to the included unit tests, a Postman collection has been provided.

[<span style="color:red">X</span>] 1. Open Postman.

[<span style="color:red">X</span>] 2. Select the Import button.

[<span style="color:red">X</span>] 3. Import the file found in this repository under src/main/resource/Udacity.postman_collection.json

[<span style="color:red">X</span>] 4. Expand the Udacity folder in postman.

Each entry in this collection contains information in its Body tab if necessary and all requests should function for a completed project. Depending on your key generation strategy, you may need to edit the specific ids in these requests for your particular project.

# Built With (skip)

# License (Skip)

## Task 1:  Configure Properties

The starter project contains a blank application.properties file.

Provide the appropriate connection url and credentials for Spring to configure your external db as the primary data source.

[ ]  If you want Spring to automatically generate schema for you, set values for initialization-mode and ddl-auto to customize the way Spring generates or updates your schema.

## Task 2: Configure Unit Tests

[<span style="color:red">X</span>]  Create a new application.properties file in your test/resources directory and configure it to use an H2 in-memory database for unit tests.

[ ]  The starter project includes a set of functional tests to help you make sure you’ve met the requirements.

[<span style="color:red">X</span>]  More information can be found about the unit tests and how to run them in the Testing section of the README. They will fail for now because the starter project controller methods are incomplete, but you can use them to check your progress as you go.

[<span style="color:red">X</span>] The starter project also includes a Postman collection under src/main/resource/Udacity.postman_collection.json. Importing this collection into the Postman application will provide you with a variety of requests you can submit. You should use them to confirm functionality of your external data source as you work. You will also find information about the Postman collection in the project README.