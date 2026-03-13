'use client';

import { Box, Button, TextField } from '@mui/material';

export function ReportForm({ officeName, action }: { officeName: string; action: (formData: FormData) => void }) {
  return <Box component='form' action={action} display='grid' gap={2}>
    <TextField label='Office' value={officeName} InputProps={{ readOnly: true }} />
    <TextField name='content' multiline minRows={4} label='Content' required />
    <Button type='submit' variant='contained'>Create Report</Button>
  </Box>;
}
