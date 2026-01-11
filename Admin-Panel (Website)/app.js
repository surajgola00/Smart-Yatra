const BASE_URL = "API_BASE_URL"; // Replace with actual API base URL
let map;
const userLayers = {};
const colors = ["#A03BD9", "#5859DF", "#DF48C9", "#5FE4DE", "#FA6981", "#FF963C"];
let colorIndex = 0;

window.onload = () => {
  map = L.map("map").setView([28.6139, 77.2090], 12);
  L.tileLayer("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png", {
    attribution: "© OpenStreetMap contributors"
  }).addTo(map);
  loadUsers();
  setInterval(refreshActiveUsers, 5000);
};

async function loadUsers() {
  try {
    const res = await fetch(`${BASE_URL}/users`);
    if (!res.ok) throw new Error("Failed to fetch users");
    const users = await res.json();
    renderUserList(users);
  } catch (err) {
    document.getElementById("user-list").innerHTML =
      `<p style="color:#FA6981;font-weight:bold;">Error loading users</p>`;
    console.error(err);
  }
}

// Render user names as checkboxes, use user_id for location fetch
function renderUserList(users) {
  const listDiv = document.getElementById("user-list");
  listDiv.innerHTML = "";
  users.forEach(u => {
    const userId = u.user_id;
    const name = u.name;
    const div = document.createElement("div");
    div.className = "user-item";
    div.innerHTML = `
      <input type="checkbox" id="chk-${userId}">
      <label for="chk-${userId}">${name}</label>
    `;
    listDiv.appendChild(div);
    document.getElementById(`chk-${userId}`).addEventListener("change", e => {
      toggleUser(userId, e.target.checked, name);
    });
  });
}

// Updated to pass name for popup
async function toggleUser(userId, checked, name) {
  if (checked) {
    if (!userLayers[userId]) {
      userLayers[userId] = { color: colors[colorIndex++ % colors.length], name: name };
    }
    await updateUserLayer(userId); // load immediately
  } else {
    removeUserLayers(userId);
  }
}

// Show user name in popup, use user_id for request
async function updateUserLayer(userId) {
  try {
    const res = await fetch(`${BASE_URL}/location/history/${userId}`);
    if (!res.ok) throw new Error("Failed to fetch history");
    const history = await res.json();
    if (!Array.isArray(history) || history.length === 0) return;
    if (userLayers[userId].polyline) map.removeLayer(userLayers[userId].polyline);
    if (userLayers[userId].marker) map.removeLayer(userLayers[userId].marker);
    const path = history.map(p => [p.latitude, p.longitude]);
    const color = userLayers[userId].color;
    const name = userLayers[userId].name;
    const polyline = L.polyline(path, { color, weight: 5, opacity: 0.85 }).addTo(map);
    const marker = L.circleMarker(path[path.length - 1], { color, radius: 10, fillOpacity: 0.9 })
      .addTo(map)
      .bindPopup(`<strong>${name}</strong> (latest)`);
    userLayers[userId].polyline = polyline;
    userLayers[userId].marker = marker;
    map.fitBounds(polyline.getBounds());
  } catch (err) {
    console.error(err);
  }
}

function refreshActiveUsers() {
  Object.keys(userLayers).forEach(userId => {
    const chk = document.getElementById(`chk-${userId}`);
    if (chk && chk.checked) {
      updateUserLayer(userId);
    }
  });
}
function removeUserLayers(userId) {
  if (userLayers[userId]) {
    if (userLayers[userId].polyline) map.removeLayer(userLayers[userId].polyline);
    if (userLayers[userId].marker) map.removeLayer(userLayers[userId].marker);
    delete userLayers[userId];
  }
}