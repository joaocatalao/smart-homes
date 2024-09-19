import React, { useEffect, useState } from 'react';
import axios from 'axios';

const DeviceControl = () => {
  const [devices, setDevices] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/devices')
      .then(response => {
        setDevices(response.data);
      })
      .catch(error => {
        console.error('Error fetching devices:', error);
      });
  }, []);

  return (
    <div>
      <h2>Device Controls</h2>
      {/* Render device controls here */}
    </div>
  );
};

export default DeviceControl;
