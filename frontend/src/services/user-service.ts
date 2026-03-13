import apiClient from './api-client';
import { User } from '@/types/user';

export async function fetchUsers(token: string): Promise<User[]> {
  const res = await apiClient.get('/users', { headers: { Authorization: `Bearer ${token}` } });
  return res.data;
}
