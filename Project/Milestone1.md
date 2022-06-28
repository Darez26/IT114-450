<table><tr><td> <em>Assignment: </em> It114 Milestone1</td></tr>
<tr><td> <em>Student: </em> David Juarez(dj26)</td></tr>
<tr><td> <em>Generated: </em> 6/27/2022 9:45:25 PM</td></tr>
<tr><td> <em>Grading Link: </em> <a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M22/it114-milestone1/grade/dj26" target="_blank">Grading</a></td></tr></table>
<table><tr><td> <em>Instructions: </em> <ol><li>Create a new branch called Milestone1</li><li>At the root of your repository create a folder called Project</li><li>Create a milestone1.md file inside the project folder</li><li>Git add/commit/push it to Github</li><li>Create a pull request from Milestone1 to main (don't complete/merge it yet)</li><li>Copy in the latest Socket sample code from the most recent Socket Part example</li><ol><li>Recommended Part 5, but Part 4 should be sufficient</li></ol><li>Git add/commit the baseline</li><li>Ensure the sample is working and fill in the below deliverables</li><li>Get the markdown content or the file and paste it into the milestone1.md file or replace the file with the downloaded version</li><li>Git add/commit/push all changes</li><li>Complete the pull request merge from step 5</li><li>Locally checkout main</li><li>git pull origin main</li></ol></td></tr></table>
<table><tr><td> <em>Deliverable 1: </em> Startup </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot showing your server being started and running</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/176047547-5fe6c43c-fabd-440d-9b66-c8630d3bb006.png"/></td></tr>
<tr><td> <em>Caption:</em> <p> Server is listening on port 3000<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Add screenshot showing your client being started and running</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/176047781-72d110a8-d1c3-4b24-b539-9cdd88c74fd9.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>client waiting for input <br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 3: </em> Briefly explain the connection process</td></tr>
<tr><td> <em>Response:</em> <ol><br><li>The Server side of the connection is first started by compiling the<br>server.java file, once this is completed the server will start to listen to<br>the port that it&#39;s assigned which is 3000 for our class. Any incoming<br>connections from the clients will be accepted. After the connection is established the<br>server will then place the client in the lobby which will be the<br>main point of entry for clients. &nbsp;&nbsp;<div><br></div><div><div>2) The Client side of the connection<br>works by first compiling the client java and then setting your name to<br>the client. Once your client has a name it can then go and<br>give the command &quot;/connect&quot; which will then be followed by the port that<br>the client wished to connect to. Once the client connects to the server<br>the server will accept and establish a connection.</div></div><div><br></div><br></li><br></ol><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 2: </em> Sending/Receiving </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) showing evidence related to the checklist on the right</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/176047853-53e125a7-5f16-4027-adb8-cbb69069d40c.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>2 Clients connected<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/176047915-71fdc537-41f2-45dc-a629-b0d4ed38f570.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Client can send message to server<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/176047915-71fdc537-41f2-45dc-a629-b0d4ed38f570.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Server sends message to all clients in same room <br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/176047915-71fdc537-41f2-45dc-a629-b0d4ed38f570.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Shows who said what message <br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/176048106-dd2a9451-7e35-41e9-8157-a9febaf3dd3a.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>client in 2 different rooms can&#39;t send message to clients outside room <br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the messages are sent, broadcasted, and received</td></tr>
<tr><td> <em>Response:</em> <ol><br><li>From the client&#39;s perspective the send function works by first checking whether<br>the message is a command or a general message. The message checked to<br>see whether it begans with a &quot;/&quot; and follows a command. If it<br>does not have a command then it is processed as a message. A<br>payload will be generated with the message and then be outputted, only after<br>bieng checked that it isn&#39;t a command.<div><br></div><div>2)The server thread has been changed to<br>now accept payloads instead of strings. When a client sends a message, it<br>actually sends its message in a payload which the server then interprets. if<br>the message is a command it will determine whether the client wants to<br>connect or disconnect from the server. If it isn&#39;t a command the message<br>will then be broadcasted to all clients within the same room.</div><div><br></div><div>3) Room have<br>the same reference to the Server so each room will receive a message<br>from the server should the server wish to broadcast messages to all rooms.<br>However clients who broadcast their messages will only be able to have their<br>messages shown to other clients within the same room. The room will process<br>each clients command and then loop over an array list making sure that<br>each client is able to send a message. if a client can not<br>receive a message then it will disconnect them from the room because most<br>likely they are no longer present within the room.</div><div><br></div><div>4) The client listens for<br>messages trough the listenforserver message where the client will receive a payload from<br>the server. While the server is active and there is a a message<br>the client will process the message from the server.In addition the client will<br>also print out some debug information including the type of message and who<br>sent it.</div><br></li><br></ol><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 3: </em> Disconnecting / Terminating </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add screenshot(s) showing evidence related to the checklist on the right</td></tr>
<tr><td><table><tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/176048466-90826c0f-d021-4a51-96de-d73988f18490.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>client disconnected from server<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/176048608-0934b56f-06f4-4400-b834-80ef37db218a.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>Server terminating; client still runs<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/176048608-0934b56f-06f4-4400-b834-80ef37db218a.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>disconnected message shown for server disconnected<br></p>
</td></tr>
<tr><td><img width="768px" src="https://user-images.githubusercontent.com/90282144/176048858-44a3be5d-e613-4519-93c3-f8e9a81afb56.png"/></td></tr>
<tr><td> <em>Caption:</em> <p>disconnnected messages for when client disconnects<br></p>
</td></tr>
</table></td></tr>
<tr><td> <em>Sub-Task 2: </em> Briefly explain how the various disconnects/terminations are handled</td></tr>
<tr><td> <em>Response:</em> <ol><br><li>From a Sockets Perspective Clients that disconnect is first sent a payload<br>of disconnect to the server. The server receives this command and starts the<br>Disconnect function. The disconnect function will go ahead and close the resources of<br>the client making sure that it has safely disconnected and output debug information.&nbsp;<div><div><br><div>2)<br>Clients don&#39;t crash upon server Disconnection/ termination because the clients.java file can be<br>run standalone. This means that the clients can run even without being connected<br>to the server, however, they are very limited. Because most of the features<br>revolve around being connected to the server, the client checks its connection status<br>to the server via the isConnected function. Should the connection fail then the<br>client will call the disconnect function which will clean up after itself and<br>close all its resources in order to lower the garbage collection.&nbsp;</div><div><br></div><div>3) The Server<br>doesn&#39;t crash from the client disconnecting because the server checks whether a client<br>disconnects from various commands such as process command and when broadcasting. If a<br>client were to have to disconnect the server will call the close function<br>in which it will close all the resources that the client had and<br>clean up after it in order to mitigate garbage collection. In addition, a<br>client can also choose to disconnect themselves from the server in which case<br>the server will then clean up after them however this time it will<br>happen as a command from the client. The server will continue to listen<br>for new connections even after a client disconnects.</div></div></div><br></li><br></ol><br></td></tr>
</table></td></tr>
<table><tr><td> <em>Deliverable 4: </em> Misc </td></tr><tr><td><em>Status: </em> <img width="100" height="20" src="http://via.placeholder.com/400x120/009955/fff?text=Complete"></td></tr>
<tr><td><table><tr><td> <em>Sub-Task 1: </em> Add the pull request for this branch</td></tr>
<tr><td> <a rel="noreferrer noopener" target="_blank" href="https://github.com/Darez26/IT114-450/pull/11">https://github.com/Darez26/IT114-450/pull/11</a> </td></tr>
</table></td></tr>
<table><tr><td><em>Grading Link: </em><a rel="noreferrer noopener" href="https://learn.ethereallab.app/homework/IT114-450-M22/it114-milestone1/grade/dj26" target="_blank">Grading</a></td></tr></table>