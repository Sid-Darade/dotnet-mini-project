import React from 'react';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import HomePage from './Components/HomePage';
import AddEmployee from './Components/AddEmployee';
import EditEmployee from './Components/EditEmployee';
import DeleteEmployee from './Components/DeleteEmployee';
import './Navbar.css';
import './tabledata.css';
import './addEmp.css';

function App() {
  return (
   
      <div className="App">
        <nav className="navbar">
          <ul className="navbar-list">
            <li className="navbar-item">
              <Link  className="navbar-link" to="/">Home</Link>
            </li>
            <li className="navbar-item">
              <Link className="navbar-link" to="/add">Add Employee</Link>
            </li>
            <li className="navbar-item">
              <Link className="navbar-link" to="/edit/:id">Edit Employee</Link>
            </li>
            <li className="navbar-item">
              <Link className="navbar-link" to="/delete/:id">Delete Employee</Link>
            </li>
          </ul>
        </nav>

        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/add" element={<AddEmployee />} />
          <Route path="/edit/:id" element={<EditEmployee />} />
          <Route path="/delete/:id" element={<DeleteEmployee />} />
          
        </Routes>
      </div>
    
  );
}

export default App;


