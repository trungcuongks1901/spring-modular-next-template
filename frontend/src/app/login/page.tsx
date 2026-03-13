import { LoginForm } from '@/forms/LoginForm';
import { loginAction } from './actions';

export default function LoginPage() {
  return <LoginForm action={loginAction} />;
}
