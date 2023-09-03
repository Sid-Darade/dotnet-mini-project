import React, { useState } from 'react';
import axios from 'axios'; // Import Axios
import { toast,ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
//import from './addEmp.css';


function AddEmployee() {
  const [employeeData, setEmployeeData] = useState({
    empNo:'',
    name: '',
    basic: '',
    deptNo: '',
    
  });

  {/* const handleEmpNoChange = (e) => {
    const value = e.target.value;
    setEmployeeData({
      ...employeeData,
      empNo: value,
    });
  };  */}

  const handleChange = (e) => {
    const { name, value } = e.target;
    setEmployeeData({
      ...employeeData,
      [name]: value,
    });
  };
  

  const handleSubmit = (e) => {
    e.preventDefault();
    // Send a POST request with Axios
    axios
      .post('http://localhost:5174/Employees', employeeData)
      .then((response) => {
        console.log('Employee added:', response.data);
        if (response.status === 200) {
          // Employee added successfully
          console.log('Employee added successfully!');
          toast.success('Employee added successfully!', {
            position: toast.POSITION.TOP_RIGHT,
          });
        // Reset the form after successful submission
        setEmployeeData({
          empNo:'',
          name: '',
          basic: '',
          deptNo: '',
        });
      } else {
        // Handle other response status codes if needed
        console.error('Unexpected response status:', response.status);
      }
    })
      .catch((error) => {
        console.error('Error adding employee:', error);
        toast.error('Error adding employee. Please try again.', {
          position: toast.POSITION.TOP_RIGHT,
        });
      });
  };

  return (
    <div className='container'>
      <h2>Add Employee</h2>
      <form onSubmit={handleSubmit}>
      <label>
          Employee Id:
          <input
            type="text"
            name="empNo"
            value={employeeData.empNo}
            onChange={handleChange}
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
        
        <button type="submit">Add Employee</button>
      </form>
      <ToastContainer />
    </div>
  );
}

export default AddEmployee;
