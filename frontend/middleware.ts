import { NextResponse, NextRequest } from 'next/server';

export function middleware(req: NextRequest) {
  const token = req.cookies.get('token')?.value;
  const userRaw = req.cookies.get('user')?.value;
  if (!token || !userRaw) {
    if (req.nextUrl.pathname.startsWith('/login')) return NextResponse.next();
    return NextResponse.redirect(new URL('/login', req.url));
  }
  const user = JSON.parse(userRaw);
  if (req.nextUrl.pathname.startsWith('/admin') && user.role !== 'ADMIN') return NextResponse.redirect(new URL('/reports', req.url));
  if (req.nextUrl.pathname.startsWith('/reports') && !['ADMIN', 'OFFICE'].includes(user.role)) return NextResponse.redirect(new URL('/login', req.url));
  return NextResponse.next();
}

export const config = { matcher: ['/admin/:path*', '/reports/:path*', '/login'] };
