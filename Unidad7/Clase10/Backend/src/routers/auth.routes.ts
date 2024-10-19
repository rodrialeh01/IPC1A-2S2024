import { Router } from 'express';
import { login } from '../controllers/auth.controller';

const routerAuth = Router();

routerAuth.post('/login', login);

export default routerAuth;