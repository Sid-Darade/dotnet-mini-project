import React, { useState, useEffect } from 'react';
import axios from 'axios'; // Import Axios

function HomePage() {
  const [employeeList, setEmployeeList] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    // Send a GET request to fetch employee data with Axios
    axios
      .get('http://localhost:5174/Employees')
      .then((response) => {
        setEmployeeList(response.data);
        setIsLoading(false); // Set loading state to false once data is fetched
      })
      .catch((error) => {
        console.error('Error fetching employee data:', error);
        setIsLoading(false); 
      });
  }, []);

  if (isLoading) {
    return <div>Loading...</div>;
  }

  return (
    <div className="home-page">
      <h1 className="page-title">Welcome to the Employee Management System</h1>
      <div className="employee-list">
        <h2>Employee List</h2>
        <table className="employee-table">
          <thead>
            <tr>
              <th>Employee Id</th>
              <th>Name</th>
              <th>Basic</th>
              <th>Department</th>
            </tr>
          </thead>
          <tbody>
            {employeeList.map((employee) => (
              <tr key={employee.empNo}>
                <td>{employee.empNo}</td>
                <td>{employee.name}</td>
                <td>{employee.basic}</td>
                <td>{employee.deptNo}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default HomePage;

