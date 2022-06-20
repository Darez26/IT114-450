<table><tr><td> <em>Assignment: </em> IT114 - Sockets Part 1 - 3</td></tr>
<tr><td> <em>Student: </em> David Juarez(dj26)</td></tr>
<tr><td> <em>Generated: </em> 6/20/2022 12:55:44 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M22/it114-sockets-part-1-3/grade/dj26" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <ol><li>Create a new branch for this assignment</li><li>Go through the socket lessons and get each part implemented (parts 1-3)</li><li>Create a new folder called Part3HW</li><li>Create an empty m4_submission.md file in Part3HW</li><li>Add/commit/push the branch</li><li>Create a pull request to main and keep it open</li><li>Copy the the Part3 code into this new folder</li><li>Git add/commit all of the sample code and the Part3HW code</li><li>Implement two of the following server-side activities for all connected clients (majority of the logic should be processed server-side and broadcasted to all clients if/when applicable)</li><ol><li>Simple number guesser where all clients can attempt to guess</li><ol><li>Hint: may want separate commands to start, stop, and guess (or starting lasts for x rounds then stops)</li><li>No need to implement complexities like strikes</li></ol><li>Coin toss command (random heads or tails)</li><li>Dice roller given a command and text format of "roll #d#" (i.e., roll 2d6)</li><li>Math game (server outputs a basic equation, first person to guess it right gets congradulated and a new equatiion is given)</li><ol><li>Hint: may want a separate start, stop, answer commands (or starting lasts for x rounds then stops)</li></ol><li>Private message (a client can send a message targetting another client where only the two can see the messages)</li><li>Message shuffler (randomizes the order of the characters of the given message)</li></ol><li>Fill in the below deliverables</li><li>Save and generated the markdown or markdown file</li><li>Update the m4_submission.md file in the Part3HW folder</li><li>Add/commit/push your changes</li><li>Merge the pull request</li><li>From the M4-Sockets branch, navigate to your m4_submission.md file on github and copy the link</li><li>Submit the direct link to Canvas</li></ol></td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Baseline </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add as many screenshots as necessary to show basic communication among 3 clients and 1 server</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/174647166-2582bced-5408-4a6c-b0ff-f68d1282e965.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>3 clients created<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/174647937-23c02d10-ee62-44e9-ad77-c8f217ae0e21.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>broadcasted messages to clients <br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/174648805-47d3817d-b5d6-4613-8e46-fcc9d323f5d6.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>features implemented among clients<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Feature Implementation 1 </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> What feature did you pick? Briefly explain how you implemented it</td></tr>
<tr><td> <em>Response:</em> <div style="line-height: 18px;"><div> For this function of CoinToss, I created a function that<br>would create a random integer from 0-10; The intial state of the coin<br>is heads however if the random integer were to change to an odd<br>number than the message would be that the coin is tails. The message<br>will then get returned and passed into the broadcast function. this would then<br>allow the user to see the state of the coin after each flip<br>command.</div></div><br></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot(s) showing the implemented feature working</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/174647937-23c02d10-ee62-44e9-ad77-c8f217ae0e21.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Coin toss feature<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Feature Implementation 2 </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> What feature did you pick? Briefly explain how you implemented it</td></tr>
<tr><td> <em>Response:</em> <div style="line-height: 18px;"><div>Logic: The logic for the shuffler message revolves with taking in<br>a string parameter, and storing the string into a charater array. this will<br>make it easier to loop over and change the places of each letter<br>within the string. The logic for shuffling the word around revolves around switching<br>the last letter of the word with the first letter up until the<br>for loop reaches the middle letter of the word. when the middle is<br>reached then the loop will break and the character array will be returned<br>as a string  and broadcasted above.</div></div><br></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot(s) showing the implemented feature working</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/174648139-1de1e94d-e4bd-4af3-9733-150c11d053bc.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Shuffle my message feature<br></p>
</td></tr>
</table></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Did you have an issues and how did you resolve them? If no issues, what did you learn during this assignment that you found interesting?</td></tr>
<tr><td> <em>Response:</em> <p>Some of the issues that I had were figuring out how to use<br>the broadcast feature. The main issue with my shuffle message was that the<br>input shuffle would always be the one to get shuffled. I solved this<br>issue by reaching out to the professor after hours of thinking of a<br>workaround. Which was a simple fix of using .Starts with() instead of equals.<br>This would make it easier to just split the message and then use<br>the second word to be passed into the function.&nbsp;<div><br></div><div>Another issue I had was<br>how to shuffle the word, initially, I looped through the whole word switching<br>the &quot;I&quot; value and its negative value, however, i realized that if the<br>loop finished each letter would be switched back to it&#39;s original position eventually.<br>SO I decided to create a break statement where if it reached the<br>middle it would break.&nbsp;</div><br></p><br></td></tr>
<tr><td> <em>Sub-Task 2: </em> Pull request link</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/Darez26/IT114-450/pull/9">https://github.com/Darez26/IT114-450/pull/9</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M22/it114-sockets-part-1-3/grade/dj26" target="_blank">Grading</a></td></tr></table>