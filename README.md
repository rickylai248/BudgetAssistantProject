# Financial Budget Assistant

##My Personal Project

[**Project Proposal**]

The main purpose of this application is to scope and plan out a monthly budget based on a given take-home salary/income
and to insert any expenses e.g. titled Rent $1000, then it can even categorize these expenses (e.g. essential living)
and represent the monthly savings (or debt) visually alongside a percentage saved since the objective is to manage
money better. 

This is of use to anyone, but it's extremely helpful as a quick and easy tool for people of all ages
regardless of their experience of technology/computers to calculate their average expenses and cut down on anything.
I've always been interested in living a frugal / minimalist lifestyle alongside finance so this will benefit me in cost 
averaging and budget management. 

//

**Begin Now For a Brighter Future!:**
- Quick and easy tool to calculate average expenses
- For people of all ages regardless of experience
- Easy frugal / minimalism lifestyle!

You can generate the first required event by typing in the box then clicking submit (a budget). <br>
You can generate the second required event by typing in the box then clicking (submit) a budget once again (also see
below for screen shot). <br>
You can trigger my audio component by clicking submit at the very end (Windows XP Chime.wav played from your media
player) in addition to viewing a screenshot of your created budget when you press "Save" in data (e.g. name.png). <br>
You can save the state of my application by clicking "Save", also takes a screenshot for you. <br>
You can reload the state of my application by "Load".

























































##User Stories
(OLD)
As a user, I want to be able to track my budget by inputting expenses and my monthly allowance <br>
As a user, I want to be able to input certain expenses and label them accordingly <br>
As a user, I want to be able to categorize the type of expense and view the overall total cost <br>
As a user, I want to be able to see the difference between my salary and expenses, in numerical and percentage form <br>
As a user, I want to be able to print/download my imported expenses and earnings report <br>
As a user, I want to be able to save my budget list file <br>
As a user, I want to be able to easily open up a saved budget file <br>
As a user, I want to be able to download my inputted expenses and earnings report <br>
As a user, I want to be able to visualize my expenses with colour and imagery <br>

Decided to test the robustness of my Budget class/model and added a method called ValidPercent to see if my final value
for the percentage spent would be undefined (e.g. throws IllegalArgumentException and boolean valid percent becomes
false) and added three tests accordingly in BudgetTest to test the cases where it isn't and is thrown, adding to the
robustness of my Java personal project alongside other exception management in my UI and main classes like file reader
and potential missing class methods in accordance to the input requirements.

Identifying major/minor issues such as the double-edged sword where there was both high coupling and poor cohesion in
one of my classes where I took measures to isolate the specified tasks from my project (e.g. Console UI) and
separated it into a different, new class where I could easily call on it with a (new ConsoleUI()) line, helping
differentiate and allocate tasks to classes rather than having it all in one. A much better point of design
especially when other people are viewing this project in addition to other numerous changes such as the refactoring, 
separation and cohesion work of the project as to delegate meaningful tasks to each class respectively (e.g. then
solved other problems with a new GUI class to manage my Swing portion of the project with minor refactoring such as
the extraction of the audio play, double parse helper method, and JLabel text overwriting method in order to reduce 
redundant code throughout the project in order to keep everything tidy and readable/understandable alongside other
fixes in the Budget model).
