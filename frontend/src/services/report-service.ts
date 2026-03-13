import apiClient from './api-client';
import { Report } from '@/types/report';

export async function fetchReports(token: string): Promise<Report[]> {
  const res = await apiClient.get('/reports', { headers: { Authorization: `Bearer ${token}` } });
  return res.data;
}

export async function createReport(token: string, content: string) {
  await apiClient.post('/reports', { content }, { headers: { Authorization: `Bearer ${token}` } });
}
