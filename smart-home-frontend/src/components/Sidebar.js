import React from 'react';
import './css/Sidebar.css';

const Sidebar = () => {
  return (
    <div className="sidebar">
      <h2>Smart Home</h2>
      <ul>
        <li><a href="#">Dashboard</a></li>
        <li><a href="#">Lights</a></li>
        <li><a href="#">Thermostat</a></li>
        <li><a href="#">Security</a></li>
        <li><a href="#">Settings</a></li>
      </ul>
    </div>
  );
};

export default Sidebar;
