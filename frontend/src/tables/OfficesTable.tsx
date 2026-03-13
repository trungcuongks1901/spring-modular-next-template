'use client';
import { DataGrid, GridColDef } from '@mui/x-data-grid';
import { Office } from '@/types/office';

export function OfficesTable({ rows }: { rows: Office[] }) {
  const cols: GridColDef[] = [{ field: 'id' }, { field: 'code' }, { field: 'name', flex: 1 }, { field: 'active' }];
  return <DataGrid autoHeight rows={rows} columns={cols} />;
}
