'use client';
import { DataGrid, GridColDef } from '@mui/x-data-grid';
import { User } from '@/types/user';

export function UsersTable({ rows }: { rows: User[] }) {
  const cols: GridColDef[] = [{ field: 'id' }, { field: 'username', flex: 1 }, { field: 'role' }, { field: 'officeId' }];
  return <DataGrid autoHeight rows={rows} columns={cols} />;
}
