<table><tr><td> <em>Assignment: </em> IT114 M2 Java-HW</td></tr>
<tr><td> <em>Student: </em> David Juarez(dj26)</td></tr>
<tr><td> <em>Generated: </em> 6/4/2022 8:54:10 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M22/it114-m2-java-hw/grade/dj26" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p><br></p><p><strong>Template Files</strong>&nbsp;You can find all 3 template files in this gist:&nbsp;<a href="https://gist.github.com/MattToegel/fdd2b37fa79a06ace9dd259ac82728b6">https://gist.github.com/MattToegel/fdd2b37fa79a06ace9dd259ac82728b6</a>&nbsp;<br></p><p>Setup steps:</p><ol><li><code>git checkout main</code></li><li><code>git pull origin main</code></li><li><code>git checkout -b M2-Java-HW</code></li></ol><p>You'll have 3 problems to save for this assignment.</p><p>Each problem you're given a template&nbsp;<strong>Do not edit anything in the template except where the comments tell you to</strong>.</p><p>The templates are done in such a way to make it easier to capture the output in a screenshot.</p><p>You'll copy each template into their own separate .java files, immediately git add, git commit these files (you can do it together) so we can capture the difference/changes between the templates and your additions. This part is required for full credit.</p><p>HW steps:</p><ol><li>Open VS Code at the root of your repository folder</li><li>In VS Code create a new folder/directory called M2</li><li>Create 3 new files in this new M2 folder (Problem1.java, Problem2.java, Problem3.java)</li><li>Paste each template into their respective files</li><li><code>git add .</code></li><li><code>git commit -m "adding template baselines</code></li><li>Do the related work (you may do steps 8 and 9 as often as needed or you can do it all at once at the end)</li><li><code>git add .</code></li><li><code>git commit -m "completed hw"</code></li><li>When you're done push the branch<ol><li><code>git push origin M2-Java-HW</code></li></ol></li><li>Create the Pull Request with <b>main</b>&nbsp;as base and&nbsp;<strong>M2-Java-HW</strong>&nbsp;as compare (don't merge/close it yet)</li><li>Create a new file in the M2 folder in VS Code called m2_submission.md</li><li>Fill out the below deliverable items, save the submission, and copy to markdown</li><li>Paste the markdown into the m2_submission.md</li><li>add/commit/push the md file<ol><li><code>git add m2_submission.md</code></li><li><code>git commit -m "adding submission file"</code></li><li><code>git push origin M2-Java-HW</code></li></ol></li><li>Merge the pull request from step 11</li><li>On your local machine sync the changes<ol><li><code>git checkout main</code></li><li><code>git pull origin main</code></li></ol></li><li>Submit the link to the m2_submission.md file from the main branch to Canvas</li></ol><p><br></p></td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Problem 1 - Only output Odd values of the Array under "Odds output" </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> 2 Screenshots: Clearly screenshot the output of Problem 1 showing the data and show the code</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/172029810-2ed805ae-23d3-48f1-8db2-2e5cef93b6af.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>output for Problem 1<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/172029823-6e0f2c54-e6d9-4ddb-866e-6a64bc1fa3e6.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>code for problem 1<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Describe how you solved the problem</td></tr>
<tr><td> <em>Response:</em> <p><font color="#586e75"><i style="caret-color: rgb(88, 110, 117);">In order to solve this problem I first<br>had to loop trough the array that was   passed as a&nbsp;</i><i>parameter</i><i style="caret-color: rgb(88,<br>110, 117);">.By looping trough the array&nbsp;</i><i>I</i><i style="caret-color: rgb(88, 110, 117);">&nbsp;can then divide each<br>value by 2 in order to see if the value had any remainders.<br>If there was no remainders then the value was even however if there<br>were a remainder than the input was odd.&nbsp;</i></font><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Problem 2 - Only output the sum/total of the array values (the number must end in 2 decimal places, if it ends in 1 it must have a 0 at the end) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> 2 Screenshots: Clearly screenshot the output of Problem 2 showing the data and show the code</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/172029880-7be6b72a-db69-42a5-abe6-0046853b3075.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Output for problem 2<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/172030143-a47ee6a6-55b2-4a59-b71c-f4662bd80d87.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>code for problem2<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Describe how you solved the problem</td></tr>
<tr><td> <em>Response:</em> <p>In order to solve this problem I took a similar approach to problem<br>1. I created a variable first to keep track of the total, then<br>I created a for loop that looped trough the array and accumulated the<br>total variable by the current value of the array. after the for loop<br>is done the total is calculated and now needs to be rounded to<br>two decimal places. this can be accomplished trough one of the java libraries<br>specifically the math library.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Problem 3 - Output the given values as positive under the "Positive Output" message (the data otherwise shouldn't change) </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> 2 Screenshots: Clearly screenshot the output of Problem 3 showing the data and show the code</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/172030225-a3744e0f-937f-42c5-988d-5fef3501c472.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>output for problem 3<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/172030237-8f420205-c4b8-4876-9498-b6ff2fa3cc12.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>code for problem 3 part 1<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/172030249-b53c5756-0ad1-4dcc-b4c8-47acaa5f8358.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>code for problem 3 part 2<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Describe how you solved the problem</td></tr>
<tr><td> <em>Response:</em> <p>because the arrays contained different data types what I did was create a<br>for loop that would loop trough each value in the array. inside this<br>for loop I would convert each value to a string and store it<br>within a variable named strNum. I would also get the datatype of each<br>value and store the name of the class within the &quot;type&quot; &nbsp;variable. Since<br>we are already looping trough the array I created a nested switch statement<br>that would take the type of the variable as an input. If the<br>data type was an integer, double, or string, it would be handled by<br>three separate cases. All three cases follow a similar approach, I would take<br>the string equivalent of the current arr[position] and convert it to an integer<br>or double depending on the case. I then preformed an if else statement<br>where if the value was less then 0, it would have to be<br>multiplied by -1 to become a positive number.<br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc Items </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Pull Request URL for M2-Java-HW to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/Darez26/IT114-450/pull/4">https://github.com/Darez26/IT114-450/pull/4</a> </td></tr>
<tr><td> <em>Sub-Task 2: </em> Talk about what you learned, any issues you had, how you resolve them</td></tr>
<tr><td> <em>Response:</em> <p>An issue that I had was making sure my ssh key was stored<br>correctly, I now know which steps to follow in order to make sure<br>that I am using the right key to the right repository. In addition<br>for &nbsp;the last problemI had look trough documentation for the java language in<br>order to use tools that are already made such as the math library<br>or the getClass function. This made it easier to solve these problems because<br>I could use simple functions instead of having to reinvent the wheel.&nbsp;<br></p><br></td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M22/it114-m2-java-hw/grade/dj26" target="_blank">Grading</a></td></tr></table>



