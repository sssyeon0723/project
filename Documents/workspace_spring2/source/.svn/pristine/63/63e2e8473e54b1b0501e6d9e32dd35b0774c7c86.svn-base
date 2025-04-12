<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>📩 실시간 쪽지 & 알림 시스템</title>
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client/dist/sockjs.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/stompjs/lib/stomp.min.js"></script>
</head>
<body>
    <h1>📨 실시간 쪽지</h1>
    <input type="text" id="receiver" placeholder="받는 사람 사원 코드">
    <input type="text" id="messageInput" placeholder="메시지 입력">
    <button onclick="sendMessage()">보내기</button>

    <h2>📩 받은 쪽지</h2>
    <ul id="messageList"></ul>

    <script>
        var loggedInEmpCode = "EMP001"; // 하드코딩된 발신자

        var socket = new SockJS('/ws-message');
        var stompClient = Stomp.over(socket);

        stompClient.connect({}, function(frame) {
            stompClient.subscribe('/user/queue/messages', function(message) {
                var msg = JSON.parse(message.body);
                var messageList = document.getElementById("messageList");
                var newMessage = document.createElement("li");
                newMessage.innerText = "💌 [보낸 사람: " + msg.dsptcher + "] " + msg.cn;
                messageList.appendChild(newMessage);
            });

            stompClient.subscribe('/user/queue/notifications', function(notification) {
                var noti = JSON.parse(notification.body);
                alert("🔔 새 알림: " + noti.sj + " - " + noti.cn);
            });
        });

        function sendMessage() {
            var receiver = document.getElementById("receiver").value;
            var content = document.getElementById("messageInput").value;

            if (!receiver || !content) {
                alert("수신자와 메시지를 입력하세요!");
                return;
            }

            var message = {
                dsptcher: loggedInEmpCode,  // 발신자 (하드코딩)
                rcver: receiver,            // 수신자 사원 코드
                cn: content                 // 메시지 내용
            };

            stompClient.send("/app/sendMessage", {}, JSON.stringify(message));
            document.getElementById("messageInput").value = "";
            alert("메시지가 전송되었습니다!");
        }
    </script>
</body>
</html>
