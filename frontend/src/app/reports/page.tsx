import { Box, Typography } from '@mui/material';
import { ReportForm } from '@/forms/ReportForm';
import { createReport, fetchReports } from '@/services/report-service';
import { ReportsTable } from '@/tables/ReportsTable';
import { cookies } from 'next/headers';
import { revalidatePath } from 'next/cache';

async function create(formData: FormData) {
  'use server';
  const token = cookies().get('token')?.value ?? '';
  await createReport(token, String(formData.get('content') ?? ''));
  revalidatePath('/reports');
}

export default async function ReportsPage() {
  const token = cookies().get('token')?.value ?? '';
  const user = JSON.parse(cookies().get('user')?.value ?? '{}');
  const reports = await fetchReports(token);
  return <Box p={4} display='grid' gap={3}><Typography variant='h5'>Reports Dashboard</Typography>
    <ReportForm officeName={`Office ${user.officeId ?? ''}`} action={create} />
    <ReportsTable rows={reports} />
  </Box>;
}
