function fetchRooms() {
    fetch('/chat/rooms')
        .then(res => res.json())
        .then(rooms => {
            const listDiv = document.getElementById('chat-room-list');
            listDiv.innerHTML = ''; // 기존 목록 초기화
            rooms.forEach(room => {
                const card = document.createElement('div');
                card.className = 'card';
                card.innerHTML = `<h3>${room.roomName}</h3>
                                  <p>Participants: ${room.participantCount}</p>
                                  <button onclick="joinRoom('${room.roomId}', '${room.roomName}')">Join</button>`;
                listDiv.appendChild(card);
            });
        })
        .catch(err => console.error(err));
}

document.addEventListener('DOMContentLoaded', () => {
    fetchRooms();
    setInterval(fetchRooms, 5000);
});

function joinRoom(roomId, roomName) {
    window.location.href = `chat-room.html?roomId=${roomId}&roomName=${encodeURIComponent(roomName)}`;
}
