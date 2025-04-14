<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>🔔 실시간 알림</title>
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client/dist/sockjs.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/stompjs/lib/stomp.min.js"></script>
</head>
<body>
    <h1>🔔 실시간 알림</h1>
    <ul id="notificationList"></ul>

    <script>
        function loadNotifications() {
            fetch('/notifications/EMP001')
                .then(response => response.json())
                .then(data => {
                    let notificationList = document.getElementById("notificationList");
                    notificationList.innerHTML = "";
                    data.forEach(notification => {
                        notificationList.innerHTML += `<li>${notification.sj} - ${notification.cn} 
                            <button onclick="markAsRead(${notification.ntcnNo})">읽음</button>
                            <button onclick="deleteNotification(${notification.ntcnNo})">삭제</button></li>`;
                    });
                });
        }

        function markAsRead(ntcnNo) {
            fetch(`/notifications/read/${ntcnNo}`, { method: "PUT" })
                .then(() => loadNotifications());
        }

        function deleteNotification(ntcnNo) {
            fetch(`/notifications/delete/${ntcnNo}`, { method: "DELETE" })
                .then(() => loadNotifications());
        }

        var socket = new SockJS('/ws-message');
        var stompClient = Stomp.over(socket);

        stompClient.connect({}, function(frame) {
            stompClient.subscribe('/user/queue/notifications', function(notification) {
                alert("🔔 새 알림: " + JSON.parse(notification.body).sj);
                loadNotifications();
            });
        });

        window.onload = loadNotifications;
    </script>
</body>
</html>
