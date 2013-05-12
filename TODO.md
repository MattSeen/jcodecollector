# Build system

### 
~~Have updated the build system, but it seems a later build of macwidgets was used by this code base. Will need to pull and build this code and create a local repo on my machine for maven to grab.~~

Did this, must include a better way for someone doing a clean build set-up though

# Code

### Compiling everywhere
~~The mac specific code won't compile on other platforms, should look into how to make the build system work everywhere without exception by replace those Apple specific JVM libraries.~~

Have solved this issue by using a maven repository package called orange-extension

### Manaually analysis

Read over the code base, debug through the main flows and see it in action.

### Statically analysis
~~Setup sonar to scan the code~~
Done and by the looks of the analysis the code is pretty clean as is. Only issue now is the italian comments.

~~Install Google Code Pro utility in Eclipse~~
Done, this tools allows me to analysis the code in the same as Sonar and as such I don't need a seperate tools for development purposes.

### Diagramming

Use a tools like Eclipse UML tools to get a diagram overview of the different dependancies between classes and begin making a plain for how to proceed.

### Testing

Using Google Code Pro, generate tests to cover the behaviour of the app.

Read over tests to ensure they are good clean and consistant with what you want.
