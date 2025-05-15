## TDD `Mock` & `Spy`

>Spies are particularly useful when you want to verify interactions with external dependencies or side effects without altering their core behavior. In my react.js alert box example, i am spying on window.alert because:

- i want to ensure that alert is called when the form is submitted with valid data.
- i don't want to actually pop up alert boxes during your tests (they can disrupt the test runner and require manual intervention).

>Mocks are valuable when:

- You need to isolate your component from complex dependencies.  Mocking a database interaction, for example, lets you test your component's logic without actually hitting the database.
- You need to simulate specific scenarios, like error conditions or edge cases, that are difficult to reproduce with real dependencies.