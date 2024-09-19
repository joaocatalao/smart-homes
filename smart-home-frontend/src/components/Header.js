import React from 'react';
import './css/Header.css'; // Import the CSS file for styling

const Header = () => {
  return (
    <header className="header">
      <nav className="nav">
        <div className="logo">
          <h1>Smart Home</h1>
        </div>
        <ul className="nav-links">
          <li><a href="#">Dashboard</a></li>
          <li><a href="#">Lights</a></li>
          <li><a href="#">Thermostat</a></li>
          <li><a href="#">Security</a></li>
          <li><a href="#">Settings</a></li>
        </ul>
      </nav>
    </header>
  );
};

export default Header;
