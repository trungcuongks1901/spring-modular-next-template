import { ReportsTable } from '@/tables/ReportsTable';
import { fetchReports } from '@/services/report-service';
import { cookies } from 'next/headers';
import { Box, Typography } from '@mui/material';

export default async function AdminReportsPage() {
  const token = cookies().get('token')?.value ?? '';
  const reports = await fetchReports(token);
  return <Box p={4}><Typography variant='h5' mb={2}>Report List</Typography><ReportsTable rows={reports} /></Box>;
}
