import React from 'react';
import './css/Dashboard.css';
import Card from './Card';

const Dashboard = () => {
  return (
    <div className="dashboard">
      <div className="overview">
        <h2>Overview</h2>
        {/* Add overview data here */}
      </div>
      <div className="cards">
        <Card title="Temperature" value="22°C" />
        <Card title="Humidity" value="55%" />
        <Card title="Air Quality" value="Good" />
        <Card title="Energy Consumption" value="1.2kWh" />
      </div>
    </div>
  );
};

export default Dashboard;
