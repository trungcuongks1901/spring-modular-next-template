'use server';

import apiClient from '@/services/api-client';
import { cookies } from 'next/headers';
import { redirect } from 'next/navigation';

function decodeJwt(token: string): any {
  const payload = token.split('.')[1];
  return JSON.parse(Buffer.from(payload, 'base64url').toString('utf8'));
}

export async function loginAction(_: unknown, formData: FormData) {
  const username = formData.get('username') as string;
  const password = formData.get('password') as string;
  const response = await apiClient.post('/auth/login', { username, password });
  const token = response.data.token as string;
  const claims = decodeJwt(token);
  cookies().set('token', token, { httpOnly: true, sameSite: 'lax', path: '/' });
  cookies().set('user', JSON.stringify({ userId: claims.userId, role: claims.role, officeId: claims.officeId, username }), { httpOnly: true, sameSite: 'lax', path: '/' });
  redirect(claims.role === 'ADMIN' ? '/admin' : '/reports');
}
