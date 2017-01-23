// get websocket class, firefox has a different way to get it
var WS = window['MozWebSocket'] ? window['MozWebSocket'] : WebSocket;

var socket = new WS('ws://localhost:9000/websocket');

$(document).ready(function () {
 
    socket.onmessage = handleMessage;
    socket.onclose = function () {console.log("socket schließt..")};
    var gamefield = document.getElementById('gamefield');
    var poly_gamefield = document.createElement('battleship-gamefield');
    gamefield.appendChild(poly_gamefield);
});

var messageType = {
        CHAT: "CHAT",
        PLAYERNAME: "PLAYERNAME",
        // HIT and MISS
        HIT: "HIT",
        MISS: "MISS",
        // INVALID
        WRONGINPUT: "WRONGINPUT",
        PLACEERR: "PLACEERR",
        WAIT: "WAIT",
        START: "START",
        // PLACE
        PLACE1: "PLACE1",
        PLACE2: "PLACE2",
        FINALPLACE1: "FINALPLACE1",
        FINALPLACE2: "FINALPLACE2",
        // SHOOT
        SHOOT1: "SHOOT1",
        SHOOT2: "SHOOT2",
        // WIN
        WIN1: "WIN1",
        WIN2: "WIN2",
    };

var handleMessage = function handleMessage(message) {
    var msg = JSON.parse(message.data);
        console.log("Message %o received", msg);
        switch (msg.type) {
            case messageType.CHAT: displayChatMessage(message); break;
            case messageType.PLAYERNAME: getPlayerName(); break;
            default: break;
        }
};

function chat() {
    var chatPrefix = "CHAT ";
    var text = document.getElementById('chatInput').value;
    document.getElementById('chatInput').value = "";
    console.log("sending message: " + text);
    socket.send(chatPrefix + text);
}

function displayChatMessage(message) {
    var msg = JSON.parse(message.data);
    var date = new Date();
    var charView = document.getElementById('chatView');
    chatView.append ("[" + date.getHours() + ":" + date.getMinutes() + "] " + msg.sender + ": " + msg.message + "\n");
}

function fillField() {

    
}

function getPlayerName() {
    var playername = prompt("Please enter your name", "");
    socket.send("PLAYERNAME " + playername);
}

