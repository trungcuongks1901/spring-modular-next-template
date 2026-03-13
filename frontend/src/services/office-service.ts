import apiClient from './api-client';
import { Office } from '@/types/office';

export async function fetchOffices(token: string): Promise<Office[]> {
  const res = await apiClient.get('/offices', { headers: { Authorization: `Bearer ${token}` } });
  return res.data;
}
