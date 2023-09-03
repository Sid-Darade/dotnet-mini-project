import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import axios from 'axios';
import { toast,ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function EditEmployee() {
  const { id } = useParams(); // Get the ID from the URL
  const [employeeData, setEmployeeData] = useState({
    id: id, // Initialize with the ID from the URL
    name: '',
    basic: '',
    deptNo: '',
  });

  useEffect(() => {
    // Fetch the existing employee data by ID
    axios
      .get(`http://localhost:5174/Employees/${id}`)
      .then((response) => {
        setEmployeeData(response.data); // Set the employee data in the state
      })
      .catch((error) => {
        console.error('Error fetching employee data:', error);
      });
  }, [id]); // Fetch data when the ID changes

  const handleChange = (e) => {
    const { name, value } = e.target;
    setEmployeeData({
      ...employeeData,
      [name]: value,
    });
  };

  const navigate = useNavigate(); // Get the navigate function

  const handleSubmit = (e) => {
    e.preventDefault();
    // Send a PUT request with Axios to update the employee data
    axios
      .put(`http://localhost:5174/Employees/${id}`, employeeData)
      .then((response) => {
        console.log('Employee updated:', response.data);
        if (response.status === 200) {
          // Employee added successfully
          console.log('Employee updated successfully!');
          toast.success('Employee updated successfully!', {
            position: toast.POSITION.TOP_RIGHT,
          });
        // Use the navigate function to redirect to the employee's details page or another appropriate page
        navigate(`/`);
      } else {
        // Handle other response status codes if needed
        console.error('Unexpected response status:', response.status);
      }
    })
    .catch((error) => {
      console.error('Error updating employee:', error);
      toast.error('Error updating employee. Please try again.', {
        position: toast.POSITION.TOP_RIGHT,
      });
    });
     
  };

  return (
    <div className='container'>
      <h2>Edit Employee</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Employee ID:
          <input
            type="text"
            name="id"
            value={employeeData.id}
            onChange={handleChange}
            //disabled // Disable editing of ID
          />
        </label>
        <br />
        <label>
          Name:
          <input
            type="text"
            name="name"
            value={employeeData.name}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Basic:
          <input
            type="text"
            name="basic"
            value={employeeData.basic}
            onChange={handleChange}
          />
        </label>
        <br />
        <label>
          Department:
          <input
            type="text"
            name="deptNo"
            value={employeeData.deptNo}
            onChange={handleChange}
          />
        </label>
        <br />
        <button type="submit">Update Employee</button>
      </form>
      <ToastContainer />
    </div>
  );
}

export default EditEmployee;




