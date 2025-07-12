// ✅ Declare this at the top
const API_URL = "https://employee-management-system-toox.onrender.com/api/employees";

let editingEmployeeId = null;

// ✅ Call fetch on page load
window.onload = fetchEmployees;

function fetchEmployees() {
  fetch(API_URL)
    .then(res => res.json())
    .then(data => {
      const tbody = document.getElementById("employeeTableBody");
      tbody.innerHTML = "";
      data.forEach(emp => {
        const row = `
          <tr>
            <td>${emp.id}</td>
            <td>${emp.firstName}</td>
            <td>${emp.lastName}</td>
            <td>${emp.email}</td>
            <td>
              <button onclick="loadEmployeeForEdit(${emp.id})">Update</button>
              <button onclick="deleteEmployee(${emp.id})">Delete</button>
            </td>
          </tr>
        `;
        tbody.insertAdjacentHTML("beforeend", row);
      });
    });
}


function showForm() {
  document.getElementById("formContainer").style.display = "block";
}

function hideForm() {
  document.getElementById("formContainer").style.display = "none";
  clearForm();
}

function clearForm() {
  document.getElementById("firstName").value = "";
  document.getElementById("lastName").value = "";
  document.getElementById("email").value = "";
  editingEmployeeId = null;
  document.getElementById("formTitle").innerText = "Add Employee";
  document.getElementById("submitBtn").innerText = "Submit";
}

function submitEmployee() {
  const employee = getFormData();
  if (!employee) return;

  if (editingEmployeeId) {
    updateEmployee(employee);
  } else {
    createEmployee(employee);
  }
}

function getFormData() {
  const firstName = document.getElementById("firstName").value.trim();
  const lastName = document.getElementById("lastName").value.trim();
  const email = document.getElementById("email").value.trim();

  if (!firstName || !lastName || !email) {
    alert("All fields are required!");
    return null;
  }

  return { firstName, lastName, email };
}

function createEmployee(emp) {
  fetch(API_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(emp),
  })
    .then(res => {
      if (!res.ok) throw new Error("Failed to add");
      return res.json();
    })
    .then(() => {
      alert("Employee added");
      fetchEmployees();
      hideForm();
    })
    .catch(err => alert("Add failed: " + err.message));
}

function updateEmployee(emp) {
  fetch(`${API_URL}/${editingEmployeeId}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(emp),
  })
    .then(res => {
      if (!res.ok) throw new Error("Failed to update");
      return res.json();
    })
    .then(() => {
      alert("Employee updated");
      fetchEmployees();
      hideForm();
    })
    .catch(err => alert("Update failed: " + err.message));
}

function loadEmployeeForEdit(id) {
  fetch(`${API_URL}/${id}`)
    .then(res => res.json())
    .then(emp => {
      document.getElementById("firstName").value = emp.firstName;
      document.getElementById("lastName").value = emp.lastName;
      document.getElementById("email").value = emp.email;

      editingEmployeeId = id;
      document.getElementById("formTitle").innerText = "Update Employee";
      document.getElementById("submitBtn").innerText = "Update";
      showForm();
    })
    .catch(err => alert("Failed to load employee: " + err.message));
}

function deleteEmployee(id) {
  if (!confirm("Are you sure to delete?")) return;

  fetch(`${API_URL}/${id}`, { method: "DELETE" })
    .then(res => {
      if (!res.ok) throw new Error("Delete failed");
      fetchEmployees();
    })
    .catch(err => alert("Delete failed: " + err.message));
}

function cancelEdit() {
  hideForm();
}
