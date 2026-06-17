function NoteCard({ note, onDelete }) {
  return (
    <div className="card">
      <h3>{note.title}</h3>

      <p>{note.content}</p>

      <button
        onClick={() => onDelete(note.id)}
        style={{ backgroundColor: "#e74c3c" }}
      >
        Delete
      </button>
    </div>
  );
}

export default NoteCard;