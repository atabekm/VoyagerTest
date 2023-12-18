## VoyagerTest

A sample repo to show the issue of navigating to a certain screen after authentication flow. To reproduce, 
in tab `One`, tap `Go to ScreenTwo via Auth` button, then tap `Login`. It should close the Auth screen, and 
navigate to `ScreenTwo`. However, it stays in `ScreenOne`, although from logs it is visible that `ScreenTwo` 
is added to navigation stack.