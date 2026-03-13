'use client';

import { Box, Button, Card, CardContent, TextField, Typography } from '@mui/material';

export function LoginForm({ action }: { action: (state: unknown, formData: FormData) => Promise<void> }) {
  return (
    <Card sx={{ maxWidth: 400, mx: 'auto', mt: 10 }}>
      <CardContent>
        <Typography variant='h5' mb={2}>Login</Typography>
        <Box component='form' action={action} display='grid' gap={2}>
          <TextField name='username' label='Username' required />
          <TextField name='password' label='Password' type='password' required />
          <Button type='submit' variant='contained'>Sign in</Button>
        </Box>
      </CardContent>
    </Card>
  );
}
