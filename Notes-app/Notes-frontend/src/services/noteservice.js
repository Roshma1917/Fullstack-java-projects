const API_URL = "http://localhost:8080/api/notes";

export async function getNotes() {
  const response = await fetch(API_URL);
  return response.json();
}

export async function createNote(note) {
  const response = await fetch(API_URL, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(note),
  });

  return response.json();
}

export async function deleteNote(id) {
  await fetch(`${API_URL}/${id}`, {
    method: "DELETE",
  });
}