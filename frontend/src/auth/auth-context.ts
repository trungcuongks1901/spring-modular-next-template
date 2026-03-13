'use client';
import { createContext } from 'react';
import { SessionUser } from './auth-types';

export const AuthContext = createContext<SessionUser | null>(null);
