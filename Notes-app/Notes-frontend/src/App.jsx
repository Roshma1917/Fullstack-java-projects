import { useEffect, useState } from "react";

import NoteForm from "./components/NoteForm";
import NoteCard from "./components/NoteCard";

import {
  getNotes,
  createNote,
  deleteNote,
} from "./services/noteService";

function App() {

  const [notes, setNotes] = useState([]);

  useEffect(() => {
    loadNotes();
  }, []);

  async function loadNotes() {
    const data = await getNotes();
    setNotes(data);
  }

  async function handleAdd(note) {
    await createNote(note);
    loadNotes();
  }

  async function handleDelete(id) {
    await deleteNote(id);
    loadNotes();
  }

  return (
    <div className="container">

      <h1>My Notes</h1>

      <NoteForm onAdd={handleAdd} />

      {notes.map((note) => (
        <NoteCard
          key={note.id}
          note={note}
          onDelete={handleDelete}
        />
      ))}

    </div>
  );
}

export default App;