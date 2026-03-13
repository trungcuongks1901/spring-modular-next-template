import { OfficesTable } from '@/tables/OfficesTable';
import { fetchOffices } from '@/services/office-service';
import { cookies } from 'next/headers';
import { Box, Typography } from '@mui/material';

export default async function OfficesPage() {
  const token = cookies().get('token')?.value ?? '';
  const offices = await fetchOffices(token);
  return <Box p={4}><Typography variant='h5' mb={2}>Office Management</Typography><OfficesTable rows={offices} /></Box>;
}
