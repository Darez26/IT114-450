<table><tr><td> <em>Assignment: </em> IT114 Chatroom Milestone 2</td></tr>
<tr><td> <em>Student: </em> David Juarez(dj26)</td></tr>
<tr><td> <em>Generated: </em> 7/18/2022 12:09:00 AM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M22/it114-chatroom-milestone-2/grade/dj26" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <p>Implement the features from Milestone2 from the proposal document:&nbsp; <a href="https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view">https://docs.google.com/document/d/1ONmvEvel97GTFPGfVwwQC96xSsobbSbk56145XizQG4/view</a></p>
</td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Server will have the functionality to switch users between “Rooms” </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Screenshots of lobby</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/179438619-c87341f5-d7aa-45cf-b64f-3f6b8e8a23c9.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>User David Joined<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/179438669-68ea3c0f-c63b-4012-af04-5fcd9ffdc15d.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>User David and Computer have joined Lobby<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Screenshots of different room</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/179438799-ef05e0f2-c5d9-4e65-a8bf-a0f3bba6b4d1.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Process of Creating a new room <br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/179438837-28aaf0bd-dc4e-482c-95ca-6dd7f4407b71.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Computer entered new Room and left lobby <br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/179438872-53b565ed-4241-4929-a129-82a2b70fa7e8.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Computer and user can not communicate<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Payload </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Payload Screenshots</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/179440016-47a1c324-9a6d-4582-aebe-a12f8664cf1e.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>payload for flip function<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/179440058-b9a410ea-4ed7-4da8-a33e-db4056cc21ee.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Payload output<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Server-side commands </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code for the mentioned commands</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/179438949-72c7763a-38a7-4635-83ac-5f9853f2426b.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Code for Flip<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/179438987-13a371e4-06f2-4daf-bf06-ffe877612b56.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>code for roll<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Explain the logic/implementation of each commands</td></tr>
<tr><td> <em>Response:</em> <p>roll&nbsp;<div>The roll functions works by first taking in the parameter of the user&#39;s<br>request such as &quot;/roll 20&quot;. Because roll is a command the &quot;/&quot; will<br>be stripped and &nbsp;the rest of the string will be converted to an<br>array in ProcesssCommands. roll will be used as a case in the switch<br>statement in ProecessCommands and the second place in the array which is 20<br>will be used a parameter in the roll function. A random number will<br>be generated due to the random class being imported and will then be<br>returned to the user.&nbsp;</div><div><div><br></div><div>flip</div></div><div>The flip command works by taking creating a random integer<br>object which is then checked to be even or odd. If the random<br>integer is even the message that is sent back is that the coin<br>is heads. If the integer is odd the message that is sent back<br>is tails.</div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Text Display </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Show the code for the various style handling</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/179443612-12151e20-0966-4886-bfc9-1052e17f9ad4.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Logic for the text format.<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Show source message and the result output in the terminal (note, you won't actually see the styles until Milestone3)</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/179443612-12151e20-0966-4886-bfc9-1052e17f9ad4.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Logic so far (has to be redone)<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Explain how you got each style applied</td></tr>
<tr><td> <em>Response:</em> <p>At first I tried to approach this problem trough a switch statement within<br>the function FormatMessage. My idea was to isolate the phrase that needs to<br>be formatted trough splitting the the string with a delimiter. Next I would<br>create a new String array and have it copy the string until it<br>reaches the phrase with the second part of the delimiter. For example <em>RroseR</em><br>would strip the * away and the R would then be used in<br>a switch statement where the text would be changed to red color.&nbsp;<div><br></div><div>Now I<br>will create different delimiters for each case I would like to consider. This<br>will make it so that each instance of the text format will be<br>triggered trough various symbols such as &quot;*&quot; for bold or &quot;%&quot; for italics.<br>This will make it so that is easier to loop trough and will<br>just have to strip the phrase once from the string.</div><br></p><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 5: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Include the pull request for Milestone2 to main</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/Darez26/IT114-450/pull/13">https://github.com/Darez26/IT114-450/pull/13</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M22/it114-chatroom-milestone-2/grade/dj26" target="_blank">Grading</a></td></tr></table>