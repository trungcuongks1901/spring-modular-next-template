import { CssBaseline, ThemeProvider } from '@mui/material';
import { ReactNode } from 'react';
import { muiTheme } from '@/theme/mui-theme';

export default function RootLayout({ children }: { children: ReactNode }) {
  return (
    <html lang="en"><body><ThemeProvider theme={muiTheme}><CssBaseline />{children}</ThemeProvider></body></html>
  );
}
