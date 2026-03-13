'use client';
import { DataGrid, GridColDef } from '@mui/x-data-grid';
import { Report } from '@/types/report';

export function ReportsTable({ rows }: { rows: Report[] }) {
  const cols: GridColDef[] = [{ field: 'id' }, { field: 'officeId' }, { field: 'content', flex: 1 }, { field: 'createdBy' }];
  return <DataGrid autoHeight rows={rows} columns={cols} />;
}
