import { cookies } from 'next/headers';
import { SessionUser } from './auth-types';

export async function getSessionUser(): Promise<SessionUser | null> {
  const token = cookies().get('token')?.value;
  const userRaw = cookies().get('user')?.value;
  if (!token || !userRaw) return null;
  try { return JSON.parse(userRaw) as SessionUser; } catch { return null; }
}
