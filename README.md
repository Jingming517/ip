# Duke User Guide

## Introduction
Duke is a Personal Assistant Chatbot that helps you to keep track of various things. 

### Setting up Duke
1. Download Duke file.
2. Go to `/ip/src/main/java`
3. In command line key in:
    ```
   javac duke/Duke.java
   java duke.Duke   
   ```
## Usage 
### List
Display all tasks in the list  
Format: `list`  
Example:
```$xslt
list
```

### Todo
Add a todo task to Duke  
Format: `todo [DESCRIPTION]`  
Example:
```$xslt
todo borrow book
```

### Deadline
Add a deadline to Duke  
Format: `deadline [DESCRIPTION] /by [yyyy-mm-dd]`  
Example:
```$xslt
deadline return  book /by 2020-10-01
```

### Event
Add an event to Duke
Format: `event [DESCRIPTION] /at [yyyy-mm-dd]`  
Example:
```$xslt
event school activity /at 2020-10-01
```

### Done
Mark a task as done  
Format: `done [index]`  
Example:
```$xslt
done 2
```

### Delete
Delete a task from duke  
Format: `delete [index]`  
Example:
```$xslt
delete 2
```

### Find
Find tasks that contains a certain keyword  
Format: `find [keyword]`  
Example:
```$xslt
find book
```

### Sort
Sort tasks according to their types  
Format: `sort`  
Example:
```$xslt
sort
```

### Help
Prints available commands  
Format: `help`  
Example:
```$xslt
help
```
Outcome:
```
        [List of commands available]

        list: Display all tasks in the list.
                Example: list

        todo: Add a todo task.
                Example: todo borrow book

        deadline: Add a deadline.
                Example: deadline return book /by Sunday

        event: Add a event.
                Example: event project meeting /at Mon 2-4pm

        done: Mark a task as done.
                Example: done 2

        timeline: Print tasks in time order
                Example: timeline

        bye: Exit the program.
                Example: bye

```
### Bye
Exits Duke
Format: `bye`  
Example:
```$xslt
bye
```
