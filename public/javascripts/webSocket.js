// get websocket class, firefox has a different way to get it
var WS = window['MozWebSocket'] ? window['MozWebSocket'] : WebSocket;



var socket = new WS(getSocketAddress());

console.log(socket);

var isPlayerOne;

var matrix = [];

for(var i = 0; i < 10; i++) {
    matrix[i] = new Array(10);
}

$(document).ready(function () {
 
    socket.onmessage = handleMessage;
    socket.onclose = function () {console.log("socket schließt..")};
    var gamefield = document.getElementById('gamefield');
    for (var count = 0; count < 10; count++) {
        var row = document.createElement('div');
        row.setAttribute("class", "row");
        row.setAttribute("id", "row#" + count);
        
        var border1 = document.createElement('div');
        border1.setAttribute("class", "col-md-2 text-right");
        
        var border2 = document.createElement('div');
        border2.setAttribute("class", "col-md-2 text-right");
        
        var field = document.createElement('div');
        field.setAttribute("class", "col-md-8 text-center");
        
        for (var bCount = 0; bCount < 10; bCount++) {
            var button = document.createElement('gamefield-button');
            button.setAttribute("color", "O");
            matrix [count][bCount] = button;
            field.appendChild(button);
        }
        
        row.appendChild(border1);
        row.appendChild(field);
        row.appendChild(border2);
        gamefield.appendChild(row);
    }
    
    var menu = document.getElementById('menu');
    var menuitem = document.createElement('li');
    var link = document.createElement('a');
    link.innerHTML = "Restart Game";
    link.setAttribute("onClick", function(){socket.send("RESTART");});
    menuitem.appendChild(link);
    menu.appendChild(menuitem);
    
    //Chat mit Enter bestätigen
    $('#chatInput').keypress(function(key) {
        if (key.which == 13) {
            chat();
        }
    });
    
    Polymer.updateStyles();
    
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
            case messageType.CHAT: 
                displayChatMessage(message);
                break;
            case messageType.PLAYERNAME: 
                getPlayerName(); 
                break;
            case messageType.PLACE1: 
            case messageType.PLACE2:
                fillField(msg.boardmap);
                setPlaceFunction();
                break;
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
    var hours = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours());
    var minutes = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes());
    var charView = document.getElementById('chatView');
    chatView.append ("[" + hours + ":" + minutes + "] " + msg.sender + ": " + msg.message + "\n");
}

function fillField(boardmap) {
    for(var row = 0; row < matrix.length; row++) {
       for (var col = 0; col < matrix.length; col++) {
            matrix[row][col].setAttribute("color", boardmap[row][col]);
       }
    }
    Polymer.updateStyles();
}

function setPlaceFunction() {
   for(var row = 0; row < matrix.length; row++) {
       for (var col = 0; col < matrix.length; col++) {
           matrix[row][col].onclick = placeShip(row, col, " true");
       }
   }
}

function placeShip(row, col, orientation) {
    return function (row, col, orientation) {
        socket.send("" + row + " " + col + orientation);
    };
}


function getPlayerName() {
    var playername = prompt("Please enter your name", "");
    socket.send("PLAYERNAME " + playername);
}

function getSocketAddress() {
    var socketAddress = window.location.origin.replace("http", "ws");
    return socketAddress + "/websocket";
}
