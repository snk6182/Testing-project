async function loadDashboard() {
    const table = document.getElementById("serviceTable");

    try {
        const response = await fetch("/api/dashboard");

        if (!response.ok) {
            throw new Error("API request failed");
        }

        const data = await response.json();

        document.getElementById("environment").textContent = data.environment;
        document.getElementById("version").textContent = data.version;
        document.getElementById("serviceCount").textContent = data.services.length;
        document.getElementById("status").textContent = data.overallStatus;

        table.innerHTML = data.services.map(service => `
            <tr>
                <td><strong>${service.name}</strong></td>
                <td><span class="status-up">● ${service.status}</span></td>
                <td>${service.version}</td>
                <td>${service.uptime}</td>
            </tr>
        `).join("");
    } catch (error) {
        table.innerHTML = `
            <tr>
                <td colspan="4" class="loading">
                    Unable to load dashboard data.
                </td>
            </tr>`;
    }
}

loadDashboard();
