Feature: Validate Github API

@retrieve
Scenario Outline: Validate Github GET API

Given Github API exists
When Github GET API is called for the id <Project>
Then Verify the status code is "<statusCode>"

Examples: 
|Test case description |Project				      |statusCode|
|Valid id 		   	   |TestProject888  		  |204	     |
|Invalid id 		   |TestProject5537           |404	     |
 

@create
Scenario Outline: Validate Github POST API

Given Github POST API exists
When Github POST API is called with the name <Project>
Then Verify the status code is "<statusCode>"

Examples: 
|Project		  |statusCode|
|TestProject8888  |201	   |

@delete
Scenario Outline: Validate Github DELETE API

Given Github API exists
When Github DELETE API is called for the id <Project>
Then Verify the status code is "<statusCode>"

Examples: 
|Test case description |Project				      |statusCode|
|Valid id 		   	   |TestGitProject8719 		  |204	     |
|Invalid id 		   |TestProject798			  |404	     |


@update
Scenario Outline: Validate Github PUT API

Given Github API exists
When Github PUT API is called for the id <idValue> and <nameValue>
Then Verify the status code is "<statusCode>"

Examples: 
|Test case description |idValue				 	  |nameValue 		 |statusCode|
|Valid id 		   	   |TestProject_444  |TestProject_444_Updated	 |200	    |
|Invalid id 		   |TestProject_556|TestProject_555_Updated		 |400	    |









