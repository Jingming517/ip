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

### Date
Find tasks on a certain date  
Format: `date [yyy-mm-dd]`  
Example:
```$xslt
date 2020-09-23
```

### Sort
Sort tasks according to their types  
Format: `sort`  
Example:
```$xslt
sort
```
Sample Outcome:  
```$xslt
        ____________________________________________________________
         Here are your tasks:
         Deadlines:
         1.[D][✘]  b  (by: Mar 2 2002)
         2.[D][✘]  c  (by: Mar 4 2011)
         3.[D][✘]  d  (by: Nov 11 2009)
         4.[D][✘]  read book  (by: Jan 11 2020)
         Events:
         1.[E][✘]  a  (at: Feb 2 2000)
         2.[E][✘]  e  (at: Feb 28 1980)
         Todos:
         1.[T][✘]  borrow book 
        ____________________________________________________________

```

### Timeline
Generates a timeline for deadlines and events  
Format: `timeline`  
Example:
```$xslt
timeline
```
Sample Outcome:  
```$xslt
        ____________________________________________________________
         Here is your timeline:
         1.[E][✘]  e  (at: Feb 28 1980)
         2.[E][✘]  a  (at: Feb 2 2000)
         3.[D][✘]  b  (by: Mar 2 2002)
         4.[D][✘]  d  (by: Nov 11 2009)
         5.[D][✘]  c  (by: Mar 4 2011)
         6.[D][✘]  read book  (by: Jan 11 2020)
         Here are your todos:
         1.[T][✘]  borrow book 
        ____________________________________________________________

```

### Help
Prints available commands  
Format: `help`  
Example:
```$xslt
help
```
Sample Outcome:
```$xslt
        ____________________________________________________________
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

        find: Find tasks that contain the keyword
                Example: find book

        date: Find tasks on a certain date
                Example: date 2020-09-23

        timeline: Print tasks in time order
                Example: timeline

        sort: Sort tasks according to their types
                Example: sort

        bye: Exit the program.
                Example: bye
        ____________________________________________________________

```
### Bye
Exits Duke
Format: `bye`  
Example:
```$xslt
bye
```
