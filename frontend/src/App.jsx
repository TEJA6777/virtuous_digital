import { useEffect, useState } from "react";

function App() {
  const [students, setStudents] = useState([]);

  const [form, setForm] = useState({
    studentName: "",
    collegeName: "",
    round1Marks: "",
    round2Marks: "",
    round3Marks: "",
    technicalRoundMarks: ""
  });

  // Fetch all students
  const fetchStudents = async () => {
    const res = await fetch("http://localhost:8080/students");
    const data = await res.json();
    setStudents(data);
  };

  useEffect(() => {
    fetchStudents();
  }, []);

  // Handle form input
  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  // Submit form
  const handleSubmit = async (e) => {
    e.preventDefault();

    const res = await fetch("http://localhost:8080/students", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({
        ...form,
        round1Marks: Number(form.round1Marks),
        round2Marks: Number(form.round2Marks),
        round3Marks: Number(form.round3Marks),
        technicalRoundMarks: Number(form.technicalRoundMarks)
      })
    });

    if (res.ok) {
      fetchStudents();
      setForm({
        studentName: "",
        collegeName: "",
        round1Marks: "",
        round2Marks: "",
        round3Marks: "",
        technicalRoundMarks: ""
      });
    } else {
      alert("Error adding student");
    }
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Add Student</h2>

      <form onSubmit={handleSubmit}>
        <input name="studentName" placeholder="Student Name" value={form.studentName} onChange={handleChange} required />
        <br />

        <input name="collegeName" placeholder="College Name" value={form.collegeName} onChange={handleChange} required />
        <br />

        <input type="number" name="round1Marks" placeholder="Round 1 (0-10)" value={form.round1Marks} onChange={handleChange} required />
        <br />

        <input type="number" name="round2Marks" placeholder="Round 2 (0-10)" value={form.round2Marks} onChange={handleChange} required />
        <br />

        <input type="number" name="round3Marks" placeholder="Round 3 (0-10)" value={form.round3Marks} onChange={handleChange} required />
        <br />

        <input type="number" name="technicalRoundMarks" placeholder="Technical (0-20)" value={form.technicalRoundMarks} onChange={handleChange} required />
        <br /><br />

        <button type="submit">Add Student</button>
      </form>

      <hr />

      <h2>Student List</h2>

      <table border="1" cellPadding="8">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>College</th>
            <th>Total</th>
            <th>Result</th>
            <th>Rank</th>
          </tr>
        </thead>
        <tbody>
          {students.map((s) => (
            <tr key={s.id}>
              <td>{s.id}</td>
              <td>{s.studentName}</td>
              <td>{s.collegeName}</td>
              <td>{s.totalMarks}</td>
              <td>{s.result}</td>
              <td>{s.rank}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;
