export type Role = 'ADMIN' | 'OFFICE';

export interface SessionUser {
  userId: number;
  role: Role;
  officeId?: number;
  username: string;
}
