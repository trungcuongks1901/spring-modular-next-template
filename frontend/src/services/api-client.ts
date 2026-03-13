import axios from 'axios';

const apiClient = axios.create({
  baseURL: process.env.BACKEND_URL ?? 'http://localhost:8080',
  withCredentials: true
});

export default apiClient;
