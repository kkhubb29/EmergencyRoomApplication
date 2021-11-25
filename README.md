# Triage for Walk-in ER Patients
## a program to help organize patients based on their injuries and ailments 


For my term project, I propose to create a project that can be used in ER waiting rooms. The application will allow the 
ER coordinator to order, sort and prioritize walk-in ER patients. The application will have two elements. The first will 
be a digital questionnaire that will be filled out by patients as they arrive in the ER. The second element will be a 
list of patients created using the information from the form that will be used by the coordinator in the ER to determine 
how each patient is processed.

A score will be calculated for each patient based on the answers to the questionnaire.  Patients will be assigned one of 
three states based on their score:
- in waiting room
- assigned to a doctor
- assigned to a nurse practitioner 

This project interests me because I once waited a long time in an emergency room with a sprained ankle and wondered how 
they decided who to deal with next

For **phase 1**, I am going ot focus on a patient being able to enter their name and the ER coordinator being able 
to manipulate the list and to assign them.

I will introduce sorting the list at a later phase. 

## User Stories:
- As a user *(patient)*, I want to be able to add my name to the ER patient list.
- As a user *(ER coordinator)*, I want to be able to view the list of patient and their current assignments.
- As a user *(ER coordinator)*, I want to be able to assign patients to a doctor.
- As a user *(ER coordinator)*, I want to be able to assign patients to a nurse practitioner.
- As a user *(ER coordinator)*, I want to be able to add and remove patients from the ER patient list.
- As a user *(ER coordinator)*, I want to be able to save the list of patients to file.
- As a user *(ER coordinator)*, I want to be able to load the list of patients from file.

## Phase 4: Task 2
Wed Nov 24 12:20:26 PST 2021
Patient: becca was added to ER Patients.


Wed Nov 24 12:20:34 PST 2021
Patient: becca was assigned to doctor.


Wed Nov 24 12:20:48 PST 2021
Patient: greg was added to ER Patients.


Wed Nov 24 12:20:57 PST 2021
Patient: greg was assigned to doctor.


Wed Nov 24 12:21:04 PST 2021
Patient: greg was removed from ER Patients.


## Phase 4: Task 3

- I would add a class for the patient questionnaire so in the future if questions wanted to be added or taken away it would be easier to do and there would be far fewer locations to implement those edits
- Adding a questionnaire class would also reduce redundancy and complexity in the Patient class setters and getters
- The RemovePatientDialog, AddPatientDialog, StartLoadDialog, and AssignPatientDialog all include similar methods, so I would add an interface that outlines all the methods and then implement them in each to help reduce redundancy in my code
- 

