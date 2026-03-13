import { Box, Button, Typography } from '@mui/material';
import Link from 'next/link';

export default function AdminPage() {
  return <Box p={4}><Typography variant='h4'>Admin Dashboard</Typography><Box mt={2} display='flex' gap={2}>
    <Button component={Link} href='/admin/offices' variant='contained'>Offices</Button>
    <Button component={Link} href='/admin/users' variant='contained'>Users</Button>
    <Button component={Link} href='/admin/reports' variant='contained'>Reports</Button>
  </Box></Box>;
}
