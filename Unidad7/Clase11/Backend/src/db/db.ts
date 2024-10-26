import { stringToDate } from '../controllers/evento.controller';
import { Asistente } from '../models/asistente.model';
import { Evento } from '../models/evento.model';
import { Organizador } from '../models/organizador.model';

export const lista_organizadores: Organizador[] = [];
export const lista_eventos: Evento[] = [];
export const lista_asistentes: Asistente[] = [];

lista_organizadores.push(new Organizador('ORG-001','Organizador1','organizador1@email.com','M','1234'));
lista_asistentes.push(new Asistente(1,'Asistente1','asistente1@email.com','F','1234'));
lista_eventos.push(new Evento(1, "Evento 1", stringToDate("18-09-2024"),"USAC Campus Central","ORG-001"));
