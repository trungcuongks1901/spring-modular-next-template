import { UsersTable } from '@/tables/UsersTable';
import { fetchUsers } from '@/services/user-service';
import { cookies } from 'next/headers';
import { Box, Typography } from '@mui/material';

export default async function UsersPage() {
  const token = cookies().get('token')?.value ?? '';
  const users = await fetchUsers(token);
  return <Box p={4}><Typography variant='h5' mb={2}>User Management</Typography><UsersTable rows={users} /></Box>;
}
