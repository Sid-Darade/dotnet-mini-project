import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import axios from 'axios';
import { toast,ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function DeleteEmployee() {
  const { id } = useParams(); // Get the ID from the URL
  const [employeeData, setEmployeeData] = useState({});
  const navigate = useNavigate(); // Get the navigate function

  useEffect(() => {
    // Fetch the existing employee data by ID
    axios
      .get(`http://localhost:5174/Employees/${id}`)
      .then((response) => {
        setEmployeeData(response.data);
      })
      .catch((error) => {
        console.error('Error fetching employee data:', error);
      });
  }, [id]);

  const handleDelete = () => {
    // Send a DELETE request to delete the employee
    axios
      .delete(`http://localhost:5174/Employees/${id}`)
      .then((response) => {
        console.log('Employee deleted:', response.data);
        if (response.status === 200) {
            // Employee deleted successfully
            console.log('Employee deleted successfully!');
            toast.success('Employee deleted successfully!', {
              position: toast.POSITION.TOP_RIGHT,
            });

        // Redirect to the employee list or another appropriate page
        navigate('/');
    } else {
        // Handle other response status codes if needed
        console.error('Unexpected response status:', response.status);
      }
      })
      .catch((error) => {
        console.error('Error deleting employee:', error);
        toast.error('Error deleting employee. Please try again.', {
            position: toast.POSITION.TOP_RIGHT,
          });
      });
  };

  return (
    <div className='container'>
      <h2>Delete Employee</h2>
      <p>Are you sure you want to delete this employee?</p>
      <p>Employee Id: {id}</p>
      <p>Name: {employeeData.name}</p>
      <p>Email: {employeeData.basic}</p>
      <p>Department: {employeeData.deptNo}</p>
      <button type="submit" onClick={handleDelete}>Delete Employee</button>
      <ToastContainer />
    </div>
  );
}

export default DeleteEmployee;
